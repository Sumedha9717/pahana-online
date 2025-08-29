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

  <!-- Add Customer Form -->
  <div class="container">
    <div class="form-container">
      <h2>Update Customer</h2>
      
      <%
          List<Customer> customerListedit = (List<Customer>) request.getAttribute("CustomerController");

          if (customerListedit != null && !customerListedit.isEmpty()) {
           for (Customer customer: customerListedit) {
      %>
      
      <form action="CustomerController?action=cus_update&updateid=<%= customer.getC_id() %>" method="POST">
        <label for="cfirstname">First Name</label>
        <input type="text" id="cfirstname" name="cfirstname" value="<%= customer.getC_firstname() %>" required>

        <label for="clastname">Last Name</label>
        <input type="text" id="clastname" name="clastname" value="<%= customer.getC_lastname() %>" required>

        <label for="cusername">Username</label>
        <input type="text" id="cusername"  name="cusername" value="<%= customer.getC_username() %>" required>

        <label for="cemail">Email</label>
        <input type="email" id="cemail" name="cemail" value="<%= customer.getC_email() %>" required>
        
        <label for="cmobile">Mobile</label>
        <input type="number" id="cmobile" name="cmobile" value="<%= customer.getC_mobile() %>" required>
        
        <label for="caddress">Address</label>
        <input type="text" id="caddress" name="caddress" value="<%= customer.getC_address() %>" required>

        <label for="cpassword">Password</label>
        <input type="text" id="cpassword" name="cpassword" value="<%= customer.getC_password() %>" required>
        
		<a href="CustomerController?action=listCustomer" class="btn btn-danger">Discard</a>
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
