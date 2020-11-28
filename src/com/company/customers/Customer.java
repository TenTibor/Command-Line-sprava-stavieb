package com.company.customers;

import com.company.Note;
import com.company.buildings.Building;
import com.company.buildings.BuildingsList;
import com.company.employees.Employee;
import com.company.persons.Person;

import java.util.Scanner;

public class Customer extends Person {
    public Note note = new Note();
    BuildingsList buildings = new BuildingsList();

    public Customer(String firstName, String secondName, String email) {
        super(firstName, secondName, email);
    }

    public void writeBuildingsList() {
        if (buildings.getSize() == 0)
            System.out.println(" None buildings :(");
        else
            buildings.writeList();
    }

    public void newBuilding() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Place of the building: ");
        String place = scanner.nextLine();
        buildings.addItem(new Building(place));
        System.out.println("Building was added");
    }

    public void showCard() {
        System.out.println("\n=============" + this.getName() + "=============");
        System.out.println(" Email: " + this.getEmail());

        //  Building of user
        this.writeBuildingsList();

        // just fancy end of card
        for (int i = -26; i < this.getName().length(); i++) {
            System.out.print("=");
        }
        System.out.println("");
        System.out.println("[A: Add building] [R: Remove customer] [Any index of building] \n[N: Edit note] [0: Exit]");
    }

    public Building getBuilding(int index) {
        try {
            return buildings.getItem(index - 1);
        } catch (IndexOutOfBoundsException ex) { // handle your exception
            return null;
        }
    }

    public void removeBuilding(int index) {
        buildings.removeItem(index);
    }
}
