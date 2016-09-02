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

}