package com.test.app.di.component;

import android.content.Context;

import com.test.app.di.module.AdapterModule;
import com.test.app.di.qualifier.ActivityContext;
import com.test.app.di.scopes.ActivityScope;
import com.test.app.view.AlbumActivity;

import dagger.Component;


@ActivityScope
@Component(modules = AdapterModule.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();


    void injectMainActivity(AlbumActivity mainActivity);
}
