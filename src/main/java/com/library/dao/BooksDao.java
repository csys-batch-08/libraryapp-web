package com.library.dao;

import java.sql.ResultSet;
import java.util.List;

import com.library.model.Books;

public interface BooksDao {
	
	public void insert(Books book);
	public List<Books> showBooks();
	public List<Books> authorFetch(Books books);
	public List<Books> categoryFetch(Books books);
	public void delete(Books book);
	public void update(Books book);
	public String bookBorrow(Books book);
	public int getRack(Books book);
	public void bookAvail(Books book);
	public void updateBookIssue(Books book);
	public void returnBook(Books book);
	public String preRequest(Books book);
	public boolean checkReturn(Books book);
	public int getBookIssueNo(Books book);

}
