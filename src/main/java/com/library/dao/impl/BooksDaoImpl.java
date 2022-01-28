package com.library.dao.impl;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.connection.*;
import com.library.dao.BooksDao;
import com.library.model.*;

public class BooksDaoImpl implements BooksDao {
	public void insert(Books book)  {
		
		String query="insert into book_details (book_code,book_title,category,author,price,rack_num) values (?,?,?,?,?,?)";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,book.getBook_code());
		pstmt.setString(2, book.getBook_title());
		pstmt.setString(3, book.getCategory());
		pstmt.setString(4, book.getAuthor());
		pstmt.setInt(5, book.getPrice());
		pstmt.setInt(6, book.getRack_num());
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
//	public ResultSet showBooks(){
//		String query="Select book_title,author,category from book_details";
//		Connection con = null;
//		try {
//			con = ConnectionUtil.getDBConnect();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		PreparedStatement pstmt = null;
//		try {
//			pstmt = con.prepareStatement(query);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ResultSet rs=null;
//		try {
//			rs=pstmt.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//		}
	
	public List<Books> showBooks() 
	{
		//List<Books> productsList=new ArrayList<Books>();
		
		String query="Select book_title,category,author from book_details";
		List<Books> list=new ArrayList();
		ResultSet rs=null;
		Connection con = null;
		try {
			con = ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(query);
		
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Books books=new Books();
				books.setBook_title(rs.getString(1));
				books.setAuthor(rs.getString(3));
				books.setCategory(rs.getString(2));
				list.add(books);
				
				
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	public List<Books> authorFetch(Books books) {
		String query="select book_title from book_details where author in ?";
		Connection con;
		PreparedStatement pstmt=null;  
		ResultSet rs=null;
		List<Books> bookList=new ArrayList();
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, books.getAuthor());
		
		
			rs = pstmt.executeQuery();
			if (rs.next()){
				do {
				Books authorBookList=new Books();
				authorBookList.setBook_title(rs.getString(1));
				bookList.add(authorBookList);
				}while(rs.next());
				
				return bookList;
		}} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
		
		
	}
	
	public List<Books> categoryFetch(Books books) {
		String query="select book_title from book_details where category in ?";
		Connection con;
		PreparedStatement pstmt=null;
		List<Books> bookList=new ArrayList();
		ResultSet rs=null;
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, books.getCategory());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				books=new Books();
				books.setBook_title(rs.getString(1));
				bookList.add(books);

			}
			return bookList;
		
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookList;
		
		
	}
	
