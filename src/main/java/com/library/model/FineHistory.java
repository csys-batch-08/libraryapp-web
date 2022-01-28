package com.library.model;

public class FineHistory {
	
	public FineHistory() {
		super();
	}
	private String userName;
	private int fineAmount;
	private String collectedTime;
	
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public int getfineAmount() {
		return fineAmount;
	}
	public void setfineAmount(int fineAmount) {
		this.fineAmount = fineAmount;
	}
	
	public String getCollectedTime() {
		return collectedTime;
	}
	public void setCollectedTime(String collectedTime) {
		this.collectedTime = collectedTime;
	}
	public FineHistory(String userName, int fineAmount) {
		super();
		this.userName = userName;
		this.fineAmount = fineAmount;
	}
	public FineHistory(String userName, int fineAmount, String collectedTime) {
		super();
		this.userName = userName;
		this.fineAmount = fineAmount;
		this.collectedTime = collectedTime;
	}
	@Override
	public String toString() {
		return "FineHistory [userName=" + userName + ", fineAmount=" + fineAmount + ", collectedTime="
				+ collectedTime + "]";
	}
	
	
	

}
