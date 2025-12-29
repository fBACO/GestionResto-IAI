
package org.bnsplits.model;


public class Produit {
    private int id_produit;
    private int id_categorie;
    private String nom;
    private double prix_vente;
    private int Stock_actu;
    private int seuil_alerte;
    
    public int getId_produit (){
        
        return id_produit;
        
    }
    
    public int getId_categorie (){
        
        return id_categorie;
        
    }
    
    public String getNom(){
    
    return nom;
    }
    
    public double getPrix_Vente(){
        
        return prix_vente;
        
    }
    public int getStock_actu(){
    
    return Stock_actu;
    
    }
    
    public int getSeuil_alerte(){
        
    return seuil_alerte;
    
    }
    
}


