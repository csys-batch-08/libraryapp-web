package com.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.connection.ConnectionUtil;
import com.library.dao.OrderBookDao;
import com.library.model.OrderBook;
import com.library.model.Suppliers;

public class OrderBookDaoImpl implements OrderBookDao {
	
	public void insert(OrderBook orderBook)  {
		
		String query="insert into order_book (user_name,book_name,author,supplier_name) values (?,?,?,?)";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,orderBook.getUser_name());
		pstmt.setString(2, orderBook.getBook_name());
		pstmt.setString(3, orderBook.getAuthor());
		pstmt.setString(4, orderBook.getSupplier_id());
	
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update(OrderBook orderBook)  {
		
		String query="update order_book set supplier_name=? where book_name=?";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,orderBook.getSupplier_id());
		pstmt.setString(2,orderBook.getBook_name());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows updated successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void delete(OrderBook orderBook)  {
		
		String query="delete order_book where book_name=?";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,orderBook.getBook_name());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows deleted successfully");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

public List<OrderBook> view(OrderBook order)  {
	// TODO Auto-generated method stub
	String query="select book_name,author from order_book where supplier_name in ? and status in 'pending'";
	String query1="update order_book set status='sent' where supplier_name in ?";
	ResultSet rs=null;
	try {
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt=con.prepareStatement(query);
	pstmt.setString(1, order.getUser_name());
	System.out.println(order.getUser_name());
	rs=pstmt.executeQuery();
	PreparedStatement pstmt1=con.prepareStatement(query1);
	pstmt1.setString(1, order.getUser_name());
	pstmt1.executeUpdate();
	List<OrderBook> orderBook=new ArrayList();
	while(rs.next()) {
		order=new OrderBook();
		order.setBook_name(rs.getString(1));
		order.setAuthor(rs.getString(2));
		orderBook.add(order);
	}
	return orderBook;
	}catch (Exception e) {
		e.printStackTrace();
	}
   return null;
	
	
}

public int updateStatus(OrderBook order)  {
	// TODO Auto-generated method stub
	String query="update order_book set status='arrived' where book_name=?";
	ResultSet rs=null;
	try {
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt=con.prepareStatement(query);
	System.out.println(order.getBook_name());
	pstmt.setString(1, order.getAuthor());
	//pstmt.setString(2,order.getAuthor());
	System.out.println(order.getAuthor());
	pstmt.executeUpdate();

	return 1;
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   return 1;
	
	
}

public ResultSet adminView()  {
	// TODO Auto-generated method stub
	String query="select book_name,author,status from order_book";
//	String query1="update order_book set status='sent' where supplier_name in ?";
	ResultSet rs=null;
	try {
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt=con.prepareStatement(query);
	
	rs=pstmt.executeQuery();
//	PreparedStatement pstmt1=con.prepareStatement(query1);
//	pstmt1.setString(1, order.getUser_name());
//	pstmt1.executeUpdate();
	return rs;
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   return null;
	
	
}


public ResultSet userView(OrderBook order )  {
	// TODO Auto-generated method stub
	String query="select user_name,book_name,author,supplier_name,status from order_book where user_name in ?";
//	String query1="update order_book set status='sent' where supplier_name in ?";
	ResultSet rs=null;
	try {
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt=con.prepareStatement(query);
	pstmt.setString(1, order.getUser_name());
	rs=pstmt.executeQuery();
//	PreparedStatement pstmt1=con.prepareStatement(query1);
//	pstmt1.setString(1, order.getUser_name());
//	pstmt1.executeUpdate();
	return rs;
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   return null;
	
	
}

}
