package com.library.Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		List<Users> userList=new ArrayList();

		ResultSet rs = user.userList();
		try {
			while(rs.next()){
				Users users=new Users();
				users.setUser_name(rs.getString(1));
				users.setCity(rs.getString(2));
				users.setMobile_no(rs.getLong(3));
				users.setEmail_id(rs.getString(4));
				users.setUserWallet(rs.getInt(5));
				System.out.println(users);
				userList.add(users);	
			}
			
			session.setAttribute("adminUserList", userList);
			response.sendRedirect("UserList.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
