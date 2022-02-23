package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDao;
import com.DB.DBConnect;
import com.entities.User;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	   String name = request.getParameter("name");
	   String email = request.getParameter("email");
	   String contact= request.getParameter("contact");
	  String password= request.getParameter("password");
	  
	  
	  User us= new User();
	  us.setName(name);
	  us.setEmail(email);
	  us.setContact(contact);
	  us.setPassword(password);
	  
	  UserDao dao =new UserDao(DBConnect.getConnetion());
	  boolean f= dao.userRegister(us);
	  
	  
	if(true)
	  {
		  PrintWriter out = response.getWriter();
		  out.print("data insert sucessfully");
		  response.sendRedirect("login.jsp");
	  }
	  else {
		  PrintWriter out = response.getWriter();
		  out.print("data not insert ");
		  
	  }
	  
	  
	  
	}

}
