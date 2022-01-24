package com.library.Servlet;



import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.BooksDaoImpl;
import com.library.model.Books;

/**
 * Servlet implementation class AdminBookListServlet
 */
@WebServlet("/adminBookList")
public class AdminBookListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		BooksDaoImpl user = new BooksDaoImpl();
		
		List<Books> bookList=new ArrayList();
		HttpSession session=request.getSession();

					ResultSet rs = user.availableBookList();
						try {
							while(rs.next()){
								Books book=new Books();
								book.setBook_title(rs.getString(1));
								book.setCategory(rs.getString(2));
								book.setAuthor(rs.getString(3));
								book.setPrice(rs.getInt(4));
								book.setRack_num(rs.getInt(5));
								book.setPrerequest(rs.getString(6));
								bookList.add(book);
								
							}
							
						session.setAttribute("availableBookList", bookList);
						response.sendRedirect("AvailableBookList.jsp");
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	}

}
