package com.qa.ims.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.Order_itemsDAO;
import com.qa.ims.persistence.domain.Order_items;
import com.qa.ims.utils.Utils;

public class Order_itemsController implements CrudController<Order_items> {

	public static final Logger LOGGER = LogManager.getLogger();

	private Order_itemsDAO order_itemsDAO;

	private Utils utils;

	public Order_itemsController(Order_itemsDAO order_itemsDAO, Utils utils) {

		super();

		this.order_itemsDAO = order_itemsDAO;

		this.utils = utils;

	}

	/**
	 * 
	 * Reads all order items to the logger
	 * 
	 */

	@Override

	public List<Order_items> readAll() {

		List<Order_items> items = order_itemsDAO.readAll();

		for (Order_items item : items) {

			LOGGER.info(item);

		}

		return items;

	}

	/**
	 * 
	 * Creates an order item by taking in user input
	 * 
	 */

	@Override

	public Order_items create() {

		LOGGER.info("Please enter the customer ID");

		Long fkId = utils.getLong();

		LOGGER.info("Please enter the order id");

		Long fk_orderId = utils.getLong();

		LOGGER.info("Please enter the item id");

		Long fk_itemId = utils.getLong();
		
		LOGGER.info("Please enter the quantity of your item(s)");

		Long item_quantity = utils.getLong();
//
//		LOGGER.info("Please enter the item id");
//
//		Long totoal_cost_of_order = utils.getLong();

		Order_items order_items = order_itemsDAO.create(new Order_items(fkId, fk_orderId, fk_itemId, item_quantity));

		LOGGER.info("Order Item created");

		return order_items;

		
		
	}

	/**
	 * 
	 * Updates an existing item by taking in user input
	 * 
	 */

	@Override

	public Order_items update() {

		LOGGER.info("Cannot Be Updated!");

		return null;

	}

	/**
	 * 
	 * Deletes an existing order item by the id of the order item
	 *
	 * 
	 * 
	 * @return
	 * 
	 */

	@Override

	public int delete() {

		LOGGER.info("Please enter the id of the order item you would like to delete");

		Long order_items_id = utils.getLong();

		return order_itemsDAO.delete(order_items_id);

	}

}
