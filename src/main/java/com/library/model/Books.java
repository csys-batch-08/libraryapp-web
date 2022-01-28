package com.library.model;

public class Books {
	
	private String bookCode;
	private String bookTitle;
	private String category;
	private String author;
	private int price;
	private int rackNum;
	private String availability;
	private String userName;
	private int bookIssueId;
	private String prerequest;
	
	
	
	public String getPrerequest() {
		return prerequest;
	}
	public void setPrerequest(String prerequest) {
		this.prerequest = prerequest;
	}
	public int getBook_issue_id() {
		return bookIssueId;
	}
	public void setBook_issue_id(int book_issue_id) {
		this.bookIssueId = book_issue_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String user_name) {
		this.userName = user_name;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Books(String book_code, String book_title, String category, String author, int price,
			int rack_num) {
		super();
		this.bookCode = book_code;
		this.bookTitle = book_title;
		this.category = category;
		this.author = author;
		this.price = price;
		this.rackNum = rack_num;
	}
	public Books() {
		super();
	}
	public Books(String book_title) {
		this.bookTitle=book_title;
	}
	public Books(String book_title, String user_name) {
		this.bookTitle=book_title;
		this.userName=user_name;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String book_code) {
		this.bookCode = book_code;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String book_title) {
		this.bookTitle = book_title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRackNum() {
		return rackNum;
	}
	public void setRackNum(int rack_num) {
		this.rackNum = rack_num;
	}

	
	
	public Books( String book_title, String category,String author) {
		this.bookTitle = book_title;
		this.category = category;
		this.author = author;
	}
	public Books(String book_title2, int book_issue_no) {
		this.bookTitle=book_title2;
		this.bookIssueId=book_issue_no;
		
	}
	public Books(int book_issue_no) {
		this.bookIssueId=book_issue_no;
	}
	@Override
	public String toString() {
		return "\nBook_title=" + bookTitle + "\nCategory=" + category + "\nAuthor=" + author;
	}
	
	

}
