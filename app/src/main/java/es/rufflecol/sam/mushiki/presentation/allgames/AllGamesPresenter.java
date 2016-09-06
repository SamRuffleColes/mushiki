package es.rufflecol.sam.mushiki.presentation.allgames;

import javax.inject.Inject;

import es.rufflecol.sam.mushiki.data.interactor.Interactor;

public class AllGamesPresenter implements AllGamesMvp.Presenter {

    private AllGamesMvp.View view;
    private Interactor.FetchSteamGames fetchSteamGamesInteractor;

    @Inject
    public AllGamesPresenter(Interactor.FetchSteamGames fetchSteamGamesInteractor) {
        this.fetchSteamGamesInteractor = fetchSteamGamesInteractor;
    }

    @Override
    public void setView(AllGamesMvp.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        view.requestSteamId();
    }

    @Override
    public void fetchGamesForUser(String idOrUsername) {
        try {
            long steamId64 = Long.parseLong(idOrUsername);
            fetchSteamGamesInteractor.fetchForId(steamId64);
        } catch (NumberFormatException e) {
            fetchSteamGamesInteractor.fetchForUsername(idOrUsername);
        }
    }

}
