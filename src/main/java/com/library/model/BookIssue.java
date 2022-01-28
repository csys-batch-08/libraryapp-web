package com.library.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookIssue {
	
	private int bookIssueId;
	private String userName;
	private String bookCode;
	private LocalDate dateIssue;
	private LocalDate dateReturn;
	private LocalDate dateReturned;
	private int fineRange;
	
	DateTimeFormatter formatter =
		     DateTimeFormatter.ofPattern("dd-MM-yyyy");

	
	public BookIssue(int bookIssueId, String user_name, String book_code, LocalDate date_issue, LocalDate date_return,
			LocalDate date_returned, int fine_range) {
		super();
		this.bookIssueId = bookIssueId;
		this.userName = user_name;
		this.bookCode = book_code;
		this.dateIssue = date_issue;
		this.dateReturn = date_return;
		this.dateReturned = date_returned;
		this.fineRange = fine_range;
	}
	public void setDateReturn(LocalDate date_return) {
		this.dateReturn = date_return;
	}
	public BookIssue() {
		super();
	}
	public int getBook_issue_id() {
		return bookIssueId;
	}
	public void setBook_issue_id(int book_issue_id) {
		this.bookIssueId = book_issue_id;
	}
	
	public String getUser_name() {
		return userName;
	}
	public void setUser_name(String user_name) {
		this.userName = user_name;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String book_code) {
		this.bookCode = book_code;
	}
public String getDate_issue() {
		return dateIssue.format(formatter);
	}
	public void setDate_issue(LocalDate date_issue) {
		this.dateIssue = date_issue;
	}
	public String getDateReturn() {
		return dateReturn.format(formatter);
	}
	
public String getDate_returned() {
		return dateReturned.format(formatter);
	}
	public void setDate_returned(LocalDate date_returned) {
		this.dateReturned = date_returned;
	}
	public int getFine_range() {
		return fineRange;
	}
	public BookIssue(String user_name) {
		super();
		this.userName = user_name;
	}
	public void setFine_range(int fine_range) {
		this.fineRange = fine_range;
	}
	
	public BookIssue(String user_name, String book_code, LocalDate date_issue, LocalDate date_return,
			LocalDate date_returned, int fine_range) {
		super();
		this.userName = user_name;
		this.bookCode = book_code;
		this.dateIssue = date_issue;
		this.dateReturn = date_return;
		this.dateReturned = date_returned;
		this.fineRange = fine_range;
	}
	public BookIssue(int book_issue_no) {
		this.bookIssueId=book_issue_no;
	}
	public BookIssue(int book_issue_no, LocalDate date_returned, String book_title) {

		this.bookIssueId=book_issue_no;
		this.dateReturned = date_returned;
		this.bookCode = book_title;
		
	}
	public BookIssue(int book_issue_no, String user_name2, String book_title) {
	}
	public String toString() {
		return "BookIssue [book_issue_id=" + bookIssueId + ", user_name=" + userName+ ", bookCode=" + bookCode
				+ ", date_issue=" + dateIssue + ", dateReturn=" + dateReturn + ", date_returned=" + dateReturned
				+ ", fine_range=" + fineRange + "]";
	}
	
	

}
