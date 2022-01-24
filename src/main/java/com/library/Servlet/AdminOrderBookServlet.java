package com.library.Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
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
 * Servlet implementation class AdminOrderBookServlet
 */
@WebServlet("/adminOrderBook")
public class AdminOrderBookServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				HttpSession session = request.getSession();
				OrderBookDaoImpl obDao = new OrderBookDaoImpl();
				String book_name=null;
				String author=null;
//				String user_name=session.getAttribute("supplier").toString();
				List<OrderBook> orderList=new ArrayList();
				
				
				try {
					ResultSet rs = obDao.adminView();
					if (rs.next()) {
						do{ 
							
							OrderBook orderBook=new OrderBook();
							orderBook.setBook_name(rs.getString(1));
							orderBook.setAuthor(rs.getString(2));
							orderBook.setStatus(rs.getString(3));
							orderList.add(orderBook);
							
						
						
				}while (rs.next());
						request.setAttribute("adminOrderBook", orderList);
						RequestDispatcher rd=request.getRequestDispatcher("viewOrderBook.jsp");
						rd.forward(request, response);
				

					}
				}  catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
