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
import static  org.hamcrest.Matchers.*;
import static androidx.test.espresso.Espresso.pressBack;

@RunWith(AndroidJUnit4.class)
public class NewNoteCreationTest {

    static DataManager sDataManager;

    @Rule
    public ActivityTestRule<NoteList> myNoteListRule =
            new ActivityTestRule<>(NoteList.class);





    @Test
    public void createNewNote(){
        final CourseInfo course = sDataManager.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText = "This is the body text of my test note";

        //ViewInteraction newNoteFab = onView(withId(R.id.fab));
        //newNoteFab.perform(click());

        onView(withId(R.id.fab)).perform(click());

        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(instanceOf(CourseInfo.class), equalTo(course)));

        onView(withId(R.id.note_title)).perform(typeText("Test note title"));
        onView(withId(R.id.note_text_body)).perform(typeText("This is the body text of my test note"),
        closeSoftKeyboard());

        pressBack();
    }
}