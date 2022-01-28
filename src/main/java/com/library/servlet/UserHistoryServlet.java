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

import com.library.dao.impl.BookIssueDaoImpl;
import com.library.model.BookIssue;

/**
 * Servlet implementation class UserHistoryServlet
 */
@WebServlet("/UserHistoryList")
public class UserHistoryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookIssueDaoImpl bookIssue=new BookIssueDaoImpl();
		HttpSession session=request.getSession();
		String userName=session.getAttribute("user").toString();
		BookIssue books=new BookIssue(userName);
		try {
						List<BookIssue> bookIssueList = bookIssue.userHistory(books);
						request.setAttribute("bookIssueList", bookIssueList);
						RequestDispatcher rd=request.getRequestDispatcher("userHistory.jsp");
						rd.forward(request, response);
	}catch (SQLException e) {
		e.getMessage();
	}}

}
