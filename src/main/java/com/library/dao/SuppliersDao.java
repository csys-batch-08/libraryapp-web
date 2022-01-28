package com.library.dao;

import java.sql.SQLException;

import com.library.model.Suppliers;

public interface SuppliersDao {
	
	public void insert(Suppliers supply) throws SQLException;
	public void update(Suppliers supply) throws SQLException;
	public void delete(Suppliers supply) throws SQLException;

}
