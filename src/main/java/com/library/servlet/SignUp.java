package com.library.servlet;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class SignUp
 */
@WebServlet("/signUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String userName=request.getParameter("text");
		String city=request.getParameter("text1");
		String password=request.getParameter("text2");
		Long phone=Long.parseLong(request.getParameter("text3"));
		String email=request.getParameter("text4");
		
		
		Users user=new Users(userName,city,password,phone,email);
		UsersDaoImpl userDao=new UsersDaoImpl();
		
		
			try {
			if(userDao.unameCheck(user)) {
				request.setAttribute("unameExists", "uname");
				RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
			}
			
			else if(userDao.emailCheck(user)) {
				session.setAttribute("emailExists", "uname");
				RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
			}
			else if(userDao.mobileCheck(user)) {
				session.setAttribute("mobileExists", "uname");
				RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
			}else {
				userDao.insert(user);
				
				response.sendRedirect("index.jsp");
			}
			}catch (SQLException e) {
				e.getMessage();
			}
		
		
		
	}

}
