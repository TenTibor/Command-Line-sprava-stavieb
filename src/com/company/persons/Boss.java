package com.company.persons;

public class Boss extends Employee {
    public Boss(String firstName, String secondName, String email, String password) {
        super(firstName, secondName, email, password);
        this.editEmployees = true;
        this.editBuildings = true;
    }

    public String getPerson() {
        return "Boss " + getName();
    }
}