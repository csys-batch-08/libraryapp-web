package com.library.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.impl.BookIssueDaoImpl;
import com.library.model.BookIssue;


@WebServlet("/BookIssueList")
public class BookIssueServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		BookIssueDaoImpl user = new BookIssueDaoImpl();
		List<BookIssue> bookIssue=null;
		try {
			bookIssue = user.bookIssueList();
		} catch (SQLException e) {
			e.getMessage();
		}
		request.setAttribute("BookIssueList", bookIssue);
		RequestDispatcher rd=request.getRequestDispatcher("bookIssueList.jsp");
		rd.forward(request, response);
						
	}

}
