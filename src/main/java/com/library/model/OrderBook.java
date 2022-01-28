package com.library.model;

public class OrderBook {
	private String userName;
	private String bookName;
	private String author;
	private String supplierId;
	private String status;
	
	

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public OrderBook(String userName,String bookName, String author, String status) {
		super();
		this.userName=userName;
		this.bookName = bookName;
		this.author = author;
		this.status = status;
	}
	public OrderBook(String supplierId, String bookName) {
		this.supplierId = supplierId;
		this.bookName = bookName;
	}
	public OrderBook(String bookName) {
		this.bookName = bookName;
	}
	public OrderBook(String userName, String author, String bookName) {
		this.userName=userName;
		this.bookName = bookName;
		this.author = author;
	}
	
	public OrderBook() {
		super();
	}
	@Override
	public String toString() {
		return "OrderBookPojo [userName=" + bookName +",bookName=" + bookName + ", author=" + author + ", supplierId=" + supplierId + "]";
	}
	
	

}
