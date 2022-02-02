package com.library.servlet;

import java.io.IOException;
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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BooksDaoImpl book = new BooksDaoImpl();
		
		
		
		try {
			List<Books> list=book.showBooks();
			HttpSession session=request.getSession();
			request.setAttribute("booksList", list);
			if((session.getAttribute("userRole").equals("user"))) {
				RequestDispatcher rd=request.getRequestDispatcher("showBook.jsp");
				rd.forward(request, response);
			}else if((session.getAttribute("userRole").equals("admin"))) {
				RequestDispatcher rd=request.getRequestDispatcher("authorShowBook.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

}
