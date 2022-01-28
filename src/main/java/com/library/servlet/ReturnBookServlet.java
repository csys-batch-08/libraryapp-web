package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.BooksDaoImpl;
import com.library.model.Books;

/**
 * Servlet implementation class ReturnBookServlet
 */
@WebServlet("/bookReturn")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BooksDaoImpl book=new BooksDaoImpl();
		HttpSession session=request.getSession();
		String bookTitle=session.getAttribute("bookname").toString();
		String userName=session.getAttribute("user").toString();
		Books b1 = new Books(bookTitle, userName);
		boolean returnCheck = book.checkReturn(b1);
		if (returnCheck) {
		
				b1=new Books(bookTitle);
			int bookIssueNo=book.getBookIssueNo(b1);
			session.setAttribute("bookissueno", bookIssueNo);
			b1 = new Books(bookTitle);
			book.returnBook(b1);
			response.sendRedirect("bookReturnAdmin.jsp");
		}
		else {
		PrintWriter pw=response.getWriter();
		pw.write("The book You enter is invalid");
		}
		
	}

}
