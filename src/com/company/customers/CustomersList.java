package com.company.customers;

import com.company.employees.Employee;
import com.company.listInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomersList implements listInterface {
    ArrayList<Customer> list = new ArrayList<>();

    public void addCustomer(Customer customer) {
        list.add(customer);
    }

    public void writeList() {
        System.out.println("List of all employees:");
        for (Customer item : list) {
            System.out.println(item.getPerson());
        }
    }

    public void getList() {
    }

    public void addCustomerInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of new customer: ");
        String[] name = scanner.nextLine().split(" ");

        System.out.print("Email of new employee: ");
        String email = scanner.nextLine();

        list.add(new Customer(name[0], name[1], email));
        System.out.println(name[0] + " " + name[1] + " was added");
    }
}
