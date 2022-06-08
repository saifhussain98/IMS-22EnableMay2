package com.qa.ims.persistence.domain;

public class Order_items {
	private Long order_items_id;
	private Long fkid;
	private String fk_first_name;
	private String fk_surname;
	private Long fk_orderId;
	private Long fk_itemsid;
	private int item_quantity;
	private Double total_cost;
}
