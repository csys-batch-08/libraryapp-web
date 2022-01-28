package com.library.Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.UsersDaoImpl;
import com.library.model.Books;
import com.library.model.Users;

/**
 * Servlet implementation class AdminUserListServlet
 */
@WebServlet("/adminUserList")
public class AdminUserListServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDaoImpl user = new UsersDaoImpl();
		HttpSession session=request.getSession();
		List<Users> userList=user.userList();
		request.setAttribute("adminUserList", userList);
		RequestDispatcher rd=request.getRequestDispatcher("userList.jsp");
		rd.forward(request, response);
		
	}

}
