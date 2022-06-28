package com.confidenceb.javanotetakingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String NOTE_POSITION = "com.confidenceb.javanotetakingapp.NOTE_POSITION";
    public static final int POSITION_NOT_SET = -1;
    private NoteInfo note;
    private boolean isNewNote;
    private Spinner spinner;
    private EditText noteTitle;
    private EditText noteBody;
    private int newNotePosition;
    private boolean isCancelClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        spinner = findViewById(R.id.spinner);
        List<CourseInfo> courses = DataManager.getInstance().getCourses();
        ArrayAdapter<CourseInfo> coursesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        coursesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(coursesAdapter);

        readDisplayeStateValue();

        noteTitle = findViewById(R.id.note_title);
        noteBody = findViewById(R.id.note_text_body);

        if(!isNewNote)
        displayNote(spinner, noteTitle, noteBody);
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveNote();
    }

    private void saveNote() {
        note.setCourse((CourseInfo) spinner.getSelectedItem());
        note.setTitle(noteTitle.getText().toString());
        note.setText(noteBody.getText().toString());
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
        int position = intent.getIntExtra(NOTE_POSITION, POSITION_NOT_SET);
        isNewNote = position == POSITION_NOT_SET;
        if (isNewNote) {
            createNewNote();
        } else{
            note = DataManager.getInstance().getNotes().get(position);
        }
    }

    private void createNewNote() {
        DataManager dm = DataManager.getInstance();
        newNotePosition = dm.createNewNote();
        note = dm.getNotes().get(newNotePosition);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.action_email){
            sendEmail();
            return true;
        }else if(id == R.id.cancelSend){
            isCancelClicked = true;
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void sendEmail() {
        CourseInfo course = (CourseInfo) spinner.getSelectedItem();
        String subject = noteTitle.getText().toString();
        String text = "What I have learnt from Netshare Study App /" + course.getTitle() + "\n" + noteBody.getText();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc2822");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(intent);
    }
}