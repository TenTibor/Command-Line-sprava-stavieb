package com.company;

import com.company.buildings.BuildingsList;
import com.company.customers.Customer;
import com.company.customers.CustomersList;
import com.company.employees.Boss;
import com.company.employees.Employee;
import com.company.employees.EmployeesList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // employees
        EmployeesList employeesList = new EmployeesList();

        // UPCASTING is here
        Employee randomEmployee = new Boss("Tibor", "Dulovec", "1", "1");
        employeesList.addEmployee(randomEmployee);
        randomEmployee = new Employee("Ferko", "Trelko", "empl@mail.com", "123456");
        employeesList.addEmployee(randomEmployee);
        randomEmployee = new Employee("Nezmar", "Zmareny", "zmarendo@mail.com", "123456");
        employeesList.addEmployee(randomEmployee);
        randomEmployee = new Employee("Trendo", "Drendo", "prendo@mail.com", "123456");
        employeesList.addEmployee(randomEmployee);
        employeesList.addEmployee(new Employee("Velky", "Frajer", "frajer@mail.com", "123456"));

        // buildings
        CustomersList customerList = new CustomersList();
        customerList.addCustomer(new Customer("Fero", "Velky", "maik23@mail.com"));
        customerList.addCustomer(new Customer("Jano", "Maly", "mas321@mail.com"));
        customerList.addCustomer(new Customer("Peto", "Siroky", "mdsa23@mail.com"));
        customerList.addCustomer(new Customer("Pato", "Tenky", "mh31@mail.com"));

        // start interface
        Scanner scanner = new Scanner(System.in);
        Authentication _auth = new Authentication(employeesList);
        String response = "";
        System.out.println("===================\nWelcome to system!\n===================");
        boolean showMenu = true;
        while (!response.equals("0")) {
            if (!_auth.isLoggedIn()) {
                // Login
                System.out.println("Log in as:");
                System.out.println("0: Exit\n1: Employee\n2: Guest");
                response = scanner.nextLine();
                showMenu = true;
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
                    System.out.println("================");
                    System.out.println("0: Exit\n1: Log out" +
                            (!_auth.isGuest() ? "\n2: See my profile" : "") +
                            (!_auth.isGuest() ? "\n3: See all employees" : "") +
                            (!_auth.isGuest() && _auth.getUser().canEditEmployees() ? "\n4: Add new employee" : "") +
                            (!_auth.isGuest() ? "\n5: See all customers" : "") +
                            (!_auth.isGuest() ? "\n6: Add new customer" : "")
                    );
                    System.out.print("What you wanna do? ");

                }
                response = scanner.nextLine();
                showMenu = false;

                // For everybody
                switch (response) {
                    // Show menu
                    case "m":
                        showMenu = true;
                        break;
                    // Log out
                    case "1":
                        _auth.logOut();
                        break;
                    default:
                        // For only employees
                        if (!_auth.isGuest()) switch (response) {
                            // Show profile of logged employees
                            case "2":
                                System.out.println("Your profile:");
                                System.out.println(_auth.getUser().getName());
                                System.out.println(_auth.getUser().getEmail());
                                System.out.println("Press number to do action. (Press m to show menu)");
                                break;
                            // Show all employees
                            case "3":
                                employeesList.writeList();
                                break;
                            // Show all customers
                            case "5":
                                customerList.writeList();
                                break;
                            // Add new customer
                            case "6":
                                customerList.addCustomerInterface();
                                break;
                            default:
                                // Only for boss
                                if (_auth.getUser().canEditEmployees()) switch (response) {
                                    // Add employee
                                    case "4":
                                        employeesList.addEmployeeInterface();
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
        }
    }
}