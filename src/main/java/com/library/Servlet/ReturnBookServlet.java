package com.library.Servlet;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String bookName=request.getParameter("bookreturn");
		BooksDaoImpl book=new BooksDaoImpl();
		HttpSession session=request.getSession();
		session.setAttribute("bookname",bookName);
//		String book_title=session.getAttribute("bookname").toString();
		String user_name=session.getAttribute("user").toString();
		Books b1 = new Books(bookName, user_name);
		boolean returnCheck = book.checkReturn(b1);
		if (returnCheck) {
		
				b1=new Books(bookName);
			int book_issue_no=book.getBookIssueNo(b1);
			session.setAttribute("bookissueno", book_issue_no);
			System.out.println(book_issue_no);
			b1 = new Books(bookName);
			book.returnBook(b1);
			response.sendRedirect("bookReturnAdmin.jsp");
		}
		else {
		PrintWriter pw=response.getWriter();
		pw.write("The book You enter is invalid");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String bookName=request.getParameter("bookreturn");
		BooksDaoImpl book=new BooksDaoImpl();
		HttpSession session=request.getSession();
		String book_title=session.getAttribute("bookname").toString();
		String user_name=session.getAttribute("user").toString();
		Books b1 = new Books(book_title, user_name);
		boolean returnCheck = book.checkReturn(b1);
		if (returnCheck) {
		
				b1=new Books(book_title);
			int book_issue_no=book.getBookIssueNo(b1);
			session.setAttribute("bookissueno", book_issue_no);
			System.out.println(book_issue_no);
			b1 = new Books(book_title);
			book.returnBook(b1);
			response.sendRedirect("bookReturnAdmin.jsp");
		}
		else {
		PrintWriter pw=response.getWriter();
		pw.write("The book You enter is invalid");
		}
		
	}

}
