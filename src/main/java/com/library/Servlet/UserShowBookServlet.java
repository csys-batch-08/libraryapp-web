package com.library.Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * Servlet implementation class UserShowBookServlet
 */
@WebServlet("/bookShowUser")
public class UserShowBookServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BooksDaoImpl book = new BooksDaoImpl();
		
		List<Books> list=book.showBooks();
		HttpSession session=request.getSession();
		
		try {
			
			request.setAttribute("booksList", list);
			if((session.getAttribute("user") != null)) {
				RequestDispatcher rd=request.getRequestDispatcher("showBook.jsp");
				rd.forward(request, response);
			}else if((session.getAttribute("admin") != null)) {
				RequestDispatcher rd=request.getRequestDispatcher("authorShowBook.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
