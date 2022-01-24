package com.library.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.impl.BooksDaoImpl;
import com.library.dao.impl.OrderBookDaoImpl;
import com.library.model.Books;
import com.library.model.OrderBook;

/**
 * Servlet implementation class addBook
 */
@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String book_code=request.getParameter("text");
		String book_name=request.getParameter("text1");
		String category=request.getParameter("text2");
		String author=request.getParameter("text3");
		int price=Integer.parseInt(request.getParameter("text4"));
		int rack_number=Integer.parseInt(request.getParameter("text5"));
		
		 OrderBookDaoImpl obDao=new OrderBookDaoImpl();
	       OrderBook order=new OrderBook("null",book_name,author);
	       obDao.updateStatus(order);
		System.out.println(book_code+book_name+category+author+price+rack_number);
		BooksDaoImpl book=new BooksDaoImpl();
		Books p1 = new Books(book_code, book_name, category, author, price, rack_number);
		try {
			book.insert(p1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("admin.jsp");
	}

}
