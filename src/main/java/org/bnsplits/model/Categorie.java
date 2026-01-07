package org.bnsplits.model;

public class Categorie {
    private int id_cat;
    private String libelle_cat;

    public Categorie(int id_cat, String libelle_cat){
        this.id_cat = id_cat;
        this.libelle_cat = libelle_cat;
    }

    public int getId_cat() {
        return id_cat;
    }

    public String getLibelle_cat() {
        return libelle_cat;
    }
}
