package com.company;

import com.company.buildings.BuildingsList;
import com.company.persons.Employee;
import com.company.persons.EmployeesList;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // employees
        EmployeesList employeesList = new EmployeesList();

        Employee randomEmployee = new Employee("Tibor", "Dulovec", "tiborendo@mail.com");
        employeesList.addEmployee(randomEmployee);
        randomEmployee = new Employee("Ferko", "Trelko", "treler@mail.com");
        employeesList.addEmployee(randomEmployee);
        randomEmployee = new Employee("Nezmar", "Zmareny", "zmarendo@mail.com");
        employeesList.addEmployee(randomEmployee);
        randomEmployee = new Employee("Trendo", "Drendo", "prendo@mail.com");
        employeesList.addEmployee(randomEmployee);

        // buildings
        BuildingsList buildingsList = new BuildingsList();


        // Start interface
        Scanner scanner = new Scanner(System.in);
        Authentication _auth = new Authentication(employeesList);
        String response = "";
        System.out.println("===================\n Welcome to system!\n===================");
        boolean showMenu = true;
        while (!response.equals("0")) {

            if (!_auth.isLoggedIn()) {
                // Login
                System.out.println("Log in as:");
                System.out.println("0: Exit\n1: Employee\n2: Guest");
                response = scanner.nextLine();
                switch (response) {
                    case "1":
                        _auth.logIn();
                        break;
                    case "2":
                        _auth.logAsGuest();
                        break;
                }
            } else {
                // Logged in
                if (showMenu) {
                    System.out.println("==================\nWhat you wanna do?");
                    System.out.println("0: Exit\n1: Log out\n" +
                            (!_auth.isGuest() ? "2: See my profile" : ""));
                }
                response = scanner.nextLine();
                switch (response) {
                    // Show menu
                    case "m":
                        showMenu = true;
                        break;
                    // Log out
                    case "1":
                        _auth.logOut();
                        break;
                    // Show profile of logged employees
                    case "2":
                        System.out.println("Your profile:");
                        System.out.println(_auth.getUser().getName());
                        System.out.println(_auth.getUser().getEmail());
                        System.out.println("Press number to do action. (Press m to show menu)");
                        showMenu = false;
                        break;
                }
            }
        }
    }
}
