package com.company.customers;

import com.company.buildings.Building;
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
            System.out.println((index++) + ": " + item.getPerson() + ", " + item.buildings.getSize() + " buildings" + (item.note.isEmpty() ? "" : ", " + item.note.getText()));
        }
    }

    public ArrayList<Customer> getList() {
        return list;
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

    public void writeBuildingList() {
        System.out.println("=========================\nList of all buildings:");
        for (Customer customer : list) {
            for (Building building : customer.getBuildings()) {
                System.out.println(building.getRecord() + ", " + customer.getName() + (building.note.isEmpty() ? "" : ", " + building.note.getText()));
            }
        }
    }

    public void showCustomer(String findThis) {
        for (Customer customer : list) {
            if (findThis.equals(customer.getName()) || findThis.equals(customer.getEmail())) {
                customer.showCard(false);
                return;
            }
        }
        System.out.println("Customer wasn't found");
    }
}
