package com.library.model;

import java.time.LocalDateTime;

public class FineHistory {
	
	public FineHistory() {
		super();
	}
	private String userName;
	private int fineAmount;
	private LocalDateTime collectedTime;
	private int serialNo;
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
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
	
	public LocalDateTime getCollectedTime() {
		return collectedTime;
	}
	public void setCollectedTime(LocalDateTime collectedTime) {
		this.collectedTime = collectedTime;
	}
	public FineHistory(String userName, int fineAmount) {
		super();
		this.userName = userName;
		this.fineAmount = fineAmount;
	}
	public FineHistory(String userName, int fineAmount, LocalDateTime collectedTime) {
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
