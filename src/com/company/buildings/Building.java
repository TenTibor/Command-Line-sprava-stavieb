package com.company.buildings;

import com.company.customers.Customer;
import com.company.Note;
import com.company.employees.Employee;

import java.util.ArrayList;

public class Building {
    String status;
    String place;
    public Note note = new Note();
    public ArrayList<String> workers = new ArrayList<>();

    public Building(String place) {
        status = "In progress";
        this.place = place;
    }

    public final void addWorker(String name) {
        workers.add(name);
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
        if (!workers.isEmpty()) {
            System.out.println(" Workers: ");
            for (String worker : workers) {
                System.out.println("  " + worker);
            }
        }

        // just fancy end of card
        for (int i = -26; i < status.length(); i++) {
            System.out.print("=");
        }
        System.out.println("");
        System.out.println("[R: Remove building] " + (this.status.equals("In progress") ? " [F: Finish] [C: Cancel]" : "") + "\n[W: Add worker] [N: " + (note.isEmpty() ? "Add" : "Change") + " note] [RN: Remove note] [0:Exit]");
    }
}
