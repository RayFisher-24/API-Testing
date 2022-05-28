package com.application.apitestingapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {

    @GET("posts") //posts from api url
    Call<List<ApiModels>> getPost();
}
