package es.rufflecol.sam.mushiki.application;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import es.rufflecol.sam.mushiki.application.di.ApiModule;
import es.rufflecol.sam.mushiki.application.di.AppComponent;
import es.rufflecol.sam.mushiki.application.di.InteractorModule;
import es.rufflecol.sam.mushiki.application.di.PresenterModule;

public class App extends Application {

    @Singleton
    @Component(modules = {PresenterModule.class, InteractorModule.class, ApiModule.class})
    public interface ApplicationComponent extends AppComponent {
    }

    private static App app;

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        App.app = this;
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerApp_ApplicationComponent.builder()
                    .presenterModule(new PresenterModule())
                    .interactorModule(new InteractorModule())
                    .apiModule(new ApiModule())
                    .build();
        }
        return appComponent;
    }

    public static App get() {
        return App.app;
    }

}
