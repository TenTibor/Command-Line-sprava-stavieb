package com.company.employees;

import com.company.employees.Employee;

public class Boss extends Employee {
    public Boss(String firstName, String secondName, String email, String password) {
        super(firstName, secondName, email, password);
        this.editEmployees = true;
    }

    public String getPerson() {
        return "Boss " + getName();
    }
}