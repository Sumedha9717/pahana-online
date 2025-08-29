<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.pahana.Model.Product" %>

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

  <!-- Table Section -->
  <div class="container">
    <div class="table-container">
      <a href="CategoryController?action=itm_add" class="btn btn-add">+ Add Product</a>
      <div class="table-responsive">
        <table id="userTable">
          <thead>
            <tr>
              <th> ID</th>
              <th>product Name</th>
              <th>product price</th>
              <th>product Description</th>
              <th class="text-center">Actions</th>
            </tr>
          </thead>
          
          	<%
                List<Product> productList = (List<Product>) request.getAttribute("LoginController");

                if (productList != null && !productList.isEmpty()) {
                    for (Product product: productList) {

            %>
          
          <tbody>
            <tr>
              <td><%= product.getPid() %></td>
              <td><%= product.getName()  %></td>
              <td><%= product.getPrice()%></td>
              <td><%= product.getDescription()%></td>

              <td class="text-center">
                <a href="CategoryController?action=itm_edit&editId=<%= product.getPid() %>" class="btn btn-warning">Update</a>
				<a href="CategoryController?action=itm_delete&deleteid=<%= product.getPid() %>" class="btn btn-danger">Delete</a>
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