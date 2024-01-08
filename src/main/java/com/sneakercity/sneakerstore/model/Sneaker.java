package com.sneakercity.sneakerstore.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Sneaker {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; // misschien aanpassen naar double of uuid

    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String merk;
    @Column(nullable = false)
    private String schoennaam;

    private String schoenmaat; // is dit string of int?

    private String beschrijving;

    private String categorie;

    private String color;


    // No args constructor
    public Sneaker() {

    }

    // all args constructor

    public Sneaker(UUID id, String merk, String schoennaam, String schoenmaat, String beschrijving, String categorie) {
        this.id = id;
        this.merk = merk;
        this.schoennaam = schoennaam;
        this.schoenmaat = schoenmaat;
        this.beschrijving = beschrijving;
        this.categorie = categorie;
    }

    // Getters

    public UUID getId() {
        return id;
    }

    public String getMerk() {
        return merk;
    }

    public String getSchoennaam() {
        return schoennaam;
    }

    public String getSchoenmaat() {
        return schoenmaat;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public String getCategorie() {
        return categorie;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    //Setters

    public void setId(UUID id) {
        this.id = id;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setSchoennaam(String schoennaam) {
        this.schoennaam = schoennaam;
    }

    public void setSchoenmaat(String schoenmaat) {
        this.schoenmaat = schoenmaat;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
