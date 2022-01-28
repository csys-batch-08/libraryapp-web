package com.library.dao;

import java.sql.SQLException;

import com.library.model.Fines;

public interface FinesDao {
	public void insert(Fines fine) throws SQLException;
	public void update(Fines fine) throws SQLException;
	public void delete(Fines fine) throws SQLException;
	public int fineCalculation(Fines fine) throws SQLException;
	

}
