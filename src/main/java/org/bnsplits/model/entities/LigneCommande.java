package org.bnsplits.model.entities;

public class LigneCommande {
    private int idLigneCommande;
    private int quantite;
    private double prixUnitaire;
    private double montantLigne;
    private int idCommande;
    private int idProduit;

    public LigneCommande(){};

    public LigneCommande(int idLigneCommande, int quantite, double prixUnitaire, double montantLigne, int idCommande, int idProduit){
        this.idLigneCommande = idLigneCommande;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.montantLigne = montantLigne;
        this.idCommande = idCommande;
        this.idProduit = idProduit;
    }

    public int getIdLigneCommande() {
        return idLigneCommande;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public double getMontantLigne() {
        return montantLigne;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public void setMontantLigne(double montantLigne) {
        this.montantLigne = montantLigne;
    }

    public void setIdLigneCommande(int idLigneCommande) {
        this.idLigneCommande = idLigneCommande;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }
}
