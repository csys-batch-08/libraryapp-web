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
	public void setUserName(String user_name) {
		this.userName = user_name;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String book_name) {
		this.bookName = book_name;
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
	public void setSupplierId(String supplier_id) {
		this.supplierId = supplier_id;
	}
	public OrderBook(String user_name,String book_name, String author, String status) {
		super();
		this.userName=user_name;
		this.bookName = book_name;
		this.author = author;
		this.status = status;
	}
	public OrderBook(String supplier_id, String book_name) {
		this.supplierId = supplier_id;
		this.bookName = book_name;
	}
	public OrderBook(String book_name) {
		this.bookName = book_name;
	}
	public OrderBook(String user_name, String author, String book_name) {
		this.userName=user_name;
		this.bookName = book_name;
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
