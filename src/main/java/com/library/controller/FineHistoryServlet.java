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

import com.library.dao.impl.FineHistoryDaoImpl;
import com.library.model.FineHistory;

/**
 * Servlet implementation class FineHistoryServlet
 */
@WebServlet("/FineHistory")
public class FineHistoryServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FineHistoryDaoImpl fineHist = new FineHistoryDaoImpl();

		List<FineHistory> fineList=null;
		try {
			fineList = fineHist.view();
		} catch (SQLException e) {
			e.getMessage();
		}
		
		request.setAttribute("fineList", fineList);
		RequestDispatcher rd=request.getRequestDispatcher("showFineHistory.jsp");
		rd.forward(request, response);
		
		
		
	}

}
