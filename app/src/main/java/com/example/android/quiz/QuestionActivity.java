package com.example.android.quiz;

import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quiz.data.QuestionContract;

import java.util.ArrayList;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {

    private static final int EXISTING_BOOK_LOADER = 0;
    private ArrayList<Integer> listId;
    Uri currentQuestionUri;
    String question;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String answer;
    int id;
    int score;
    int numberOfQuestions = 20;
    int currentQuestion;
    Toast toast;

    TextView scoreTextViewRadio;
    TextView questionNumberTextViewRadio;
    TextView questionTextViewRadio;
    RadioButton answer1RadioButton;
    RadioButton answer2RadioButton;
    RadioButton answer3RadioButton;
    RadioButton answer4RadioButton;
    RadioGroup questionRadioGroup;
    RadioButton answerRadioButton;

    String mGameState;

    static String SAVED_INSTANCE_STATE_KEY = "changedValue";
    static String SAVED_INSTANCE_STATE_SCORE = "score";
    static String SAVED_INSTANCE_STATE_NUMBER_OF_QUESTIONS = "numberOfQuestions";
    static String SAVED_INSTANCE_STATE_CURRENT_QUESTION = "currentValue";
    static String SAVED_INSTANCE_QUESTION_TEXT = "question";
    static String SAVED_INSTANCE_ANSWER_1 = "answer1";
    static String SAVED_INSTANCE_ANSWER_2 = "answer2";
    static String SAVED_INSTANCE_ANSWER_3 = "answer3";
    static String SAVED_INSTANCE_ANSWER_4 = "answer4";
    static String SAVED_INSTANCE_ANSWER = "answer";
    static String SAVED_INSTANCE_ID = "id";
    static String SAVED_INSTANCE_ID_LIST = "listId";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            mGameState = savedInstanceState.getString(SAVED_INSTANCE_STATE_KEY);
        }
        setContentView(R.layout.question_layout);

        Intent questionIntent = getIntent();
        currentQuestion = questionIntent.getIntExtra("currentQuestion", 0);
        listId = questionIntent.getIntegerArrayListExtra("list");
        score = questionIntent.getIntExtra("score", 0);

        if (currentQuestion == 0) {
            listId = new ArrayList<Integer>();
        }

        do {
            int min = 1;
            int max = 30;
            Random r = new Random();
            id = r.nextInt(max - min + 1) + min;
        } while (!listId.isEmpty() && listId.contains(id));
        listId.add(id);
        currentQuestionUri = ContentUris.withAppendedId(QuestionContract.QuestionEntry.CONTENT_URI, id);

        scoreTextViewRadio = findViewById(R.id.score_id);
        questionNumberTextViewRadio = findViewById(R.id.question_number_id);
        questionRadioGroup = findViewById(R.id.radio_group_id);
        questionTextViewRadio = findViewById(R.id.question_id);
        answer1RadioButton = findViewById(R.id.answer1_id);
        answer2RadioButton = findViewById(R.id.answer2_id);
        answer3RadioButton = findViewById(R.id.answer3_id);
        answer4RadioButton = findViewById(R.id.answer4_id);

        scoreTextViewRadio.setText(String.valueOf(score));
        questionNumberTextViewRadio.setText(String.format(getResources().getString(R.string.question_number), currentQuestion + 1, numberOfQuestions));


        Button submitButton = (Button) findViewById(R.id.submit_button_id);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (questionRadioGroup.getCheckedRadioButtonId() == -1) {
                    toast = Toast.makeText(QuestionActivity.this, getString(R.string.add_answer_toast), Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    int answerRadioButtonID = questionRadioGroup.getCheckedRadioButtonId();
                    answerRadioButton = (RadioButton) questionRadioGroup.findViewById(answerRadioButtonID);

                    if (answer.equals(answerRadioButton.getText().toString())) {
                        toast = Toast.makeText(QuestionActivity.this, getString(R.string.positive_toast), Toast.LENGTH_LONG);
                        toast.show();
                        score++;
                    } else {
                        toast = Toast.makeText(QuestionActivity.this, getString(R.string.negative_toast), Toast.LENGTH_LONG);
                        toast.show();
                    }

                    currentQuestion++;
                    if (currentQuestion == 20) {
                        Intent finalIntent = new Intent(QuestionActivity.this, EndActivity.class);
                        finalIntent.putExtra("score", score);
                        startActivity(finalIntent);
                    } else {
                        Intent questionIntent = new Intent(QuestionActivity.this, QuestionActivity.class);
                        questionIntent.putExtra("currentQuestion", currentQuestion);
                        questionIntent.putIntegerArrayListExtra("list", listId);
                        questionIntent.putExtra("score", score);
                        startActivity(questionIntent);
                    }
                }
            }
        });

        getLoaderManager().initLoader(EXISTING_BOOK_LOADER, null, this);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        score = savedInstanceState.getInt(SAVED_INSTANCE_STATE_SCORE);
        numberOfQuestions = savedInstanceState.getInt(SAVED_INSTANCE_STATE_NUMBER_OF_QUESTIONS);
        currentQuestion = savedInstanceState.getInt(SAVED_INSTANCE_STATE_CURRENT_QUESTION);
        question = savedInstanceState.getString(SAVED_INSTANCE_STATE_CURRENT_QUESTION);
        answer1 = savedInstanceState.getString(SAVED_INSTANCE_ANSWER_1);
        answer2 = savedInstanceState.getString(SAVED_INSTANCE_ANSWER_2);
        answer3 = savedInstanceState.getString(SAVED_INSTANCE_ANSWER_3);
        answer4 = savedInstanceState.getString(SAVED_INSTANCE_ANSWER_4);
        answer = savedInstanceState.getString(SAVED_INSTANCE_ANSWER);
        id = savedInstanceState.getInt(SAVED_INSTANCE_ID);
        listId = savedInstanceState.getIntegerArrayList(SAVED_INSTANCE_ID_LIST);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(SAVED_INSTANCE_STATE_KEY, mGameState);
        outState.putInt(SAVED_INSTANCE_STATE_SCORE, score);
        outState.putInt(SAVED_INSTANCE_STATE_NUMBER_OF_QUESTIONS, numberOfQuestions);
        outState.putInt(SAVED_INSTANCE_STATE_CURRENT_QUESTION, currentQuestion);
        outState.putString(SAVED_INSTANCE_QUESTION_TEXT, question);
        outState.putString(SAVED_INSTANCE_ANSWER_1, answer1);
        outState.putString(SAVED_INSTANCE_ANSWER_2, answer2);
        outState.putString(SAVED_INSTANCE_ANSWER_3, answer3);
        outState.putString(SAVED_INSTANCE_ANSWER_4, answer4);
        outState.putString(SAVED_INSTANCE_ANSWER, answer);
        outState.putInt(SAVED_INSTANCE_ID, id);
        outState.putIntegerArrayList(SAVED_INSTANCE_ID_LIST, listId);

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] projection = {
                QuestionContract.QuestionEntry._ID,
                QuestionContract.QuestionEntry.COLUMN_QUESTION_TEXT,
                QuestionContract.QuestionEntry.COLUMN_ANSWER_1,
                QuestionContract.QuestionEntry.COLUMN_ANSWER_2,
                QuestionContract.QuestionEntry.COLUMN_ANSWER_3,
                QuestionContract.QuestionEntry.COLUMN_ANSWER_4,
                QuestionContract.QuestionEntry.COLUMN_ANSWER};

        return new CursorLoader(this,
                currentQuestionUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {
            int questionColumnIndex = cursor.getColumnIndex(QuestionContract.QuestionEntry.COLUMN_QUESTION_TEXT);
            int answer1ColumnIndex = cursor.getColumnIndex(QuestionContract.QuestionEntry.COLUMN_ANSWER_1);
            int answer2ColumnIndex = cursor.getColumnIndex(QuestionContract.QuestionEntry.COLUMN_ANSWER_2);
            int answer3ColumnIndex = cursor.getColumnIndex(QuestionContract.QuestionEntry.COLUMN_ANSWER_3);
            int answer4ColumnIndex = cursor.getColumnIndex(QuestionContract.QuestionEntry.COLUMN_ANSWER_4);
            int answerColumnIndex = cursor.getColumnIndex(QuestionContract.QuestionEntry.COLUMN_ANSWER);

            question = cursor.getString(questionColumnIndex);
            answer1 = cursor.getString(answer1ColumnIndex);
            answer2 = cursor.getString(answer2ColumnIndex);
            answer3 = cursor.getString(answer3ColumnIndex);
            answer4 = cursor.getString(answer4ColumnIndex);
            answer = cursor.getString(answerColumnIndex);

            questionTextViewRadio.setText(question);
            answer1RadioButton.setText(answer1);
            answer2RadioButton.setText(answer2);
            answer3RadioButton.setText(answer3);
            answer4RadioButton.setText(answer4);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        questionTextViewRadio.setText("");
        answer1RadioButton.setText("");
        answer2RadioButton.setText("");
        answer3RadioButton.setText("");
        answer4RadioButton.setText("");
    }
}
