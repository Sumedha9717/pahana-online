<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pahana Edu Bookshop</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="/pahana_edu/css/navbar.css">
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
                            <a class="nav-link active" href=""><i class="fas fa-home fa-fw me-1"></i> Home</a>
                        </li>
             
                        <li class="nav-item">
                            <a class="nav-link" href="about.html"><i class="fas fa-info-circle fa-fw me-1"></i> About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ContactController?action=showContact"><i class="fas fa-envelope fa-fw me-1"></i> Contact</a>
                        </li>
                    </ul>

                    

                    <!-- User Actions -->
                    <div class="d-flex user-actions ms-lg-3">
                        <a href="Login?action=showLogin" class="btn btn-outline-light me-2">
                            <i class="fas fa-user me-1"></i> Login
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
