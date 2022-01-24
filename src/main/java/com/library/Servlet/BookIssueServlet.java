package com.library.Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		List<BookIssue> bookIssue=new ArrayList();

						ResultSet rs = user.bookIssueList();
						try {
							while(rs.next()){
							BookIssue books=new BookIssue();
							books.setBook_code(rs.getString(2));
							books.setUser_name(rs.getString(1));
							books.setDate_issue(rs.getDate(3).toLocalDate());
							books.setDate_return(rs.getDate(4).toLocalDate());
							books.setDate_returned(rs.getDate(5).toLocalDate());
							books.setFine_range(rs.getInt(6));
							books.setBook_issue_id(rs.getInt(7));
							bookIssue.add(books);
							
							
								
							}
							session.setAttribute("BookIssueList", bookIssue);
							response.sendRedirect("BookIssueList.jsp");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		
	}

}
