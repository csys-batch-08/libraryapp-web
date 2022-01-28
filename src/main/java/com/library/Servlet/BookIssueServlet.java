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

import com.library.dao.impl.BookIssueDaoImpl;
import com.library.model.BookIssue;

/**
 * Servlet implementation class BookIssueServlet
 */
@WebServlet("/BookIssueList")
public class BookIssueServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		BookIssueDaoImpl user = new BookIssueDaoImpl();
		HttpSession session=request.getSession();
		List<BookIssue> bookIssue= user.bookIssueList();
		request.setAttribute("BookIssueList", bookIssue);
		RequestDispatcher rd=request.getRequestDispatcher("bookIssueList.jsp");
		rd.forward(request, response);
						
	}

}
