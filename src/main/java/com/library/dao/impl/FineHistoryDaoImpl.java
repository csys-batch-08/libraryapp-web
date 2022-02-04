package com.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.library.dao.FineHistoryDao;
import com.library.model.FineHistory;
import com.library.util.ConnectionUtil;

public class FineHistoryDaoImpl implements FineHistoryDao {

	public void insert(FineHistory fineHistory) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
		String query="insert into fine_history (user_name,fine_amount )values (?,?)";
		 con=ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,fineHistory.getuserName());
		pstmt.setInt(2,fineHistory.getfineAmount());
		pstmt.executeUpdate();

		} catch (Exception e) {
			e.getMessage();
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
		List<FineHistory> fineList = new ArrayList<>();
		DateTimeFormatter formatter =
			     DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
		String query="Select s_no,user_name,fine_amount,collected_time from fine_history order by s_no desc";
		 con=ConnectionUtil.getDBConnect();
		 pstmt=con.prepareStatement(query);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			FineHistory fine=new FineHistory();
			fine.setSerialNo(rs.getInt("s_no"));
			fine.setuserName(rs.getString("user_name"));
			fine.setfineAmount(rs.getInt("fine_amount"));
			fine.setCollectedTime(rs.getTimestamp("collected_time").toLocalDateTime().format(formatter));
			fineList.add(fine);
			
			}
		return fineList;
		}catch (Exception e) {
			e.getMessage();
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
