package com.library.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.OrderBookDaoImpl;
import com.library.model.OrderBook;

/**
 * Servlet implementation class RequestBookServlet
 */
@WebServlet("/requestBook")
public class RequestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String bookName=request.getParameter("bookName");
		String author=request.getParameter("authorName");
		session.setAttribute("newbook", bookName);
		String userName=session.getAttribute("user").toString();
		String supplierId = null;
		OrderBook p1 = new OrderBook(userName, bookName, author, supplierId);
		OrderBookDaoImpl obDao=new OrderBookDaoImpl();
		try {
			obDao.insert(p1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("requestAdmin.jsp");
		
	}

}
