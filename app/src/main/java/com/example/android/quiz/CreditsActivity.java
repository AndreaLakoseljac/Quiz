package com.example.android.quiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CreditsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.credits_layout);

        TextView collegeTextView = (TextView) findViewById(R.id.credits_college_id);
        collegeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(R.string.college_web_page)));
                startActivity(intent);
            }
        });

        TextView universityTextView = (TextView) findViewById(R.id.credits_university_id);
        universityTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(R.string.university_web_page)));
                startActivity(intent);
            }
        });

        TextView mentorTextView = (TextView) findViewById(R.id.credits_mentor_id);
        mentorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(R.string.mentor_web_page)));
                startActivity(intent);
            }
        });

        TextView authorTextView = (TextView) findViewById(R.id.credits_author_id);
        authorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType(getString(R.string.intent_type_email));
                intent.setData(Uri.parse(getString(R.string.email_address)));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}