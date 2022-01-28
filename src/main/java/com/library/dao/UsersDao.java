package com.library.dao;




import java.sql.SQLException;

import com.library.model.Users;

public interface UsersDao {
	
	public boolean insert(Users user) throws SQLException;
	public boolean adminInsert(Users user) throws SQLException;
	public String fetch(Users user) throws SQLException;
	public void delete(Users user) throws SQLException;
	public void update(Users user) throws SQLException;
	public int getFine(Users user) throws SQLException;
	public int setFine(Users user) throws SQLException;
	public boolean forgotPassword(Users users) throws SQLException;

}
