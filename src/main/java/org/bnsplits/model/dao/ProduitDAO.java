package org.bnsplits.model.dao;

import org.bnsplits.model.entities.Produit;
import org.bnsplits.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;

public class ProduitDAO {
    // Create
    public void add(Produit produit) throws SQLException {
        String query = "INSERT INTO produit (nom, prix_vente, stock_actuel, seuil_alerte, id_categorie) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setString(1, produit.getNom());
            pstmt.setDouble(2, produit.getPrixVente());
            pstmt.setInt(3, produit.getStockActuel());
            pstmt.setInt(4, produit.getSeuilAlerte());
            pstmt.setInt(5, produit.getIdCategorie());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Read
    public Produit getById(Integer id) throws SQLException {
        String query = "SELECT * FROM produit WHERE id_produit=?";
        Produit produit = new Produit();

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                produit.setIdProduit(rs.getInt("id_produit"));
                produit.setNom(rs.getString("nom"));
                produit.setPrixVente(rs.getDouble("prix_vente"));
                produit.setStockActuel(rs.getInt("stock_actuel"));
                produit.setSeuilAlerte(rs.getInt("seuil_alerte"));
                produit.setIdCategorie(rs.getInt("id_categorie"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produit;
    }

    public static ArrayList<Produit> getALl() throws SQLException {
        String query = "SELECT * FROM produit";
        ArrayList<Produit> produits = new ArrayList<>();

        try (
                Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Produit produit = new Produit();
                produit.setIdProduit(rs.getInt("id_prduit"));
                produit.setNom(rs.getString("nom"));
                produit.setPrixVente(rs.getDouble("prix_vente"));
                produit.setStockActuel(rs.getInt("stock_actuel"));
                produit.setSeuilAlerte(rs.getInt("seuil_alerte"));

                produits.add(produit);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produits;
    }

    // Update
    public static void update(Produit produit) throws SQLException {
        String query = "UPDATE produit SET nom=?, prix_vente=?, stock_actuel=?, seuil_alerte=?, id_categorie=?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setString(1, produit.getNom());
            pstmt.setDouble(2, produit.getPrixVente());
            pstmt.setInt(3, produit.getStockActuel());
            pstmt.setInt(4, produit.getSeuilAlerte());
            pstmt.setInt(5, produit.getIdCategorie());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Delete
    public static void delete(Produit produit) throws SQLException {
        String query = "DELETE FROM produit WHERE id_produit=?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {

            pstmt.setInt(1, produit.getIdProduit());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
