package com.example.android.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = (Button) findViewById(R.id.start_continue_button_id);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent questionIntent = new Intent(MainActivity.this, QuestionActivity.class);
                startActivity(questionIntent);
            }
        });

        Button resultsButton = (Button) findViewById(R.id.results_button_id);
        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultsIntent = new Intent(MainActivity.this, ResultsActivity.class);
                startActivity(resultsIntent);
            }
        });

        Button creditsButton = (Button) findViewById(R.id.credits_button_id);
        creditsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent creditsIntent = new Intent(MainActivity.this, CreditsActivity.class);
                startActivity(creditsIntent);
            }
        });

        Button exitButton = (Button) findViewById(R.id.exit_button_id);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}