package com.pahana.Controller;

import com.pahana.Dao.CustomerDao;
import com.pahana.Model.Customer;
import com.pahana.Service.CustomerService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService;

	public void init() throws ServletException {
		customerService = CustomerService.getInstance();

	}

	
	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("cus_edit"))
		{
			String editid =request.getParameter("editid");
			System.out.println("edit id "+editid);
			List<Customer> customerListedit = new ArrayList<>();
			customerListedit = CustomerDao.getEditCustomer(editid);
			request.setAttribute("CustomerController", customerListedit);
			request.getRequestDispatcher("WEB-INF/admin/updateCustomer.jsp").forward(request, response);
		}
		else if (action.equals("listCustomer"))
		{
			List<Customer> customerList = new ArrayList<>();
			customerList = CustomerDao.getAllCustomer();
			request.setAttribute("CustomerController", customerList);
			request.getRequestDispatcher("WEB-INF/admin/customerList.jsp").forward(request, response);
		}
		else if (action.equals("cus_delete"))
		{
			String deleteid =request.getParameter("deleteid");
			CustomerDao.deleteCustomer(deleteid);
			response.sendRedirect(request.getContextPath() + "/CustomerController?action=listCustomer");
		}
		else if (action.equals("cus_add"))
		{
			request.getRequestDispatcher("WEB-INF/admin/customers.jsp").forward(request, response);
		}
		else if (action.equals("showDashboard"))
		{
			request.getRequestDispatcher("/WEB-INF/admin/adminDashboard.jsp").forward(request, response); 
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("cus_insert"))
		{
			String c_firstname = request.getParameter("cfirstname");
			String c_lastname = request.getParameter("clastname");
			String c_username = request.getParameter("cusername");
			String c_email = request.getParameter("cemail");
			String c_mobile = request.getParameter("cmobile");
			String c_address = request.getParameter("caddress");
			String c_password = request.getParameter("cpassword");
			

			Customer customer = new Customer(c_firstname,c_lastname,c_username,c_email,c_mobile,c_address,c_password);
			CustomerDao.addCustomer(customer);
			response.sendRedirect(request.getContextPath() + "/CustomerController?action=listCustomer");
		}
		else if (action.equals("cus_update"))
		{

			String updateid = request.getParameter("updateid");
			String c_firstname = request.getParameter("cfirstname");
			String c_lastname = request.getParameter("clastname");
			String c_username = request.getParameter("cusername");
			String c_email = request.getParameter("cemail");
			String c_mobile = request.getParameter("cmobile");
			String c_address = request.getParameter("caddress");
			String c_password = request.getParameter("cpassword");
			Integer id = Integer.parseInt(updateid);
            System.out.println("password"+ c_password);
			System.out.println("updateid"+ updateid);

			Customer customer = new Customer(id,c_firstname,c_lastname,c_username,c_email,c_mobile,c_address,c_password);
			CustomerDao.updateCustomer(customer);
			response.sendRedirect(request.getContextPath() + "/CustomerController?action=listCustomer");
		}

		doGet(request, response);
	}

}
