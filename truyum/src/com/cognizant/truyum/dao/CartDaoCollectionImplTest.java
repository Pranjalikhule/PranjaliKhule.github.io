package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void testAddCartItem() throws CartEmptyException {

		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 2L);
		cartDao.addCartItem(2, 5L);
		cartDao.addCartItem(2, 1L);
		cartDao.addCartItem(2, 5L);
		Cart cart = cartDao.getAllCartItem(2);
		System.out.println("User added Cart List for CheckOut");
		for (MenuItem menuItem : cart.getMenuItemList()) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() throws CartEmptyException {

		CartDao cartDao = new CartDaoCollectionImpl();
		System.out.println("Item List for Customer after Remove");
		try {
			cartDao.removeCartItem(1, 2L);
			cartDao.removeCartItem(2, 5L);
			cartDao.removeCartItem(2, 3L);
			Cart cart = cartDao.getAllCartItem(2);
			// List<MenuItem> menuItemListCustomer = cartDao.getAllCartItem(1);
			// System.out.println("Item List for Customer after Remove");
			for (MenuItem menuItem : cart.getMenuItemList()) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e);
		}
	}

	public static void testGetAllCartItems() {

	}

	public static void main(String[] args) throws CartEmptyException {

		testAddCartItem();
		testRemoveCartItem();
	}
}
