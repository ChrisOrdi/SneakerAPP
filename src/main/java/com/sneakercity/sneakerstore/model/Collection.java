package com.sneakercity.sneakerstore.model;

import jakarta.persistence.Entity;

import java.util.List;


public class Collection {

        private int id;
        private String name;
        private String description;
        private List<Sneaker> items; // 'Item' could be any class like 'Sneaker', 'Book', etc.

        // Constructors, getters, setters, and other methods


    // No args constructor
    public Collection() {
    }

    // all args constructor

    public Collection(int id, String name, String description, List<Sneaker> items) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.items = items;
    }

    // getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Sneaker> getItems() {
        return items;
    }

    // setters

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setItems(List<Sneaker> items) {
        this.items = items;
    }
}
