package com.test.app;

import android.app.Activity;
import android.app.Application;

import com.test.app.di.component.ApplicationComponent;
import com.test.app.di.component.DaggerApplicationComponent;
import com.test.app.di.module.ContextModule;

public class MyApplication extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        mApplicationComponent.injectApplication(this);

    }

    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}

