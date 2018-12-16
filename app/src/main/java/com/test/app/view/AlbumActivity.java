package com.test.app.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.app.MyApplication;
import com.test.app.R;
import com.test.app.apiservice.APIInterface;
import com.test.app.di.component.ApplicationComponent;
import com.test.app.di.component.DaggerMainActivityComponent;
import com.test.app.di.component.MainActivityComponent;
import com.test.app.di.module.MainActivityContextModule;
import com.test.app.di.qualifier.ApplicationContext;
import com.test.app.model.Album;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumActivity extends Activity implements AlbumAdapter.ClickListener {


    MainActivityComponent mMainActivityComponent;

    @Inject
    public APIInterface mApiInterface;

    @Inject
    public AlbumAdapter mAlbumAdapter;

    @Inject
    @ApplicationContext
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSetUpDagger();

        initSetUpViews();
    }


    private void initSetUpDagger() {

        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        mMainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .applicationComponent(applicationComponent)
                .build();

        mMainActivityComponent.injectMainActivity(this);
    }

    private void initSetUpViews() {

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.albumRecyclerView);
        LinearLayoutManager mLinearLayoutManger = new LinearLayoutManager(this);
        mLinearLayoutManger.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(mLinearLayoutManger);


        mRecyclerView.setAdapter(mAlbumAdapter);

        mApiInterface.fetchAlbums().enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {

                System.out.println("Nikhil 111::>"+response.body());
                mAlbumAdapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });

    }


    @Override
    public void launchIntent(String details) {

    }
}
