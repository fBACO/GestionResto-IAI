package org.bnsplits.model;

import org.bnsplits.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CategorieDAO {

    public List<Categorie> getAllCategories() throws SQLException {
        List<Categorie> categories = List.of();

        String query = "SELECT * FROM CATEGORIE";
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmp = conn.createStatement();
            ResultSet rs = stmp.executeQuery(query);
            while (rs.next()) {
                categories.add(
                        new Categorie(rs.getInt("id"), rs.getString("libelle"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
}
