package com.library.Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.BooksDaoImpl;
import com.library.exception.InvalidAuthorException;
import com.library.exception.InvalidCategoryException;
import com.library.model.Books;

/**
 * Servlet implementation class SearchBook
 */
@WebServlet("/authorSearch")
public class AuthorSearch extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String authorName=request.getParameter("author");
		
		BooksDaoImpl book=new BooksDaoImpl();
		HttpSession session = request.getSession();
		
		String category = null,book_title=null,author=null;
		Books books=new Books(book_title,category,authorName);
		
		session.setAttribute("booksearch", category);
		List<Books> bookList=book.authorFetch(books);
		
			if(bookList!=null) {
				request.setAttribute("authorBookList", bookList);
				RequestDispatcher rd=request.getRequestDispatcher("authorSearch.jsp");
				rd.forward(request, response);
			}
			else {
			try {
					throw new InvalidAuthorException();
				}catch(InvalidAuthorException e){
					String validate=e.getMessage();
					response.sendRedirect(validate);
				}
			
		} 
		
		
	}

}