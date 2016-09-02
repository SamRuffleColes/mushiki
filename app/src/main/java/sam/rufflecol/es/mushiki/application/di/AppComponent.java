package sam.rufflecol.es.mushiki.application.di;

import javax.inject.Singleton;

import dagger.Component;
import sam.rufflecol.es.mushiki.presentation.allgames.AllGamesActivity;

@Singleton
@Component(modules = {PresenterModule.class, InteractorModule.class, ApiModule.class})
public interface AppComponent {
    AllGamesActivity inject(AllGamesActivity activity);
}

