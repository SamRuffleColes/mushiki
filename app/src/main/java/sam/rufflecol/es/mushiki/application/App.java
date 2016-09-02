package sam.rufflecol.es.mushiki.application;

import android.app.Application;

import sam.rufflecol.es.mushiki.application.di.ApiModule;
import sam.rufflecol.es.mushiki.application.di.AppComponent;
import sam.rufflecol.es.mushiki.application.di.DaggerAppComponent;
import sam.rufflecol.es.mushiki.application.di.InteractorModule;
import sam.rufflecol.es.mushiki.application.di.PresenterModule;

public class App extends Application {

    private static App app;

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        App.app = this;
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
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
