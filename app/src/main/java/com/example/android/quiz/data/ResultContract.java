package com.example.android.quiz.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class ResultContract {

    public static final String CONTENT_AUTHORITY = "com.example.android.results";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_RESULTS = "results";


    private ResultContract() {
    }


    public static final class ResultEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_RESULTS);

        public final static String TABLE_NAME = "results";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PLAYER_NAME = "name";
        public final static String COLUMN_PLAYER_SCORE = "score";

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_RESULTS;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_RESULTS;
    }
}
