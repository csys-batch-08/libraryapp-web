package com.library.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.library.connection.*;
import com.library.dao.SuppliersDao;
import com.library.model.*;

public class SuppliersDaoImpl implements SuppliersDao{
	public void insert(Suppliers supply) throws SQLException  {
		
		 String   query="insert into supplier_details (supplier_name,address,contact) values (?,?,?)";
		 Connection con = null;
			PreparedStatement pstmt=null;
		try {
		 con=ConnectionUtil.getDBConnect();
		
		 pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, supply.getSupplierName());
		pstmt.setString(2, supply.getAddress());
		pstmt.setLong(3, supply.getContact());
	
		
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
	
	public void update(Suppliers supply) throws SQLException  {
	    String query="update supplier_details set contact=? where supplier_name=?";
	    Connection con = null;
		PreparedStatement pstmt=null;
		try {
		
			con=ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		
		pstmt.setString(2,supply.getSupplierName());
		pstmt.setLong(1,supply.getContact());
		
         pstmt.executeUpdate();
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
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
	
public void delete(Suppliers supply) throws SQLException  {
		
		String query="delete supplier_details where supplier_name=?";
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
		 con=ConnectionUtil.getDBConnect();
		 pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,supply.getSupplierName());
		
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

}

