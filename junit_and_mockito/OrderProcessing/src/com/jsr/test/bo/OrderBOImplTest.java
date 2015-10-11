package com.jsr.test.bo;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import com.jsr.java.OrderDAO;
import com.jsr.java.bo.OrderBOImpl;
import com.jsr.java.bo.exception.BOException;
import com.jsr.java.dto.Order;

public class OrderBOImplTest {

	@Mock
	OrderDAO dao;
	private OrderBOImpl bo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		bo = new OrderBOImpl();
		bo.setDao(dao);
	}

	@Test
	public void test_place_order_Should_create_order() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(order)).thenReturn(new Integer(1));
		boolean result = bo.placeOrder(order);

		assertTrue(result);
		verify(dao).create(order);

	}

	@Test
	public void test_place_order_Should_create_no_order() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(order)).thenReturn(new Integer(0));
		boolean result = bo.placeOrder(order);

		assertFalse(result);
		verify(dao).create(order);
	}

	@Test(expected = BOException.class)
	public void test_place_order_Should_throw_bo_exception() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(order)).thenThrow(BOException.class);
		boolean result = bo.placeOrder(order);

	}

	@Test
	public void test_cancel_order_Should_cancel_order_successfully() throws SQLException, BOException {

		Order order = new Order();
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenReturn(1);

		boolean result = bo.cancelorder(123);
		assertTrue(result);

		verify(dao).read(123);
		verify(dao).update(order);
	}

	@Test
	public void test_cancel_order_Should_fail() throws SQLException, BOException {

		Order order = new Order();
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenReturn(0);

		boolean result = bo.cancelorder(123);
		assertFalse(result);

		verify(dao).read(123);
		verify(dao).update(order);
	}

	@Test(expected = BOException.class)
	public void test_cancel_order_Should_throw_exception_on_read() throws SQLException, BOException {
		when(dao.read(123)).thenThrow(SQLException.class);
		bo.cancelorder(123);
	}
	
	@Test(expected = BOException.class)
	public void test_cancel_order_Should_fail_on_update() throws SQLException, BOException {

		Order order = new Order();
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenThrow(SQLException.class);

		boolean result = bo.cancelorder(123);
	}

}
