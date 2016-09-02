package es.rufflecol.sam.mushiki.application.di;

import dagger.Module;
import dagger.Provides;
import es.rufflecol.sam.mushiki.data.interactor.Interactor;
import es.rufflecol.sam.mushiki.presentation.allgames.AllGamesMvp;
import es.rufflecol.sam.mushiki.presentation.allgames.AllGamesPresenter;

@Module
public class PresenterModule {

    @Provides
    public AllGamesMvp.Presenter provideAllGamesPresenter(Interactor.FetchSteamGames fetchSteamGamesInteractor) {
        return new AllGamesPresenter(fetchSteamGamesInteractor);
    }

}
