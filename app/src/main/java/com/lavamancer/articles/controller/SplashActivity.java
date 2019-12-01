package com.lavamancer.articles.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lavamancer.articles.R;
import com.lavamancer.articles.service.UserService;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        SplashService.getLoading(this);
        UserService.getUsers(this);

    }

}
