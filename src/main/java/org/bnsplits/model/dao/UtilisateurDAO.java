package org.bnsplits.model.dao;

import org.bnsplits.model.entities.Utilisateur;
import org.bnsplits.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurDAO {
    // Create
    public static void add(Utilisateur utilisateur) throws SQLException {
        String query = "INSERT INTO utilisateur (login, username, mot_de_passe) VALUES (?, ?, ?)";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setString(1, utilisateur.getLogin());
            pstmt.setString(2, utilisateur.getUsername());
            pstmt.setString(3, utilisateur.getMotDePasse());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Read
    public static Utilisateur getById(Integer id) throws SQLException {
        String query = "SELECT * FROM utilisateur WHERE id_utilisateur = ?";
        Utilisateur utilisateur = new Utilisateur();

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                utilisateur = new Utilisateur(
                        rs.getInt("id_utilisateur"),
                        rs.getString("login"),
                        rs.getString("username"),
                        rs.getString("mot_de_passe")
                );
                utilisateur.setIdUtilisateur(
                        rs.getInt("id_utilisateur")
                );
            }
        } catch (SQLException e) {
            throw e;
        }

        return utilisateur;
    }

    // Update
    public static void update(Utilisateur utilisateur) throws SQLException {
        String query = "UPDATE utilisateur SET login=?, username=?, mot_de_passe=? WHERE id_utilisateur=?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setString(1, utilisateur.getLogin());
            pstmt.setString(2, utilisateur.getUsername());
            pstmt.setString(3, utilisateur.getMotDePasse());
            pstmt.setInt(4, utilisateur.getIdUtilisateur());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Delete
    public static void delete(Utilisateur utilisateur) throws SQLException {
        String query = "DELETE FROM utilisateur WHERE id_utilisateur=?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setInt(1, utilisateur.getIdUtilisateur());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
