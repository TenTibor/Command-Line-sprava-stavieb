package com.company;

// Note about building or customer from employees
public class Note {
    String text = null;

    public void editNote(String newNote) {
        this.text = newNote;
    }

    public void removeNote() {
        this.text = null;
    }
}
