<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.pahana.Model.Product" %>
<%@ page import="com.pahana.Model.Category" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Product Management</title>
  <link rel="stylesheet" href="/PahanaeduBookshop/assets_admin/css/style.css">
</head>
<body>

  <!-- Navigation Bar -->
  <nav class="navbar">
    <div class="logo">Product Manager</div>
    <ul class="nav-links" id="navLinks">
      <li><a href="CategoryController?action=showDashboard">Home</a></li>
    </ul>
    <div class="menu-toggle" onclick="toggleMenu()">☰</div>
  </nav>

  <!-- Add Customer Form -->
  <div class="container">
    <div class="form-container">
      <h2>Update Product</h2>
      
     <%
     List<Product> productListEdit = (List<Product>) request.getAttribute("productListEdit");
     List<Category> categoryList = (List<Category>) request.getAttribute("categoryList");

        if (productListEdit != null && !productListEdit.isEmpty()) {
          for (Product product : productListEdit) {
      %>
     
      
      <form action="CategoryController?action=itm_update&updateId=<%= product.getPid() %>" method="POST" enctype="multipart/form-data">
        <label for="itemname">Product Name</label>
        <input type="text" id="itemname" name="itemname" value="<%= product.getName() %>" required>

        <label for="itemprice">Price</label>
        <input type="number" step="0.01" id="itemprice" name="itemprice" value="<%= product.getPrice() %>" required>

        <label for="itemdescription">Description</label>
        <textarea id="itemdescription" name="itemdescription" required><%= product.getDescription() %></textarea>

        <label for="Icategory">Category</label>
        <select id="Icategory" name="Icategory" required>
          <% if (categoryList != null) {
               for (Category cat : categoryList) {
          %>
            <option value="<%= cat.getCate_name() %>" <%= cat.getCate_name().equals(product.getCategory()) ? "selected" : "" %>>
              <%= cat.getCate_name() %>
            </option>
          <% } } %>
        </select>

        <label for="Iimage">Product Image</label>
        <input type="file" id="Iimage" name="Iimage" accept="image/*">
        <p>Current Image: <%= product.getPimage() %></p>

        <a href="LoginController?action=product" class="btn btn-danger">Discard</a>
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
 
