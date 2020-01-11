package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;

public class CartDaoSqlImplTest {

	public static void testaddCartItem() {

		Long userId = 2l;
		Long MenuItemId = 5l;
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.addCartItem(userId, MenuItemId);
		System.out.println("Item added successfully");
	}

	public static void testgetAllCartItem() throws CartEmptyException {

		long userId = 1l;
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		Cart t = cartDaoSqlImpl.getAllCartItem(userId);
		System.out.println(t.getMenuItemList());
		System.out.println("--------------");
		System.out.println("Total Price:" + t.getTotal());
	}

	public static void testremoveCartItem() {

		Long userId = 1l;
		Long menuItemId = 5l;
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.removeCartItem(userId, menuItemId);
		System.out.println("Item removed successfully");
	}

	public static void main(String[] args) throws CartEmptyException {
		
		testaddCartItem();
		testgetAllCartItem();
		testremoveCartItem();
	}

}
