<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.pahana.Model.Customer" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Customer Management</title>
  <link rel="stylesheet" href="/PahanaeduBookshop/assets_admin/css/style.css">
</head>
<body>

  <!-- Navigation Bar -->
  <nav class="navbar">
    <div class="logo">Customer Manager</div>
    <ul class="nav-links" id="navLinks">
      <li><a href="CustomerController?action=showDashboard">Home</a></li>
    </ul>
    <div class="menu-toggle" onclick="toggleMenu()">☰</div>
  </nav>

  <!-- Table Section -->
  <div class="container">
    <div class="table-container">
      <a href="CustomerController?action=cus_add" class="btn btn-add">+ Add Customer</a>
      <div class="table-responsive">
        <table id="userTable">
          <thead>
            <tr>
              <th>Customer ID</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Username</th>
              <th>Email</th>
              <th>Mobile</th>
              <th>Address</th>
              <th class="text-center">Actions</th>
            </tr>
          </thead>
          
          	<%
                List<Customer> customerList = (List<Customer>) request.getAttribute("CustomerController");

                if (customerList != null && !customerList.isEmpty()) {
                    for (Customer customer: customerList) {

            %>
          
          <tbody>
            <tr>
              <td><%= customer.getC_id() %></td>
              <td><%= customer.getC_firstname() %></td>
              <td><%= customer.getC_lastname()%></td>
         	  <td><%= customer.getC_username()%></td>
              <td><%= customer.getC_email() %></td>
              <td><%= customer.getC_mobile() %></td>
              <td><%= customer.getC_address() %></td>
              
              <td class="text-center">
                <a href="CustomerController?action=cus_edit&editid=<%= customer.getC_id() %>" class="btn btn-warning">Update</a>
				<a href="CustomerController?action=cus_delete&deleteid=<%= customer.getC_id() %>" class="btn btn-danger">Delete</a>
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