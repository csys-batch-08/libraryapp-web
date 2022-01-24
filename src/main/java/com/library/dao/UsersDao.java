package com.library.dao;

import java.sql.ResultSet;

import com.library.model.Users;

public interface UsersDao {
	
	public boolean insert(Users user);
	public boolean adminInsert(Users user);
	public String fetch(Users user);
	public void delete(Users user);
	public void update(Users user);
	public ResultSet getFine(Users user);
	public int setFine(Users user);
	public boolean forgotPassword(Users users);

}
