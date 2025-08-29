package com.pahana.Controller;

import com.pahana.Dao.CategoryDao;
import com.pahana.Dao.DbConnectionFactory;
import com.pahana.Dao.ProductDao;
import com.pahana.Model.Category;
import com.pahana.Model.Product;
import com.pahana.Service.CategoryService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig( // Enables file upload handling
		fileSizeThreshold =1024*1024*2,  // 2MB
		maxFileSize =1024*1024*10,       // 10MB
		maxRequestSize =1024*1024*50     // 50MB
)
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService categoryService;
       
	public void init() throws ServletException {
		categoryService = CategoryService.getInstance();

	}
	
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> ItemList = new ArrayList<>();

		try (Connection conn = DbConnectionFactory.getConnection();
			 PreparedStatement stmt = conn.prepareStatement("SELECT catename FROM category");
			 ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				ItemList.add(rs.getString("catename"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("ItemList", ItemList);



		String action = request.getParameter("action");
		if (action.equals("cat_edit"))
		{
			String editid =request.getParameter("editid");
			System.out.println("edit id "+editid);
			List<Category> categoryListedit = new ArrayList<>();
			categoryListedit = CategoryDao.getEditCategory(editid);
			request.setAttribute("CategoryController", categoryListedit);
			request.getRequestDispatcher("WEB-INF/admin/updateCategory.jsp").forward(request, response);
		}
		else if (action.equals("listCategory"))
		{
			List<Category> categoryList = new ArrayList<>();
			categoryList = CategoryDao.getAllCategory();
			request.setAttribute("CategoryController", categoryList);
			request.getRequestDispatcher("WEB-INF/admin/categoryList.jsp").forward(request, response);
		}
		else if (action.equals("cat_delete"))
		{
			String deleteid =request.getParameter("deleteid");
			CategoryDao.deleteCategory(deleteid);
			response.sendRedirect(request.getContextPath() + "/CustomerController?action=listCategory");
		}
		else if (action.equals("cat_add"))
		{
			request.getRequestDispatcher("WEB-INF/admin/category.jsp").forward(request, response);
		}
		else if (action.equals("showDashboard"))
		{
			request.getRequestDispatcher("/WEB-INF/admin/adminDashboard.jsp").forward(request, response); 
		}
		else if (action.equals("itm_add"))
		{

			request.getRequestDispatcher("/WEB-INF/admin/Items.jsp").forward(request, response);
		}
		else if (action.equals("itm_delete"))
		{
			String deleteid =request.getParameter("deleteid");
			ProductDao.deleteProduct(deleteid);
			response.sendRedirect(request.getContextPath() + "/LoginController?action=product");
		}
		else if (action.equals("itm_edit"))
		{
			String editId = request.getParameter("editId");
		    System.out.println("edit id" + editId);

		 // Fetch product by ID
		    List<Product> productListEdit = ProductDao.getEditProduct(editId);

		    // Fetch category list for dropdown
		    List<Category> categoryList = CategoryDao.getAllCategory(); // Ensure this method exists

		    // Set attributes with distinct names
		    request.setAttribute("productListEdit", productListEdit);
		    request.setAttribute("categoryList", categoryList);

			request.getRequestDispatcher("WEB-INF/admin/updateItems.jsp").forward(request, response);
		}


		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("cat_insert"))
		{
			String cate_name = request.getParameter("catename");
			String cate_description = request.getParameter("catedescription");
			
			Category category = new Category(cate_name,cate_description);
			CategoryDao.addCategory(category);
			response.sendRedirect(request.getContextPath() + "/CategoryController?action=listCategory");

		}
		else if (action.equals("cat_update"))
		{

			String updateid = request.getParameter("updateid");
			String cate_name = request.getParameter("catename");
			String cate_description = request.getParameter("catedescription");
			Integer id = Integer.parseInt(updateid);
            System.out.println("catename"+ cate_name);
			System.out.println("updateid"+ updateid);

			Category category = new Category(id,cate_name,cate_description);
			CategoryDao.updateCategory(category);
			response.sendRedirect(request.getContextPath() + "/CategoryController?action=listCategory");
		}
		else if (action.equals("itm_insert"))
		{

				Part filePart = request.getPart("Iimage");
				String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

				String uploadPath = getServletContext().getRealPath("") + File.separator + "assets/items/";
				File uploadDir = new File(uploadPath);
				if (!uploadDir.exists()) uploadDir.mkdir();


				String filePath = uploadPath + File.separator + fileName;
				filePart.write(filePath);



				String name = request.getParameter("itemname");
				String price = request.getParameter("itemprice");
				String description = request.getParameter("itemdescription");
				String category = request.getParameter("Icategory");

				Product product = new Product(fileName, name, price, description, category);
				ProductDao.addItemDetails(product);


			response.sendRedirect(request.getContextPath() + "/LoginController?action=product");
		}
		else if (action.equals("itm_update"))
		{

			String updateId = request.getParameter("updateId");
		    String pname = request.getParameter("itemname");
		    String pprice = request.getParameter("itemprice");
		    String pdescription = request.getParameter("itemdescription");
		    String category = request.getParameter("Icategory");

		    Part filePart = request.getPart("Iimage");
		    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

		    String uploadPath = getServletContext().getRealPath("") + File.separator + "assets/items/";
		    File uploadDir = new File(uploadPath);
		    if (!uploadDir.exists()) uploadDir.mkdir();

		    String filePath = uploadPath + File.separator + fileName;
		    filePart.write(filePath);

		    int id = Integer.parseInt(updateId);
		    Product product = new Product(id, fileName, pname, pprice, pdescription, category);
		    ProductDao.updateProduct(product);


			response.sendRedirect(request.getContextPath() + "/LoginController?action=product");
		}

		doGet(request, response);
	}

}
