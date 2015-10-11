package com.jsr.java;

import java.sql.SQLException;

import com.jsr.java.dto.Order;

public interface OrderDAO {
	
	int create (Order order) throws SQLException;
	int update (Order order) throws SQLException;
	int delete (int id) throws SQLException;
	Order read (int id) throws SQLException;

}
