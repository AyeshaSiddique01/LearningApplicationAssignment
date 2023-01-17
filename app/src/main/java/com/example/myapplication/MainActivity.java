package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    Button OptionA, OptionB, OptionC, OptionD, goRepository;
    TextView QuestionTField, Result, ResultRecord,
            OptionTextA, OptionTextB, OptionTextC, OptionTextD;

    int QuestionNo, WrongCount = 0, CorrectCount = 0, status = 0;
    String answer = "", answerString = "", inputAnswer="";
    ArrayList<Integer> QuestionDone = new ArrayList<>(11);
    DbHelper db;

    @SuppressLint("MissingInflatedId")
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
        goRepository = findViewById(R.id.goRepoBtnMain);
        //Db handler
        db = new DbHelper(this);
        DisplayQuestion();
        goRepository.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://github.com/AyeshaSiddique01/LearningApplicationAssignment/commits/main");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onClick(View view) {
        if (QuestionDone.size() == 11){
            Intent intent = new Intent(MainActivity.this, results_activity.class);
            startActivity(intent);
        }
        else if (QuestionDone.size() < 11){
        switch (view.getId()) {
            case R.id.OptionA:
                inputAnswer = options[QuestionNo][0];
                if (answer == "A")
                    CorrectAnswer();
                else
                    WrongAnswer();
                break;
            case R.id.OptionB:
                inputAnswer = options[QuestionNo][1];
                if (answer == "B")
                    CorrectAnswer();
                else
                    WrongAnswer();
                break;
            case R.id.OptionC:
                inputAnswer = options[QuestionNo][2];
                if (answer == "C")
                    CorrectAnswer();
                else
                    WrongAnswer();
                break;
            case R.id.OptionD:
                inputAnswer = options[QuestionNo][3];
                if (answer == "D")
                    CorrectAnswer();
                else
                    WrongAnswer();
                break;
        }
        db.AddQuestion(new Question(Questions[QuestionNo], answerString, inputAnswer, status));
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
                answerString = options[QuestionNo][0];
            }
            else if (QuestionNo == 0 || QuestionNo == 10 || QuestionNo == 9 || QuestionNo == 8){
                answer = "B";
                answerString = options[QuestionNo][1];
            }
            else if (QuestionNo == 7) {
                answer = "C";
                answerString = options[QuestionNo][2];
            }
            else if (QuestionNo == 4 || QuestionNo == 5 || QuestionNo == 6) {
                answer = "D";
                answerString = options[QuestionNo][3];
            }
        }
        else {
            DisplayQuestion();
        }
    }
    private void WrongAnswer() {
        WrongCount++;
        status = 0;
        Result.setText("No, " + answerString + " is correct answer");
        ResultRecord.setText("Attempted: "+ QuestionDone.size() +"  Correct: "+ CorrectCount +"  Wrong: " + WrongCount);
    }
    private void CorrectAnswer() {
        status = 1;
        CorrectCount++;
        Result.setText("Yes, " + answerString + " is correct answer");
        ResultRecord.setText("Attempted: "+ QuestionDone.size() +"  Correct: "+ CorrectCount +"  Wrong: " + WrongCount);
    }
}


