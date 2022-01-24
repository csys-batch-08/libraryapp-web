package com.library.model;

public class Books {
	
	private String book_code;
	private String book_title;
	private String category;
	private String author;
	private int price;
	private int rack_num;
	private String availability;
	private String user_name;
	private int book_issue_id;
	private String prerequest;
	
	
	
	public String getPrerequest() {
		return prerequest;
	}
	public void setPrerequest(String prerequest) {
		this.prerequest = prerequest;
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
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Books(String book_code, String book_title, String category, String author, int price,
			int rack_num) {
		super();
		this.book_code = book_code;
		this.book_title = book_title;
		this.category = category;
		this.author = author;
		this.price = price;
		this.rack_num = rack_num;
	}
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(String book_title) {
		// TODO Auto-generated constructor stub
		this.book_title=book_title;
	}
	public Books(String book_title, String user_name) {
		this.book_title=book_title;
		this.user_name=user_name;
		// TODO Auto-generated constructor stub
	}
	public String getBook_code() {
		return book_code;
	}
	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
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
	public int getRack_num() {
		return rack_num;
	}
	public void setRack_num(int rack_num) {
		this.rack_num = rack_num;
	}

	
	
	public Books( String book_title, String category,String author) {
		this.book_title = book_title;
		this.category = category;
		this.author = author;
	}
	public Books(String book_title2, int book_issue_no) {
		// TODO Auto-generated constructor stub
		this.book_title=book_title2;
		this.book_issue_id=book_issue_no;
		
	}
	public Books(int book_issue_no) {
		// TODO Auto-generated constructor stub
		this.book_issue_id=book_issue_no;
	}
	@Override
	public String toString() {
		return "\nBook_title=" + book_title + "\nCategory=" + category + "\nAuthor=" + author;
	}
	
	

}
