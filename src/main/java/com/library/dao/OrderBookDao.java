package com.library.dao;

import java.sql.ResultSet;
import java.util.List;

import com.library.model.OrderBook;

public interface OrderBookDao {
	
	public void insert(OrderBook orderBook);
	public void update(OrderBook orderBook);
	public void delete(OrderBook orderBook);
	public List<OrderBook> view(OrderBook order);

}
