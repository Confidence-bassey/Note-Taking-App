package com.confidenceb.javanotetakingapp;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class NewNoteCreationTest {

    @Rule
    public ActivityTestRule<NoteList> myNoteListRule =
            new ActivityTestRule<>(NoteList.class);





    @Test
    public void createNewNote(){

    }
}