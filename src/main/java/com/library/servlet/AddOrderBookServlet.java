package com.library.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addOrderBook")
public class AddOrderBookServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String bookName=request.getParameter("orderBookName");
	       String author=request.getParameter("orderAuthorName");
	       
	       request.setAttribute("orderBookName", bookName);
	       request.setAttribute("orderAuthorName", author);
	       RequestDispatcher rd=request.getRequestDispatcher("addOrderBook.jsp");
	       rd.forward(request, response);
	}

	
	

}
