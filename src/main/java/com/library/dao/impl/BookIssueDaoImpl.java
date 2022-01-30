package com.library.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.library.connection.*;
import com.library.dao.BookIssueDao;
import com.library.model.*;


public class BookIssueDaoImpl implements BookIssueDao {
	
	public int insert(BookIssue bookIssue) throws SQLException  {
		
		String query="insert into book_issue_details (user_name,book_title,date_issue,date_return,date_returned) values (?,?,?,?,?)";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
		con=ConnectionUtil.getDBConnect();
		pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, bookIssue.getuserName());
		pstmt.setString(2, bookIssue.getBookCode());
		pstmt.setString(3, bookIssue.getdateIssue());
		pstmt.setString(4,bookIssue.getDateReturn());
		pstmt.setString(5,bookIssue.getdateReturned());
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
		
		return 1;
		
	}
	
	public void update(BookIssue bookIssue) throws SQLException  {
		
		String query="update book_issue_details set fine_range_in_month=? where user_name=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
		 con=ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1,bookIssue.getfineRange());
		pstmt.setString(2,bookIssue.getuserName());
		
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
	
public void delete(BookIssue bookIssue) throws SQLException  {
		
		String query="delete book_issue_details where book_issue_no=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
		con=ConnectionUtil.getDBConnect();
		pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1,bookIssue.getbookIssueId());
		
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

public int getBookIssueNo(BookIssue book) throws SQLException {
	
	String query="Select book_issue_no from book_issue_details where user_name in ? and book_title in ? and date_issue in ? and date_return in ?";
	Connection con=null;
	PreparedStatement pstmt=null;
	try {
		con=ConnectionUtil.getDBConnect();
		pstmt=con.prepareStatement(query);
		pstmt.setString(1, book.getuserName());
		pstmt.setString(2, book.getBookCode());
		pstmt.setString(3, book.getdateIssue());
		pstmt.setString(4, book.getDateReturn());
		
		ResultSet resultSet=pstmt.executeQuery();
		while(resultSet.next()){
			return resultSet.getInt(1);
		}
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
	
	return 0;
	
}

@SuppressWarnings("resource")
public int returnBookIssue(BookIssue bookIssue) throws SQLException {
	String query= "update book_issue_details set date_returned = ? where book_issue_no in ?";
	String query1="Update BOOK_ISSUE_DETAILS set FINE_RANGE_IN_MONTH = (Round(Months_between(DATE_RETURNED,DATE_RETURN)))";
	
	Connection con=null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	try {
		con=ConnectionUtil.getDBConnect();
		
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, bookIssue.getdateReturned());
		pstmt.setInt(2,bookIssue.getbookIssueId());
		pstmt.executeUpdate();
		pstmt=con.prepareStatement(query1);
		pstmt.executeUpdate();
		String query2="select fine_range_in_month from book_issue_details where book_issue_no in ?";
		pstmt1=con.prepareStatement(query2);
		pstmt1.setInt(1,bookIssue.getbookIssueId());
		ResultSet rs2=pstmt1.executeQuery();
		
		while(rs2.next()) {
			return rs2.getInt(1);
		}
	} catch (Exception e) {
		e.getMessage();
	}finally {
		if(pstmt!=null) {
			pstmt.close();
		}
		if(pstmt1!=null) {
			pstmt1.close();
		}
		if(con!=null) {
			con.close();
		}
	}
	return 0;
	
	
}

public List<BookIssue> userHistory(BookIssue book) throws SQLException {
	Connection con=null;
	PreparedStatement pstmt = null;

	String query="select book_title,date_issue,date_return,date_returned,fine_range_in_month from book_issue_details where user_name in ?";
	try {
	 con=ConnectionUtil.getDBConnect();
	 pstmt = con.prepareStatement(query);
	
	pstmt.setString(1, book.getuserName());
	List<BookIssue> bookIssue=new ArrayList<>();
     ResultSet rs = pstmt.executeQuery();
     while(rs.next()) {
    	 book=new BookIssue();
    	 book.setBookCode(rs.getString(1));
    	 book.setdateIssue(rs.getDate(2).toLocalDate());
    	 book.setDateReturn(rs.getDate(3).toLocalDate());
    	 book.setdateReturned(rs.getDate(4).toLocalDate());
    	 book.setfineRange(rs.getInt(5));
    	 bookIssue.add(book);
     }
     
     return bookIssue;


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

public List<BookIssue> bookIssueList() throws SQLException {
	

	String query="select user_name,book_title,date_issue,date_return,date_returned,fine_range_in_month,book_issue_no from book_issue_details";
	Connection con=null;
	PreparedStatement pstmt = null;
	try {
	 con=ConnectionUtil.getDBConnect();
	 pstmt = con.prepareStatement(query);
	List<BookIssue> bookIssue=new ArrayList<>();
	
     ResultSet rs = pstmt.executeQuery();
     
     while(rs.next()){
			BookIssue books=new BookIssue();
			books.setBookCode(rs.getString(2));
			books.setuserName(rs.getString(1));
			books.setdateIssue(rs.getDate(3).toLocalDate());
			books.setDateReturn(rs.getDate(4).toLocalDate());
			books.setdateReturned(rs.getDate(5).toLocalDate());
			books.setfineRange(rs.getInt(6));
			books.setbookIssueId(rs.getInt(7));
			bookIssue.add(books);
			
     }
     
     return bookIssue;


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
