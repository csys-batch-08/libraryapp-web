package com.library.dao;

import java.sql.SQLException;
import java.util.List;

import com.library.model.OrderBook;

public interface OrderBookDao {
	
	public void insert(OrderBook orderBook) throws SQLException;
	public void update(OrderBook orderBook) throws SQLException;
	public void delete(OrderBook orderBook) throws SQLException;
	public List<OrderBook> view(OrderBook order) throws SQLException;

}
