package com.library.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.impl.UsersDaoImpl;
import com.library.model.Users;

/**
 * Servlet implementation class UserInsert
 */
@WebServlet("/indexrole")
public class UserInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName=request.getParameter("text");
		String city=request.getParameter("text1");
		String password=request.getParameter("text2");
		Long phone=Long.parseLong(request.getParameter("text3"));
		String email=request.getParameter("text4");
		String role=request.getParameter("role");
		
		
		Users user=new Users(userName,city,role,password,phone,email);
		UsersDaoImpl userDao=new UsersDaoImpl();
		try {
			userDao.adminInsert(user);
		} catch (SQLException e) {
			e.getMessage();
		}
		
		response.sendRedirect("admin.jsp");
	}

}
