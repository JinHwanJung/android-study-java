package jinhwan.com.androidappstudy.activities.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    private static volatile Preferences preferences;
    private Context context;

    private Preferences() {}

    public static Preferences getInstance() {
        synchronized (Preferences.class) {
            if (preferences == null) preferences = new Preferences();
        }
        return preferences;
    }

    public void setInit(Context context) {
        if (this.context == null) this.context = context;
    }

    public void put(String key, String value, String mode) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(mode, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void put(String key, int value, String mode) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(mode, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void put(String key, boolean value, String mode) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(mode, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public String getValue(String key, String value, String mode) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(mode, Activity.MODE_PRIVATE);
        try {
            return sharedPreferences.getString(key, value);
        } catch (Exception e) {
            return value;
        }
    }

    public int getValue(String key, int value, String mode) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(mode, Activity.MODE_PRIVATE);
        try {
            return sharedPreferences.getInt(key, value);
        } catch (Exception e) {
            return value;
        }
    }

    public boolean getValue(String key, boolean value, String mode) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(mode, Activity.MODE_PRIVATE);
        try {
            return sharedPreferences.getBoolean(key, value);
        } catch (Exception e) {
            return value;
        }
    }


}
