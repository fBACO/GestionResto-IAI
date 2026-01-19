package org.bnsplits.model.dao;

import org.bnsplits.model.entities.Categorie;
import org.bnsplits.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategorieDAO {
    // Create
    public static void add(Categorie categorie) throws SQLException {
        String query = "INSERT INTO categorie (libelle) VALUES (?)";
        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setString(1, categorie.getLibelle());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Read
    public static Categorie getById(int id) throws SQLException {
        String query = "SELECT * FROM categorie WHERE id_categorie=?";
        Categorie categorie = new Categorie();

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                categorie.setIdCategorie(rs.getInt("id_categorie"));
                categorie.setLibelle(rs.getString("libelle"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  categorie;
    }

    public static ArrayList<Categorie> getAll() throws SQLException {
        String query = "SELECT * FROM categorie";
        ArrayList<Categorie> categories = new ArrayList<>();

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Categorie categorie = new Categorie();
                categorie.setIdCategorie(rs.getInt("id_categorie"));
                categorie.setLibelle(rs.getString("libelle"));

                categories.add(categorie);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    // Update
    public static void update(Categorie categorie) throws SQLException {
        String query = "UPDATE categorie SET libelle=? WHERE id_categorie=?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setString(1, categorie.getLibelle());
            pstmt.setInt(2, categorie.getIdCategorie());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Delete
    public static void delete(Categorie categorie) throws SQLException {
        String query = "DELETE FROM categorie WHERE id_categorie=?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setInt(1, categorie.getIdCategorie());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
