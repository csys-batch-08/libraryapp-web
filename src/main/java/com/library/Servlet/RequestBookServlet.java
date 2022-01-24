package com.library.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.OrderBookDaoImpl;
import com.library.model.OrderBook;

/**
 * Servlet implementation class RequestBookServlet
 */
@WebServlet("/requestBook")
public class RequestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestBookServlet() {
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
		String book_name=request.getParameter("bookName");
		String author=request.getParameter("authorName");
		session.setAttribute("newbook", book_name);
		String user_name=session.getAttribute("user").toString();
		String supplier_id = null;
		OrderBook p1 = new OrderBook(user_name, book_name, author, supplier_id);
		OrderBookDaoImpl obDao=new OrderBookDaoImpl();
		obDao.insert(p1);
		response.sendRedirect("requestAdmin.jsp");
	}

}
