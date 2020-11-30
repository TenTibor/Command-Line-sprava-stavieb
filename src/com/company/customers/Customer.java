package com.company.customers;

import com.company.Note;
import com.company.buildings.Building;
import com.company.buildings.BuildingsList;
import com.company.employees.Employee;
import com.company.persons.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person {
    public Note note = new Note();
    BuildingsList buildings = new BuildingsList();

    public Customer(String firstName, String secondName, String email) {
        super(firstName, secondName, email);
    }

    public void writeBuildingsList() {
        if (buildings.getSize() > 0)
            buildings.writeList();
    }

    public void newBuilding() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Place of the building: ");
        String place = scanner.nextLine();
        buildings.addItem(new Building(place));
        System.out.println("Building was added");
    }

    public void showCard(boolean havePermissions) {
        System.out.println("\n=============" + this.getName() + "=============");
        System.out.println(" Email: " + this.getEmail());
        if (!note.isEmpty()) System.out.println(" Note: " + note.getText());

        //  Building of user
        this.writeBuildingsList();

        // just fancy end of card
        for (int i = -26; i < this.getName().length(); i++) {
            System.out.print("=");
        }
        System.out.println("");
        if (havePermissions)
            System.out.println("[A: Add building] [R: Remove customer] [Index of building] \n[N: " + (note.isEmpty() ? "Add" : "Change") + " note] [RN: Remove note] [0: Exit]");
    }


    public ArrayList<Building> getBuildings() {
        return buildings.getList();
    }

    public Building getBuilding(int index) {
        try {
            return buildings.getItem(index - 1);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    public void removeBuilding(int index) {
        buildings.removeItem(index);
    }
}
