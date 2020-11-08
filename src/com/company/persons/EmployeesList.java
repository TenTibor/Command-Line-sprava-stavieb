package com.company.persons;

import java.util.ArrayList;

public class EmployeesList {
    ArrayList<Employee> list = new ArrayList<>();

    public void addEmployee(Employee employee) {
        list.add(employee);
    }

    public void writeList() {
    }
}
