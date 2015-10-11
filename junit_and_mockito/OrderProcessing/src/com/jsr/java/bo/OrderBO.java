package com.jsr.java.bo;

import com.jsr.java.bo.exception.BOException;
import com.jsr.java.dto.Order;

public interface OrderBO {

	boolean placeOrder(Order order) throws BOException;
	boolean cancelorder(int id) throws BOException;
	boolean deleteOrder(int id) throws BOException;

}
