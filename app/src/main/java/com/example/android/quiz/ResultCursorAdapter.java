package com.example.android.quiz;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.quiz.data.ResultContract;

public class ResultCursorAdapter extends CursorAdapter {

    public ResultCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }


    @Override
    public void bindView(View view, final Context context, Cursor cursor) {
        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView priceTextView = (TextView) view.findViewById(R.id.score);

        int nameColumnIndex = cursor.getColumnIndex(ResultContract.ResultEntry.COLUMN_PLAYER_NAME);
        int scoreColumnIndex = cursor.getColumnIndex(ResultContract.ResultEntry.COLUMN_PLAYER_SCORE);

        String playerName = cursor.getString(nameColumnIndex);
        int playerScore = cursor.getInt(scoreColumnIndex);

        nameTextView.setText(playerName);
        priceTextView.setText(String.valueOf(playerScore));
    }
}
