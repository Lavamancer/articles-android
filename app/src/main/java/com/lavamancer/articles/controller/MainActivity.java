package com.lavamancer.articles.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.lavamancer.articles.R;
import com.lavamancer.articles.model.Post;
import com.lavamancer.articles.service.PostService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Post> posts = new ArrayList<>();
    ListView listView;
    PostAdapter postAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postAdapter = new PostAdapter(this, posts);
        listView = findViewById(R.id.listView);
        listView.setAdapter(postAdapter);

        PostService.getPosts(this);
    }

    public void updatePosts(List<Post> posts) {
        this.posts.clear();
        this.posts.addAll(posts);
        postAdapter.notifyDataSetChanged();
        listView.invalidateViews();
    }
}
