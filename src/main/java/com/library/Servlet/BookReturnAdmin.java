package com.library.Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.BookIssueDaoImpl;
import com.library.dao.impl.FineHistoryDaoImpl;
import com.library.dao.impl.FinesDaoImpl;
import com.library.dao.impl.UsersDaoImpl;
import com.library.exception.InvalidFineException;
import com.library.exception.InvalidUserException;
import com.library.model.BookIssue;
import com.library.model.Fines;
import com.library.model.Users;

/**
 * Servlet implementation class BookReturnAdmin
 */
@WebServlet("/returnadmin")
public class BookReturnAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookReturnAdmin() {
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
		String user_name=request.getParameter("uname1");
		String password=request.getParameter("password1");
		LocalDate date_returned=LocalDate.parse(request.getParameter("returndate").toString());
		String book_title=session.getAttribute("bookname").toString();
		System.out.println(user_name+password);
		UsersDaoImpl user = new UsersDaoImpl();
		Users u1 = new Users(user_name, password);
		System.out.println(user_name);
		System.out.println(password);
		
		String val = user.fetch(u1);
		
		System.out.println(val);
		if (val.equals("admin")) {
			System.out.println("welcome admin " + user_name);
			LocalDate date_returned1=null;
			boolean flag=false;
			
			int book_issue_no=Integer.parseInt(session.getAttribute("bookissueno").toString());
			BookIssue bi1=new BookIssue(book_issue_no,date_returned,book_title);
			BookIssueDaoImpl bookIssue=new BookIssueDaoImpl();
			int userFine = bookIssue.returnBookIssue(bi1);
			if(userFine>12) {
				try {
					String userName=session.getAttribute("user").toString();
					Users users=new Users(userName);
					user.delete(users);
					throw new InvalidFineException();
				}catch(InvalidFineException e) {
					System.out.println("hi");
					String validate=e.getMessage();
					System.out.println(validate);
					response.sendRedirect(validate);
					
				}
			}
			System.out.println(userFine);
			Fines f1 = new Fines(userFine);
			FinesDaoImpl fine=new FinesDaoImpl();
			int fineAmount = fine.fineCalculation(f1);
			System.out.println("FineAmount= " + fineAmount);
			Users u2 = new Users(fineAmount, user_name);
			user.update(u2);
			Users u3 = new Users(user_name);
			int fineOf = 0;
			FineHistoryDaoImpl fineHistory = new FineHistoryDaoImpl();
			try {
				ResultSet rs= user.getFine(u3);
				fineOf=rs.getInt(1);
				session.setAttribute("fineamount", fineOf);
				response.sendRedirect("fineCalculation.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	

}else {
	session.setAttribute("AdminError", "adminWrong");
	response.sendRedirect("bookReturnAdmin.jsp");
}
}
	
	
}