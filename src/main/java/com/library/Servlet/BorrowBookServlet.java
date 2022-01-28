package com.library.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.BooksDaoImpl;
import com.library.model.BookIssue;
import com.library.model.Books;
import com.library.model.Users;

/**
 * Servlet implementation class BorrowBookServlet
 */
@WebServlet("/bookName")
public class BorrowBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user_name=session.getAttribute("user").toString();
		String book_name=request.getParameter("bookname");
		session.setAttribute("bookname", book_name);
//		String user_name="mani";
		System.out.println(book_name);
		System.out.println(user_name);
		PrintWriter pw=response.getWriter();
		BooksDaoImpl book=new BooksDaoImpl();
		Books b1 = new Books(book_name, user_name);
		String availability = book.bookBorrow(b1);
		int count=book.eligle(b1);
		
			
				if(count>=2) {
					session.setAttribute("eligible", "hi");
					response.sendRedirect("user.jsp");
				}else if (availability.equals("available")) {
					System.out.println("available");
					response.sendRedirect("bookAvailable.jsp");
				}else {
					System.out.println("Unavailable");
					response.sendRedirect("bookUnavailable.jsp");
				}
			}
		

//			if (opinion.equals("yes")) {

//				System.out.println("Here After admin will takeover");
//				System.out.println("Hi admin Enter your user_name");
//				String uname = sc.nextLine();
//				System.out.println("Enter PassWord");
//				String password = sc.nextLine();
//				Users u1 = new Users(uname, password);
//				String adminCheck = user.fetch(u1);
//				if (adminCheck.equals("admin")) {
//					b1 = new Books(book_title, user_name);
//					book.bookAvail(b1);
//					b1 = new Books(book_title);
//					int rackNumber = book.getRack(b1);
//					System.out.println("The book is in Rack number " + rackNumber);
//					LocalDate date_issue = LocalDate.now();
//					LocalDate date_return = date_issue.plusMonths(3);
//					LocalDate date_returned = date_return;
//					int fine_range_in_month = 0;
//					BookIssue p1 = new BookIssue(user_name, book_title, date_issue, date_return,date_returned, fine_range_in_month);
//
//					bookIssue.insert(p1);
//					int book_issue_no=bookIssue.getBookIssueNo(p1);
//					Books b2 = new Books(book_title, book_issue_no);
//					book.updateBookIssue(b2);
		
	//	response.sendRedirect("bookAvailable.jsp");
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String user_name=session.getAttribute("user").toString();
		String book_name=request.getParameter("bookname");
		session.setAttribute("bookname", book_name);
//		String user_name="mani";
		System.out.println(book_name);
		System.out.println(user_name);
		PrintWriter pw=response.getWriter();
		BooksDaoImpl book=new BooksDaoImpl();
		Books b1 = new Books(book_name, user_name);
		String availability = book.bookBorrow(b1);
		int count=book.eligle(b1);
	
				if(count>=2) {
					session.setAttribute("eligible", "hi");
					response.sendRedirect("user.jsp");
				}else if (availability.equals("available")) {
					System.out.println("available");
					response.sendRedirect("bookAvailable.jsp");
				}else {
					System.out.println("Unavailable");
					response.sendRedirect("bookUnavailable.jsp");
				
			}
		} 
		

//			if (opinion.equals("yes")) {

//				System.out.println("Here After admin will takeover");
//				System.out.println("Hi admin Enter your user_name");
//				String uname = sc.nextLine();
//				System.out.println("Enter PassWord");
//				String password = sc.nextLine();
//				Users u1 = new Users(uname, password);
//				String adminCheck = user.fetch(u1);
//				if (adminCheck.equals("admin")) {
//					b1 = new Books(book_title, user_name);
//					book.bookAvail(b1);
//					b1 = new Books(book_title);
//					int rackNumber = book.getRack(b1);
//					System.out.println("The book is in Rack number " + rackNumber);
//					LocalDate date_issue = LocalDate.now();
//					LocalDate date_return = date_issue.plusMonths(3);
//					LocalDate date_returned = date_return;
//					int fine_range_in_month = 0;
//					BookIssue p1 = new BookIssue(user_name, book_title, date_issue, date_return,date_returned, fine_range_in_month);
//
//					bookIssue.insert(p1);
//					int book_issue_no=bookIssue.getBookIssueNo(p1);
//					Books b2 = new Books(book_title, book_issue_no);
//					book.updateBookIssue(b2);
		
	//	response.sendRedirect("bookAvailable.jsp");

	

}
