package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDao;
import com.DB.DBConnect;
import com.entities.User;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
	/*	System.out.println("email"+email);
		
		System.out.println("password"+password);*/
		
		
		
		UserDao dao = new UserDao(DBConnect.getConnetion());
		User user=dao.getlogin(email,password);
		
		if(user!=null)
		{
			HttpSession session = request.getSession();
		    session.setAttribute("user", user);
		    response.sendRedirect("product.jsp");
		
		}else {
			PrintWriter out=response.getWriter();
		out.println("login envalid");
		}
		
	}

}
