
package org.bnsplits.model;


public class Produit {
    
    private int id_produit;
    private int id_categorie;
    private String nom;
    private double prix_vente;
    private int Stock_actu;
    private int seuil_alerte;
    
       
    
    public Produit(int id_produit,int id_categorie, String nom, double prix_vente, int Stock_actu, int seuil_alerte ){
    
    this.id_produit = id_produit ;
    this. id_categorie = id_categorie;
    this. nom = nom  ;
    this.prix_vente = prix_vente;
    this.Stock_actu = Stock_actu;
    this. seuil_alerte = seuil_alerte;
    
    
    
    }
    
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