public void delete(Books book) {
		
		String query="delete book_details where book_title=?";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,book.getBook_title());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows deleted successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	

	public void update(Books book) {
		// TODO Auto-generated method stub
		String query="update book_details set availability=? where book_code=?";
		Connection con = null;
		 int i = 0;
		try {
			con = ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,book.getAvailability());
			pstmt.setString(2, book.getBook_code());
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
		
         
		
		System.out.println(i+"rows updated successfully");
		
	}

	public String bookBorrow(Books book) {
		
		// TODO Auto-generated method stub
		String query="select availability,prerequest from book_details where book_title in ?";
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			con=ConnectionUtil.getDBConnect();
		    pstmt=con.prepareStatement(query);
		    pstmt.setString(1, book.getBook_title());
		ResultSet rs=null;
			rs=pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals("available")&&(rs.getString(2).equals(book.getUser_name())||rs.getString(2).equals("none"))) {
					System.out.println(book.getBook_title()+" is available");
					return "available";
					
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "unavailable";
		
		
	}

	public int getRack(Books book) {
		// TODO Auto-generated method stub
		String query = "select rack_num from book_details where book_title in ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, book.getBook_title());
			ResultSet rs = null;
			rs = pstmt.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public void bookAvail(Books book) {
		// TODO Auto-generated method stub
		String query="update book_details set availability='unavailable',user_name=? where book_title in ?";
		Connection con = null;
		PreparedStatement pstmt=null;
		int rs=0;
		try {
			con = ConnectionUtil.getDBConnect();
		    pstmt=con.prepareStatement(query);
		    pstmt.setString(1, book.getUser_name());
		    pstmt.setString(2, book.getBook_title());
		
			rs=pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(rs+ "update success");
	
		
	}
	
	public void updateBookIssue(Books book) {
		// TODO Auto-generated method stub
		String query = "update book_details set book_issue_no=? where book_title=?";
		Connection con = null;
		int i = 0;
		try {
			con = ConnectionUtil.getDBConnect();
			PreparedStatement pstmt = null;
			

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, book.getBook_issue_id());
			pstmt.setString(2, book.getBook_title());
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(i + "rows updated successfully");

	}

	public void returnBook(Books book) {
		// TODO Auto-generated method stub
		String query = "update book_details set availability='available',user_name=null,book_issue_no=0 where book_title in ? ";
		Connection con = null;
		try {
			con = ConnectionUtil.getDBConnect();

			PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, book.getBook_title());
			int rs = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String preRequest(Books book)  {
		// TODO Auto-generated method stub
		String query="update book_details set prerequest=? where book_title in ? and prerequest in 'none'";
		Connection con = null;
		try {
			con = ConnectionUtil.getDBConnect();
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1, book.getUser_name());
		pstmt.setString(2, book.getBook_title());
		System.out.println(book.getBook_title());
		int i=pstmt.executeUpdate();
		System.out.println(i);
		if(i>0) {
			return "Pre Request successful";
		}
		else {
			return "Prerequest un success";
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

	public boolean checkReturn(Books book) {
		// TODO Auto-generated method stub
		String query="select rack_num from book_details where book_title in ? and user_name in ? and availability='unavailable'";
		try {
		Connection con = ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, book.getBook_title());
		pstmt.setString(2, book.getUser_name());
		ResultSet rs=pstmt.executeQuery();
		
			while(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public int getBookIssueNo(Books book) {
		
		String query="Select book_issue_no from book_details where book_title in ? ";
		
		try {
			Connection con=ConnectionUtil.getDBConnect();
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, book.getBook_title());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	public List<Books> returnBookList(Books book) {
		String query="select book_title from book_details where user_name in ?";
		ResultSet rs=null;
		List<Books> returnBook=new ArrayList();
		try {
			Connection con=ConnectionUtil.getDBConnect();
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, book.getUser_name());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				book=new Books();
				book.setBook_title(rs.getString(1));
				System.out.println(rs.getString(1));
				
				returnBook.add(book);
				System.out.println(returnBook);
			}
			System.out.println(returnBook);
			return returnBook;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return returnBook;
	}
	public List<Books> availableBookList() {
		String query="select book_title,category,author,price,rack_num,prerequest from book_details where availability in 'available'";
		ResultSet rs=null;
		List<Books> bookList=new ArrayList();
		try {
			Connection con=ConnectionUtil.getDBConnect();
			PreparedStatement pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();
				while(rs.next()){
					Books book=new Books();
					book.setBook_title(rs.getString(1));
					book.setCategory(rs.getString(2));
					book.setAuthor(rs.getString(3));
					book.setPrice(rs.getInt(4));
					book.setRack_num(rs.getInt(5));
					book.setPrerequest(rs.getString(6));
					bookList.add(book);
					
				}
			return bookList;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bookList;
	}
	
	public List<Books> unavailableBookList() {
		String query="select book_title,category,author,price,user_name,prerequest from book_details where availability in 'unavailable'";
		ResultSet rs=null;
		try {
			Connection con=ConnectionUtil.getDBConnect();
			PreparedStatement pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();
			List<Books> bookList=new ArrayList();
			while(rs.next()) {
				Books book=new Books();
				book.setBook_title(rs.getString(1));
				book.setCategory(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setUser_name(rs.getString(5));
				book.setPrerequest(rs.getString(6));
				bookList.add(book);
				
			}
			return bookList;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public ResultSet BookList() {
		String query="select book_code,book_title,category,author,price,user_name,availability,user_name,book_issue_no,prerequest from book_details";
		ResultSet rs=null;
		try {
			Connection con=ConnectionUtil.getDBConnect();
			PreparedStatement pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();
			return rs;
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	public int eligle(Books book) {
		String query="select count(user_name) from book_details where user_name in ?";
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			System.out.println("hisui");
			con=ConnectionUtil.getDBConnect();
		    pstmt=con.prepareStatement(query);
		    pstmt.setString(1, book.getUser_name());
		    ResultSet rs=null;
			rs=pstmt.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


	
	

}

