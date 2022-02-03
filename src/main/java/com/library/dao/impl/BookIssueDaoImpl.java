package com.library.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.library.dao.BookIssueDao;
import com.library.model.*;
import com.library.util.*;


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
		
		ResultSet issueSet=pstmt.executeQuery();
		while(issueSet.next()){
			return issueSet.getInt("book_issue_no");
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
			return rs2.getInt("fine_range_in_month");
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
    	 book.setBookCode(rs.getString("book_title"));
    	 book.setdateIssue(rs.getDate("date_issue").toLocalDate());
    	 book.setDateReturn(rs.getDate("date_return").toLocalDate());
    	 book.setdateReturned(rs.getDate("date_returned").toLocalDate());
    	 book.setfineRange(rs.getInt("fine_range_in_month"));
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
			books.setBookCode(rs.getString("book_title"));
			books.setuserName(rs.getString("user_name"));
			books.setdateIssue(rs.getDate("date_issue").toLocalDate());
			books.setDateReturn(rs.getDate("date_return").toLocalDate());
			books.setdateReturned(rs.getDate("date_returned").toLocalDate());
			books.setfineRange(rs.getInt("fine_range_in_month"));
			books.setbookIssueId(rs.getInt("book_issue_no"));
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
