package org.bnsplits.model.entities;

public class Categorie {
    private int idCategorie;
    private String libelle;

    public Categorie() {};

    public Categorie(int idCategorie, String libelle) {
        this.idCategorie = idCategorie;
        this.libelle = libelle;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
