<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.pahana.Model.Category" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Category Management</title>
  <link rel="stylesheet" href="/PahanaeduBookshop/assets_admin/css/style.css">
</head>
<body>

  <!-- Navigation Bar -->
  <nav class="navbar">
    <div class="logo">Category Manager</div>
    <ul class="nav-links" id="navLinks">
      <li><a href="CategoryController?action=showDashboard">Home</a></li>
    </ul>
    <div class="menu-toggle" onclick="toggleMenu()">☰</div>
  </nav>

  <!-- Table Section -->
  <div class="container">
    <div class="table-container">
      <a href="CategoryController?action=cat_add" class="btn btn-add">+ Add Category</a>
      <div class="table-responsive">
        <table id="userTable">
          <thead>
            <tr>
              <th>Category ID</th>
              <th>Category Name</th>
              <th>Category Description</th>
              <th class="text-center">Actions</th>
            </tr>
          </thead>
          
          	<%
                List<Category> categoryList = (List<Category>) request.getAttribute("CategoryController");

                if (categoryList != null && !categoryList.isEmpty()) {
                    for (Category category: categoryList) {

            %>
          
          <tbody>
            <tr>
              <td><%= category.getCate_id() %></td>
              <td><%= category.getCate_name() %></td>
              <td><%= category.getCate_description()%></td>
              
              <td class="text-center">
                <a href="CategoryController?action=cat_edit&editid=<%= category.getCate_id() %>" class="btn btn-warning">Update</a>
				<a href="CategoryController?action=cat_delete&deleteid=<%= category.getCate_id() %>" class="btn btn-danger">Delete</a>
              </td>
            </tr>
          </tbody>
          
           <%
               }
             }
           %>
          
        </table>
      </div>
    </div>
  </div>

  <script src="/PahanaeduBookshop/assets_admin/js/script.js"></script>
</body>
</html>