package com.test.app.apiservice;

import com.test.app.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("albums")
    Call<List<Album>> fetchAlbums();
}
