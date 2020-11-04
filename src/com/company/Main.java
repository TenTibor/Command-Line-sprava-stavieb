package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee randomEmployee = new Employee("Tibor", "Dulovec", "tibor@mail.com");
        EmployeesList employeesList = new EmployeesList();
        employeesList.addEmployee(randomEmployee);

        BuildingsList buildingsList = new BuildingsList();

        Authentication _auth = new Authentication(employeesList);

        String response = "";
        System.out.println("===================\n Welcome to system!\n===================");
        while (!response.equals("0")) {
            if (!_auth.isLoggedIn()) {
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
                System.out.println("==================\nWhat you wanna do?");
                System.out.println("0: Exit\n1: Log out\n" + (!_auth.isGuest() ? "2: See my profile" : ""));
                response = scanner.nextLine();
                switch (response) {
                    case "1":
                        _auth.logOut();
                        break;
                    case "2":
                        System.out.println("Your profile:");
                        System.out.println(_auth.getUser().getName());
                        System.out.println(_auth.getUser().getEmail());
                        break;
                }
            }
        }
    }
}
