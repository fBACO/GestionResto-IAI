package org.bnsplits.model.dao;

import org.bnsplits.model.entities.LigneCommande;
import org.bnsplits.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LigneCommandeDAO {
    // Create
    public static void add(LigneCommande ligneCommande) throws SQLException {
        String query = "INSERT INTO ligne_commande (quantite, prix_unitaire, montant_ligne, id_commande, id_produit) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setInt(1, ligneCommande.getQuantite());
            pstmt.setDouble(2, ligneCommande.getPrixUnitaire());
            pstmt.setDouble(3, ligneCommande.getMontantLigne());
            pstmt.setInt(4, ligneCommande.getIdCommande());
            pstmt.setInt(5, ligneCommande.getIdProduit());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Read
    public static LigneCommande getById(int id) throws SQLException {
        String query = "SELECT * FROM ligne_commande WHERE id_ligne_commande=?";
        LigneCommande ligneCommande = new LigneCommande();

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                ligneCommande.setIdLigneCommande(rs.getInt("id_ligne_commande"));
                ligneCommande.setQuantite(rs.getInt("quantite"));
                ligneCommande.setPrixUnitaire(rs.getDouble("prix_unitaire"));
                ligneCommande.setMontantLigne(rs.getDouble("montant_ligne"));
                ligneCommande.setIdCommande(rs.getInt("id_commande"));
                ligneCommande.setIdProduit(rs.getInt("id_produit"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ligneCommande;
    }

    public static ArrayList<LigneCommande> getAll() throws SQLException {
        String query = "SELECT * FROM ligne_commande";
        ArrayList<LigneCommande> lignesCommande = new ArrayList<>();

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                LigneCommande ligneCommande = new LigneCommande();
                ligneCommande.setIdLigneCommande(rs.getInt("id_ligne_commande"));
                ligneCommande.setQuantite(rs.getInt("quantite"));
                ligneCommande.setPrixUnitaire(rs.getDouble("prix_unitaire"));
                ligneCommande.setMontantLigne(rs.getDouble("montant_ligne"));
                ligneCommande.setIdCommande(rs.getInt("id_commande"));
                ligneCommande.setIdProduit(rs.getInt("id_produit"));

                lignesCommande.add(ligneCommande);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lignesCommande;
    }

    // Update
    public static void update(LigneCommande ligneCommande) throws SQLException {
        String query = "UPDATE ligne_commande SET quantite=?, prix_unitaire=?, montant_ligne=?, id_commande=?, id_produit=? WHERE id_ligne_commande=?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setInt(1, ligneCommande.getQuantite());
            pstmt.setDouble(2, ligneCommande.getPrixUnitaire());
            pstmt.setDouble(3, ligneCommande.getMontantLigne());
            pstmt.setInt(4, ligneCommande.getIdCommande());
            pstmt.setInt(5, ligneCommande.getIdProduit());
            pstmt.setInt(6, ligneCommande.getIdLigneCommande());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Delete
    public static void delete(LigneCommande ligneCommande) throws SQLException {
        String query = "DELETE FROM ligne_commande WHERE id_ligne_commande=?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setInt(1, ligneCommande.getIdLigneCommande());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
