package com.confidenceb.javanotetakingapp;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;

@RunWith(AndroidJUnit4.class)
public class NewNoteCreationTest {

    @Rule
    public ActivityTestRule<NoteList> myNoteListRule =
            new ActivityTestRule<>(NoteList.class);





    @Test
    public void createNewNote(){
        //ViewInteraction newNoteFab = onView(withId(R.id.fab));
        //newNoteFab.perform(click());
        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.note_title)).perform(typeText("note title"));
        onView(withId(R.id.note_text_body)).perform(typeText("note body"),
        closeSoftKeyboard());
    }
}