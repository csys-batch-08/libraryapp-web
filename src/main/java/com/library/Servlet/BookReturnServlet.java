package com.library.Servlet;

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
 * Servlet implementation class BookReturnServlet
 */
@WebServlet("/BookReturn")
public class BookReturnServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BooksDaoImpl book=new BooksDaoImpl();
		HttpSession session=request.getSession();
		String user_name=session.getAttribute("user").toString();
		String book_name=null;
		Books books=new Books(book_name,user_name);

		List<Books> returnBooks=book.returnBookList(books);
		System.out.println(returnBooks);
		request.setAttribute("returnBookList", returnBooks);
		RequestDispatcher rd=request.getRequestDispatcher("returnBook.jsp");
		rd.forward(request, response);
	}

}
