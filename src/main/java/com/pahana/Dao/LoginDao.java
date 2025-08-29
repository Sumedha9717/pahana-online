package com.pahana.Dao;

import com.pahana.Model.Admin;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {
    public static List<Admin> getAllAdmin() {
        List<Admin> adminList = new ArrayList<>();
        String query = "SELECT * FROM admin";

        try {
            Connection Connection = DbConnectionFactory.getConnection();
            Statement statement1 = Connection.createStatement();
            ResultSet resultSet = statement1.executeQuery(query);

            while (resultSet.next()) {

                int id = resultSet.getInt("userid");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");

                adminList.add(new Admin(id, firstname, lastname, username, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }



}
