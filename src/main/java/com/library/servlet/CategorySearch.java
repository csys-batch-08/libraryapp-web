package com.library.servlet;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.impl.BooksDaoImpl;
import com.library.exception.InvalidCategoryException;
import com.library.model.Books;

/**
 * Servlet implementation class CategorySearch
 */
@WebServlet("/categorySearch")
public class CategorySearch extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String categoryName=request.getParameter("category");
		String bookTitle=null;
		String authorName=null;
		BooksDaoImpl book=new BooksDaoImpl();
		Books b1=new Books(bookTitle,categoryName,authorName);
		
		
		List<Books> bookList=null;
		try {
			bookList = book.categoryFetch(b1);
			if(bookList.isEmpty()) {
				throw new InvalidCategoryException();
			}
			else {
			request.setAttribute("categoryBookList", bookList);
			RequestDispatcher rd=request.getRequestDispatcher("categorySearch.jsp");
			rd.forward(request, response);
		}
		} catch (InvalidCategoryException e) {
			String validate=e.getMessage();
			request.setAttribute("categoryNotFound", "category");
			RequestDispatcher rd=request.getRequestDispatcher(validate);
			rd.forward(request, response);
			
		}catch (SQLException e) {
			e.getMessage();
		}
		
		
			
			
		 
		
	}

}
