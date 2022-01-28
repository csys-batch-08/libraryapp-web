package com.library.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddOrderBookServlet
 */
@WebServlet("/addOrderBook")
public class AddOrderBookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String bookName=request.getParameter("orderBookName");
	       String author=request.getParameter("orderAuthorName");
	       System.out.println(bookName);
	       request.setAttribute("orderBookName", bookName);
	       request.setAttribute("orderAuthorName", author);
	       RequestDispatcher rd=request.getRequestDispatcher("addOrderBook.jsp");
	       rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String bookName=request.getParameter("orderBookName");
	       String author=request.getParameter("orderAuthorName");
	       System.out.println(bookName);
	       request.setAttribute("orderBookName", bookName);
	       request.setAttribute("orderAuthorName", author);
	       RequestDispatcher rd=request.getRequestDispatcher("addOrderBook.jsp");
	       rd.forward(request, response);
	}

}
