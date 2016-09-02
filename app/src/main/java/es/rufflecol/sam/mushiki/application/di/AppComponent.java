package es.rufflecol.sam.mushiki.application.di;

import javax.inject.Singleton;

import dagger.Component;
import es.rufflecol.sam.mushiki.presentation.allgames.AllGamesActivity;

@Singleton
@Component(modules = {PresenterModule.class, InteractorModule.class, ApiModule.class})
public interface AppComponent {
    AllGamesActivity inject(AllGamesActivity activity);
}

