package com.library.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.BooksDaoImpl;
import com.library.model.Books;

/**
 * Servlet implementation class BorrowBookServlet
 */
@WebServlet("/bookName")
public class BorrowBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName=session.getAttribute("user").toString();
		String bookName=request.getParameter("bookname");
		session.setAttribute("bookname", bookName);
		BooksDaoImpl book=new BooksDaoImpl();
		Books b1 = new Books(bookName, userName);
		String availability=null;
		int count=0;
		try {
			availability = book.bookBorrow(b1);
			count=book.eligle(b1);
			if(count>=2) {
				request.setAttribute("eligible", "adminWrong");
				RequestDispatcher rd=request.getRequestDispatcher("user.jsp");
				rd.forward(request, response);
			}else if (availability.equals("available")) {
				response.sendRedirect("bookAvailable.jsp");
			}else {
				response.sendRedirect("bookUnavailable.jsp");
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		
			
				
			}
		
	
}
