package com.example.android.quiz;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quiz.data.ResultContract;

public class EndActivity extends AppCompatActivity {

    Integer score;
    String name;
    EditText nameEditText;
    String mState;

    static String SAVED_INSTANCE_STATE_KEY = "changedValue";
    static String SAVED_INSTANCE_STATE_SCORE = "score";
    static String SAVED_INSTANCE_STATE_NAME = "name";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            mState = savedInstanceState.getString(SAVED_INSTANCE_STATE_KEY);
        }

        setContentView(R.layout.final_layout);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        Intent finalIntent = getIntent();
        score = finalIntent.getIntExtra("score", 0);

        TextView scoreTextView = (TextView) findViewById(R.id.final_score_id);
        scoreTextView.setText(String.valueOf(score));

        nameEditText = (EditText) findViewById(R.id.name_id);

        ImageView trophyImageView = (ImageView) findViewById(R.id.image_trophy_id);
        if (score == 20) {
            trophyImageView.setVisibility(View.VISIBLE);
        } else {
            trophyImageView.setVisibility(View.GONE);
        }

        Button startButton = (Button) findViewById(R.id.start_button1_id);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nameEditText.getText().toString().trim().isEmpty()) {
                    saveResult();
                }
                Intent startIntent = new Intent(EndActivity.this, MainActivity.class);
                startActivity(startIntent);
            }
        });

        Button quitButton = (Button) findViewById(R.id.exit_button1_id);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nameEditText.getText().toString().trim().isEmpty()) {
                    saveResult();
                }
                Intent startIntent = new Intent(EndActivity.this, MainActivity.class);
                startActivity(startIntent);
                Intent exitIntent = new Intent(Intent.ACTION_MAIN);
                exitIntent.addCategory(Intent.CATEGORY_HOME);
                startActivity(exitIntent);
            }
        });
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        score = savedInstanceState.getInt(SAVED_INSTANCE_STATE_SCORE);
        nameEditText.setText(SAVED_INSTANCE_STATE_NAME);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(SAVED_INSTANCE_STATE_KEY, mState);
        outState.putInt(SAVED_INSTANCE_STATE_SCORE, score);
        outState.putString(SAVED_INSTANCE_STATE_NAME, nameEditText.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {}

    private void saveResult() {

        String nameString = nameEditText.getText().toString().trim();

        ContentValues values = new ContentValues();
        values.put(ResultContract.ResultEntry.COLUMN_PLAYER_NAME, nameString);
        values.put(ResultContract.ResultEntry.COLUMN_PLAYER_SCORE, score);

        Uri resultUri = getContentResolver().insert(ResultContract.ResultEntry.CONTENT_URI, values);

        if (resultUri == null) {
            Toast.makeText(this,"Rezultat nije spremljen.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Rezultat je spremljen.", Toast.LENGTH_SHORT).show();
        }
    }
}
