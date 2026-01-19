package org.bnsplits.model.dao;

import org.bnsplits.model.entities.Commande;
import org.bnsplits.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;

public class CommandeDAO {
    // Create
    public static void add(Commande commande) throws SQLException {
        String query = "INSERT INTO commande (date_commande, etat, total) VALUES (?, ?, ?)";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setTimestamp(1, Timestamp.valueOf(commande.getDateCommande()));
            pstmt.setString(2, commande.getEtat().name());
            pstmt.setDouble(3, commande.getTotal());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Read
    public static Commande getById(int id) throws SQLException {
        String query = "SELECT * FROM commande WHERE id_commande=?";
        Commande commande = new Commande();

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                commande.setIdCommande(rs.getInt("id_commande"));
                Timestamp dateCommande = rs.getTimestamp("date_commande");
                if (dateCommande != null) {
                    commande.setDateCommande(dateCommande.toLocalDateTime());
                }
                commande.setEtat(Commande.EtatCommande.valueOf(rs.getString("etat")));
                commande.setTotal(rs.getDouble("total"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return commande;
    }

    public static ArrayList<Commande> getALl() throws SQLException {
        String query = "SELECT * FROM commande";
        ArrayList<Commande> commandes = new ArrayList<>();

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Commande commande = new Commande();
                commande.setIdCommande(rs.getInt("id_commande"));
                Timestamp dateCommande = rs.getTimestamp("date_commande");
                if (dateCommande != null) {
                    commande.setDateCommande(dateCommande.toLocalDateTime());
                }
                commande.setEtat(Commande.EtatCommande.valueOf(rs.getString("etat")));
                commande.setTotal(rs.getDouble("total"));

                commandes.add(commande);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return commandes;
    }

    // Update
    public static void update(Commande commande) throws SQLException {
        String query = "UPDATE commande SET date_commande=?, etat=?, total=? WHERE id_commande=?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setTimestamp(1, Timestamp.valueOf(commande.getDateCommande()));
            pstmt.setString(2, commande.getEtat().name());
            pstmt.setDouble(3, commande.getTotal());
            pstmt.setInt(4, commande.getIdCommande());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Delete
    public static void delete(Commande commande) throws SQLException {
        String query = "DELETE FROM commande WHERE id_commande=?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setInt(1, commande.getIdCommande());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
