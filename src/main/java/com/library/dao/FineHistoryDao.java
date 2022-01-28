package com.library.dao;

import java.sql.SQLException;
import java.util.List;

import com.library.model.FineHistory;

public interface FineHistoryDao {
	
	public void insert(FineHistory fineHistory) throws SQLException;
	public List<FineHistory> view() throws SQLException;

}
