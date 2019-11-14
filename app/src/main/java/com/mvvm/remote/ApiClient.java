package com.mvvm.remote;

import com.mvvm.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private ApiServers apiServers;
    private static ApiClient INSTANCE;

    public ApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiServers = retrofit.create(ApiServers.class);
    }

    public static ApiClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new ApiClient();
        }
        return INSTANCE;
    }

    public Call<List<PostModel>> getPosts(){
        return apiServers.getPosts();
    }
}
