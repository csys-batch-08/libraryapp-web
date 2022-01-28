package com.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.library.connection.ConnectionUtil;
import com.library.dao.FineHistoryDao;
import com.library.model.FineHistory;

public class FineHistoryDaoImpl implements FineHistoryDao {

	public void insert(FineHistory fineHistory) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
		String query="insert into fine_history (user_name,fine_amount )values (?,?)";
		 con=ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,fineHistory.getUser_name());
		pstmt.setInt(2,fineHistory.getFine_amount());
		pstmt.executeUpdate();

		} catch (Exception e) {
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

	public List<FineHistory> view() throws SQLException {
		List<FineHistory> fineList = new ArrayList<FineHistory>();
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
		String query="Select user_name,fine_amount,collected_time from fine_history";
		 con=ConnectionUtil.getDBConnect();
		 pstmt=con.prepareStatement(query);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			FineHistory fine=new FineHistory();
			fine.setUser_name(rs.getString(1));
			fine.setFine_amount(rs.getInt(2));
			fine.setCollected_time(rs.getString(3));
			fineList.add(fine);
			
			}
		return fineList;
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
	
	

}
