package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	public static final String ADD_MENUITEM_TO_CART = "insert into cart(ct_us_id,ct_me_id)values(?,?)";
	public static final String GET_MENU_ITEM = "select  me_id,me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from menu_item inner join cart on  ct_me_id=me_id where ct_us_id=?";
	public static final String GET_TOTAL = "select sum(me_price)as Total from menu_item inner join cart on  ct_me_id=me_id where ct_us_id=?";
	public static final String REMOVE_MENUITEM_TO_CART = "delete from cart where ct_us_id=? and ct_me_id=? limit 1";

	@Override
	public void addCartItem(long userId, long menuItemId) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(ADD_MENUITEM_TO_CART);
			statement.setLong(1, userId);
			statement.setLong(2, menuItemId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number of rows affected" + noOfRows);
		} catch (SQLException e) {
			System.out.println("Data not inserted");
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Cart getAllCartItem(long userId) throws CartEmptyException {

		Cart cart = new Cart();
		ArrayList<MenuItem> CartItem = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		PreparedStatement statementResult = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		// cart.setTotal(0.00);
		try {
			statement = connection.prepareStatement(GET_MENU_ITEM);
			statement.setLong(1, userId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("1"));
				CartItem.add(menuItem);
			}
			statementResult = connection.prepareStatement(GET_TOTAL);
			statementResult.setLong(1, userId);
			resultSetTotal = statementResult.executeQuery();
			if (CartItem.size() == 0) {
				throw new CartEmptyException();
			}
			while (resultSetTotal.next()) {
				cart.setTotal(resultSetTotal.getDouble("Total"));
			}
			cart.setMenuItemList(CartItem);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statementResult != null)
					statementResult.close();
				if (resultSetTotal != null)
					resultSetTotal.close();
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}
		return cart;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(REMOVE_MENUITEM_TO_CART);
			statement.setLong(1, userId);
			statement.setLong(2, menuItemId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number of rows affected:" + noOfRows);
		} catch (SQLException e) {
			System.out.println("Data not inserted");
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
			}
		}
	}
}
