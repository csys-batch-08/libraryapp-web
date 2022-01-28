package com.library.model;

public class FineHistory {
	
	public FineHistory() {
		super();
	}
	private String userName;
	private int fineAmount;
	private String collectedTime;
	
	public String getUser_name() {
		return userName;
	}
	public void setUser_name(String user_name) {
		this.userName = user_name;
	}
	public int getFine_amount() {
		return fineAmount;
	}
	public void setFine_amount(int fine_amount) {
		this.fineAmount = fine_amount;
	}
	
	public String getCollectedTime() {
		return collectedTime;
	}
	public void setCollectedTime(String collected_time) {
		this.collectedTime = collected_time;
	}
	public FineHistory(String user_name, int fine_amount) {
		super();
		this.userName = user_name;
		this.fineAmount = fine_amount;
	}
	public FineHistory(String user_name, int fine_amount, String collected_time) {
		super();
		this.userName = user_name;
		this.fineAmount = fine_amount;
		this.collectedTime = collected_time;
	}
	@Override
	public String toString() {
		return "FineHistory [user_name=" + userName + ", fine_amount=" + fineAmount + ", collectedTime="
				+ collectedTime + "]";
	}
	
	
	

}
