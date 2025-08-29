<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://kit.fontawesome.com/64d58efce2.js" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/3047765448.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/login.css" />
    <title>Login</title>
  </head>
  <body>
    <div class="container">
      <div class="forms-container">
        <div class="signin-form">

             <form action="Login?action=loginAdmin" method="POST" class="sign-in-form">

              <% if (request.getParameter("success") != null) { %>
                 <div class="success">Registration successful! You can now login.</div>
              <% } %>

                <h2 class="title">Login</h2>
                <div class="input-field">
                  <i class="fas fa-user"></i>
                  <input type="text" name="username" placeholder="Username" required/>
                </div>
                <div class="input-field">
                  <i class="fas fa-lock"></i>
                  <input type="password" name="password" placeholder="Password" required/>
                </div>
                <input type="submit" value="login" class="btn solid" />

                <p class="social-text">Or Sign in with social platforms</p>
                <div class="social-media">
                  <a href="#" class="social-icon">
                    <i class="fab fa-facebook-f"></i>
                  </a>
                  <a href="#" class="social-icon">
                    <i class="fab fa-twitter"></i>
                  </a>
                  <a href="#" class="social-icon">
                    <i class="fab fa-google"></i>
                  </a>
                  <a href="#" class="social-icon">
                    <i class="fab fa-linkedin-in"></i>
                  </a>
                </div>
              </form>

        </div>
      </div>
      <div class="panel">
        <div class="content">
          <h3>Don't have an account?</h3>
          <p>
            Create an account to access all features
          </p>
          <a href="CustomerRegister?action=showRegister" class="btn transparent">Sign up</a>
        </div>
        <img src="/pahana_edu/assets/log.svg" class="image" alt="" />
      </div>
    </div>
  </body>
</html>