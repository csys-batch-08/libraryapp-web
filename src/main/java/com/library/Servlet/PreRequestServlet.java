package com.library.Servlet;

import java.io.IOException;

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
 * Servlet implementation class PreRequestServlet
 */
@WebServlet("/bookPrerequest")
public class PreRequestServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		BooksDaoImpl book=new BooksDaoImpl(); 
		HttpSession session=request.getSession();
		String book_title=session.getAttribute("bookname").toString();
		String user_name=session.getAttribute("user").toString();
			Books b1 = new Books(book_title, user_name);
			String prerequestStatus=book.preRequest(b1);
			
			request.setAttribute("preRequestStatus", prerequestStatus);
			RequestDispatcher rd=request.getRequestDispatcher("bookPreRequest.jsp");
			rd.forward(request, response);
	}

}
