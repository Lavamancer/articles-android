package com.lavamancer.articles.service;

import android.os.AsyncTask;
import android.widget.Toast;

import com.lavamancer.articles.controller.MainActivity;
import com.lavamancer.articles.model.Post;
import com.lavamancer.articles.service.retrofit.RetrofitTool;

import java.io.IOException;
import java.util.List;

public class PostService {


    public static void getPosts(final MainActivity mainActivity) {
        new AsyncTask<Void, Void, List<Post>>() {

            @Override
            protected List<Post> doInBackground(Void... voids) {
                try {
                    return RetrofitTool.getInstance().retrofitApi.getPosts().execute().body();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(List<Post> posts) {
                if (posts != null) {
                    mainActivity.updatePosts(posts);
                } else {
                    Toast.makeText(mainActivity, "Error al conectar con el servidor", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }


}
