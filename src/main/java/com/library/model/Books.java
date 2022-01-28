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
	public int getbookIssueId() {
		return bookIssueId;
	}
	public void setbookIssueId(int bookIssueId) {
		this.bookIssueId = bookIssueId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Books(String bookCode, String bookTitle, String category, String author, int price,
			int rackNum) {
		super();
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
		this.category = category;
		this.author = author;
		this.price = price;
		this.rackNum = rackNum;
	}
	public Books() {
		super();
	}
	public Books(String bookTitle) {
		this.bookTitle=bookTitle;
	}
	public Books(String bookTitle, String userName) {
		this.bookTitle=bookTitle;
		this.userName=userName;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
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
	public void setRackNum(int rackNum) {
		this.rackNum = rackNum;
	}

	
	
	public Books( String bookTitle, String category,String author) {
		this.bookTitle = bookTitle;
		this.category = category;
		this.author = author;
	}
	public Books(String bookTitle2, int bookIssueNo) {
		this.bookTitle=bookTitle2;
		this.bookIssueId=bookIssueNo;
		
	}
	public Books(int bookIssueNo) {
		this.bookIssueId=bookIssueNo;
	}
	@Override
	public String toString() {
		return "\nbookTitle=" + bookTitle + "\nCategory=" + category + "\nAuthor=" + author;
	}
	
	

}
