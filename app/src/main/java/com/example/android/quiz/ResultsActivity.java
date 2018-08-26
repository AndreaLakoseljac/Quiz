package com.example.android.quiz;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.android.quiz.data.ResultContract;

public class ResultsActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {

    ResultCursorAdapter mCursorAdapter;

    private static final int RESULT_LOADER = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_layout);

        ListView resultListView = (ListView) findViewById(R.id.list);

        View emptyView = findViewById(R.id.empty_view);
        resultListView.setEmptyView(emptyView);

        mCursorAdapter = new ResultCursorAdapter(this, null);
        resultListView.setAdapter(mCursorAdapter);

        getLoaderManager().initLoader(RESULT_LOADER, null, this);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] projection = {
                ResultContract.ResultEntry._ID,
                ResultContract.ResultEntry.COLUMN_PLAYER_NAME,
                ResultContract.ResultEntry.COLUMN_PLAYER_SCORE};

        return new CursorLoader(this,
                ResultContract.ResultEntry.CONTENT_URI,
                projection,
                null,
                null,
                "score DESC");
    }


    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        mCursorAdapter.swapCursor(cursor);
    }


    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mCursorAdapter.swapCursor(null);
    }
}
