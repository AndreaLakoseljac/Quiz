package com.example.android.quiz.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class QuestionContract {

    public static final String CONTENT_AUTHORITY = "com.example.android.questions";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_QUESTIONS = "questions";

    private QuestionContract() {
    }

    public static final class QuestionEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_QUESTIONS);

        public final static String TABLE_NAME = "questions";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_QUESTION_TEXT = "question";
        public final static String COLUMN_ANSWER_1 = "answer1";
        public final static String COLUMN_ANSWER_2 = "answer2";
        public final static String COLUMN_ANSWER_3 = "answer3";
        public final static String COLUMN_ANSWER_4 = "answer4";
        public final static String COLUMN_ANSWER = "answer";

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_QUESTIONS;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_QUESTIONS;
    }
}
