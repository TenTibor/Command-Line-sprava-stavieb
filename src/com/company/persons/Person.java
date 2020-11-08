package com.company.persons;

public class Person {
    private String firstName;
    private String secondName;
    private String email = "";

    public Person(String firstName, String secondName, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
    }

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getName() {
        return this.firstName + " " + this.secondName;
    }

    public String getEmail() {
        return email.length() > 0 ? email : "Email is not set";
    }
}
