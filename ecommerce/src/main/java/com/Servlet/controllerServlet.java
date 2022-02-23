package com.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDao;
import com.entities.Product;

@WebServlet("/controllerServlet")
public class controllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public controllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String action = request.getServletPath();
		 
	        try {
	            switch (action) {
	            case "/new":
	                showNewForm(request, response);
	                break;
	            case "/insert":
	                insertProduct(request, response);
	                break;
	            case "/delete":
	                deleteProduct(request, response);
	                break;
	            case "/edit":
	                showEditForm(request, response);
	                break;
	            case "/update":
	                updateProduct(request, response);
	                break;
	            default:
	                listProduct(request, response);
	                break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
		private void listProduct(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
			List<Product> listProduct = UserDao.listAllProducts();
			request.setAttribute("listProduct", listProduct);
			RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
			dispatcher.forward(request, response);
		}
		
		private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("ProductForm.jsp");
	        dispatcher.forward(request, response);
		}
		
		
		  private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		            throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Product existingProduct = UserDao.getproduct("id");
		        RequestDispatcher dispatcher = request.getRequestDispatcher("ProductForm.jsp");
		        request.setAttribute("product", existingProduct);
		        dispatcher.forward(request, response);
		  }
		  
		  
		  private void insertProduct(HttpServletRequest request, HttpServletResponse response)
		            throws SQLException, IOException {
			  String type = request.getParameter("type");
			  String brand = request.getParameter("brand");
			  String price = request.getParameter("price");
			  String size = request.getParameter("size");
			  
			  Product newProduct = new Product(type, brand , price, size);
			  UserDao.insertProduct(newProduct);
			  response.sendRedirect("list");
		  }
		  
		  private void updateProduct(HttpServletRequest request, HttpServletResponse response)
		            throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String type = request.getParameter("type");
				  String brand = request.getParameter("brand");
				  String price = request.getParameter("price");
				  String size = request.getParameter("size");
				  
				  
				  Product newProduct = new Product(type, brand , price, size);
				  UserDao.updateProduct(newProduct);
				  response.sendRedirect("list");
		  }
		  
		  private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
		            throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		 
		        Product product = new Product(id);
		        UserDao.deleteProduct(product);
		        response.sendRedirect("list");
		 
		    }
				  
				  
				  
		
	

}
