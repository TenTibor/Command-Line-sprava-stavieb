package com.company.persons;

public class Employee extends Person {
    String password;

    public Employee(String firstName, String secondName, String email) {
        super(firstName, secondName, email);
    }

    public Employee(String firstName, String secondName) {
        super(firstName, secondName);
    }

    public String getPassword() {
        return password;
    }
}
