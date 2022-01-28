package com.library.Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class CategorySearch
 */
@WebServlet("/categorySearch")
public class CategorySearch extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String categoryName=request.getParameter("category");
		String bookTitle=null;
		String authorName=null;
		BooksDaoImpl book=new BooksDaoImpl();
		Books b1=new Books(bookTitle,categoryName,authorName);
		
		
		List<Books> bookList=book.categoryFetch(b1);
		
		
			request.setAttribute("categoryBookList", bookList);
			RequestDispatcher rd=request.getRequestDispatcher("categorySearch.jsp");
			rd.forward(request, response);
			
		 
		
	}

}
