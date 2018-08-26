package com.example.android.quiz.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ResultDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "kviz.db";


    public ResultDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_RESULT_TABLE = "CREATE TABLE " + ResultContract.ResultEntry.TABLE_NAME +
                "(" + ResultContract.ResultEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ResultContract.ResultEntry.COLUMN_PLAYER_NAME + " TEXT NOT NULL, " +
                ResultContract.ResultEntry.COLUMN_PLAYER_SCORE + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_RESULT_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}