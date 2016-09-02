package es.rufflecol.sam.mushiki;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import es.rufflecol.sam.mushiki.application.MockApp;

public class MockTestRunner extends AndroidJUnitRunner {

    private static final String APPLICATION_CLASS_NAME = MockApp.class.getName();

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, APPLICATION_CLASS_NAME, context);
    }

}
