package org.bnsplits.model.entities;

import java.time.LocalDateTime;

public class MouvementStock {
    private int idMouvementStock;
    private TypeMouvement type;
    private int quantite;
    private LocalDateTime dateMouvement;
    private String motif;
    private int idProduit;

    public enum TypeMouvement {
        ENTREE, SORTIE
    }

    public MouvementStock(){};

    public MouvementStock(int idMouvementStock, TypeMouvement type, int quantite, LocalDateTime dateMouvement, String motif, int idProduit) {
        this.idMouvementStock = idMouvementStock;
        this.type = type;
        this.quantite = quantite;
        this.dateMouvement = dateMouvement;
        this.motif = motif;
        this.idProduit = idProduit;
    }

    public int getIdMouvementStock() {
        return idMouvementStock;
    }

    public TypeMouvement getType() {
        return type;
    }

    public int getQuantite() {
        return quantite;
    }

    public LocalDateTime getDateMouvement() {
        return dateMouvement;
    }

    public String getMotif() {
        return motif;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdMouvementStock(int idMouvementStock) {
        this.idMouvementStock = idMouvementStock;
    }

    public void setType(TypeMouvement type) {
        this.type = type;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setDateMouvement(LocalDateTime dateMouvement) {
        this.dateMouvement = dateMouvement;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }
}
