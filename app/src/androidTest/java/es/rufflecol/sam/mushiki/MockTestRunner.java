package es.rufflecol.sam.mushiki;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import es.rufflecol.sam.mushiki.application.MockApp;

public class MockTestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, MockApp.class.getName(), context);
    }

}
