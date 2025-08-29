<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Contact Us</title>

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link rel="stylesheet" href="./css/contact.css">
</head>
<body>

  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand" href="#">Pahana Edu Bookshop</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
              data-bs-target="#navbarNav" aria-controls="navbarNav" 
              aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item">
            <a class="nav-link active" href="ContactController?action=showHome">Home</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Contact Section -->
  <div class="container my-5">
    <div class="contact-section clearfix">

      <!-- Floating Image (Right) -->
      <img src="https://cdn-icons-png.flaticon.com/512/2331/2331966.png" 
           alt="Contact Illustration" class="contact-image">

      <!-- Left Side: Form -->
      <div class="contact-form">
        <div class="contact-header">
          <h2>Contact Us</h2>
          <p>We’d love to hear from you! Fill out the form below and we’ll get back to you soon.</p>
        </div>

        <form id="contactForm">
          <div class="mb-3">
            <label for="name" class="form-label">Your Name</label>
            <input type="text" class="form-control" id="name" placeholder="Enter your name" required>
          </div>
          <div class="mb-3">
            <label for="mobile" class="form-label">Mobile</label>
            <input type="number" class="form-control" id="mobile" placeholder="Enter your mobile number" required>
          </div>
          <div class="mb-3">
            <label for="email" class="form-label">Email Address</label>
            <input type="email" class="form-control" id="email" placeholder="Enter your email" required>
          </div>
          <div class="mb-3">
            <label for="message" class="form-label">Your Message</label>
            <textarea class="form-control" id="message" rows="4" placeholder="Type your message here..." required></textarea>
          </div>
          <button type="submit" class="btn btn-custom w-100">Send Message</button>
        </form>
      </div>
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

  <!-- JavaScript for form submission -->
  <script>
    document.getElementById("contactForm").addEventListener("submit", function(event){
      event.preventDefault();
      alert("Thank you for contacting us! We will get back to you soon.");
      this.reset();
    });
  </script>

</body>
</html>
    