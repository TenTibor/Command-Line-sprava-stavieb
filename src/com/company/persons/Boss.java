package com.company.persons;

public class Boss extends Employee {
    public Boss(String firstName, String secondName, String email) {
        super(firstName, secondName, email);
        this.editEmployees = true;
        this.editBuildings = true;
    }

    public String getPerson() {
        return "Boss " + getName();
    }
}