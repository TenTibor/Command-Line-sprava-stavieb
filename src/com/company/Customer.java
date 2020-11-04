package com.company;

public class Customer extends Person{
    public Note note = new Note();

    public Customer(String firstName, String secondName, String email) {
        super(firstName, secondName, email);
    }
}
