package com.confidenceb.javanotetakingapp;

import junit.framework.TestCase;

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
}