<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>



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

  <!-- Add Admin Form -->
  <div class="container">
    <div class="form-container">
      <h2>Add Admin</h2>
      <form action="AdminController?action=insert" method="POST">
        <label for="firstname">First Name</label>
        <input type="text" id="firstname" name="firstname" required>

        <label for="lastname">Last Name</label>
        <input type="text" id="lastname" name="lastname" required>

        <label for="username">Username</label>
        <input type="text" id="username"  name="username" required>

        <label for="email">Email</label>
        <input type="email" id="email" name="email" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <button type="submit" class="btn btn-add">Save</button>
      </form>
    </div>
  </div>

  <script src="/PahanaeduBookshop/assets_admin/js/script.js"></script>
</body>
</html>