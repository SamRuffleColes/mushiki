package es.rufflecol.sam.mushiki.data.interactor;

import java.util.List;

import es.rufflecol.sam.mushiki.data.steam.community.model.SteamGame;

public interface Interactor {

    interface FetchSteamGames {
        void fetchForId(long steamId64, Listener listener);

        void fetchForUsername(String username, Listener listener);

        interface Listener {
            void onFetchSteamGamesSuccess(List<SteamGame> games);

            void onFetchSteamGamesFailure();
        }
    }

}
