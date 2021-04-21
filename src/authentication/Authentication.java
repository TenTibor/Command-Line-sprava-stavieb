package authentication;

import employees.Employee;
import employees.EmployeesList;

import java.util.Scanner;

public class Authentication {
    private Employee user = null;
    private Guest guest = null;
    private EmployeesList employees;

    public Authentication(EmployeesList employees) {
        this.employees = employees;
    }

    boolean checkPassword(String typedPassword, Employee employee) {
        return typedPassword.equals(employee.getPassword());
    }

    public void logAsGuest() {
        System.out.println("Logged in as guest.");
        this.guest = new Guest();
    }

    public void logIn() {
        System.out.println("Login with email: ");

        Scanner scanner = new Scanner(System.in);
        String loginEmail = scanner.nextLine();
        Employee theEmployee = null;

        // find  user
        boolean userFound = false;
        for (Employee employee : employees.getList()) {
            if (employee.getEmail().equals(loginEmail)) {
                theEmployee = employee;
                userFound = true;
                break;
            }
        }
        if (!userFound) {
            System.out.println("User wasn't found");
            return;
        }

        // check password
        System.out.println("Password: ");
        String input = "";
        while (!(input = scanner.nextLine()).equals("0") && !checkPassword(input, theEmployee)) {
            System.out.println("Bad password, try again (or type 0 to cancel): ");
        }

        if (input.equals("0")) return;

        System.out.println("Successfully logged in.");
        this.user = theEmployee;
    }

    public void logOut() {
        this.user = null;
        this.guest = null;
        System.out.println("You are logged out\n==================");
    }

    public boolean isLoggedIn() {
        return this.user != null || this.guest != null;
    }

    public boolean isGuest() {
        return this.guest != null;
    }

    public Employee getUser() {
        return user;
    }
}
