package com.library.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.impl.BooksDaoImpl;
import com.library.model.Books;

/**
 * Servlet implementation class UnavailableBookServlet
 */
@WebServlet("/unavailableBooks")
public class UnavailableBookServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		BooksDaoImpl user = new BooksDaoImpl();
	

		List<Books> bookList = user.unavailableBookList();
		request.setAttribute("unavailableBookList", bookList);
		RequestDispatcher rd=request.getRequestDispatcher("unavailableBookList.jsp");
		rd.forward(request, response);			
	}

}
