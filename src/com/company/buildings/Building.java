package com.company.buildings;

import com.company.persons.Customer;
import com.company.Note;

public class Building {
    Customer customer;
    String status;
    String town;
    public Note note = new Note();

    public Building(Customer customer) {
        this.customer = customer;
        status = "In progress";
    }

    public void finish() {
        this.status = "Done";
    }

    public void cancel() {
        this.status = "Canceled";
    }

}
