package com.company;

public class Person {
    String firstName;
    String secondName;
    String email;

    public Person(String firstName, String secondName, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
    }

    public String getName() {
        return this.firstName + " " + this.secondName;
    }

    public String getEmail() {
        return email;
    }
}
