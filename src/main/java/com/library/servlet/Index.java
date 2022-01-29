package com.library.servlet;

import java.io.IOException;

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




@WebServlet("/Index")
public class Index extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	String userName=req.getParameter("uname");
	String password=req.getParameter("password");
	UsersDaoImpl user = new UsersDaoImpl();
	Users u1 = new Users(userName, password);
	
	try {
	String val = user.fetch(u1);
	session.setAttribute("userRole", val);
	
	if (val.equals("admin")) {
        session.setAttribute(val, userName);
		req.setAttribute(val, userName);
		RequestDispatcher rd= req.getRequestDispatcher("admin.jsp");
		rd.forward(req, resp);
	}
	else if (val.equals("supplier")) {
		session.setAttribute(val, userName);
				
						session = req.getSession();
						OrderBookDaoImpl obDao = new OrderBookDaoImpl();
						String bookName=null;
						String author=null;
						userName=session.getAttribute(val).toString();
						OrderBook order=new OrderBook(userName,author,bookName);
						List<OrderBook> orderBook = obDao.view(order);
						req.setAttribute("OrderBookList", orderBook);
						RequestDispatcher rd=req.getRequestDispatcher("supplierLogin.jsp");
						rd.forward(req, resp);
			}
	else if(val.equals("user")) {
		session.setAttribute("user", userName);
		int fineamount=0;
		int userwallet=0;
		int fineOf=0;
		Users u3 = new Users(fineOf,userName);
		UsersDaoImpl user1=new UsersDaoImpl();
		int userWallet= user1.getUserWallet(u3);
		
		session.setAttribute("oldwallet", userwallet);
		session.setAttribute("loginfine", fineamount);
		
		if(userWallet>500) {
			session.setAttribute("userWalletLogin", userWallet);
			req.setAttribute("userWalletLogin", userWallet);
			req.setAttribute("user", userName);
			RequestDispatcher rd= req.getRequestDispatcher("user.jsp");
			rd.forward(req, resp);
			}
		else if(userWallet<=500) {
			session.setAttribute("userWalletLogin", userWallet);
			req.setAttribute("userWalletLogin", userWallet);
			req.setAttribute("user", userName);
			RequestDispatcher rd= req.getRequestDispatcher("walletRecharge.jsp");
			rd.forward(req, resp);
		}
		
		
		}
	
	else {
		
			throw new InvalidUserException();
		
		
		
		
	}
}catch(InvalidUserException e) {
	req.setAttribute("invalidUser", "invalid");
	String validate=e.getMessage();
	RequestDispatcher rd=req.getRequestDispatcher(validate);
	rd.forward(req, resp);
	
}catch(Exception e) {
	e.getMessage();
	
}}
}
