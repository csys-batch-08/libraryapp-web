package com.library.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.UsersDaoImpl;
import com.library.model.Users;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/forgotpass")
public class ForgotPasswordServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("uname");
		String password=request.getParameter("password");
		UsersDaoImpl user=new UsersDaoImpl();
		Users users=new Users(userName,password);
		boolean valid=user.forgotPassword(users);
		if(valid) {
			
				  request.setAttribute("passchange", true);
				  RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				  rd.forward(request, response);
			  
		}
		
		
	}

}
