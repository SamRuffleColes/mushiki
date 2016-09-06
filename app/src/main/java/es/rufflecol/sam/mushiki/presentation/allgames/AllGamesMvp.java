package es.rufflecol.sam.mushiki.presentation.allgames;

import java.util.List;

import es.rufflecol.sam.mushiki.data.steam.community.model.SteamGame;
import es.rufflecol.sam.mushiki.presentation.common.BasePresenter;

public interface AllGamesMvp {

    interface Presenter extends BasePresenter<View> {
        void onCreate();

        void fetchGamesForUser(String idOrUsername);
    }

    interface View {
        void requestSteamId();

        void displayGames(List<SteamGame> games);

        void displayError();
    }

}
