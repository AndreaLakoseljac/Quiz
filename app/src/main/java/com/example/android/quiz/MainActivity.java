package com.example.android.quiz;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score;
    int numberOfQuestions = 9;
    int currentQuestion;
    Toast toast;

    // class array for questions and answers
    Question[] quizQuestions;

    // views for work with radio buttons
    TextView scoreTextViewRadio;
    TextView questionNumberTextViewRadio;
    TextView questionTextViewRadio;
    RadioButton answer1RadioButton;
    RadioButton answer2RadioButton;
    RadioButton answer3RadioButton;
    RadioButton answer4RadioButton;
    RadioGroup questionRadioGroup;
    RadioButton answerRadioButton;

    // views for work with checkboxes
    TextView scoreTextViewCheckbox;
    TextView questionNumberTextViewCheckbox;
    TextView questionTextViewCheckbox;
    CheckBox answer1CheckBox;
    CheckBox answer2CheckBox;
    CheckBox answer3CheckBox;
    CheckBox answer4CheckBox;

    // views for work with textview
    TextView scoreTextView;
    TextView questionNumberTextView;
    TextView questionTextView;
    EditText answerTextView;

    // some transient state for the activity instance
    String mGameState;

    //constants
    static String SAVED_INSTANCE_STATE_KEY = "changedValue";
    static String SAVED_INSTANCE_STATE_SCORE = "score";
    static String SAVED_INSTANCE_STATE_NUMBER_OF_QUESTIONS = "numberOfQuestions";
    static String SAVED_INSTANCE_STATE_CURRENT_QUESTION = "currentValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // recovering the instance state
        if (savedInstanceState != null) {
            mGameState = savedInstanceState.getString(SAVED_INSTANCE_STATE_KEY);
        }
        setContentView(R.layout.activity_main);

        Button creditsButton = (Button) findViewById(R.id.credits_button_id);
        creditsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent creditsIntent = new Intent(MainActivity.this, CreditsActivity.class);
                startActivity(creditsIntent);
            }
        });


        quizQuestions = new Question[numberOfQuestions];
        for (int i = 0; i < numberOfQuestions; i++) {
            quizQuestions[i] = new Question();
        }
        quizQuestions[0].setQuestion(getString(R.string.question1), getString(R.string.answer11), getString(R.string.answer12), getString(R.string.answer13), getString(R.string.answer14), getString(R.string.true_answer1));
        quizQuestions[1].setQuestion(getString(R.string.question2), getString(R.string.answer21), getString(R.string.answer22), getString(R.string.answer23), getString(R.string.answer24), getString(R.string.true_answer2));
        quizQuestions[2].setQuestion(getString(R.string.question3), getString(R.string.answer31), getString(R.string.answer32), getString(R.string.answer33), getString(R.string.answer34), getString(R.string.true_answer3));
        quizQuestions[3].setQuestion(getString(R.string.question4), getString(R.string.answer41), getString(R.string.answer42), getString(R.string.answer43), getString(R.string.answer44), getString(R.string.true_answer4));
        quizQuestions[4].setQuestion(getString(R.string.question5), getString(R.string.answer51), getString(R.string.answer52), getString(R.string.answer53), getString(R.string.answer54), getString(R.string.true_answer5));
        quizQuestions[5].setQuestion(getString(R.string.question6), getString(R.string.answer61), getString(R.string.answer62), getString(R.string.answer63), getString(R.string.answer64), getString(R.string.true_answer6));
        quizQuestions[6].setQuestion(getString(R.string.question7), getString(R.string.answer71), getString(R.string.answer72), getString(R.string.answer73), getString(R.string.answer74), getString(R.string.true_answer7));
        quizQuestions[7].setQuestion(getString(R.string.question8), getString(R.string.answer81), getString(R.string.answer82), getString(R.string.answer83), getString(R.string.answer84), "");
        quizQuestions[8].setQuestion(getString(R.string.question9), "", "", "", "", getString(R.string.true_answer9));
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

    // methods for START option
    public void playQuiz(View view) {
        if (currentQuestion < numberOfQuestions - 2) {
            setContentView(R.layout.question_layout);
            scoreTextViewRadio = findViewById(R.id.score_id);
            questionNumberTextViewRadio = findViewById(R.id.question_number_id);
            questionTextViewRadio = findViewById(R.id.question_id);
            answer1RadioButton = findViewById(R.id.answer1_id);
            answer2RadioButton = findViewById(R.id.answer2_id);
            answer3RadioButton = findViewById(R.id.answer3_id);
            answer4RadioButton = findViewById(R.id.answer4_id);
            displayRadioButtonQuestion(view);
        } else if (currentQuestion == numberOfQuestions - 2) {
            setContentView(R.layout.checkbox_layout);
            scoreTextViewCheckbox = findViewById(R.id.score_id);
            questionNumberTextViewCheckbox = findViewById(R.id.question_number_id);
            questionTextViewCheckbox = findViewById(R.id.question_id);
            answer1CheckBox = findViewById(R.id.checkbox1_id);
            answer2CheckBox = findViewById(R.id.checkbox2_id);
            answer3CheckBox = findViewById(R.id.checkbox3_id);
            answer4CheckBox = findViewById(R.id.checkbox4_id);
            displayCheckBoxQuestion(view);
        } else {
            setContentView(R.layout.textbox_layout);
            scoreTextView = findViewById(R.id.score_id);
            questionNumberTextView = findViewById(R.id.question_number_id);
            questionTextView = findViewById(R.id.question_id);
            displayTextViewQuestion(view);
        }
    }

    public void displayRadioButtonQuestion(View view) {
        Resources res = getResources();
        scoreTextViewRadio.setText(String.format(res.getString(R.string.score_message), score, currentQuestion));
        questionNumberTextViewRadio.setText(String.format(res.getString(R.string.question_number), currentQuestion + 1, numberOfQuestions));
        questionTextViewRadio.setText(quizQuestions[currentQuestion].getQuestion());
        answer1RadioButton.setText(quizQuestions[currentQuestion].getAnswer1());
        answer2RadioButton.setText(quizQuestions[currentQuestion].getAnswer2());
        answer3RadioButton.setText(quizQuestions[currentQuestion].getAnswer3());
        answer4RadioButton.setText(quizQuestions[currentQuestion].getAnswer4());
    }

    public void displayCheckBoxQuestion(View view) {
        Resources res = getResources();
        scoreTextViewCheckbox.setText(String.format(res.getString(R.string.score_message), score, currentQuestion));
        questionNumberTextViewCheckbox.setText(String.format(res.getString(R.string.question_number), currentQuestion + 1, numberOfQuestions));
        questionTextViewCheckbox.setText(quizQuestions[currentQuestion].getQuestion());
        answer1CheckBox.setText(quizQuestions[currentQuestion].getAnswer1());
        answer2CheckBox.setText(quizQuestions[currentQuestion].getAnswer2());
        answer3CheckBox.setText(quizQuestions[currentQuestion].getAnswer3());
        answer4CheckBox.setText(quizQuestions[currentQuestion].getAnswer4());
    }

    public void displayTextViewQuestion(View view) {
        Resources res = getResources();
        scoreTextView.setText(String.format(res.getString(R.string.score_message), score, currentQuestion));
        questionNumberTextView.setText(String.format(res.getString(R.string.question_number), currentQuestion + 1, numberOfQuestions));
        questionTextView.setText(quizQuestions[currentQuestion].getQuestion());
    }

    public void submitAnswer(View view) throws InterruptedException {
        String trueAnswer = quizQuestions[currentQuestion].getTrueAnswer();
        String answerText = null;
        if (currentQuestion == (numberOfQuestions - 2)) {
            if (answer1CheckBox.isChecked() && !answer2CheckBox.isChecked() && answer3CheckBox.isChecked() && !answer4CheckBox.isChecked()) {
                showPositiveMessage(view);
            } else {
                showNegativeMessage(view);
            }
            currentQuestion++;
            playQuiz(view);
        } else if (currentQuestion == (numberOfQuestions - 1)) {
            answerTextView = findViewById(R.id.answer_id);
            answerText = answerTextView.getText().toString();
            answerText = answerText.trim();
            if (answerText.toLowerCase().equalsIgnoreCase(trueAnswer.toLowerCase())) {
                showPositiveMessage(view);
            } else {
                showNegativeMessage(view);
            }
            showTheEnd(view);
        } else {
            questionRadioGroup = findViewById(R.id.radio_group_id);
            if (answer1RadioButton.isChecked() || answer2RadioButton.isChecked() || answer3RadioButton.isChecked() || answer4RadioButton.isChecked()) {
                int answerRadioButtonID = questionRadioGroup.getCheckedRadioButtonId();
                answerRadioButton = (RadioButton) questionRadioGroup.findViewById(answerRadioButtonID);
                answerText = answerRadioButton.getText().toString();
            }
            if (answerText == trueAnswer) {
                showPositiveMessage(view);
            } else {
                showNegativeMessage(view);
            }
            currentQuestion++;
            playQuiz(view);
        }
    }

    // methods for toast messages
    public void showPositiveMessage(View view) {
        toast = Toast.makeText(this, getString(R.string.positive_toast), Toast.LENGTH_LONG);
        toast.show();
        score++;
    }

    public void showNegativeMessage(View view) {
        toast = Toast.makeText(this, getString(R.string.negative_toast), Toast.LENGTH_LONG);
        toast.show();
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

    // methods for MAIN layout
    public void showCredits(View view) {
        setContentView(R.layout.credits_layout);
    }

    public void exitFromApp(View view) {
        System.exit(0);
    }

    // methods for CREDITS option
    public void goToMain(View view) {
        setContentView(R.layout.activity_main);
    }

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType(getString(R.string.intent_type_email));
        intent.setData(Uri.parse(getString(R.string.email_address)));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void openWebPage1(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.college_web_page)));
        startActivity(intent);
    }

    public void openWebPage2(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.university_web_page)));
        startActivity(intent);
    }

    public void openWebPage3(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.mentor_web_page)));
        startActivity(intent);
    }
}