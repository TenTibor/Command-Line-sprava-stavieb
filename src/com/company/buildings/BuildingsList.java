package com.company.buildings;

import com.company.customers.Customer;
import com.company.employees.Employee;
import com.company.listInterface;

import java.util.ArrayList;

public class BuildingsList implements listInterface {
    ArrayList<Building> list = new ArrayList<>();

    public void addItem(Building building) {
        list.add(building);
    }

    public Building getItem(int index) {
        return list.get(index);
    }

    public void writeList() {
        System.out.println(" Buildings(" + getSize() + "): ");
        int index = 1;
        for (Building item : list) {
            System.out.println("  " + (index++) + ": " + item.getRecord() + (item.note.isEmpty() ? "" : ", " + item.note.getText()));
        }
    }

    public void getList() {
    }

    public void removeItem(int index){
        list.remove(index);
    }

    public int getSize() {
        return list.size();
    }
}
