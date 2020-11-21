package com.company.buildings;

import com.company.listInterface;

import java.util.ArrayList;

public class BuildingsList implements listInterface {
    ArrayList<Building> list = new ArrayList<>();

    void addBuilding(Building building) {
        list.add(building);
    }

    public void writeList() {
    }

    public void getList() {
    }
}
