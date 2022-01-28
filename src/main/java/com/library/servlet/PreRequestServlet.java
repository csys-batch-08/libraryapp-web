package com.library.servlet;

import java.io.IOException;
import java.sql.SQLException;

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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		BooksDaoImpl book=new BooksDaoImpl(); 
		HttpSession session=request.getSession();
		String bookTitle=session.getAttribute("bookname").toString();
		String userName=session.getAttribute("user").toString();
			Books b1 = new Books(bookTitle, userName);
			String prerequestStatus=null;
			try {
				prerequestStatus = book.preRequest(b1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("preRequestStatus", prerequestStatus);
			RequestDispatcher rd=request.getRequestDispatcher("bookPreRequest.jsp");
			rd.forward(request, response);
	}

}
