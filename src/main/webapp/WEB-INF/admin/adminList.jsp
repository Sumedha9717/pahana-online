<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.pahana.Model.Admin" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Management</title>
  <link rel="stylesheet" href="/PahanaeduBookshop/assets_admin/css/style.css">
</head>
<body>

  <!-- Navigation Bar -->
  <nav class="navbar">
    <div class="logo">Admin Manager</div>
    <ul class="nav-links" id="navLinks">
      <li><a href="AdminController?action=showDashboard">Home</a></li>
    </ul>
    <div class="menu-toggle" onclick="toggleMenu()">☰</div>
  </nav>

  <!-- Table Section -->
  <div class="container">
    <div class="table-container">
      <a href="AdminController?action=addadmin" class="btn btn-add">+ Add Admin</a>
      <div class="table-responsive">
        <table id="userTable">
          <thead>
            <tr>
              <th>Admin ID</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Username</th>
              <th>Email</th>
              <th class="text-center">Actions</th>
            </tr>
          </thead>
          
          	<%
                List<Admin> adminList = (List<Admin>) request.getAttribute("LoginController");

                if (adminList != null && !adminList.isEmpty()) {
                    for (Admin admin: adminList) {

            %>
          
          <tbody>
            <tr>
              <td><%= admin.getId() %></td>
              <td><%= admin.getFirstname() %></td>
              <td><%= admin.getLastname()%></td>
              <td><%= admin.getUsername() %></td>
              <td><%= admin.getEmail() %></td>
              <td class="text-center">
                <a href="AdminController?action=edit&editid=<%= admin.getId() %>" class="btn btn-warning">Update</a>
				<a href="AdminController?action=delete&deleteid=<%= admin.getId() %>" class="btn btn-danger">Delete</a>
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