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

    public void removeItem(int index) {
        list.remove(index);
    }

    public void writeList() {
        System.out.println("=========================\nList of all customers:");
        int index = 1;
        for (Customer item : list) {
            System.out.println((index++) + ": " + item.getPerson());
        }
    }

    public void getList() {
    }

    public Customer getCustomer(String sIndex) {
        int index;
        try {
            index = Integer.parseInt(sIndex) - 1;
        } catch (NumberFormatException ex) { // handle your exception
            return null;
        }
        try {
            return list.get(index);
        } catch (IndexOutOfBoundsException ex) { // handle your exception
            return null;
        }
    }

    public void addCustomerInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of new customer(two words): ");
        String[] name = scanner.nextLine().split(" ");

        System.out.print("Email of new employee: ");
        String email = scanner.nextLine();

        list.add(new Customer(name[0], name[1], email));
        System.out.println(name[0] + " " + name[1] + " was added");
    }
}
