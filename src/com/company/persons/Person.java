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

    public boolean isEmail() {
        return !email.isEmpty();
    }

    public String getEmail() {
        return isEmail() ? email : "Email is not set";
    }
    public String getPerson() {
        return this.firstName + " " + this.secondName + (isEmail() ? ", " + email : "");
    }
}
