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
import com.library.exception.InvalidUserException;
import com.library.model.Users;





/**
 * Servlet implementation class Index
 */


@WebServlet("/signup11")
public class Index extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	String user_name=req.getParameter("uname");
	String password=req.getParameter("password");
//	System.out.println(user_name+password);
//	UsersDaoImpl user = new UsersDaoImpl();
	System.out.println(user_name+password);
	UsersDaoImpl user = new UsersDaoImpl();
	Users u1 = new Users(user_name, password);
	System.out.println(user_name);
	System.out.println(password);
	
	String val = user.fetch(u1);
	
	
	System.out.println(val);
	if (val.equals("admin")) {
session.setAttribute("admin", user_name);
		System.out.println("welcome admin " + user_name);
		
		resp.sendRedirect("admin.jsp");
	}
	else if (val.equals("supplier")) {
		session.setAttribute("supplier", user_name);
				System.out.println("welcome Supplier " + user_name);
				
				resp.sendRedirect("supplierLogin.jsp");
			}
	else if(val.equals("user")) {
		session.setAttribute("user", user_name);
		System.out.println("Welcome User" + user_name);
		int fineamount=0,userwallet=0;
		int fineOf=0;
		Users u3 = new Users(fineOf,user_name);
		UsersDaoImpl user1=new UsersDaoImpl();
		ResultSet rs = user1.getFine(u3);
		try {
			fineamount=Integer.parseInt(rs.getString(1));
			userwallet=Integer.parseInt(rs.getString(2));
			session.setAttribute("oldwallet", userwallet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(fineamount);
		session.setAttribute("loginfine", fineamount);
		
		if(userwallet>500) {
			session.setAttribute("userWalletLogin", userwallet);
			resp.sendRedirect("user.jsp");
			}
		else if(userwallet<=500) {
			resp.sendRedirect("walletRecharge.jsp");
		}
		
		
		}
	
	else {
		try {
			throw new InvalidUserException();
		}catch(InvalidUserException e) {
			session.setAttribute("invalidUser", "invalid");
			String validate=e.getMessage();
			resp.sendRedirect(validate);
			
		}
		
		
		
	}
}
}
