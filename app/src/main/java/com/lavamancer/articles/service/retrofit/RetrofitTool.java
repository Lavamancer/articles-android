package com.lavamancer.articles.service.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitTool {


    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static RetrofitTool instance;
    public RetrofitApi retrofitApi;


    private RetrofitTool() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL);
        builder.client(httpClient.build());
        Retrofit retrofit = builder.addConverterFactory(GsonConverterFactory.create(gson)).build();
        retrofitApi = retrofit.create(RetrofitApi.class);
    }

    public static RetrofitTool getInstance() {
        if (instance == null) instance = new RetrofitTool();
        return instance;
    }

}
