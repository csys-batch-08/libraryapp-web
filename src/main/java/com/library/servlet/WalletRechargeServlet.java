package com.library.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.UsersDaoImpl;
import com.library.model.Users;

/**
 * Servlet implementation class WalletRechargeServlet
 */
@WebServlet("/WalletRecharge")
public class WalletRechargeServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDaoImpl user=new UsersDaoImpl();
		HttpSession session=request.getSession();
		  String userName=session.getAttribute("user").toString();
		  Users u3=new Users(userName);
		  
			
				try {
					user.walletRecharge(u3);
				} catch (Exception e) {
				
					e.getMessage();
				}
				int userWallet=(int)session.getAttribute("userWalletLogin");
				userWallet+=500;
				request.setAttribute("userWalletLogin", userWallet);
				RequestDispatcher rd=request.getRequestDispatcher("user.jsp");
				rd.forward(request, response);
		
	}

}
