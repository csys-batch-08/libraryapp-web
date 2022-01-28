package com.library.model;

public class Users {
	
	private String userName;
	private String city;
	private String password;
	private long mobileNo;
	private String emailId;
	private int userId;
	private int fineAmount;
	private String userRole;
	private int userWallet;
	
	public int getUserWallet() {
		return userWallet;
	}

	public void setUserWallet(int userWallet) {
		this.userWallet = userWallet;
	}

	public Users(String userName, String city, String userRole, String password, long mobileNo, String emailId) {
		super();
		this.userName = userName;
		this.city = city;
		this.password = password;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.userRole = userRole;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(int fineAmount) {
		this.fineAmount = fineAmount;
	}

	public Users() {
		super();
	}

	public Users(String userName, String city, String password, long mobileNo,String emailId) {
		super();
		this.userName = userName;
		this.city = city;
		this.password = password;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Users(int userId) {
		this.userId=userId;
	}

	public Users(String userName, String password) {
		this.userName=userName;
		this.password=password;
	}

	public Users(int fineAmount, String userName2) {
		this.fineAmount=fineAmount;
		this.userName=userName2;
	}

	public Users(String userName2) {
		this.userName=userName2;
	}

	@Override
	public String toString() {
		return "Users [userName=" + userName + ", city=" + city + ", password=" + password + ", mobileNo="
				+ mobileNo + ", emailId=" + emailId + ", userId=" + userId + ", fineAmount=" + fineAmount + ", userwallet=\" + userWallet + \" ]";
	}

	
	
	
	
	
	

}
