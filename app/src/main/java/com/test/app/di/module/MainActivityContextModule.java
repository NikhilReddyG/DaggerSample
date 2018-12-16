package com.test.app.di.module;

import android.content.Context;

import com.test.app.di.qualifier.ActivityContext;
import com.test.app.di.scopes.ActivityScope;
import com.test.app.view.AlbumActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {
    private AlbumActivity mAlbumActivity;

    public Context context;

    public MainActivityContextModule(AlbumActivity albumActivity) {
        this.mAlbumActivity = albumActivity;
        context = albumActivity;
    }

    @Provides
    @ActivityScope
    public AlbumActivity providesMainActivity() {
        return mAlbumActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }

}
