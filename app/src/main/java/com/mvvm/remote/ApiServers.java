package com.mvvm.remote;

import com.mvvm.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServers {
    @GET("posts")
    public Call<List<PostModel>> getPosts();
}
