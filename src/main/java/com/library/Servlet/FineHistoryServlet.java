package com.library.Servlet;

import java.io.IOException;
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
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FineHistoryDaoImpl fineHist = new FineHistoryDaoImpl();

		List<FineHistory> fineList= fineHist.view();
		
		request.setAttribute("fineList", fineList);
		RequestDispatcher rd=request.getRequestDispatcher("showFineHistory.jsp");
		rd.forward(request, response);
		
		
		
	}

}
