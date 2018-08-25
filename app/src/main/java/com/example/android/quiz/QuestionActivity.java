package com.example.android.quiz;

import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quiz.data.QuestionContract;

public class QuestionActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {

    private static final int EXISTING_BOOK_LOADER = 0;
    Uri currentQuestionUri;
    String answer;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            mGameState = savedInstanceState.getString(SAVED_INSTANCE_STATE_KEY);
        }
        setContentView(R.layout.question_layout);

        Intent questionIntent = getIntent();
        currentQuestion = questionIntent.getIntExtra("currentQuestion", 0);
        score = questionIntent.getIntExtra("score", 0);

        int id = 1;
        currentQuestionUri = ContentUris.withAppendedId(QuestionContract.QuestionEntry.CONTENT_URI, id);

        scoreTextViewRadio = findViewById(R.id.score_id);
        questionNumberTextViewRadio = findViewById(R.id.question_number_id);
        questionRadioGroup = findViewById(R.id.radio_group_id);
        questionTextViewRadio = findViewById(R.id.question_id);
        answer1RadioButton = findViewById(R.id.answer1_id);
        answer2RadioButton = findViewById(R.id.answer2_id);
        answer3RadioButton = findViewById(R.id.answer3_id);
        answer4RadioButton = findViewById(R.id.answer4_id);

        scoreTextViewRadio.setText(String.format(getResources().getString(R.string.score_message), score, currentQuestion));
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
                        Intent finalIntent = new Intent(QuestionActivity.this, MainActivity.class);
                        finalIntent.putExtra("score", score);
                        startActivity(finalIntent);
                    } else {
                        Intent questionIntent = new Intent(QuestionActivity.this, QuestionActivity.class);
                        questionIntent.putExtra("currentQuestion", currentQuestion);
                        questionIntent.putExtra("score", score);
                        startActivity(questionIntent);
                    }
                }
            }
        });

        getLoaderManager().initLoader(EXISTING_BOOK_LOADER, null, this);
    }

    // This callback is called only when there is a saved instance previously saved using
    // onSaveInstanceState(). We restore some state in onCreate() while we can optionally restore
    // other state here, possibly usable after onStart() has completed.
    // The savedInstanceState Bundle is same as the one used in onCreate().
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        TextView button = findViewById(R.id.start_continue_button_id);
        button.setText(getString(R.string.continue_button));
        score = savedInstanceState.getInt(SAVED_INSTANCE_STATE_SCORE);
        numberOfQuestions = savedInstanceState.getInt(SAVED_INSTANCE_STATE_NUMBER_OF_QUESTIONS);
        currentQuestion = savedInstanceState.getInt(SAVED_INSTANCE_STATE_CURRENT_QUESTION);
    }

    // invoked when the activity may be temporarily destroyed, save the instance state here
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(SAVED_INSTANCE_STATE_KEY, mGameState);
        outState.putInt(SAVED_INSTANCE_STATE_SCORE, score);
        outState.putInt(SAVED_INSTANCE_STATE_NUMBER_OF_QUESTIONS, numberOfQuestions);
        outState.putInt(SAVED_INSTANCE_STATE_CURRENT_QUESTION, currentQuestion);
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }

    public void showTheEnd(View view) {
        if (score > (numberOfQuestions / 2.0)) {
            setContentView(R.layout.final_win_layout);
        } else {
            setContentView(R.layout.final_lose_layout);
        }
        TextView scoreTextView = findViewById(R.id.final_score_id);
        Resources res = getResources();
        double percentage = score / (double) numberOfQuestions * 100;
        if (score > (numberOfQuestions / 2.0)) {
            scoreTextView.setText(String.format(res.getString(R.string.congrats_message), percentage));
        } else {
            scoreTextView.setText(String.format(res.getString(R.string.sorry_message), percentage));

            //(getString(R.string.sorry) + " " + String.format(getString(R.string.round_decimal_to_2_decomals), (score / (double) numberOfQuestions) * 100) + getString(R.string.percent));
        }
        String resultMessage = getString(R.string.result_message) + " " + score + getString(R.string.score_on_screen) + numberOfQuestions;
        toast = Toast.makeText(this, resultMessage, Toast.LENGTH_LONG);
        toast.show();
        currentQuestion = 0;
        score = 0;
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
            int questinColumnIndex = cursor.getColumnIndex(QuestionContract.QuestionEntry.COLUMN_QUESTION_TEXT);
            int answer1ColumnIndex = cursor.getColumnIndex(QuestionContract.QuestionEntry.COLUMN_ANSWER_1);
            int answer2ColumnIndex = cursor.getColumnIndex(QuestionContract.QuestionEntry.COLUMN_ANSWER_2);
            int answer3ColumnIndex = cursor.getColumnIndex(QuestionContract.QuestionEntry.COLUMN_ANSWER_3);
            int answer4ColumnIndex = cursor.getColumnIndex(QuestionContract.QuestionEntry.COLUMN_ANSWER_4);
            int answerColumnIndex = cursor.getColumnIndex(QuestionContract.QuestionEntry.COLUMN_ANSWER);

            String question = cursor.getString(questinColumnIndex);
            String answer1 = cursor.getString(answer1ColumnIndex);
            String answer2 = cursor.getString(answer2ColumnIndex);
            String answer3 = cursor.getString(answer3ColumnIndex);
            String answer4 = cursor.getString(answer4ColumnIndex);
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
