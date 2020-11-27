package com.company.customers;

import com.company.Note;
import com.company.persons.Person;

public class Customer extends Person {
    public Note note = new Note();

    public Customer(String firstName, String secondName, String email) {
        super(firstName, secondName, email);
    }
}
