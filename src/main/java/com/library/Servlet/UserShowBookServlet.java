package com.library.Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.BooksDaoImpl;
import com.library.model.Books;

/**
 * Servlet implementation class UserShowBookServlet
 */
@WebServlet("/bookShowUser")
public class UserShowBookServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BooksDaoImpl book = new BooksDaoImpl();
		ResultSet rs = book.showBooks();
		List<Books> list=new ArrayList();
		HttpSession session=request.getSession();
		
		try {
			while(rs.next()) {
				Books books=new Books();
				books.setBook_title(rs.getString(1));
				books.setAuthor(rs.getString(3));
				books.setCategory(rs.getString(2));
				list.add(books);
				
				
			}
			session.setAttribute("booksList", list);
			if((session.getAttribute("user") != null)) {
			response.sendRedirect("showBook.jsp");
			}else if((session.getAttribute("admin") != null)) {
				response.sendRedirect("authorShowBook.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
