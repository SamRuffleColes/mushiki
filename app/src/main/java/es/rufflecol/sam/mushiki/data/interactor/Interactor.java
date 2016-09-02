package es.rufflecol.sam.mushiki.data.interactor;

public interface Interactor {

    interface FetchSteamGames {
        void fetchForId(long steamId64);

        void fetchForUsername(String username);

        interface Listener {
            void onFetchSteamGamesSuccess();

            void onFetchSteamGamesFailure();
        }
    }

}
