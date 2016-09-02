package es.rufflecol.sam.mushiki.application.di;

import org.mockito.Mockito;

import dagger.Module;
import dagger.Provides;
import es.rufflecol.sam.mushiki.presentation.allgames.AllGamesMvp;

@Module
public class MockPresenterModule extends PresenterModule {

    private AllGamesMvp.Presenter allGamesPresenter;

    public void setAllGamesPresenter(AllGamesMvp.Presenter allGamesPresenter) {
        this.allGamesPresenter = allGamesPresenter;
    }

    @Provides
    public AllGamesMvp.Presenter provideAllGamesPresenter() {
        if (allGamesPresenter != null) {
            return allGamesPresenter;
        }
        return Mockito.mock(AllGamesMvp.Presenter.class);
    }

}
