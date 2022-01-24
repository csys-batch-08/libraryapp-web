package com.library.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.impl.FinesDaoImpl;
import com.library.model.Fines;

/**
 * Servlet implementation class FineDetailsServlet
 */
@WebServlet("/finedetail")
public class FineDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FineDetailsServlet() {
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
	
		
		int fine_range=Integer.parseInt(request.getParameter("text"));
		int fine_amount=Integer.parseInt(request.getParameter("text1"));
		FinesDaoImpl fine=new FinesDaoImpl();
		System.out.println(fine_range);
		Fines fines = new Fines(fine_range, fine_amount);
		try {
			fine.insert(fines);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("admin.jsp");
		
	}

}
