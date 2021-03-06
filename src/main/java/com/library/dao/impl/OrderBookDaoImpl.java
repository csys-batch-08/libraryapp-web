package com.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.library.dao.OrderBookDao;
import com.library.model.OrderBook;
import com.library.util.ConnectionUtil;

public class OrderBookDaoImpl implements OrderBookDao {
	String book="book_name";
	String author="author";
	public void insert(OrderBook orderBook) throws SQLException  {
		Connection con = null;
		PreparedStatement pstmt=null;
		String query="insert into order_book (user_name,book_name,author,supplier_name) values (?,?,?,?)";
		try {
		 con=ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,orderBook.getUserName());
		pstmt.setString(2, orderBook.getBookName());
		pstmt.setString(3, orderBook.getAuthor());
		pstmt.setString(4, orderBook.getSupplierId());
	
		
		 pstmt.executeUpdate();
		
		}catch (Exception e) {
			e.getMessage();
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		
	}
	
	public void update(OrderBook orderBook) throws SQLException  {
		Connection con = null;
		PreparedStatement pstmt=null;
		String query="update order_book set supplier_name=? where book_name=?";
		try {
		 con=ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,orderBook.getSupplierId());
		pstmt.setString(2,orderBook.getBookName());
		
         pstmt.executeUpdate();
		
		}catch (Exception e) {
			e.getMessage();
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	}
	
public void delete(OrderBook orderBook) throws SQLException  {
	Connection con = null;
	PreparedStatement pstmt=null;
		String query="delete order_book where book_name=?";
		try {
		 con=ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,orderBook.getBookName());
		
         pstmt.executeUpdate();
		
		}catch (Exception e) {
			e.getMessage();
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	}

@SuppressWarnings("resource")
public List<OrderBook> view(OrderBook order) throws SQLException  {
	String query="select book_name,author from order_book where supplier_name in ? and status in 'pending'";
	String query1="update order_book set status='sent' where supplier_name in ?";
	ResultSet rs=null;
	Connection con = null;
	PreparedStatement pstmt=null;
	try {
	 con=ConnectionUtil.getDBConnect();
	 pstmt=con.prepareStatement(query);
	pstmt.setString(1, order.getUserName());
	rs=pstmt.executeQuery();
	pstmt=con.prepareStatement(query1);
	pstmt.setString(1, order.getUserName());
	pstmt.executeUpdate();
	List<OrderBook> orderBook=new ArrayList<>();
	while(rs.next()) {
		order=new OrderBook();
		order.setBookName(rs.getString(book));
		order.setAuthor(rs.getString(author));
		orderBook.add(order);
	}
	return orderBook;
	}catch (Exception e) {
		e.getMessage();
	}finally {
		if(pstmt!=null) {
			pstmt.close();
		}
		if(con!=null) {
			con.close();
		}
	}
   return Collections.emptyList();
	
	
}

public int updateStatus(OrderBook order) throws SQLException  {
	String query="update order_book set status='arrived' where book_name=?";
	Connection con = null;
	PreparedStatement pstmt=null;
	try {
	 con=ConnectionUtil.getDBConnect();
	 pstmt=con.prepareStatement(query);
	pstmt.setString(1, order.getAuthor());
	pstmt.executeUpdate();

	return 1;
	}catch (Exception e) {
		e.getMessage();
	}finally {
		if(pstmt!=null) {
			pstmt.close();
		}
		if(con!=null) {
			con.close();
		}
	}
   return 1;
	
	
}

public List<OrderBook> adminView() throws SQLException  {
	String query="select book_name,author,status from order_book";
	ResultSet rs=null;
	Connection con = null;
	PreparedStatement pstmt=null;
	try {
	 con=ConnectionUtil.getDBConnect();
	 pstmt=con.prepareStatement(query);
	
	rs=pstmt.executeQuery();
	
	List<OrderBook> orderList=new ArrayList<>();
	if (rs.next()) {
		do{ 
			
			OrderBook orderBook=new OrderBook();
			orderBook.setBookName(rs.getString(book));
			orderBook.setAuthor(rs.getString(author));
			orderBook.setStatus(rs.getString("status"));
			orderList.add(orderBook);
			
		
		
}while (rs.next());
	}
	return orderList;
	}catch (Exception e) {
		e.getMessage();
	}finally {
		if(pstmt!=null) {
			pstmt.close();
		}
		if(con!=null) {
			con.close();
		}
	}
   return Collections.emptyList();
	
	
}


public List<OrderBook> userView(OrderBook order) throws SQLException  {
	String query="select book_name,author,status from order_book where user_name in ?";
	ResultSet resultSet=null;
	Connection con = null;
	PreparedStatement pstmt=null;
	try {
	 con=ConnectionUtil.getDBConnect();
	 pstmt=con.prepareStatement(query);
	pstmt.setString(1, order.getUserName());
	resultSet=pstmt.executeQuery();

	List<OrderBook> userOrderList=new ArrayList<>();
	if (resultSet.next()) {
		do{ 
			
			OrderBook orderBook=new OrderBook();
			orderBook.setBookName(resultSet.getString(book));
			orderBook.setAuthor(resultSet.getString(author));
			orderBook.setStatus(resultSet.getString("status"));
			userOrderList.add(orderBook);
			
		
		
}while (resultSet.next());
	}
	return userOrderList;
	}catch (Exception e) {
		e.getMessage();
	}finally {
		if(pstmt!=null) {
			pstmt.close();
		}
		if(con!=null) {
			con.close();
		}
	}
   return Collections.emptyList();
	
	
}

}
