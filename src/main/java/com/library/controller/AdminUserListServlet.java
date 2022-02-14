package com.library.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.impl.UsersDaoImpl;
import com.library.model.Users;


@WebServlet("/adminUserList")
public class AdminUserListServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDaoImpl user = new UsersDaoImpl();
		List<Users> userList=null;
		try {
			userList = user.userList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("adminUserList", userList);
		RequestDispatcher rd=request.getRequestDispatcher("userList.jsp");
		rd.forward(request, response);
		
	}

}
