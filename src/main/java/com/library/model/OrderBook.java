package com.library.model;

public class OrderBook {
	private String user_name;
	private String book_name;
	private String author;
	private String supplier_id;
	private String status;
	
	

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public OrderBook(String user_name,String book_name, String author, String status) {
		super();
		this.user_name=user_name;
		this.book_name = book_name;
		this.author = author;
		this.status = status;
	}
	public OrderBook(String supplier_id, String book_name) {
		this.supplier_id = supplier_id;
		this.book_name = book_name;
	}
	public OrderBook(String book_name) {
		this.book_name = book_name;
	}
	public OrderBook(String user_name, String author, String book_name) {
		this.user_name=user_name;
		this.book_name = book_name;
		this.author = author;
	}
	
	public OrderBook() {
		super();
	}
	@Override
	public String toString() {
		return "OrderBookPojo [user_name=" + book_name +",book_name=" + book_name + ", author=" + author + ", supplier_id=" + supplier_id + "]";
	}
	
	

}
