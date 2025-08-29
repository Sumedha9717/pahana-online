package com.pahana.Dao;

import com.pahana.Model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CategoryDao {
	
	public static List<Category> getAllCategory() {
        List<Category> categoryList = new ArrayList<>();
        String query = "SELECT * FROM category";

        try {
            Connection Connection = DbConnectionFactory.getConnection();
            Statement statement1 = Connection.createStatement();
            ResultSet resultSet = statement1.executeQuery(query);

            while (resultSet.next()) {

                int cate_id = resultSet.getInt("cateid");
                String cate_name = resultSet.getString("catename");
                String cate_description = resultSet.getString("catedescription");
              

                categoryList.add(new Category(cate_id, cate_name, cate_description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
	
	public static void addCategory(Category category) {
        String insertQuery = "INSERT INTO category (catename,catedescription) VALUES (?, ?)";
        try (Connection connection = DbConnectionFactory.getConnection();
             PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {

            insertStmt.setString(1, category.getCate_name());
            insertStmt.setString(2, category.getCate_description());
           

            insertStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }


    }

    public static void deleteCategory(String deleteid) {
        String query = "DELETE FROM category WHERE cateid = ?";

        try (Connection connection = DbConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, deleteid);
            statement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static List<Category> getEditCategory(String editid) {
        List<Category> getEditCategory = new ArrayList<>();
        String query = "SELECT * FROM category WHERE cateid = ?";

        try (Connection connection = DbConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, editid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int cate_id = rs.getInt("cateid");
                String cate_name = rs.getString("catename");
                String cate_description = rs.getString("catedescription");

                getEditCategory.add(new Category(cate_id, cate_name, cate_description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getEditCategory;
    }


    public static void updateCategory(Category category) {
        String updateQuery = "UPDATE category SET catename=?, catedescription=? WHERE cateid=?";
        try (Connection connection = DbConnectionFactory.getConnection();
             PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {

            updateStmt.setString(1, category.getCate_name());
            updateStmt.setString(2, category.getCate_description());
            updateStmt.setInt(3, category.getCate_id());

            updateStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update Category", e);
        }
    }

}
