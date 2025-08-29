package com.pahana.Controller;

import com.pahana.Dao.AdminDao;
import com.pahana.Model.Admin;
import com.pahana.Service.LoginService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService;

	public void init() throws ServletException {
		loginService = LoginService.getInstance();

	}
       
  
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("edit"))
		{
			String editid =request.getParameter("editid");
			System.out.println("edit id "+editid);
			List<Admin> adminListedit = new ArrayList<>();
			adminListedit = AdminDao.getEditAdmin(editid);
			request.setAttribute("AdminController", adminListedit);
			request.getRequestDispatcher("WEB-INF/admin/updateAdmin.jsp").forward(request, response);
		}
		else if (action.equals("delete"))
		{
			String deleteid =request.getParameter("deleteid");
			AdminDao.addDeleteadmin(deleteid);
			response.sendRedirect(request.getContextPath() + "/LoginController?action=listAdmins");
		}
		else if (action.equals("addadmin"))
		{
			request.getRequestDispatcher("WEB-INF/admin/admins.jsp").forward(request, response);
		}
		else if (action.equals("showDashboard"))
		{
			request.getRequestDispatcher("/WEB-INF/admin/adminDashboard.jsp").forward(request, response); 
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("insert"))
		{
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");

			Admin admin = new Admin(firstname,lastname,username,password,email);
			AdminDao.addAdmins(admin);
			response.sendRedirect(request.getContextPath() + "/LoginController?action=listAdmins");
		}
		else if (action.equals("update"))
		{

			String updateid = request.getParameter("updateid");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			Integer id = Integer.parseInt(updateid);
            System.out.println("passwortd"+ password);
			System.out.println("updateid"+ updateid);

			Admin admin = new Admin(id,firstname,lastname,username,password,email);
			AdminDao.updateAdmin(admin);
			response.sendRedirect(request.getContextPath() + "/LoginController?action=listAdmins");
		}

		doGet(request, response);
	}

}
