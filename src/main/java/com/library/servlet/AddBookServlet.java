package com.library.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.impl.BooksDaoImpl;
import com.library.dao.impl.OrderBookDaoImpl;
import com.library.model.Books;
import com.library.model.OrderBook;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
	

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookCode=request.getParameter("text");
		String bookName=request.getParameter("text1");
		String category=request.getParameter("text2");
		String author=request.getParameter("text3");
		int price=Integer.parseInt(request.getParameter("text4"));
		int rackNumber=Integer.parseInt(request.getParameter("text5"));
		
		 OrderBookDaoImpl obDao=new OrderBookDaoImpl();
	       OrderBook order=new OrderBook("null",bookName,author);
	       try {
			obDao.updateStatus(order);
		} catch (SQLException e) {
			e.getMessage();
		}
		BooksDaoImpl book=new BooksDaoImpl();
		Books p1 = new Books(bookCode, bookName, category, author, price, rackNumber);
		try {
			book.insert(p1);
		} catch (Exception e) {
			e.getMessage();
		}
		response.sendRedirect("admin.jsp");
	}

}
