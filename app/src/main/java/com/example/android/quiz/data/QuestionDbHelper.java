package com.example.android.quiz.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuestionDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "kviz_pitanja.db";

    public QuestionDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " + QuestionContract.QuestionEntry.TABLE_NAME +
                "(" + QuestionContract.QuestionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionContract.QuestionEntry.COLUMN_QUESTION_TEXT + " TEXT NOT NULL, " +
                QuestionContract.QuestionEntry.COLUMN_ANSWER_1 + " TEXT NOT NULL, " +
                QuestionContract.QuestionEntry.COLUMN_ANSWER_2 + " TEXT NOT NULL, " +
                QuestionContract.QuestionEntry.COLUMN_ANSWER_3 + " TEXT NOT NULL, " +
                QuestionContract.QuestionEntry.COLUMN_ANSWER_4 + " TEXT NOT NULL, " +
                QuestionContract.QuestionEntry.COLUMN_ANSWER + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question1', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question2', 'a', 'b', 'c', 'd', 'b');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question3', 'a', 'b', 'c', 'd', 'c');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question4', 'a', 'b', 'c', 'd', 'd');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question5', 'a', 'b', 'c', 'd', 'b');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question6', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question7', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question8', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question9', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question10', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question11', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question12', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question13', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question14', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question15', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question16', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question17', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question18', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question19', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question20', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question21', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question22', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question23', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question24', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question25', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question26', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question27', 'a', 'b', 'c', 'd', 'a');");
        db.execSQL("INSERT INTO " + QuestionContract.QuestionEntry.TABLE_NAME + " (question, answer1, answer2, answer3, answer4, answer) VALUES('question28', 'a', 'b', 'c', 'd', 'a');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { }
}
