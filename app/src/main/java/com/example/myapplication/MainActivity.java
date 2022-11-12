package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String [] Questions = {"Who is the last Prophet of Allah?",
            "Who is the First Prophet of Allah?",
            "What is our Religion?",
            "How many Allah?",
            "Where is Allah?",
            "How many prayers we offer in a day?",
            "In which month Muslims keep fast?",
            "How many eids we enjoy in a year?",
            "Whom do we worship?",
            "In which city the Holy Kabah is?",
            "Who feeds us?"};
    public String[][] options = {{"Hazrat Muhammad(PBUH)", "Hazrat Adam(AS)", "Hazrat Ibrahim(AS)", "Hazrat Isma’il"},
            {"Hazrat Muhammad(PBUH)", "Hazrat Adam(AS)", "Hazrat Ibrahim(AS)", "Hazrat Isma’il"},
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

    int QuestionNo, AttemptedCount = 0, WrongCount = 0, CorrectCount = 0;
    String answer = "";
    ArrayList<Integer> QuestionDone = new ArrayList<Integer>(11);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuestionTField = findViewById(R.id.QuestionField);
        Result = findViewById(R.id.Result);
        ResultRecord = findViewById(R.id.ResultRecord);
        OptionA = findViewById(R.id.OptionA);
        OptionB = findViewById(R.id.OptionB);
        OptionC = findViewById(R.id.OptionC);
        OptionD = findViewById(R.id.OptionD);
        OptionTextA = findViewById(R.id.OptionAText);
        OptionTextB = findViewById(R.id.OptionBText);
        OptionTextC = findViewById(R.id.OptionCText);
        OptionTextD = findViewById(R.id.OptionDText);

        DisplayQuestion();
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

            switch (QuestionNo) {
                case 1:
                case 4:
                case 3:
                    answer = "A";
                    break;
                case 2:
                case 11:
                case 10:
                case 9:
                    answer = "B";
                    break;
                case 5:
                case 8:
                    answer = "C";
                    break;
                case 6:
                case 7:
                    answer = "D";
                    break;
            }

        }
        else DisplayQuestion();
    }



}