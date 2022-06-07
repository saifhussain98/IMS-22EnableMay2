package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private Long itemsId;
	private String itemsName;
	private double value;

	public Item(String itemsName, double value) {
		this.setItemsName(itemsName);
		this.setValue(value);
	}

	public Item(Long itemsId, String itemsName, double value) {
		this.setItemsId(itemsId);
		this.setItemsName(itemsName);
		this.setValue(value);
	}

	public Long getItemsId() {
		return itemsId;
	}

	public void setItemsId(Long itemsId) {
		this.itemsId = itemsId;
	}

	public String getItemsName() {
		return itemsName;
	}

	public void setItemsName(String itemsName) {
		this.itemsName = itemsName;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Item [itemsId=" + itemsId + ", itemsName=" + itemsName + ", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemsId, itemsName, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(itemsId, other.itemsId) && Objects.equals(itemsName, other.itemsName)
				&& Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}

}
