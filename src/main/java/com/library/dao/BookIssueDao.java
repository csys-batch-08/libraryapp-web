package com.library.dao;

import java.sql.SQLException;
import java.util.List;

import com.library.model.BookIssue;

public interface BookIssueDao {
	public int insert(BookIssue bookIssue) throws SQLException;
	public void update(BookIssue bookIssue) throws SQLException;
	public void delete(BookIssue bookIssue) throws SQLException;
	public int getBookIssueNo(BookIssue book) throws SQLException;
	public int returnBookIssue(BookIssue bookIssue) throws SQLException;
	List<BookIssue> userHistory(BookIssue book) throws SQLException;

}
