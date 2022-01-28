package com.library.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.impl.SuppliersDaoImpl;
import com.library.model.Suppliers;

/**
 * Servlet implementation class Supplier
 */
@WebServlet("/adminjsp")
public class Supplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("text");
		String address=request.getParameter("text1");
		long contact=Long.parseLong(request.getParameter("text3"));
		SuppliersDaoImpl supply=new SuppliersDaoImpl();
		Suppliers s1 = new Suppliers(name, address, contact);
		try {
			supply.insert(s1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("admin.jsp");
	}

}
