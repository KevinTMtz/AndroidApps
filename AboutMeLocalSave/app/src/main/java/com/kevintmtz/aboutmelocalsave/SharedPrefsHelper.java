package com.kevintmtz.aboutmelocalsave;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefsHelper {
    private static final String FILE_PREFS = "MyPrefs";
    private static final String KEY_REGARD_ONE = "regard one";
    private static final String KEY_REGARD_TWO = "regard two";

    private SharedPreferences sharedPrefs;

    public SharedPrefsHelper(Context context) {
        sharedPrefs = context.getSharedPreferences(FILE_PREFS, context.MODE_PRIVATE);
    }

    public String[] read() {
        return new String[]{
                sharedPrefs.getString(KEY_REGARD_ONE, "Regard One"),
                sharedPrefs.getString(KEY_REGARD_TWO, "Regard Two")
        };
    }

    public void save(String regardOne, String regardTwo) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(KEY_REGARD_ONE, regardOne);
        editor.putString(KEY_REGARD_TWO, regardTwo);
        editor.commit();
    }

    public void deleteRegards() {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.remove(KEY_REGARD_ONE);
        editor.remove(KEY_REGARD_TWO);
        editor.commit();
    }
}
