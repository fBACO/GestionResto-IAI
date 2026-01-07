package org.bnsplits.model;

public class LigneDeCommande {

    private int id_LigneCmde;
    private int id_cmde;
    private int id_produit;
    private int quantite;
    private double prix_unitaire;
    private double montant_ligne;
    
//    public void ligneDeCommande(int id_LigneCmde, int id_cmde, int id_produit, in id) {
//    }

    public LigneDeCommande (int id_LigneCmde, int id_cmde, int id_produit, int quantite, double prix_unitaire, double montant_ligne)
    {
    
     this.id_LigneCmde = id_LigneCmde;
     this.id_cmde = id_cmde;
     this.id_produit = id_produit;
     this.quantite = quantite ;
     this.prix_unitaire = prix_unitaire;
     this.montant_ligne = montant_ligne;
    };
    
    public int getId_LigneCmde() {

        return id_LigneCmde;

    }

    public int getId_cmde() {

        return id_cmde;
    }

    public int getId_produit() {

        return id_produit;
    }

    public int getQuantite() {

        return quantite;

    }

    public double getPrix_unit() {

        return prix_unitaire;

    }

    public double getMontant_ligne() {

        return montant_ligne;

    }

}
