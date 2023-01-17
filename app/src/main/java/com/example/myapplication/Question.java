package com.example.myapplication;

public class Question {
    String questionStatement;
    String answer;
    String input;
    int status;

    public Question(String questionStatement, String answer, String input, int status) {
        this.questionStatement = questionStatement;
        this.answer = answer;
        this.input = input;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getQuestionStatement() {
        return questionStatement;
    }

    public void setQuestionStatement(String questionStatement) {
        this.questionStatement = questionStatement;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
