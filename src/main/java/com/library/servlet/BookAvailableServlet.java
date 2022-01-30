package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.BookIssueDaoImpl;
import com.library.dao.impl.BooksDaoImpl;
import com.library.dao.impl.UsersDaoImpl;
import com.library.model.BookIssue;
import com.library.model.Books;
import com.library.model.Users;


@WebServlet("/borrowadmin")
public class BookAvailableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

		HttpSession session = request.getSession();
		String userName=request.getParameter("uname");
		String password=request.getParameter("password");
		UsersDaoImpl user = new UsersDaoImpl();
		Users u1 = new Users(userName, password);
		
		String val = user.fetch(u1);
		
		if (val.equals("admin")) {
			BooksDaoImpl book=new BooksDaoImpl();
			String bookTitle=session.getAttribute("bookname").toString();
			String username=session.getAttribute("user").toString();
			Books b1 = new Books(bookTitle, username);
			book.bookAvail(b1);
			b1 = new Books(bookTitle);
			int rackNumber = book.getRack(b1);
			PrintWriter pw=response.getWriter();
			pw.write("The book is in Rack number " + rackNumber);
			request.setAttribute("rack", rackNumber);
			username=session.getAttribute("user").toString();
			LocalDate dateIssue = LocalDate.now();
			LocalDate dateReturn = dateIssue.plusMonths(3);
			LocalDate dateReturned = dateReturn;
			int fineRangeInMonth = 0;
			BookIssue p1 = new BookIssue(username, bookTitle, dateIssue, dateReturn,dateReturned, fineRangeInMonth);
			BookIssueDaoImpl bookIssue=new BookIssueDaoImpl();
			bookIssue.insert(p1);
			int bookIssueNo=bookIssue.getBookIssueNo(p1);
			Books b2 = new Books(bookTitle, bookIssueNo);
			book.updateBookIssue(b2);
			RequestDispatcher rd=request.getRequestDispatcher("bookBorrowSuccess.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("AdminError", "adminWrong");
			RequestDispatcher rd=request.getRequestDispatcher("bookAvailable.jsp");
			rd.forward(request, response);
		}
	}catch(SQLException e) {
		e.getMessage();
	}}

}
