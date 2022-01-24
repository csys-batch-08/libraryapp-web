package com.library.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.OrderBookDaoImpl;
import com.library.dao.impl.UsersDaoImpl;
import com.library.model.OrderBook;
import com.library.model.Users;

/**
 * Servlet implementation class RequestAdminServlet
 */
@WebServlet("/requestadmin")
public class RequestAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestAdminServlet() {
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
		HttpSession session=request.getSession();
		String uname=request.getParameter("uname1");
		String password=request.getParameter("password1");
		String supplier_name=request.getParameter("supplier");
		String book_name=session.getAttribute("newbook").toString();
		Users u1 = new Users(uname, password);
		UsersDaoImpl user=new UsersDaoImpl();
		String adminCheck = user.fetch(u1);
		if (adminCheck.equals("admin")) {
			OrderBook order=new OrderBook(supplier_name, book_name);
			OrderBookDaoImpl obDao=new OrderBookDaoImpl();
			obDao.update(order);
			response.sendRedirect("user.jsp");

		}else {
			session.setAttribute("AdminError", "adminWrong");
			response.sendRedirect("requestAdmin.jsp");
		}
		
		

	}

}
