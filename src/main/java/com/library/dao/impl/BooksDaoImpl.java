package com.library.dao.impl;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.library.dao.BooksDao;
import com.library.exception.InvalidReturnException;
import com.library.model.*;
import com.library.util.*;

public class BooksDaoImpl implements BooksDao {
	String bookTitle="book_title";
	String author="author";
	String preRequest="prerequest";
	String category="category";
	public void insert(Books book) throws SQLException  {
		
		String insertQuery="insert into book_details (book_code,book_title,category,author,price,rack_num) values (?,?,?,?,?,?)";
		Connection con=null;
		PreparedStatement pstmt =null;
		try {
		 con=ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(insertQuery);
		
		pstmt.setString(1,book.getBookCode());
		pstmt.setString(2, book.getBookTitle());
		pstmt.setString(3, book.getCategory());
		pstmt.setString(4, book.getAuthor());
		pstmt.setInt(5, book.getPrice());
		pstmt.setInt(6, book.getRackNum());
		
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

	
	public List<Books> showBooks() throws SQLException 
	{
		
		String showQuery="Select book_title,category,author from book_details";
		List<Books> list=new ArrayList<>();
		ResultSet rs=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDBConnect();
		
			pstmt = con.prepareStatement(showQuery);
		
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Books books=new Books();
				books.setBookTitle(rs.getString(bookTitle));
				books.setAuthor(rs.getString(author));
				books.setCategory(rs.getString(category));
				list.add(books);
				
				
			}
			return list;
		} catch (Exception e) {
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

	
	public List<Books> authorFetch(Books books) throws SQLException {
		String authorFetchQuery="select book_title from book_details where author in ?";
		Connection con=null;
		PreparedStatement pstmt=null;  
		ResultSet authorResultSet=null;
		List<Books> bookList=new ArrayList<>();
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(authorFetchQuery);
			pstmt.setString(1, books.getAuthor());
		
		
			authorResultSet = pstmt.executeQuery();
			if (authorResultSet.next()){
				do {
				Books authorBookList=new Books();
				authorBookList.setBookTitle(authorResultSet.getString(bookTitle));
				bookList.add(authorBookList);
				}while(authorResultSet.next());
				
				return bookList;
		}else {
			if(books.getAuthor()!=null) {
			return Collections.emptyList();
			}
		}
			
		
		} catch (Exception e) {
			e.getMessage();
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return bookList;
		
		
	}
	
	public List<Books> categoryFetch(Books books) throws SQLException {
		String categoryQuery="select book_title from book_details where category in ?";
		Connection con=null;
		PreparedStatement pstmt=null;
		List<Books> bookList=new ArrayList<>();
		ResultSet catergoryResultSet=null;
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(categoryQuery);
			pstmt.setString(1, books.getCategory());
			catergoryResultSet = pstmt.executeQuery();
			if (catergoryResultSet.next()) {
				do {
				books=new Books();
				books.setBookTitle(catergoryResultSet.getString(bookTitle));
				bookList.add(books);

			}while (catergoryResultSet.next());
				return bookList;
			}
			else {
				return Collections.emptyList();
			}
			
		
			

		} catch (Exception e) {
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
	
public void delete(Books book) throws SQLException {
		
		String deleteQuery="delete book_details where book_title=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
		con=ConnectionUtil.getDBConnect();
		pstmt = con.prepareStatement(deleteQuery);
		
		pstmt.setString(1,book.getBookTitle());
		
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


	

	public void update(Books book) throws SQLException {
		String query="update book_details set availability=? where book_code=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		 try {
			con = ConnectionUtil.getDBConnect();
		
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,book.getAvailability());
			pstmt.setString(2, book.getBookCode());
			pstmt.executeUpdate();
		} catch (Exception e) {
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

	public String bookBorrow(Books book) throws SQLException {
		
		String bookBorrowQuery="select availability,prerequest from book_details where book_title in ?";
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			con=ConnectionUtil.getDBConnect();
		    pstmt=con.prepareStatement(bookBorrowQuery);
		    pstmt.setString(1, book.getBookTitle());
		    ResultSet rs=null;
			rs=pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("availability").equals("available")&&(rs.getString(preRequest).equals(book.getUserName())||rs.getString(preRequest).equals("none"))) {
					return "available";
					
				}
				
			}
		} catch (Exception e) {
			e.getMessage();
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return "unavailable";
		
		
	}

	public int getRack(Books book) throws SQLException {
		String getRackQuery = "select rack_num from book_details where book_title in ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(getRackQuery);
			pstmt.setString(1, book.getBookTitle());
			ResultSet rackResultSet = null;
			rackResultSet = pstmt.executeQuery();
			while (rackResultSet.next()) {
				return rackResultSet.getInt("rack_num");
			}

		} catch (Exception e) {
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

	public void bookAvail(Books book) throws SQLException {
		String query="update book_details set availability='unavailable',user_name=? where book_title in ?";
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			con = ConnectionUtil.getDBConnect();
		    pstmt=con.prepareStatement(query);
		    pstmt.setString(1, book.getUserName());
		    pstmt.setString(2, book.getBookTitle());
		    pstmt.executeUpdate();
		} catch (Exception e) {
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
	
	public void updateBookIssue(Books book) throws SQLException {
		String query = "update book_details set book_issue_no=? where book_title=?";
		Connection con = null;

		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDBConnect();
			

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, book.getbookIssueId());
			pstmt.setString(2, book.getBookTitle());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		}
		finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}

	}

	public void returnBook(Books book) throws SQLException {
		String query = "update book_details set availability='available',user_name=null,book_issue_no=0 where book_title in ? ";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDBConnect();

			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, book.getBookTitle());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		}
		finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}

	}

	public String preRequest(Books book) throws SQLException  {
		String query="update book_details set prerequest=? where book_title in ? and prerequest in 'none'";
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			con = ConnectionUtil.getDBConnect();
		pstmt=con.prepareStatement(query);
		pstmt.setString(1, book.getUserName());
		pstmt.setString(2, book.getBookTitle());
		int i=pstmt.executeUpdate();
		if(i>0) {
			return "Pre Request successful";
		}
		else {
			return "Prerequest un success";
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
		return null;
		
		
	}

	public boolean checkReturn(Books book) throws SQLException {
		String query="select rack_num from book_details where book_title in ? and user_name in ? and availability='unavailable'";
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
		 con = ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		pstmt.setString(1, book.getBookTitle());
		pstmt.setString(2, book.getUserName());
		ResultSet rackResultSet=pstmt.executeQuery();
		
			while(rackResultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		
		return false;
		
	}
	
	public int getBookIssueNo(Books book) throws SQLException {
		
		String query="Select book_issue_no from book_details where book_title in ? ";
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			 con=ConnectionUtil.getDBConnect();
			 pstmt=con.prepareStatement(query);
			pstmt.setString(1, book.getBookTitle());
			ResultSet bookIssueNoRs=pstmt.executeQuery();
			while(bookIssueNoRs.next()){
				return bookIssueNoRs.getInt("book_issue_no");
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
	
	
	public List<Books> returnBookList(Books book) throws SQLException {
		String returnBookQuery="select book_title from book_details where user_name in ?";
		ResultSet rs=null;
		Connection con = null;
		PreparedStatement pstmt=null;
		List<Books> returnBook=new ArrayList<>();
		try {
			 con=ConnectionUtil.getDBConnect();
			 pstmt=con.prepareStatement(returnBookQuery);
			pstmt.setString(1, book.getUserName());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
				book=new Books();
				book.setBookTitle(rs.getString(bookTitle));
				
				returnBook.add(book);
				}while(rs.next());
			}
			else {
				throw new InvalidReturnException();
			}
			return returnBook;
		}catch (InvalidReturnException e) {
			return Collections.emptyList();
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
		
		return returnBook;
	}
	public List<Books> availableBookList() throws SQLException {
		String availableBookQuery="select book_title,category,author,price,rack_num,prerequest from book_details where availability in 'available'";
		ResultSet rs=null;
		Connection con = null;
		PreparedStatement pstmt=null;
		List<Books> bookList=new ArrayList<>();
		try {
			 con=ConnectionUtil.getDBConnect();
			 pstmt=con.prepareStatement(availableBookQuery);
			rs=pstmt.executeQuery();
				while(rs.next()){
					Books book=new Books();
					book.setBookTitle(rs.getString(bookTitle));
					book.setCategory(rs.getString(category));
					book.setAuthor(rs.getString(author));
					book.setPrice(rs.getInt("price"));
					book.setRackNum(rs.getInt("rack_num"));
					book.setPrerequest(rs.getString(preRequest));
					bookList.add(book);
					
				}
			return bookList;
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
		
		return bookList;
	}
	
	public List<Books> unavailableBookList() throws SQLException {
		String query="select book_title,category,author,price,user_name,prerequest from book_details where availability in 'unavailable'";
		ResultSet rs=null;
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			 con=ConnectionUtil.getDBConnect();
			 pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();
			List<Books> unavailableBookList=new ArrayList<>();
			while(rs.next()) {
				Books book=new Books();
				book.setBookTitle(rs.getString(bookTitle));
				book.setCategory(rs.getString(category));
				book.setAuthor(rs.getString(author));
				book.setPrice(rs.getInt("price"));
				book.setUserName(rs.getString("user_name"));
				book.setPrerequest(rs.getString(preRequest));
				unavailableBookList.add(book);
				
			}
			return unavailableBookList;
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
	

	public int eligle(Books book) throws SQLException {
		String query="select count(user_name) from book_details where user_name in ?";
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			con=ConnectionUtil.getDBConnect();
		    pstmt=con.prepareStatement(query);
		    pstmt.setString(1, book.getUserName());
		    ResultSet eligibleResultSet=null;
			eligibleResultSet=pstmt.executeQuery();
			while(eligibleResultSet.next()) {
				return eligibleResultSet.getInt(1);
			}
		} catch (Exception e) {
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


	
	

}

