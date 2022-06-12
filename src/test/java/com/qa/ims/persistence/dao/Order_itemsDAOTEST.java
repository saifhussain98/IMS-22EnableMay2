package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order_items;
import com.qa.ims.utils.DBUtils;

public class Order_itemsDAOTEST {

	private final Order_itemsDAO DAO = new Order_itemsDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Order_items created = new Order_items(2L, 1L, 1L, 1L);
		assertEquals(null, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Order_items> expected = new ArrayList<>();
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(null, DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long order_items_id = 1L;
		assertEquals(null, DAO.read(order_items_id));
	}

	@Test
	public void testUpdate() {
		final Order_items updated = new Order_items(1L, 1L, 1L, 1L);
		assertEquals(null, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(1));
	}
}