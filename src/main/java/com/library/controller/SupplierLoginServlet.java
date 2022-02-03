package com.library.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.OrderBookDaoImpl;
import com.library.model.OrderBook;

/**
 * Servlet implementation class SupplierLoginServlet
 */
@WebServlet("/SupplierLogin")
public class SupplierLoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
				HttpSession session = request.getSession();
				OrderBookDaoImpl obDao = new OrderBookDaoImpl();
				String bookName=null;
				String author=null;
				String userName=session.getAttribute("supplier").toString();
				OrderBook order=new OrderBook(userName,author,bookName);
				
				
					List<OrderBook> orderBook=null;
					try {
						orderBook = obDao.view(order);
					} catch (SQLException e) {
						e.getMessage();
					}
				if (orderBook!=null) {
					request.setAttribute("OrderBookList", orderBook);
					RequestDispatcher rd=request.getRequestDispatcher("supplierLogin.jsp");
					rd.forward(request, response);
				}else{
				response.sendRedirect("invalid.jsp");
			}
			
			
			}

}
