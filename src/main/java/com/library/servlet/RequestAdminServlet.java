package com.library.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.OrderBookDaoImpl;
import com.library.dao.impl.UsersDaoImpl;
import com.library.model.OrderBook;
import com.library.model.Users;

/**
 * Servlet implementation class RequestAdminServlet
 */
@WebServlet("/requestadmin")
public class RequestAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String uname=request.getParameter("uname1");
		String password=request.getParameter("password1");
		String supplierName=request.getParameter("supplier");
		String bookName=session.getAttribute("newbook").toString();
		Users u1 = new Users(uname, password);
		UsersDaoImpl user=new UsersDaoImpl();
		String adminCheck = user.fetch(u1);
		if (adminCheck.equals("admin")) {
			OrderBook order=new OrderBook(supplierName, bookName);
			OrderBookDaoImpl obDao=new OrderBookDaoImpl();
			obDao.update(order);
			response.sendRedirect("user.jsp");

		}else {
			session.setAttribute("AdminError", "adminWrong");
			response.sendRedirect("requestAdmin.jsp");
		}
		
		

	}

}
