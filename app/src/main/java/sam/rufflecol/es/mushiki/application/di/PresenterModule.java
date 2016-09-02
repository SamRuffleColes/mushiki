package sam.rufflecol.es.mushiki.application.di;

import dagger.Module;
import dagger.Provides;
import sam.rufflecol.es.mushiki.presentation.allgames.AllGamesMvp;
import sam.rufflecol.es.mushiki.presentation.allgames.AllGamesPresenter;

@Module
public class PresenterModule {

    @Provides
    public AllGamesMvp.Presenter provideAllGamesPresenter() {
        return new AllGamesPresenter();
    }

}
