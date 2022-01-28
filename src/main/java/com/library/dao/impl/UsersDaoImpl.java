package com.library.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.library.connection.*;
import com.library.dao.UsersDao;
import com.library.model.*;

public class UsersDaoImpl implements UsersDao{
	public boolean insert(Users user) throws SQLException  {
		
		String query="insert into user_details (user_name,city,password,mobile_no,email_id) values (?,?,?,?,?)";
		Connection con=null;
		PreparedStatement pstmt =null;
		try {
		 con=ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,user.getUserName());
		pstmt.setString(2, user.getCity());
		pstmt.setString(3,user.getPassword());
		pstmt.setLong(4, user.getMobileNo());
		pstmt.setString(5, user.getEmailId());
		
		int i = pstmt.executeUpdate();
		if(i>0)
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		
		return false;
		
		
	}
public boolean adminInsert(Users user) throws SQLException  {
		
		String query="insert into user_details (user_name,city,user_role,password,mobile_no,email_id) values (?,?,?,?,?,?)";
		Connection con=null;
		PreparedStatement pstmt =null;
		try {
		 con=ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,user.getUserName());
		pstmt.setString(2, user.getCity());
		pstmt.setString(3, user.getUserRole());
		pstmt.setString(4,user.getPassword());
		pstmt.setLong(5, user.getMobileNo());
		pstmt.setString(6, user.getEmailId());
		int i=pstmt.executeUpdate();
		if(i>0)
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		
		return false;
		
		
	}
	
	
@SuppressWarnings("resource")
public String fetch(Users user) throws SQLException {
	
	String query="select user_name,password from user_details where user_name in ? and password in ?";
	Connection con=null;
	PreparedStatement pstmt =null;
	try {
	 con=ConnectionUtil.getDBConnect();
	 pstmt = con.prepareStatement(query);
	pstmt.setString(1, user.getUserName());
	pstmt.setString(2, user.getPassword());
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()) {
		String query1="select user_role from user_details where user_name in ?";
		pstmt = con.prepareStatement(query1);
		pstmt.setString(1, user.getUserName());
		ResultSet rs1 = pstmt.executeQuery();
		rs1.next();
		return rs1.getString(1);
	}
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(pstmt!=null) {
			pstmt.close();
		}
		if(con!=null) {
			con.close();
		}
	}
	return "invalid";
	
}



public void delete(Users user) throws SQLException  {
	
	String query="update user_details set user_role='invalid' where user_name in ?";
	Connection con=null;
	PreparedStatement pstmt =null;
	try {
	 con=ConnectionUtil.getDBConnect();
	 pstmt = con.prepareStatement(query);
	
	pstmt.setString(1,user.getUserName());
	
     pstmt.executeUpdate();
	
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(pstmt!=null) {
			pstmt.close();
		}
		if(con!=null) {
			con.close();
		}
	}
}


public void update(Users user) throws SQLException  {
	String query="update user_details set fine_amount=? where user_name=?";
	Connection con=null;
	PreparedStatement pstmt =null;
	try {
	 con=ConnectionUtil.getDBConnect();
	 pstmt=con.prepareStatement(query);
	pstmt.setInt(1, user.getFineAmount());
	pstmt.setString(2, user.getUserName());
	pstmt.executeUpdate();
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(pstmt!=null) {
			pstmt.close();
		}
		if(con!=null) {
			con.close();
		}
	}
	
	
}
public int getUserWallet(Users user) throws SQLException  {
	Connection con=null;
	PreparedStatement pstmt =null;
	String query="Select userwallet from user_details where user_name in ?";
	try {
	 con=ConnectionUtil.getDBConnect();
	 pstmt=con.prepareStatement(query);
	pstmt.setString(1, user.getUserName());
	ResultSet rs=pstmt.executeQuery();
	
	while(rs.next()) {
		return rs.getInt(1);
	}
	
	}catch (Exception e) {
	
		e.printStackTrace();
	}finally {
		if(pstmt!=null) {
			pstmt.close();
		}
		if(con!=null) {
			con.close();
		}
	}
	return 0;
}

