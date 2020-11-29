package com.company.buildings;

import com.company.customers.Customer;
import com.company.Note;

public class Building {
    String status;
    String place;
    public Note note = new Note();

    public Building(String place) {
        status = "In progress";
        this.place = place;
    }

    public void finish() {
        this.status = "Done";
    }

    public void cancel() {
        this.status = "Canceled";
    }

    public String getRecord() {
        return "[" + status + "] " + place;
    }

    public void showCard() {
        System.out.println("\n=============" + status + "=============");
        System.out.println(" Place: " + place);
        if (!note.isEmpty()) System.out.println(" Note: " + note.getText());

        // just fancy end of card
        for (int i = -26; i < status.length(); i++) {
            System.out.print("=");
        }
        System.out.println("");
        System.out.println("[R: Remove building] " + (this.status.equals("In progress") ? " [F: Finish] [C: Cancel]" : "") + "\n[N: " + (note.isEmpty() ? "Add" : "Change") + " note] [RN: Remove note] [0:Exit]");
    }
}
