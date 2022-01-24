package com.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.connection.ConnectionUtil;
import com.library.dao.FineHistoryDao;
import com.library.model.FineHistory;

public class FineHistoryDaoImpl implements FineHistoryDao {

	public void insert(FineHistory fineHistory) {
		// TODO Auto-generated method stub
		try {
		String query="insert into fine_history (user_name,fine_amount )values (?,?)";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,fineHistory.getUser_name());
		pstmt.setInt(2,fineHistory.getFine_amount());
		int i = pstmt.executeUpdate();

		System.out.println(i+"rows inserted successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

	public ResultSet view() {
		// TODO Auto-generated method stub
		List<FineHistory> fineList = new ArrayList<FineHistory>();
		try {
		String query="Select user_name,fine_amount,collected_time from fine_history";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt=con.prepareStatement(query);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			FineHistory fine=new FineHistory(rs.getString(1),rs.getInt(2),rs.getString(3));
			fineList.add(fine);
			return rs;
			} 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}
