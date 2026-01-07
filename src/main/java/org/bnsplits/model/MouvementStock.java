package org.bnsplits.model;

import java.time.LocalDateTime;

public class MouvementStock {
    private int id;
    private int produit_id;
    private int quantite;
    private LocalDateTime date_mouvement;
    private String motif;

    enum Type {
        ENTREE,
        SORTIE
    }

    private Type type;

    public MouvementStock(int id, int produit_id, int quantite, LocalDateTime date_mouvement, String motif, Type type){
        this.id = id;
        this.produit_id = produit_id;
        this.quantite = quantite;
        this.date_mouvement = date_mouvement;
        this.motif = motif;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public LocalDateTime getDate_mouvement() {
        return date_mouvement;
    }

    public String getMotif() {
        return motif;
    }

    public Type getType() {
        return type;
    }
}
