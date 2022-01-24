package com.library.Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

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
@WebServlet("/index1")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignUp() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String user_name=request.getParameter("text");
//		String city=request.getParameter("text1");
//		String password=request.getParameter("text2");
//		Long phone=Long.parseLong(request.getParameter("text3"));
//		String email=request.getParameter("text4");
//		
//		System.out.println(user_name+city+password+phone.toString()+email);
//		
//		Users user=new Users(user_name,city,password,phone,email);
//		UsersDaoImpl userDao=new UsersDaoImpl();
//		userDao.insert(user);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String user_name=request.getParameter("text");
		String city=request.getParameter("text1");
		String password=request.getParameter("text2");
		Long phone=Long.parseLong(request.getParameter("text3"));
		String email=request.getParameter("text4");
		
		System.out.println(user_name+city+password+phone.toString()+email);
		
		Users user=new Users(user_name,city,password,phone,email);
		UsersDaoImpl userDao=new UsersDaoImpl();
		
		try {
			ResultSet rs=userDao.unameCheck(user);
			ResultSet rs1=userDao.emailCheck(user);
			ResultSet rs2=userDao.mobileCheck(user);
			if(rs.next()) {
				session.setAttribute("unameExists", "uname");
				response.sendRedirect("signup.jsp");
			}
			
			else if(rs1.next()) {
				session.setAttribute("emailExists", "uname");
				response.sendRedirect("signup.jsp");
			}
			else if(rs2.next()) {
				session.setAttribute("mobileExists", "uname");
				response.sendRedirect("signup.jsp");
			}else {
				userDao.insert(user);
				
				response.sendRedirect("index.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
