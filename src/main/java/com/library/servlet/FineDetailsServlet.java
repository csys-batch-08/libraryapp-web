package com.library.servlet;

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
       
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int fineRange=Integer.parseInt(request.getParameter("text"));
		int fineAmount=Integer.parseInt(request.getParameter("text1"));
		FinesDaoImpl fine=new FinesDaoImpl();
		Fines fines = new Fines(fineRange, fineAmount);
		try {
			fine.insert(fines);
		} catch (Exception e) {
			e.getMessage();
		}
		
		response.sendRedirect("admin.jsp");
		
	}

}
