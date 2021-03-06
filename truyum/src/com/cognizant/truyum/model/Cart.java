package com.cognizant.truyum.model;

import java.util.List;

public class Cart {

	private List<MenuItem> menuItemList;
	private Double total;

	public Cart(List<MenuItem> menuItemList, Double total) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
	}

	public Cart() {

	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;

		if (menuItemList == null) {

			if (other.menuItemList != null)
				return false;

		} else if (!menuItemList.equals(other.menuItemList))
			return false;

		if (total == null) {

			if (other.total != null)
				return false;

		} else if (!total.equals(other.total))
			return false;
		return true;
	}

}
