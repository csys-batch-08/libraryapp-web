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

		pstmt.setInt(1, fine.getFineRange());
		pstmt.setInt(2, fine.getFineAmount());

		 pstmt.executeUpdate();

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

	}

	public void update(Fines fine) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt=null;
		String query = "update fine_details set fine_amount=? where fine_range_in_month=?";
		try {
		 con = ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);

		pstmt.setInt(1, fine.getFineAmount());
		pstmt.setInt(2, fine.getFineRange());

		int i = pstmt.executeUpdate();

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
	}

	public void delete(Fines fine) throws SQLException  {
		Connection con = null;
		PreparedStatement pstmt=null;
		String query = "delete fine_details where fine_range_in_month=?";
		try {
		 con = ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);

		pstmt.setInt(1, fine.getFineRange());

		pstmt.executeUpdate();

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
	}

	public int fineCalculation(Fines fine) throws SQLException {
		String query = "select fine_amount from fine_details where fine_range_in_month in ?";
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			con = ConnectionUtil.getDBConnect();
			 
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, fine.getFineRange());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
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
		return 0;
	}

}



