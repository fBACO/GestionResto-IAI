package org.bnsplits.model;

import org.bnsplits.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LigneDeCommandeDAO {

    public List<LigneDeCommande> getAllLignesDeCommande() throws SQLException {
        List<LigneDeCommande> LignesDeCommande = new ArrayList<>();

        String query = "SELECT * LigneDeCommande";
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmp = conn.createStatement();
            ResultSet rs = stmp.executeQuery(query);
            while (rs.next()) {
                LignesDeCommande.add(
                        new LigneDeCommande(
                                rs.getInt("id_LigneCmde"),
                                rs.getInt("id_cmde"),
                                rs.getInt("id_produit"),
                                rs.getInt("quantite"),
                                rs.getDouble("prix_unitaire"),
                                rs.getDouble("montant_ligne")
                                
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return LignesDeCommande;
    }
}
