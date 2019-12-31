package com.driscan.expandablerecyclerview.data.model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Parent extends ExpandableGroup<Child> {
    public Parent(String title, List<Child> items) {
        super(title, items);
    }
}
