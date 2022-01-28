package com.library.servlet;

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


@WebServlet("/adminOrderBook")
public class AdminOrderBookServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				HttpSession session = request.getSession();
				OrderBookDaoImpl obDao = new OrderBookDaoImpl();
				
				List<OrderBook> orderList=null;
				try {
					orderList = obDao.adminView();
				} catch (SQLException e) {
					e.getMessage();
				}
					
						if((session.getAttribute("userRole").toString()).equals("admin")){
						request.setAttribute("adminOrderBook", orderList);
						RequestDispatcher rd=request.getRequestDispatcher("viewOrderBook.jsp");
						rd.forward(request, response);
						}
						else {
							request.setAttribute("adminOrderBook", orderList);
							RequestDispatcher rd=request.getRequestDispatcher("orderBook.jsp");
							rd.forward(request, response);
						}
				

					}
				
	}


