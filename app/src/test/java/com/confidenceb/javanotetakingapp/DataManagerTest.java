package com.confidenceb.javanotetakingapp;

import junit.framework.TestCase;
import org.junit.Test;

public class DataManagerTest extends TestCase {

    public void testCreateNewNote() {
        DataManager dm = DataManager.getInstance();
        CourseInfo course = dm.getCourse("android_sync");
        final String noteTitle = "Note title";
        final String noteText = "My note text";

        int noteIndex = dm.createNewNote();
        NoteInfo newNote = dm.getNotes().get(noteIndex);
        newNote.setCourse(course);
        newNote.setTitle(noteTitle);
        newNote.setText(noteText);

        NoteInfo compareNote = dm.getNotes().get(noteIndex);
        assertEquals(compareNote.getCourse(), course);
        assertEquals(compareNote.getTitle(), noteTitle);
        assertEquals(compareNote.getText(), noteText);
    }

    @Test
    public void findSimilarNotes(){
        DataManager dm = DataManager.getInstance();
        CourseInfo course = dm.getCourse("android_sync");
        final String noteTitle = "Note title";
        final String noteText1 = "First text body of my note test";
        final String noteText2 = "Second text body of my note test";

        int noteIndex1 = dm.createNewNote();
        NoteInfo newNote1 = dm.getNotes().get(noteIndex1);
        newNote1.setCourse(course);
        newNote1.setTitle(noteTitle);
        newNote1.setText(noteText1);

        int noteIndex2 = dm.createNewNote();
        NoteInfo newNote2 = dm.getNotes().get(noteIndex2);
        newNote2.setCourse(course);
        newNote2.setTitle(noteTitle);
        newNote2.setText(noteText2);

        int foundIndex1 = DataManager.findNote(newNote1);
        assertEquals(noteIndex1, foundIndex1);

        int foundIndex2 = DataManager.findNote(newNote2);
        assertEquals(noteIndex2, foundIndex2);

    }
}