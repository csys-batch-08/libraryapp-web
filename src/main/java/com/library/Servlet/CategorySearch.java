package com.library.Servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.dao.impl.BooksDaoImpl;
import com.library.model.Books;

/**
 * Servlet implementation class CategorySearch
 */
@WebServlet("/categorySearch")
public class CategorySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorySearch() {
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
		doGet(request, response);
		String categoryName=request.getParameter("category");
		HttpSession session = request.getSession();
		String book_title=null;
		String authorName=null;
		String category =null;
		BooksDaoImpl book=new BooksDaoImpl();
		Books b1=new Books(book_title,categoryName,authorName);
		ResultSet rs = book.categoryFetch(b1);
		session.setAttribute("categorysearch", rs);
		
		try {
			while (rs.next()) {
				System.out.println(rs.getString(1));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("AuthorSearch.jsp");
	}

}
