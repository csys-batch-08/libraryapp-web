package com.library.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.BookIssueDaoImpl;
import com.library.dao.impl.FinesDaoImpl;
import com.library.dao.impl.UsersDaoImpl;
import com.library.exception.InvalidFineException;
import com.library.model.BookIssue;
import com.library.model.Fines;
import com.library.model.Users;

/**
 * Servlet implementation class BookReturnAdmin
 */
@WebServlet("/returnadmin")
public class BookReturnAdmin extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession();
		String userName=request.getParameter("uname1");
		String password=request.getParameter("password1");
		LocalDate dateReturned=LocalDate.parse(request.getParameter("returndate"));
		String bookTitle=session.getAttribute("bookname").toString();
		UsersDaoImpl user = new UsersDaoImpl();
		Users u1 = new Users(userName, password);
		
		String val = user.fetch(u1);
		userName=session.getAttribute("user").toString();
		if (val.equals("admin")) {
			int bookIssueNo=Integer.parseInt(session.getAttribute("bookissueno").toString());
			BookIssue bi1=new BookIssue(bookIssueNo,dateReturned,bookTitle);
			BookIssueDaoImpl bookIssue=new BookIssueDaoImpl();
			int userFine = bookIssue.returnBookIssue(bi1);
			
			if(userFine>12) {
				
					
					Users users=new Users(userName);
					user.delete(users);
					//throw new InvalidFineException();
					response.sendRedirect("invalidFine.jsp");
			}
			
			Fines f1 = new Fines(userFine);
			FinesDaoImpl fine=new FinesDaoImpl();
			int fineAmount = fine.fineCalculation(f1);
			Users u2 = new Users(fineAmount, userName);
			user.update(u2);
			Users u3 = new Users(userName);
			int fineOf = 0;
			
				fineOf= user.getFine(u3);
				
				if(fineOf>0) {
				request.setAttribute("fineamount", fineOf);
				session.setAttribute("fineamount", fineOf);
				request.setAttribute("userName", userName);
				RequestDispatcher rd=request.getRequestDispatcher("fineCalculation.jsp");
				rd.forward(request, response);
				}
				else {
					String userWallet=session.getAttribute("userWalletLogin").toString();
					request.setAttribute("userName", userName);
					request.setAttribute("userWallet",userWallet);
					RequestDispatcher rd=request.getRequestDispatcher("returnSuccess.jsp");
					rd.forward(request, response);
				}
			
			
			
		
	

}else {
	request.setAttribute("AdminError", "adminWrong");
	RequestDispatcher rd=request.getRequestDispatcher("bookReturnAdmin.jsp");
	rd.forward(request, response);
}
}catch (Exception e) {
	e.getMessage();
}
	
	
}}