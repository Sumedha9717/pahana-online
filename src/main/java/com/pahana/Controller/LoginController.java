package com.pahana.Controller;

import com.pahana.Dao.DbConnectionFactory;
import com.pahana.Dao.LoginDao;
import com.pahana.Dao.ProductDao;
import com.pahana.Model.*;
import com.pahana.Service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService;
       
	public void init() throws ServletException {
		loginService = LoginService.getInstance();
		
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Product> featuredProducts = ProductDao.getFeaturedProducts(); // You can define this method
		request.setAttribute("featuredProducts", featuredProducts);
		request.getRequestDispatcher("index.jsp").forward(request, response);


		String action = request.getParameter("action");
			if (action.equals("showLogin")) {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			else if (action.equals("showDash"))
			{
				showAdminhome(request, response);
			}
			else if (action.equals("listAdmins"))
			{
				List<Admin> adminList = new ArrayList<>();
				adminList = LoginDao.getAllAdmin();
				request.setAttribute("LoginController", adminList);
				request.getRequestDispatcher("WEB-INF/admin/adminList.jsp").forward(request, response);
			}
			else if (action.equals("customer"))
			{

				request.getRequestDispatcher("WEB-INF/admin/customerList.jsp").forward(request, response);
			}

			else if (action.equals("product"))
			{

				List<Product> productList = new ArrayList<>();
				productList = ProductDao.getAllproduct();
				request.setAttribute("LoginController", productList);
				request.getRequestDispatcher("WEB-INF/admin/itemsList.jsp").forward(request, response);
			}

			else if (action.equals("logout")) {
				HttpSession session = request.getSession(false);
				if (session != null) {
					session.invalidate();
				}
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
//		response.getWriter().append("Served at: ").append(request.getContextPath());


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

	    if (action != null && action.equals("loginAdmin")) {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");


	        try (Connection connection = DbConnectionFactory.getConnection()) {

	            String query = "SELECT * FROM admin WHERE username=? AND Password=?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setString(1, username);
	            statement.setString(2, password);
	            ResultSet rs = statement.executeQuery();

	            

	            if (rs.next()) {
//					HttpSession session = request.getSession();
//					session.setAttribute("userId", rs.getInt("id"));
//					session.setAttribute("name", rs.getString("Name"));
//					session.setAttribute("address", rs.getString("Address"));
//					session.setAttribute("mobile", rs.getInt("Mobile"));
//

					showAdminhome(request, response);
	            } else {
	            	
	            	    request.getSession().setAttribute("errorMessage", "Login Failed! Please try again.");
	            	    response.sendRedirect("index.jsp");
	            	    return;
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new ServletException("SQL error: " + e.getMessage());
	        }

	        doGet(request, response);
	    }

	}


	private void showAdminhome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/admin/adminDashboard.jsp").forward(request, response);
	}


}
