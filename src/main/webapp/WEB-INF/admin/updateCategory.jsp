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

  <!-- Add Customer Form -->
  <div class="container">
    <div class="form-container">
      <h2>Update Category</h2>
      
      <%
          List<Category> categoryListedit = (List<Category>) request.getAttribute("CategoryController");

          if (categoryListedit != null && !categoryListedit.isEmpty()) {
           for (Category category: categoryListedit) {
      %>
      
      <form action="CategoryController?action=cat_update&updateid=<%= category.getCate_id() %>" method="POST">
        <label for="catename">First Name</label>
        <input type="text" id="catename" name="catename" value="<%= category.getCate_name() %>" required>

        <label for="catedescription">Last Name</label>
        <input type="text" id="catedescription" name="catedescription" value="<%= category.getCate_description() %>" required>
        
		<a href="CategoryController?action=listCategory" class="btn btn-danger">Discard</a>
        <button type="submit" class="btn btn-add">Update</button>
      </form>
      <%
        }
        }
     %>
      
    </div>
  </div>

  <script src="/PahanaeduBookshop/assets_admin/js/script.js"></script>
</body>
</html>
 
