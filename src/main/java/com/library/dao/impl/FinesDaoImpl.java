package com.library.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.connection.*;
import com.library.dao.FinesDao;
import com.library.model.*;

public class FinesDaoImpl implements FinesDao {
	public void insert(Fines fine) throws SQLException  {
		Connection con = null;
		PreparedStatement pstmt=null;
		String query = "insert into fine_details (fine_range_in_month,fine_amount) values (?,?)";
		try {
		 con = ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);

		pstmt.setInt(1, fine.getFine_range());
		pstmt.setInt(2, fine.getFine_amount());

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

	public void update(Fines fine) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt=null;
		String query = "update fine_details set fine_amount=? where fine_range_in_month=?";
		try {
		 con = ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);

		pstmt.setInt(1, fine.getFine_amount());
		pstmt.setInt(2, fine.getFine_range());

		int i = pstmt.executeUpdate();

		System.out.println(i + "rows updated successfully");
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

	public void delete(Fines fine) throws SQLException  {
		Connection con = null;
		PreparedStatement pstmt=null;
		String query = "delete fine_details where fine_range_in_month=?";
		try {
		 con = ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);

		pstmt.setInt(1, fine.getFine_range());

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

	public int fineCalculation(Fines fine) throws SQLException {
		String query = "select fine_amount from fine_details where fine_range_in_month in ?";
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			con = ConnectionUtil.getDBConnect();
			 
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, fine.getFine_range());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
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
		return 0;
	}

}



