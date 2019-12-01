package com.lavamancer.articles;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.lavamancer.articles.model.User;

import java.util.ArrayList;
import java.util.List;

public class Session {

    public List<User> users = new ArrayList<>();

    private static final String SHARED_PREFERENCES_NAME = "SESSION";
    private static Session instance;
    private Session() {}

    public static Session getInstance() {
        if (instance == null) instance = new Session();
        return instance;
    }

    public enum Key {
        USERS
    }

    public static String getString(Context context, Key key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key.toString(), null);
    }

    public static void putString(Activity activity, Key key, String value) {
        SharedPreferences.Editor editor = activity.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(key.toString(), value);
        editor.apply();
    }

    public static void removeString(Activity activity, Key key) {
        SharedPreferences.Editor editor = activity.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE).edit();
        editor.remove(key.toString());
        editor.apply();
    }


}
