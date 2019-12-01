package com.lavamancer.articles.service;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import com.lavamancer.articles.controller.MainActivity;

public class SplashService {


    public static void getLoading(final Activity activity) {

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                activity.startActivity(new Intent(activity, MainActivity.class));
                activity.finish();
            }

        }.execute();

    }

}
