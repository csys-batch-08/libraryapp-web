package com.library.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.impl.UsersDaoImpl;
import com.library.model.Users;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/forgotpass")
public class ForgotPasswordServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("uname");
		String password=request.getParameter("password");
		UsersDaoImpl user=new UsersDaoImpl();
		Users users=new Users(userName,password);
		boolean valid=false;
		try {
			valid = user.forgotPassword(users);
		} catch (SQLException e) {
			e.getMessage();
		}
		if(valid) {
			
				  request.setAttribute("passchange", true);
				  RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				  rd.forward(request, response);
			  
		}
		
		
	}

}
