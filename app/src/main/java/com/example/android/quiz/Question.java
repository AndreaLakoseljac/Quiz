package com.example.android.quiz;

public class Question{
    private String question, answer1, answer2, answer3, answer4, trueAnswer;
    public void setQuestion(String q, String a1, String a2, String a3, String a4, String t){
        question = q;
        answer1 = a1;
        answer2 = a2;
        answer3 = a3;
        answer4 = a4;
        trueAnswer = t;
    }

    public String getQuestion() { return question; }

    public String getAnswer1() { return answer1; }

    public String getAnswer2() { return answer2; }

    public String getAnswer3() { return answer3; }

    public String getAnswer4() { return answer4; }

    public String getTrueAnswer() { return trueAnswer; }

}
