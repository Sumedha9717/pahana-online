<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pahana Edu Bookshop</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="./css/home.css">
</head>
<body>
    <!-- Top Bar -->
    <div class="top-bar">
        <div class="container">
            <div class="d-flex justify-content-between align-items-center">
                <!-- Bookstore Name - Left Side -->
                <div class="bookstore-name">
                    <h1>Pahana Edu Bookshop</h1>
                </div>

                <!-- Contact Info - Right Side -->
                <div class="contact-info">
                    <span class="contact-item">
                        <i class="fas fa-map-marker-alt"></i> No,123 Lotus Road, Colombo 1
                    </span>
                    <span class="contact-item">
                        <i class="fas fa-phone"></i> (+94) 77 384 9452
                    </span>
                </div>
            </div>
        </div>
    </div>

    <!-- Navigation Bar -->
    <%@ include file="adminNavbar.jsp" %>

    <!-- Hero Section -->
    <section class="hero-section">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-6">
                    <div class="hero-content">
                        <h2 class="hero-title">DISCOVER KNOWLEDGE</h2>
                        <p class="hero-subtitle">We fuel your learning journey</p>
                        <p class="hero-text">Lorem ipsum dolor sit amet consectetur adipisicing elit.<br>
                        Provident commodi eveniet asperiores similique officio,<br>
                        praesentium placeat esse opportun deserunt est.</p>
                        <a href="#" class="btn btn-primary mt-3">BROWSE BOOKS <i class="fas fa-arrow-right ms-2"></i></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="hero-image">
                        <img src="./assets/home_img.svg" alt="Bookstore" class="img-fluid floating-image">
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Bootstrap JS Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Custom JS -->
    <script src="./js/home.js"></script>
</body>
</html>