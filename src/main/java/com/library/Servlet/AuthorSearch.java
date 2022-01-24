package com.library.Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.BooksDaoImpl;
import com.library.exception.InvalidCategoryException;
import com.library.model.Books;

/**
 * Servlet implementation class SearchBook
 */
@WebServlet("/authorSearch")
public class AuthorSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String authorName=request.getParameter("author");
		
		BooksDaoImpl book=new BooksDaoImpl();
		HttpSession session = request.getSession();
		try {
		String category = null,book_title=null,author=null;
		Books books=new Books(book_title,category,authorName);
		ResultSet rs = book.authorFetch(books);
		session.setAttribute("booksearch", category);
		
			if (rs.next()){
				do {
				System.out.println(rs.getString(1));
				}while(rs.next());
				response.sendRedirect("AuthorSearch.jsp");

			}
			else {
			
					throw new InvalidCategoryException();
				}
			
		}catch(InvalidCategoryException e){
			String validate=e.getMessage();
			response.sendRedirect(validate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}

}