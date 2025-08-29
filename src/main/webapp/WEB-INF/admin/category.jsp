<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


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
      <h2>Add Category</h2>
      <form action="CategoryController?action=cat_insert" method="POST">
        <label for="catename">Category Name</label>
        <input type="text" id="catename" name="catename" required>

        <label for="catedescription">Category Description</label>
        <input type="text" id="catedescription" name="catedescription" required>


        <button type="submit" class="btn btn-add">Save</button>
      </form>
    </div>
  </div>

  <script src="/PahanaeduBookshop/assets_admin/js/script.js"></script>

</body>
</html>