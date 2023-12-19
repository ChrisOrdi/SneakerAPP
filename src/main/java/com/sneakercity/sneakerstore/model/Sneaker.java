package com.sneakercity.sneakerstore.model;

public class Sneaker {

    private int id; // misschien aanpassen naar double of uuid
    private String merk;
    private String schoennaam;

    private String schoenmaat; // is dit string of int?

    private String beschrijving;

    private String categorie;


    // No args constructor
    public Sneaker() {

    }

    // all args constructor

    public Sneaker(int id, String merk, String schoennaam, String schoenmaat, String beschrijving, String categorie) {
        this.id = id;
        this.merk = merk;
        this.schoennaam = schoennaam;
        this.schoenmaat = schoenmaat;
        this.beschrijving = beschrijving;
        this.categorie = categorie;
    }

    // Getters

    public int getId() {
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


    //Setters

    public void setId(int id) {
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
}
