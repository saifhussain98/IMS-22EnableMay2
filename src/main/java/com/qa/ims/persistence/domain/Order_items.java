package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order_items {

	private Long order_items_id;

    private Long fkId;

    private Long fk_orderId;

    private Long fk_itemsId;
    
    private Long item_quantity;
    
//    private double total_cost_of_order;



    public Order_items(Long fkId, Long fk_orderId, Long fk_itemsId, Long item_quantity) {

        this.fkId = fkId;

        this.fk_orderId = fk_orderId;

        this.fk_itemsId = fk_itemsId;
        
        this.item_quantity = item_quantity;
        
//        this.total_cost_of_order = total_cost_of_order;

    }

    

    public Order_items(Long order_items_id, Long fkId, Long fk_orderId, Long fk_itemsId, Long item_quantity) {

    	this.order_items_id = order_items_id;
    	
    	this.fkId = fkId;

        this.fk_orderId = fk_orderId;

        this.fk_itemsId = fk_itemsId;
        
        this.item_quantity = item_quantity;
        
//        this.total_cost_of_order = total_cost_of_order;

    }



	public Long getOrder_items_id() {
		return order_items_id;
	}



	public void setOrder_items_id(Long order_items_id) {
		this.order_items_id = order_items_id;
	}



	public Long getFkId() {
		return fkId;
	}



	public void setFkId(Long fkId) {
		this.fkId = fkId;
	}



	public Long getFk_orderId() {
		return fk_orderId;
	}



	public void setFk_orderId(Long fk_orderId) {
		this.fk_orderId = fk_orderId;
	}



	public Long getFk_itemsId() {
		return fk_itemsId;
	}



	public void setFk_itemsId(Long fk_itemsId) {
		this.fk_itemsId = fk_itemsId;
	}



	public Long getItem_quantity() {
		return item_quantity;
	}



	public void setItem_quantity(Long item_quantity) {
		this.item_quantity = item_quantity;
	}



	@Override
	public String toString() {
		return "Order_items [order_items_id=" + order_items_id + ", fkId=" + fkId + ", fk_orderId=" + fk_orderId
				+ ", fk_itemsId=" + fk_itemsId + ", item_quantity=" + item_quantity + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(fkId, fk_itemsId, fk_orderId, item_quantity, order_items_id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order_items other = (Order_items) obj;
		return Objects.equals(fkId, other.fkId) && Objects.equals(fk_itemsId, other.fk_itemsId)
				&& Objects.equals(fk_orderId, other.fk_orderId) && item_quantity == other.item_quantity
				&& Objects.equals(order_items_id, other.order_items_id);
	}



//	public double getTotal_cost_of_order() {
//		return total_cost_of_order;
//	}



//	public void setTotal_cost_of_order(double total_cost_of_order) {
//		this.total_cost_of_order = total_cost_of_order;
//	}


}