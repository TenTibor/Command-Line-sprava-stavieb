package com.company.employees;

import com.company.persons.Person;

public class Employee extends Person {
    private String password;
    protected boolean editEmployees = false;
    protected boolean editBuildings = false;

    public Employee(String firstName, String secondName, String email, String password) {
        super(firstName, secondName, email);
        this.password = password;
    }

    public Employee(String firstName, String secondName) {
        super(firstName, secondName);
    }

    public String getPassword() {
        return password;
    }

    public boolean canEditEmployees() {
        return editEmployees;
    }

    public boolean canEditBuildings() {
        return editBuildings;
    }
}
