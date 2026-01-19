package org.bnsplits.model.entities;

import java.time.LocalDateTime;

public class Commande {
    private int idCommande;
    private LocalDateTime dateCommande;
    private EtatCommande etat;
    private double total;

    public enum EtatCommande {
        EN_COURS, VALIDEE, ANNULEE
    }

    public Commande(){};

    public Commande(int idCommande, LocalDateTime dateCommande, EtatCommande etat, double total){
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.etat = etat;
        this.total = total;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public EtatCommande getEtat() {
        return etat;
    }

    public double getTotal() {
        return total;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public void setEtat(EtatCommande etat) {
        this.etat = etat;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
