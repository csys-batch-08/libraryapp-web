package com.library.controller;


import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.BooksDaoImpl;
import com.library.exception.InvalidAuthorException;
import com.library.model.Books;


@WebServlet("/authorSearch")
public class AuthorSearch extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String authorName=request.getParameter("author");
		
		BooksDaoImpl book=new BooksDaoImpl();
		HttpSession session = request.getSession();
		
		String category = null;
		String bookTitle=null;
		Books books=new Books(bookTitle,category,authorName);
		
		session.setAttribute("booksearch", category);
		List<Books> bookList=null;
		try {
			bookList = book.authorFetch(books);
		
		
			if(!bookList.isEmpty()) {
				request.setAttribute("authorBookList", bookList);
				RequestDispatcher rd=request.getRequestDispatcher("authorSearch.jsp");
				rd.forward(request, response);
			}
			else {
					throw new InvalidAuthorException();
				}
			
		}catch (InvalidAuthorException e) {
			String validate=e.getMessage();
			request.setAttribute("authorNotFound", "category");
			RequestDispatcher rd=request.getRequestDispatcher(validate);
			rd.forward(request, response);
			
		}  catch (SQLException e1) {
			e1.getMessage();
		}
		
		
	}

}