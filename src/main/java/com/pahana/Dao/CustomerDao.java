package com.pahana.Dao;


import com.pahana.Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
	
	public static List<Customer> getAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        String query = "SELECT * FROM customer";

        try {
            Connection Connection = DbConnectionFactory.getConnection();
            Statement statement1 = Connection.createStatement();
            ResultSet resultSet = statement1.executeQuery(query);

            while (resultSet.next()) {

                int id = resultSet.getInt("cid");
                String firstname = resultSet.getString("Cfirstname");
                String lastname = resultSet.getString("Clastname");
                String username = resultSet.getString("Cusername");
                String email = resultSet.getString("Cemail");
                String mobile = resultSet.getString("Cmobile");
                String address = resultSet.getString("Caddress");

                customerList.add(new Customer(id, firstname, lastname, username, email, mobile, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
	
	public static void addCustomer(Customer customer) {
        String insertQuery = "INSERT INTO customer (Cfirstname,Clastname,Cusername,Cemail,Cmobile,Caddress,Cpassword) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DbConnectionFactory.getConnection();
             PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {

            insertStmt.setString(1, customer.getC_firstname());
            insertStmt.setString(2, customer.getC_lastname());
            insertStmt.setString(3, customer.getC_username());
            insertStmt.setString(4, customer.getC_email());
            insertStmt.setString(5, customer.getC_mobile());
            insertStmt.setString(6, customer.getC_address());
            insertStmt.setString(7, customer.getC_password());

            insertStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }


    }

    public static void deleteCustomer(String deleteid) {
        String query = "DELETE FROM customer WHERE cid = ?";

        try (Connection connection = DbConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, deleteid);
            statement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static List<Customer> getEditCustomer(String editid) {
        List<Customer> getEditCustomer = new ArrayList<>();
        String query = "SELECT * FROM customer WHERE cid = ?";

        try (Connection connection = DbConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, editid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int c_id = rs.getInt("cid");
                String c_firstname = rs.getString("cfirstname");
                String c_lastname = rs.getString("clastname");
                String c_username = rs.getString("cusername");
                String c_email = rs.getString("cemail");
                String c_mobile = rs.getString("cmobile");
                String c_address = rs.getString("caddress");
                String c_password = rs.getString("cpassword");

                getEditCustomer.add(new Customer(c_id, c_firstname, c_lastname, c_username, c_email, c_mobile, c_address, c_password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getEditCustomer;
    }


    public static void updateCustomer(Customer customer) {
        String updateQuery = "UPDATE customer SET Cfirstname=?, Clastname=?, Cusername=?, Cemail=?, Cmobile=?, Caddress=?, Cpassword=? WHERE cid=?";
        try (Connection connection = DbConnectionFactory.getConnection();
             PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {

            updateStmt.setString(1, customer.getC_firstname());
            updateStmt.setString(2, customer.getC_lastname());
            updateStmt.setString(3, customer.getC_username());
            updateStmt.setString(4, customer.getC_email());
            updateStmt.setString(5, customer.getC_mobile());
            updateStmt.setString(6, customer.getC_address());
            updateStmt.setString(7, customer.getC_password());
            updateStmt.setInt(8, customer.getC_id());

            updateStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update Customer", e);
        }
    }
}
