package com.company;

public class Authentication {
    private Employee user = null;
    private Guest guest = null;
    EmployeesList employees;

    public Authentication(EmployeesList employees) {
        this.employees = employees;
    }

    boolean checkPassword(String typedPassword, Employee employee) {
        return typedPassword.equals(employee.password);
    }

    void logAsGuest() {
        System.out.println("Logged in as guest.");
        this.guest = new Guest();
    }

    void logIn() {
        // TODO Prihlasenie. Uzivatel zada email, ten sa vyhlada ci existuje v zozname zamestanncov.
        //  Ak existuje, zistuje ci sa bude zhodovat heslo
        System.out.println("Successfully logged in.");
        this.user = new Employee("Tibor", "Dulovec", "tibor@mail.com");
    }

    void logOut() {
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
