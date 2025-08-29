package com.pahana.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ContactController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equals("showContact"))
		{
			request.getRequestDispatcher("/WEB-INF/contactus.jsp").forward(request, response); 
		}
		else if (action.equals("showHome"))
		{
			request.getRequestDispatcher("/index.jsp").forward(request, response); 
		}


		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}
