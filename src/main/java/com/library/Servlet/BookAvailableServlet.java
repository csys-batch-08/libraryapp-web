package com.library.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class BookAvailableServlet
 */
@WebServlet("/borrowadmin")
public class BookAvailableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAvailableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String user_name=request.getParameter("uname");
		String password=request.getParameter("password");
		System.out.println(user_name+password);
		UsersDaoImpl user = new UsersDaoImpl();
		Users u1 = new Users(user_name, password);
		System.out.println(user_name);
		System.out.println(password);
		
		String val = user.fetch(u1);
		
		System.out.println(val);
		if (val.equals("admin")) {
			System.out.println("welcome admin " + user_name);
			BooksDaoImpl book=new BooksDaoImpl();
			String book_title=session.getAttribute("bookname").toString();
			System.out.println(book_title);
			String username=session.getAttribute("user").toString();
			Books b1 = new Books(book_title, username);
			book.bookAvail(b1);
			b1 = new Books(book_title);
			int rackNumber = book.getRack(b1);
			System.out.println("The book is in Rack number " + rackNumber);
			PrintWriter pw=response.getWriter();
			pw.write("The book is in Rack number " + rackNumber);
			request.setAttribute("rack", rackNumber);
			username=session.getAttribute("user").toString();
			LocalDate date_issue = LocalDate.now();
			LocalDate date_return = date_issue.plusMonths(3);
			LocalDate date_returned = date_return;
			int fine_range_in_month = 0;
			BookIssue p1 = new BookIssue(username, book_title, date_issue, date_return,date_returned, fine_range_in_month);
			BookIssueDaoImpl bookIssue=new BookIssueDaoImpl();
			bookIssue.insert(p1);
			int book_issue_no=bookIssue.getBookIssueNo(p1);
			Books b2 = new Books(book_title, book_issue_no);
			book.updateBookIssue(b2);
			RequestDispatcher rd=request.getRequestDispatcher("bookBorrowSuccess.jsp");
			rd.forward(request, response);
		}else {
			session.setAttribute("AdminError", "adminWrong");
			response.sendRedirect("bookAvailable.jsp");
		}
	}

}
