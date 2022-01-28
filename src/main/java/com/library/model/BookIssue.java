package com.library.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookIssue {
	
	private int book_issue_id;
	private String user_name;
	private String book_code;
	private LocalDate date_issue;
	private LocalDate date_return;
	private LocalDate date_returned;
	private int fine_range;
	
	DateTimeFormatter formatter =
		     DateTimeFormatter.ofPattern("dd-MM-yyyy");

	
	public BookIssue(int book_issue_id, String user_name, String book_code, LocalDate date_issue, LocalDate date_return,
			LocalDate date_returned, int fine_range) {
		super();
		this.book_issue_id = book_issue_id;
		this.user_name = user_name;
		this.book_code = book_code;
		this.date_issue = date_issue;
		this.date_return = date_return;
		this.date_returned = date_returned;
		this.fine_range = fine_range;
	}
	public void setDate_return(LocalDate date_return) {
		this.date_return = date_return;
	}
	public BookIssue() {
		super();
	}
	public int getBook_issue_id() {
		return book_issue_id;
	}
	public void setBook_issue_id(int book_issue_id) {
		this.book_issue_id = book_issue_id;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getBook_code() {
		return book_code;
	}
	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}
public String getDate_issue() {
		return date_issue.format(formatter);
	}
	public void setDate_issue(LocalDate date_issue) {
		this.date_issue = date_issue;
	}
	public String getDate_return() {
		return date_return.format(formatter);
	}
	
public String getDate_returned() {
		return date_returned.format(formatter);
	}
	public void setDate_returned(LocalDate date_returned) {
		this.date_returned = date_returned;
	}
	public int getFine_range() {
		return fine_range;
	}
	public BookIssue(String user_name) {
		super();
		this.user_name = user_name;
	}
	public void setFine_range(int fine_range) {
		this.fine_range = fine_range;
	}
	
	public BookIssue(String user_name, String book_code, LocalDate date_issue, LocalDate date_return,
			LocalDate date_returned, int fine_range) {
		super();
		this.user_name = user_name;
		this.book_code = book_code;
		this.date_issue = date_issue;
		this.date_return = date_return;
		this.date_returned = date_returned;
		this.fine_range = fine_range;
	}
	public BookIssue(int book_issue_no) {
		this.book_issue_id=book_issue_no;
	}
	public BookIssue(int book_issue_no, LocalDate date_returned, String book_title) {

		this.book_issue_id=book_issue_no;
		this.date_returned = date_returned;
		this.book_code = book_title;
		
	}
	public BookIssue(int book_issue_no, String user_name2, String book_title) {
	}
	public String toString() {
		return "BookIssue [book_issue_id=" + book_issue_id + ", user_name=" + user_name+ ", book_code=" + book_code
				+ ", date_issue=" + date_issue + ", date_return=" + date_return + ", date_returned=" + date_returned
				+ ", fine_range=" + fine_range + "]";
	}
	
	

}
