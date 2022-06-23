package com.confidenceb.javanotetakingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String NOTE_INFO = "com.confidenceb.javanotetakingapp.NOTE_INFO";
    private NoteInfo note;
    private boolean isNewNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        Spinner spinner = findViewById(R.id.spinner);
        List<CourseInfo> courses = DataManager.getInstance().getCourses();
        ArrayAdapter<CourseInfo> coursesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        coursesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(coursesAdapter);

        readDisplayeStateValue();

        EditText noteTitle = findViewById(R.id.note_title);
        EditText noteBody = findViewById(R.id.note_text_body);

        if(!isNewNote)
        displayNote(spinner, noteTitle, noteBody);
    }

    private void displayNote(Spinner spinner, EditText noteTitle, EditText noteBody) {
        List<CourseInfo> courses = DataManager.getInstance().getCourses();
        int courseIndex = courses.indexOf(note.getCourse());
        spinner.setSelection(courseIndex);

        noteTitle.setText(note.getTitle());
        noteBody.setText(note.getText());
    }

    private void readDisplayeStateValue() {
        Intent intent = getIntent();
        note = intent.getParcelableExtra(NOTE_INFO);
        isNewNote = note == null;
    }
}