<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


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
      <h2>Add Customer</h2>
      <form action="CustomerController?action=cus_insert" method="POST">
        <label for="cfirstname">First Name</label>
        <input type="text" id="cfirstname" name="cfirstname" required>

        <label for="clastname">Last Name</label>
        <input type="text" id="clastname" name="clastname" required>

        <label for="cusername">Username</label>
        <input type="text" id="cusername"  name="cusername" required>

        <label for="cemail">Email</label>
        <input type="email" id="cemail" name="cemail" required>
        
        <label for="cmobile">Mobile</label>
        <input type="number" id="cmobile" name="cmobile" required>
        
        <label for="caddress">Address</label>
        <input type="text" id="caddress" name="caddress" required>

        <label for="cpassword">Password</label>
        <input type="password" id="cpassword" name="cpassword" required>

        <button type="submit" class="btn btn-add">Save</button>
      </form>
    </div>
  </div>

  <script src="/PahanaeduBookshop/assets_admin/js/script.js"></script>

</body>
</html>