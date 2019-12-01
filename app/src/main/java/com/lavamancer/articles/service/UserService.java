package com.lavamancer.articles.service;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.lavamancer.articles.Session;
import com.lavamancer.articles.controller.MainActivity;
import com.lavamancer.articles.model.User;
import com.lavamancer.articles.service.retrofit.RetrofitTool;

import java.io.IOException;
import java.util.List;

public class UserService {


    public static void getUsers(final Activity activity) {
        new AsyncTask<Void, Void, List<User>>() {
            @Override
            protected List<User> doInBackground(Void... voids) {
                try {
                    return RetrofitTool.getInstance().retrofitApi.getUsers().execute().body();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                if (users != null) {
                    Session.getInstance().users.clear();
                    Session.getInstance().users.addAll(users);
                    activity.startActivity(new Intent(activity, MainActivity.class));
                    activity.finish();
                } else {
                    Toast.makeText(activity, "Error al conectar con el servidor", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }


}
