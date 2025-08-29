<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.pahana.Model.Category" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Products Management</title>
  <link rel="stylesheet" href="/PahanaeduBookshop/assets_admin/css/style.css">
</head>
<body>

  <!-- Navigation Bar -->
  <nav class="navbar">
    <div class="logo">Products Manager</div>
    <ul class="nav-links" id="navLinks">
      <li><a href="CategoryController?action=showDashboard">Home</a></li>
    </ul>
    <div class="menu-toggle" onclick="toggleMenu()">☰</div>
  </nav>

  <!-- Add Customer Form -->
  <div class="container">
    <div class="form-container">
      <h2>Add Product</h2>
      <form action="CategoryController?action=itm_insert" method="POST" enctype="multipart/form-data">
        <label>Item Image :</label>
        <input type="file" name="Iimage" class="form-control" required>

        <label for="catename">Item Name</label>
        <input type="text" id="itemname" name="itemname" required>

        <label for="catedescription">Item Price</label>
        <input type="text" id="itemprice" name="itemprice" required>

        <label for="catedescription">Item Description</label>
        <input type="text" id="itemdescription" name="itemdescription" required>

        <label>Select Category :</label>
        <select type="text" class="form-control" name="Icategory" placeholder="" >
           <option value="">Select Category</option>
           <%
           List<String> ItemList = (List<String>) request.getAttribute("ItemList");
           if (ItemList != null) {
           for (String Item : ItemList) {
           %>
           <option value="<%= Item %>"><%= Item %></option>
           <%
           }
           }
           %>
        </select>

        <button type="submit" class="btn btn-add">Save</button>
      </form>
    </div>
  </div>

  <script src="/PahanaeduBookshop/assets_admin/js/script.js"></script>

</body>
</html>