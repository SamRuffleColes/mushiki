package es.rufflecol.sam.mushiki.application.di;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockPresenterModule.class})
public interface MockAppComponent extends AppComponent {
}
