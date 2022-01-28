package com.library.Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.OrderBookDaoImpl;
import com.library.dao.impl.UsersDaoImpl;
import com.library.exception.InvalidUserException;
import com.library.model.OrderBook;
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
	session.setAttribute("userRole", val);
	
	System.out.println(val);
	if (val.equals("admin")) {
session.setAttribute("admin", user_name);
		System.out.println("welcome admin " + user_name);
		req.setAttribute("admin", user_name);
		RequestDispatcher rd= req.getRequestDispatcher("admin.jsp");
		rd.forward(req, resp);
	}
	else if (val.equals("supplier")) {
		session.setAttribute("supplier", user_name);
				System.out.println("welcome Supplier " + user_name);
				
						session = req.getSession();
						OrderBookDaoImpl obDao = new OrderBookDaoImpl();
						String book_name=null;
						String author=null;
						user_name=session.getAttribute("supplier").toString();
						OrderBook order=new OrderBook(user_name,author,book_name);
						List<OrderBook> orderBook = obDao.view(order);
						req.setAttribute("OrderBookList", orderBook);
						RequestDispatcher rd=req.getRequestDispatcher("supplierLogin.jsp");
						rd.forward(req, resp);
			}
	else if(val.equals("user")) {
		session.setAttribute("user", user_name);
		System.out.println("Welcome User" + user_name);
		int fineamount=0,userwallet=0;
		int fineOf=0;
		Users u3 = new Users(fineOf,user_name);
		UsersDaoImpl user1=new UsersDaoImpl();
		int userWallet= user1.getUserWallet(u3);
		
		session.setAttribute("oldwallet", userwallet);
		System.out.println(userWallet);
		session.setAttribute("loginfine", fineamount);
		
		if(userWallet>500) {
			session.setAttribute("userWalletLogin", userWallet);
			req.setAttribute("userWalletLogin", userWallet);
			req.setAttribute("user", user_name);
			RequestDispatcher rd= req.getRequestDispatcher("user.jsp");
			rd.forward(req, resp);
			}
		else if(userWallet<=500) {
			session.setAttribute("userWalletLogin", userWallet);
			req.setAttribute("userWalletLogin", userWallet);
			req.setAttribute("user", user_name);
			RequestDispatcher rd= req.getRequestDispatcher("walletRecharge.jsp");
			rd.forward(req, resp);
		}
		
		
		}
	
	else {
		try {
			throw new InvalidUserException();
		}catch(InvalidUserException e) {
			req.setAttribute("invalidUser", "invalid");
			String validate=e.getMessage();
			RequestDispatcher rd=req.getRequestDispatcher(validate);
			rd.forward(req, resp);
			
		}
		
		
		
	}
}
}
