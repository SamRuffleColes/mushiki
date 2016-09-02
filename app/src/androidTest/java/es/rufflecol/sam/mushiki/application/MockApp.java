package es.rufflecol.sam.mushiki.application;

import es.rufflecol.sam.mushiki.application.di.AppComponent;

public class MockApp extends App {

    private AppComponent appComponent;

    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }

    @Override
    public AppComponent getAppComponent() {
        return appComponent;
    }

}
