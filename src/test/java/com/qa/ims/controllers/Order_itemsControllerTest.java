package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.Order_itemsController;
import com.qa.ims.persistence.dao.Order_itemsDAO;
import com.qa.ims.persistence.domain.Order_items;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class Order_itemsControllerTest {
	@Mock
	private Utils utils;

	@Mock
	private Order_itemsDAO dao;

	@InjectMocks
	private Order_itemsController controller;

//	@Test
//	public void testCreate() {
////		final Long order_items_id = (long) 1;
//		final Long fkId = (long) 1;
//		final Long fk_orderId = (long) 1;
//		final Long fk_itemsId = (long) 1;
//		final Long item_quantity = (long) 1;
//		final Order_items created = new Order_items(fkId, fk_orderId, fk_itemsId, item_quantity);
//
//		Mockito.when(utils.getLong()).thenReturn(fkId);
//		Mockito.when(utils.getLong()).thenReturn(fk_orderId);
//		Mockito.when(utils.getLong()).thenReturn(fk_itemsId);
//		Mockito.when(utils.getLong()).thenReturn(item_quantity);
//		
//		Mockito.when(dao.create(created)).thenReturn(created);
//
//		assertEquals(created, controller.create());
//
//		Mockito.verify(utils, Mockito.times(4)).getLong();
//
//		Mockito.verify(dao, Mockito.times(1)).create(created);
//	}

	@Test
	public void testReadAll() {
		List<Order_items> order_items = new ArrayList<>();
		order_items.add(new Order_items(1L, 1L, 1L, 1L));

		Mockito.when(dao.readAll()).thenReturn(order_items);

		assertEquals(order_items, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {

		assertEquals(null, this.controller.update());
	}

	@Test
	public void testDelete() {
		final long order_items_id = 1L;

		Mockito.when(utils.getLong()).thenReturn(order_items_id);
		Mockito.when(dao.delete(order_items_id)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(order_items_id);
	}

}