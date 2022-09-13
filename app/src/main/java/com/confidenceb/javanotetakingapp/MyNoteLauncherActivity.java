package com.confidenceb.javanotetakingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MyNoteLauncherActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_note_launcher);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MyNoteLauncherActivity.this, NoteList.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}