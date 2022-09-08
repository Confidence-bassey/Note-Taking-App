package com.confidenceb.javanotetakingapp;

//import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static  org.hamcrest.Matchers.*;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.*;

@RunWith(AndroidJUnit4.class)
public class NewNoteCreationTest {

    static DataManager sDataManager;
    //final DataManager sDataManager = DataManager.getInstance();
    @BeforeClass
    public static void myClassSetUp(){
        sDataManager = DataManager.getInstance();
    }

    @Rule
    public ActivityTestRule<NoteList> myNoteListRule =
            new ActivityTestRule<>(NoteList.class);
    //private DataManager sDataManager = DataManager.getInstance();


    @Test
    public void createNewNote(){
        final CourseInfo course = sDataManager.getCourse("android_sync");
        final String noteTitle = "Note title";
        final String noteText = "My note text";

        //ViewInteraction newNoteFab = onView(withId(R.id.fab));
        //newNoteFab.perform(click());

        onView(withId(R.id.fab)).perform(click());

        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(instanceOf(CourseInfo.class), equalTo(course))).perform(click());
        //onView(withId(R.id.spinner)).check(matches(withSpinnerText(
        //        containsString(course.getTitle()))));

        onView(withId(R.id.note_title)).perform(typeText(noteTitle));
                //.check(matches(withText(containsString(noteTitle))));
        onView(withId(R.id.note_text_body)).perform(typeText(noteText),
        closeSoftKeyboard());
        //onView(withId(R.id.note_text_body)).check(matches(withText(containsString(noteText))));

        pressBack();

      /*  int noteIndex = sDataManager.createNewNote();
        NoteInfo note = sDataManager.getNotes().get(noteIndex);
        assertEquals(course, note.getCourse());
        assertEquals(noteTitle, note.getTitle());
        assertEquals(noteText, note.getText()); */
    }
}