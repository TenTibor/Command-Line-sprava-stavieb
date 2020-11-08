package com.company.persons;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeesList {
    ArrayList<Employee> list = new ArrayList<>();

    public void addEmployee(Employee employee) {
        list.add(employee);
    }

    public void addEmployeeInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of new employee: ");
        String[] name = scanner.nextLine().split(" ");;

        System.out.print("Email of new employee: ");
        String email = scanner.nextLine();

        list.add(new Employee(name[0], name[1], email));
        System.out.println(email + " was added");
    }

    public void writeList() {
        System.out.println("List of all employees:");
        for (Employee employee : list) {
            System.out.println(employee.getPerson());
        }
    }
}
