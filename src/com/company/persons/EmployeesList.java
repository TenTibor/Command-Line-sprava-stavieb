package com.company.persons;

import com.company.listInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeesList implements listInterface {
    ArrayList<Employee> list = new ArrayList<>();

    public ArrayList<Employee> getList() {
        return list;
    }

    public void addEmployee(Employee employee) {
        list.add(employee);
    }

    public void addEmployeeInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of new employee: ");
        String[] name = scanner.nextLine().split(" ");

        System.out.print("Email of new employee: ");
        String email = scanner.nextLine();

        System.out.print("Password for new employee: ");
        String password = scanner.nextLine();

        list.add(new Employee(name[0], name[1], email, password));
        System.out.println(email + " was added");
    }

    public void writeList() {
        System.out.println("List of all employees:");
        for (Employee employee : list) {
            System.out.println(employee.getPerson());
        }
    }
}
