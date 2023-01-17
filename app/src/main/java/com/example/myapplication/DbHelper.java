package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    public static final String questionStatement = "questionStatement";
    public static final String answer = "answer";
    public static final String input = "input";
    public static final String score = "score";
    public static final String id = "id";
    public static final String LearningApplication = "LearningApplication";

    public DbHelper(@Nullable Context context) {
        super(context, "LearningApplication", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + LearningApplication + "("
                + id + " Integer PRIMARY KEY AUTOINCREMENT, "
                + questionStatement + " Text, "
                + answer + " Text, "
                + input + " Text,"
                + score + "Integer)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LearningApplication);
        onCreate(db);
    }

    public void AddQuestion(Question q) {
        SQLiteDatabase db = this.getWritableDatabase();
        String insertQuery = "Insert into " + LearningApplication + "(" + questionStatement + ", " + answer + ", " + input+ ", " + score +")" +
                " Values('" + q.getQuestionStatement() + "', '" + q.getAnswer() +"', '" + q.getInput() +"', " + q.getStatus() + ") ";
        db.execSQL(insertQuery);
    }

    public ArrayList<String> getResult() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + LearningApplication, null);

        ArrayList<String> QuestionArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                if (cursorCourses.getInt(4) == 1){
                    QuestionArrayList.add("Yes, correct answer of '" + cursorCourses.getString(1) +
                            "' is '" + cursorCourses.getString(2) + "'");
                }
                else {
                    QuestionArrayList.add("No, correct answer of '" + cursorCourses.getString(1) +
                            "' is '" + cursorCourses.getString(2) +
                            "' not '" + cursorCourses.getString(3) + "'");
                }
            } while (cursorCourses.moveToNext());

        }

        cursorCourses.close();
        return QuestionArrayList;
    }
}
