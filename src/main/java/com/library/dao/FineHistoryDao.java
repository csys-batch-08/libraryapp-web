package com.library.dao;

import java.sql.ResultSet;
import java.util.List;

import com.library.model.FineHistory;

public interface FineHistoryDao {
	
	public void insert(FineHistory fineHistory);
	public ResultSet view();

}
