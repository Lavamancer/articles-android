package com.lavamancer.articles.service.retrofit;

import com.lavamancer.articles.model.Post;
import com.lavamancer.articles.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {


    @GET("/posts")
    Call<List<Post>> getPosts();

    @GET("/users")
    Call<List<User>> getUsers();


}
