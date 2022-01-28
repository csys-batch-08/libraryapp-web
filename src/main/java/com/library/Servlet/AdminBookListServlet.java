package com.library.Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BooksDaoImpl user = new BooksDaoImpl();

		List<Books> bookList = user.availableBookList();
		HttpSession session = request.getSession();

		request.setAttribute("availableBookList", bookList);
		RequestDispatcher rd = request.getRequestDispatcher("availableBookList.jsp");
		rd.forward(request, response);

	}

}
