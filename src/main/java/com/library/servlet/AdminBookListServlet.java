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

import com.library.dao.impl.BooksDaoImpl;
import com.library.model.Books;


@WebServlet("/adminBookList")
public class AdminBookListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BooksDaoImpl user = new BooksDaoImpl();

		List<Books> bookList=null;
		try {
			bookList = user.availableBookList();
		} catch (SQLException e) {
			e.getMessage();
		}

		request.setAttribute("availableBookList", bookList);
		RequestDispatcher rd = request.getRequestDispatcher("availableBookList.jsp");
		rd.forward(request, response);

	}

}
