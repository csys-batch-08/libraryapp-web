package com.library.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.FineHistoryDaoImpl;
import com.library.dao.impl.UsersDaoImpl;
import com.library.model.FineHistory;
import com.library.model.Users;

/**
 * Servlet implementation class ReturnSuccessServlet
 */
@WebServlet("/returnSuccess")
public class ReturnSuccessServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userWallet;
		HttpSession session=request.getSession();
		int fineOf=Integer.parseInt(session.getAttribute("fineamount").toString());
		String userName=session.getAttribute("user").toString();
		Users u3=new Users(fineOf,userName);
		UsersDaoImpl user=new UsersDaoImpl();
		FineHistoryDaoImpl fineHistory=new FineHistoryDaoImpl();
			try {
						userWallet=user.setFine(u3);
						FineHistory fh1 = new FineHistory(userName, fineOf);
						fineHistory.insert(fh1);
						
						request.setAttribute("userWallet", userWallet);
						RequestDispatcher rd=request.getRequestDispatcher("returnSuccess.jsp");
						rd.forward(request, response);
						} catch (Exception e) {
											
						e.getMessage();
						}
		
	}

}
