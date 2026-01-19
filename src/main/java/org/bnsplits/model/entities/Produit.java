package org.bnsplits.model.entities;

public class Produit {
    private int idProduit;
    private String nom;
    private double prixVente;
    private int stockActuel;
    private int seuilAlerte;
    private int idCategorie;

    public Produit(){};

    public Produit(int idProduit, String nom, double prixVente, int stockActuel, int seuilAlerte, int idCategorie){
        this.idProduit = idProduit;
        this.nom = nom;
        this.prixVente = prixVente;
        this.stockActuel = stockActuel;
        this.seuilAlerte = seuilAlerte;
        this.idCategorie = idCategorie;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public String getNom() {
        return nom;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public int getStockActuel() {
        return stockActuel;
    }

    public int getSeuilAlerte() {
        return seuilAlerte;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public void setStockActuel(int stockActuel) {
        this.stockActuel = stockActuel;
    }

    public void setSeuilAlerte(int seuilAlerte) {
        this.seuilAlerte = seuilAlerte;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }
}
