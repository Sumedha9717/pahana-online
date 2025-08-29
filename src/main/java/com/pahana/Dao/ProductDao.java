package com.pahana.Dao;

import com.pahana.Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public static List<Product> getAllproduct() {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM product";

        try {
            Connection Connection = DbConnectionFactory.getConnection();
            Statement statement1 = Connection.createStatement();
            ResultSet resultSet = statement1.executeQuery(query);

            while (resultSet.next()) {

                int id = resultSet.getInt("pid");
                String name = resultSet.getString("pname");
                String price = resultSet.getString("pprice");
                String description = resultSet.getString("pdescription");


                productList.add(new Product(id, name, price, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
        public static void addItemDetails(Product product) {
            String category = product.getCategory();
            int cid = 0;

            String query = "SELECT * FROM category WHERE catename=?";

            try (Connection connection = DbConnectionFactory.getConnection();
                 PreparedStatement ps = connection.prepareStatement(query)) {

                // set category name
                ps.setString(1, category);
                ResultSet resultSet = ps.executeQuery();

                if (resultSet.next()) {
                    cid = resultSet.getInt("cateid");
                }

                // Now insert into product table
                String insertQuery = "INSERT INTO product (pimage, pname, pprice, pdescription, cid) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                    insertStmt.setString(1, product.getPimage());
                    insertStmt.setString(2, product.getName());
                    insertStmt.setString(3, String.valueOf(product.getPrice()));
                    insertStmt.setString(4, product.getDescription());
                    insertStmt.setInt(5, cid);

                    insertStmt.executeUpdate();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        public static void deleteProduct(String deleteid) {
            String query = "DELETE FROM product WHERE pid = ?";

            try (Connection connection = DbConnectionFactory.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setString(1, deleteid);
                statement.executeUpdate();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        
        public static List<Product> getEditProduct(String editId) {
            List<Product> getEditProduct = new ArrayList<>();
            String query = "SELECT p.*, c.catename FROM product p JOIN category c ON p.cid = c.cateid WHERE p.pid = ?";

            try (Connection connection = DbConnectionFactory.getConnection();
                 PreparedStatement ps = connection.prepareStatement(query)) {

                ps.setString(1, editId);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                	
                	int p_id = rs.getInt("pid");
                	String p_img = rs.getString("pimage");
                    String p_name = rs.getString("pname");
                    String p_price = rs.getString("pprice");
                    String p_description = rs.getString("pdescription");
                    String cate_name = rs.getString("catename");

                    getEditProduct.add(new Product(p_id, p_img, p_name, p_price, p_description, cate_name));
                	
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return getEditProduct;
        }
        
        public static void updateProduct(Product product) {
            int cid = 0;
            String categoryQuery = "SELECT cateid FROM category WHERE catename = ?";

            try (Connection connection = DbConnectionFactory.getConnection();
                 PreparedStatement categoryStmt = connection.prepareStatement(categoryQuery)) {

                categoryStmt.setString(1, product.getCategory());
                ResultSet rs = categoryStmt.executeQuery();

                if (rs.next()) {
                    cid = rs.getInt("cateid");
                }

                String updateQuery = "UPDATE product SET pimage = ?, pname = ?, pprice = ?, pdescription = ?, cid = ? WHERE pid = ?";
                try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {
                    updateStmt.setString(1, product.getPimage());
                    updateStmt.setString(2, product.getName());
                    updateStmt.setDouble(3, product.getPrice());
                    updateStmt.setString(4, product.getDescription());
                    updateStmt.setInt(5, cid);
                    updateStmt.setInt(6, product.getPid());

                    updateStmt.executeUpdate();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static List<Product> getFeaturedProducts() {
            List<Product> getFeaturedProducts = new ArrayList<>();
            String query = "SELECT p.*, c.catename FROM product p JOIN category c ON p.cid = c.cateid"; // Add WHERE clause if needed

            try (Connection connection = DbConnectionFactory.getConnection();
                 PreparedStatement ps = connection.prepareStatement(query);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                	int p_id = rs.getInt("pid");
                	String p_img = rs.getString("pimage");
                    String p_name = rs.getString("pname");
                    String p_price = rs.getString("pprice");
                    String p_description = rs.getString("pdescription");
                    String cate_name = rs.getString("catename");

                    getFeaturedProducts.add(new Product(p_id, p_img, p_name, p_price, p_description, cate_name));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return getFeaturedProducts;
        }

        
        
    }


