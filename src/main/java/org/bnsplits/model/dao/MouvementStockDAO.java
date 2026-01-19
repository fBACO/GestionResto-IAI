package org.bnsplits.model.dao;

import org.bnsplits.model.entities.MouvementStock;
import org.bnsplits.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class MouvementStockDAO {
    // Create
    public static void add(MouvementStock mouvementStock) throws SQLException {
        String query = "INSERT INTO mouvement_stock (type, quantite, date_mouvement, motif, id_produit) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setString(1, mouvementStock.getType().name());
            pstmt.setInt(2, mouvementStock.getQuantite());
            pstmt.setTimestamp(3, Timestamp.valueOf(mouvementStock.getDateMouvement()));
            pstmt.setString(4, mouvementStock.getMotif());
            pstmt.setInt(5, mouvementStock.getIdProduit());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Read
    public static MouvementStock getById(int id) throws SQLException {
        String query = "SELECT * FROM mouvement_stock WHERE id_mouvement_stock=?";
        MouvementStock mouvementStock = new MouvementStock();

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                mouvementStock.setIdMouvementStock(rs.getInt("id_mouvement_stock"));
                mouvementStock.setType(MouvementStock.TypeMouvement.valueOf(rs.getString("type")));
                mouvementStock.setQuantite(rs.getInt("quantite"));
                Timestamp dateMouvement = rs.getTimestamp("date_mouvement");
                if (dateMouvement != null) {
                    mouvementStock.setDateMouvement(dateMouvement.toLocalDateTime());
                }
                mouvementStock.setMotif(rs.getString("motif"));
                mouvementStock.setIdProduit(rs.getInt("id_produit"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return mouvementStock;
    }

    public static ArrayList<MouvementStock> getAll() throws SQLException {
        String query = "SELECT * FROM mouvement_stock";
        ArrayList<MouvementStock> mouvements = new ArrayList<>();

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                MouvementStock mouvementStock = new MouvementStock();
                mouvementStock.setIdMouvementStock(rs.getInt("id_mouvement_stock"));
                mouvementStock.setType(MouvementStock.TypeMouvement.valueOf(rs.getString("type")));
                mouvementStock.setQuantite(rs.getInt("quantite"));
                Timestamp dateMouvement = rs.getTimestamp("date_mouvement");
                if (dateMouvement != null) {
                    mouvementStock.setDateMouvement(dateMouvement.toLocalDateTime());
                }
                mouvementStock.setMotif(rs.getString("motif"));
                mouvementStock.setIdProduit(rs.getInt("id_produit"));

                mouvements.add(mouvementStock);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mouvements;
    }

    // Update
    public static void update(MouvementStock mouvementStock) throws SQLException {
        String query = "UPDATE mouvement_stock SET type=?, quantite=?, date_mouvement=?, motif=?, id_produit=? WHERE id_mouvement_stock=?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setString(1, mouvementStock.getType().name());
            pstmt.setInt(2, mouvementStock.getQuantite());
            pstmt.setTimestamp(3, Timestamp.valueOf(mouvementStock.getDateMouvement()));
            pstmt.setString(4, mouvementStock.getMotif());
            pstmt.setInt(5, mouvementStock.getIdProduit());
            pstmt.setInt(6, mouvementStock.getIdMouvementStock());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Delete
    public static void delete(MouvementStock mouvementStock) throws SQLException {
        String query = "DELETE FROM mouvement_stock WHERE id_mouvement_stock=?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setInt(1, mouvementStock.getIdMouvementStock());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
