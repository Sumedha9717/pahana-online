package com.pahana.Dao;

import com.pahana.Model.Admin;


import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AdminDao {
    public static void addAdmins(Admin admin) {
        String insertQuery = "INSERT INTO admin (firstname,lastname,username,password,email) VALUES (?, ?, ?, ?,?)";
        try (Connection connection = DbConnectionFactory.getConnection();
             PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {

            insertStmt.setString(1, admin.getFirstname());
            insertStmt.setString(2, admin.getLastname());
            insertStmt.setString(3, admin.getUsername());
            insertStmt.setString(4, admin.getPassword());
            insertStmt.setString(5, admin.getEmail());

            insertStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    public static void addDeleteadmin(String deleteid) {
        String query = "DELETE FROM admin WHERE userid = ?";

        try (Connection connection = DbConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, deleteid);
            statement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static List<Admin> getEditAdmin(String editid) {
        List<Admin> getEditAdmin = new ArrayList<>();
        String query = "SELECT * FROM admin WHERE userid = ?";

        try (Connection connection = DbConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, editid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("userid");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");

                getEditAdmin.add(new Admin(id, firstname, lastname, username,password,email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getEditAdmin;
    }


    public static void updateAdmin(Admin admin) {
        String updateQuery = "UPDATE admin SET firstname=?, lastname=?, username=?, email=?, password=? WHERE userid=?";
        try (Connection connection = DbConnectionFactory.getConnection();
             PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {

            updateStmt.setString(1, admin.getFirstname());
            updateStmt.setString(2, admin.getLastname());
            updateStmt.setString(3, admin.getUsername());
            updateStmt.setString(4, admin.getEmail());
            updateStmt.setString(5, admin.getPassword());
            updateStmt.setInt(6, admin.getId());

            updateStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update Admin", e);
        }
    }

}
