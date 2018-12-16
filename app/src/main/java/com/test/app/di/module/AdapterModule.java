package com.test.app.di.module;


import com.test.app.di.scopes.ActivityScope;
import com.test.app.view.AlbumActivity;
import com.test.app.view.AlbumAdapter;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public AlbumAdapter getAlbumsList(AlbumAdapter.ClickListener clickListener) {
        return new AlbumAdapter(clickListener);
    }

    @Provides
    @ActivityScope
    public AlbumAdapter.ClickListener setOnClickListener(AlbumActivity mainActivity) {
        return mainActivity;
    }
}
