package com.library.dao;

import java.sql.SQLException;
import java.util.List;

import com.library.model.Books;

public interface BooksDao {
	
	public void insert(Books book) throws SQLException;
	public List<Books> showBooks() throws SQLException;
	public List<Books> authorFetch(Books books) throws SQLException;
	public List<Books> categoryFetch(Books books) throws SQLException;
	public void delete(Books book) throws SQLException;
	public void update(Books book) throws SQLException;
	public String bookBorrow(Books book) throws SQLException;
	public int getRack(Books book) throws SQLException;
	public void bookAvail(Books book) throws SQLException;
	public void updateBookIssue(Books book) throws SQLException;
	public void returnBook(Books book) throws SQLException;
	public String preRequest(Books book) throws SQLException;
	public boolean checkReturn(Books book) throws SQLException;
	public int getBookIssueNo(Books book) throws SQLException;

}
