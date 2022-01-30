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
import javax.servlet.http.HttpSession;

import com.library.dao.impl.BooksDaoImpl;
import com.library.exception.InvalidReturnException;
import com.library.model.Books;

/**
 * Servlet implementation class BookReturnServlet
 */
@WebServlet("/BookReturn")
public class BookReturnServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BooksDaoImpl book=new BooksDaoImpl();
		HttpSession session=request.getSession();
		String userName=session.getAttribute("user").toString();
		String bookName=null;
		Books books=new Books(bookName,userName);

		List<Books> returnBooks=null;
		try {
			returnBooks = book.returnBookList(books);
			if(returnBooks.isEmpty()) {
				throw new InvalidReturnException();
			}
			else {
		request.setAttribute("returnBookList", returnBooks);
		RequestDispatcher rd=request.getRequestDispatcher("returnBook.jsp");
		rd.forward(request, response);
			}
		} catch (InvalidReturnException e) {
			String validate=e.getMessage();
			response.sendRedirect(validate);
		} catch (SQLException e) {
			e.getMessage();
		}
	}

}
