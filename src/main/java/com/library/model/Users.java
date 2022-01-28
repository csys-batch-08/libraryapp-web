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

	public Users(String user_name, String city, String user_role, String password, long mobile_no, String email_id) {
		super();
		this.userName = user_name;
		this.city = city;
		this.password = password;
		this.mobileNo = mobile_no;
		this.emailId = email_id;
		this.userRole = user_role;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String user_role) {
		this.userRole = user_role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int user_id) {
		this.userId = user_id;
	}

	public int getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(int fine_amount) {
		this.fineAmount = fine_amount;
	}

	public Users() {
		super();
	}

	public Users(String user_name, String city, String password, long mobile_no,String email_id) {
		super();
		this.userName = user_name;
		this.city = city;
		this.password = password;
		this.mobileNo = mobile_no;
		this.emailId = email_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String user_name) {
		this.userName = user_name;
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

	public void setMobileNo(long mobile_no) {
		this.mobileNo = mobile_no;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String email_id) {
		this.emailId = email_id;
	}

	public Users(int user_id) {
		this.userId=user_id;
	}

	public Users(String user_name, String password) {
		this.userName=user_name;
		this.password=password;
	}

	public Users(int fineAmount, String user_name2) {
		this.fineAmount=fineAmount;
		this.userName=user_name2;
	}

	public Users(String user_name2) {
		this.userName=user_name2;
	}

	@Override
	public String toString() {
		return "Users [userName=" + userName + ", city=" + city + ", password=" + password + ", mobileNo="
				+ mobileNo + ", emailId=" + emailId + ", userId=" + userId + ", fineAmount=" + fineAmount + ", userwallet=\" + userWallet + \" ]";
	}

	
	
	
	
	
	

}
