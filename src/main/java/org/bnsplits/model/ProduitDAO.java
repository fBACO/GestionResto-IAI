package org.bnsplits.model;

import org.bnsplits.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO {

    public List<Produit> getAllProduits() throws SQLException {
        List<Produit> produits = new ArrayList<>();

        String query = "SELECT * FROM PRODUITS";
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmp = conn.createStatement();
            ResultSet rs = stmp.executeQuery(query);
            while (rs.next()) {
                produits.add(
                        new Produit(
                                rs.getInt("id_produit"),
                                rs.getInt("id_categorie"),
                                rs.getString("nom"),
                                rs.getDouble("prix_vente"),
                                rs.getInt("Stock_actu"), 
                                rs.getInt("seuil_alerte")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produits;
    }
}
