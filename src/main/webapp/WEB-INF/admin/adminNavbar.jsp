<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pahana Edu Bookshop</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/navbar.css">
</head>
<body>
    <header class="sticky-top">
        <nav class="navbar navbar-expand-lg navbar-dark">
            <div class="container">

                <!-- Mobile Toggle Button -->
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent"
                        aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <!-- Navbar Content -->
                <div class="collapse navbar-collapse" id="navbarContent">
                    <!-- Main Navigation -->
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" href="Login?action=showDash"><i class="fas fa-home fa-fw me-1"></i> Home</a>
                        </li>
                        <!-- <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="booksDropdown" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="fas fa-book fa-fw me-1"></i> Books
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="booksDropdown">
                                <li><a class="dropdown-item" href="">Textbooks</a></li>
                                <li><a class="dropdown-item" href="">Novels</a></li>
                                <li><a class="dropdown-item" href="">Reference Books</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="">All Books</a></li>
                            </ul>
                        </li>  -->
                        <li class="nav-item">
                            <a class="nav-link" href="Login?action=listAdmins"><i class="fas fa-pencil-alt fa-fw me-1"></i> Admins</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="CustomerController?action=listCustomer"><i class="fas fa-pencil-alt fa-fw me-1"></i> Customers</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Login?action=product"><i class="fas fa-pencil-alt fa-fw me-1"></i> Products</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="CategoryController?action=listCategory"><i class="fas fa-pencil-alt fa-fw me-1"></i> Categories</a>
                        </li>
                    </ul>

                    
                    <!-- User Actions -->
                    <div class="d-flex user-actions ms-lg-3">
                        <a href="Login?action=logout" class="btn btn-outline-light me-2">
                            <i class="fas fa-user me-1"></i> Logout
                        </a>
                        <a href="cart.html" class="btn btn-warning position-relative">
                            <i class="fas fa-shopping-cart"></i>
                            <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                                3
                            </span>
                        </a>
                    </div>
                </div>
            </div>
        </nav>
    </header>
    <!-- Bootstrap JS Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Custom JS -->
    <script src="/pahana_edu/js/navbar.js"></script>
</body>
</html>