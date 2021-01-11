package com.kevintmtz.aboutmelocalsave;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_FILE = "Friends.db";
    private static final String TABLE = "Friends";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_HOBBY = "hobby";

    public DatabaseHelper(Context context) {
        super(context, DB_FILE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE + "(" +
                FIELD_ID + " INTEGER PRIMARY KEY, " +
                FIELD_NAME + " TEXT, " +
                FIELD_HOBBY + " TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS ?";
        String[] params = {TABLE};
        db.execSQL(query, params);
        onCreate(db);
    }

    public void save(String name, String hobby) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(FIELD_NAME, name);
        values.put(FIELD_HOBBY, hobby);

        db.insert(TABLE, null, values);
    }

    public int delete(String name) {
        SQLiteDatabase db = getWritableDatabase();
        String clause = FIELD_NAME + " = ? ";
        String[] params = {name};

        return db.delete(TABLE, clause, params);
    }

    public String search(String name) {
        SQLiteDatabase db = getReadableDatabase();
        String clause = FIELD_NAME + " = ?";
        String[] params = {name};

        Cursor c = db.query(TABLE, null, clause, params, null, null, null);
        String result = "CODE: IT DOES NOT EXIST";

        if (c.moveToFirst()) {
            result = c.getString(2);
        }

        return result;
    }
}
