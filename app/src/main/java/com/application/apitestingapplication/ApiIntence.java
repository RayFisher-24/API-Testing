package com.application.apitestingapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiIntence {
    private static Retrofit retrofit;
    private static String BASEURL="http://jsonplaceholder.typicode.com";

    public static Retrofit getRetrofit() {
        if (retrofit == null) {

            retrofit = new Retrofit
                    .Builder().baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory
                            .create()).build();
        }

        return retrofit;
    }
}