public int getFine(Users user) throws SQLException  {
	Connection con=null;
	PreparedStatement pstmt =null;
	String query="Select fine_amount from user_details where user_name in ?";
	try {
	 con=ConnectionUtil.getDBConnect();
	 pstmt=con.prepareStatement(query);
	pstmt.setString(1, user.getUserName());
	ResultSet rs=pstmt.executeQuery();
	
	while(rs.next()) {
		return rs.getInt(1);
	}
	
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(pstmt!=null) {
			pstmt.close();
		}
		if(con!=null) {
			con.close();
		}
	}
	return 0;
}
@SuppressWarnings("resource")
public int setFine(Users user) throws SQLException  {
	String query1="select userwallet,fine_amount from user_details where user_name in ?";
	String query="update user_details set userwallet =?,fine_amount=0 where user_name in ?";
	Connection con=null;
	PreparedStatement pstmt =null;

	int userWallet=0;
	try {
	 con=ConnectionUtil.getDBConnect();
	 pstmt=con.prepareStatement(query1);
	
	pstmt.setString(1, user.getUserName());
	ResultSet rs=pstmt.executeQuery();
	
	while(rs.next()) {
		userWallet=rs.getInt(1)-user.getFineAmount();
	}
	
	 pstmt=con.prepareStatement(query);
	pstmt.setInt(1, userWallet);
	pstmt.setString(2, user.getUserName());
	pstmt.executeUpdate();
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(pstmt!=null) {
			pstmt.close();
		}
		
		if(con!=null) {
			con.close();
		}
	}
	return userWallet;
	
	
}
public boolean forgotPassword(Users users) throws SQLException {
	Connection con=null;
	PreparedStatement pstmt =null;
	String query="update user_details set password=? where user_name=?";
	try {
		
		 con=ConnectionUtil.getDBConnect();
		 pstmt=con.prepareStatement(query);
		pstmt.setString(1, users.getPassword());
		pstmt.setString(2, users.getUserName());
		int i=pstmt.executeUpdate();
		if(i>0) {
			return true;
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(pstmt!=null) {
			pstmt.close();
		}
		if(con!=null) {
			con.close();
		}
	}
	return false;
	
}

public int walletRecharge(Users user) throws SQLException {
	
	String query="update user_details set userwallet=(userwallet+500) where user_name in ?";
	Connection con=null;
	PreparedStatement pstmt =null;
try {
		 con=ConnectionUtil.getDBConnect();
		 pstmt=con.prepareStatement(query);
		pstmt.setString(1, user.getUserName());
		int i=pstmt.executeUpdate();
		if(i>0) {
		}
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(pstmt!=null) {
			pstmt.close();
		}
		if(con!=null) {
			con.close();
		}
	}
	return 1;
}

public List<Users> userList() throws SQLException {
	String query="select USER_NAME,CITY,MOBILE_NO,EMAIL_ID,USERWALLET from user_details where user_role in 'user'";
	Connection con=null;
	PreparedStatement pstmt =null;
	try {
			
			 con=ConnectionUtil.getDBConnect();
			 pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			List<Users> userList=new ArrayList<Users>();
			while(rs.next()) {
				Users user=new Users();
				user.setUserName(rs.getString(1));
				user.setCity(rs.getString(2));
				user.setMobileNo(rs.getLong(3));
				user.setEmailId(rs.getString(4));
				user.setUserWallet(rs.getInt(5));
				userList.add(user);
			}
			return userList;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return Collections.emptyList();
	
}
public boolean unameCheck(Users user) throws SQLException {
	String query="select user_name from user_details where user_name in ?";
	Connection con=null;
	PreparedStatement pstmt =null;
	try {
			
			 con=ConnectionUtil.getDBConnect();
			
			 pstmt=con.prepareStatement(query);
			pstmt.setString(1, user.getUserName());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	
	return false;
}
public boolean emailCheck(Users user) throws SQLException {

	String query="select email_id from user_details where email_id in ?";
	Connection con=null;
	PreparedStatement pstmt =null;
	try {
			
			 con=ConnectionUtil.getDBConnect();
			
			 pstmt=con.prepareStatement(query);
			pstmt.setString(1, user.getEmailId());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	return false;
}
public boolean mobileCheck(Users user) throws SQLException {
	String query="select mobile_no from user_details where mobile_no in ?";
	Connection con=null;
	PreparedStatement pstmt =null;
	try {
			
			 con=ConnectionUtil.getDBConnect();
			
			 pstmt=con.prepareStatement(query);
			pstmt.setLong(1, user.getMobileNo());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	return false;
}


}

