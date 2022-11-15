package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String [] Questions = {"Q- Who is the last Prophet of Allah?",
            "Q- Who is the First Prophet of Allah?",
            "Q- What is our Religion?",
            "Q- How many Allah?",
            "Q- Where is Allah?",
            "Q- How many prayers we offer in a day?",
            "Q- In which month Muslims keep fast?",
            "Q- How many Eids we enjoy in a year?",
            "Q- Whom do we worship?",
            "Q- In which city the Holy Kabah is?",
            "Q- Who feeds us?"};

    public String[][] options = {{"Hazrat Adam(AS)","Hazrat Muhammad(PBUH)", "Hazrat Ibrahim(AS)", "Hazrat Isma’il(AS)"},
            {"Hazrat Adam(AS)", "Hazrat Muhammad(PBUH)", "Hazrat Ibrahim(AS)", "Hazrat Isma’il(AS)"},
            {"Islam", "Christianity", "Judaism", "Hinduism"},
            {"One", "Two", "Three", "Four"},
            {"Sky", "Land", "Mountains", "EveryWhere"},
            {"Two", "Three", "Four", "Five"},
            {"Muḥarram", "Rabī‘ al-awwal", "Rajab", "Ramaḍān"},
            {"One", "Two", "Three", "Four"},
            {"Father", "Allah", "Mother", "Grand Father"},
            {"Madina", "Makkah", "Karbala", "Palestine"},
            {"Father", "Allah", "Mother", "Grand Father"}};

    Button OptionA, OptionB, OptionC, OptionD;
    TextView QuestionTField, Result, ResultRecord,
            OptionTextA, OptionTextB, OptionTextC, OptionTextD;

    int QuestionNo, WrongCount = 0, CorrectCount = 0;
    String answer = "", answerString = "";
    ArrayList<Integer> QuestionDone = new ArrayList<Integer>(11);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuestionTField = findViewById(R.id.QuestionField);
        Result = findViewById(R.id.Result);
        ResultRecord = findViewById(R.id.ResultRecord);
        OptionA = findViewById(R.id.OptionA);
        OptionA.setOnClickListener(this);
        OptionB = findViewById(R.id.OptionB);
        OptionB.setOnClickListener(this);
        OptionC = findViewById(R.id.OptionC);
        OptionC.setOnClickListener(this);
        OptionD = findViewById(R.id.OptionD);
        OptionD.setOnClickListener(this);
        OptionTextA = findViewById(R.id.OptionAText);
        OptionTextB = findViewById(R.id.OptionBText);
        OptionTextC = findViewById(R.id.OptionCText);
        OptionTextD = findViewById(R.id.OptionDText);

        DisplayQuestion();
    }
    @Override
    public void onClick(View view) {
        if (QuestionDone.size() < 11){
        switch (view.getId()) {
            case R.id.OptionA:
                if (answer == "A")
                    CorrectAnswer();
                else
                    WrongAnswer();
                break;
            case R.id.OptionB:
                if (answer == "B")
                    CorrectAnswer();
                else
                    WrongAnswer();
                break;
            case R.id.OptionC:
                if (answer == "C")
                    CorrectAnswer();
                else
                    WrongAnswer();
                break;
            case R.id.OptionD:
                if (answer == "D")
                    CorrectAnswer();
                else
                    WrongAnswer();
                break;
        }

        DisplayQuestion();
    }
    }
    private void DisplayQuestion() {
        Random rnd = new Random();
        QuestionNo = rnd.nextInt(11);
        if (!QuestionDone.contains(QuestionNo)){
            QuestionDone.add(QuestionNo);
            QuestionTField.setText(Questions[QuestionNo]);
            OptionTextA.setText(options[QuestionNo][0]);
            OptionTextB.setText(options[QuestionNo][1]);
            OptionTextC.setText(options[QuestionNo][2]);
            OptionTextD.setText(options[QuestionNo][3]);

            if (QuestionNo == 1 || QuestionNo == 2 || QuestionNo == 3) {
                answer = "A";
                answerString = options[QuestionNo][0] + " is correct answer";
            }
            else if (QuestionNo == 0 || QuestionNo == 10 || QuestionNo == 9 || QuestionNo == 8){
                answer = "B";
                answerString = options[QuestionNo][1] + " is correct answer";
            }
            else if (QuestionNo == 7) {
                answer = "C";
                answerString = options[QuestionNo][2] + " is correct answer";
            }
            else if (QuestionNo == 4 || QuestionNo == 5 || QuestionNo == 6) {
                answer = "D";
                answerString = options[QuestionNo][3] + " is correct answer";
            }
        }
        else {
            DisplayQuestion();
        }
    }
    private void WrongAnswer() {
        WrongCount++;
        Result.setText("No, " + answerString);
        ResultRecord.setText("Attempted: "+ QuestionDone.size() +"  Correct: "+ CorrectCount +"  Wrong: " + WrongCount);
    }
    private void CorrectAnswer() {
        CorrectCount++;
        Result.setText("Yes, " + answerString);
        ResultRecord.setText("Attempted: "+ QuestionDone.size() +"  Correct: "+ CorrectCount +"  Wrong: " + WrongCount);
    }
}


