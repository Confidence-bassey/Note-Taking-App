package com.confidenceb.javanotetakingapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class NoteList extends AppCompatActivity {

    //private ArrayAdapter<NoteInfo> notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoteList.this, MainActivity.class);
                startActivity(intent);
            }
        });
        
        initializeContentToDisplay();
    }

    @Override
    protected void onResume() {
        super.onResume();
       // notesAdapter.notifyDataSetChanged();
    }

    private void initializeContentToDisplay() {
       /* final ListView notesList = findViewById(R.id.notesList);
        List<NoteInfo> notes = DataManager.getInstance().getNotes();
       // notesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
       // notesList.setAdapter(notesAdapter);

        notesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(NoteList.this, MainActivity.class);
//                NoteInfo note = (NoteInfo) notesList.getItemAtPosition(position);
                intent.putExtra(MainActivity.NOTE_POSITION, position);
                startActivity(intent);
            }
        });   */

        final RecyclerView noteRecyclerV = (RecyclerView)findViewById(R.id.notesList);
        final LinearLayoutManager notesLayoutM = new LinearLayoutManager(this);
        noteRecyclerV.setLayoutManager(notesLayoutM);

        List<NoteInfo> notes = DataManager.getInstance().getNotes();
        final NoteRecyclerAdapter noteRecyclerAdapter = new NoteRecyclerAdapter(this,notes);
        noteRecyclerV.setAdapter(noteRecyclerAdapter);
    }
}