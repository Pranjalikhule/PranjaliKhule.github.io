package com.cognizant.truyum.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlTest {

	public static void testGetMenuItemAdmin() {
        
		System.out.println("List of Admin:");
		List<MenuItem> menuItemList = new MenuItemDaoCollectionImpl().getMenuItemListAdmin();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("###");
		df = new DecimalFormat("#.00");
		System.out.format("\n%15s%15s%15s%15s\t%15s%15s%15s\n", "ID", "NAME", "PRICE", " ACTIVE", "DATE_OF_LAUNCH",
				"CATEGORY", "FREE_DELIVERY");
		for (MenuItem menuItem1 : menuItemList) {
			String date = sdf.format(menuItem1.getDateOfLaunch());
			String price = df.format(menuItem1.getPrice());
			System.out.format("%15d%15s%15s%15s\t%15s%15s%15s\n", menuItem1.getId(), menuItem1.getName(), price,
					menuItem1.getActive(), date, menuItem1.getCategory(), menuItem1.getFreeDelivery());
			System.out.println("----------------------------------------------------------------------------");
		}
	}

	public static void testGetMenuItemCustomer() {

		System.out.println("List of Customer:");
		List<MenuItem> menuItemList = new MenuItemDaoCollectionImpl().getMenuItemListCustomer();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("###");
		df = new DecimalFormat("#.00");
		System.out.format("\n%15s%15s%15s%15s\t%15s%15s%15s\n", "ID", "NAME", "PRICE", " ACTIVE", "DATE_OF_LAUNCH",
				"CATEGORY", "FREE_DELIVERY");
		for (MenuItem menuItem1 : menuItemList) {
			String date = sdf.format(menuItem1.getDateOfLaunch());
			String price = df.format(menuItem1.getPrice());
			System.out.format("%15d%15s%15s%15s%15s\t%15s%15s\n", menuItem1.getId(), menuItem1.getName(), price,
					menuItem1.getActive(), date, menuItem1.getCategory(), menuItem1.getFreeDelivery());
			System.out.println("----------------------------------------------------------------------------");
		}
	}

	public static void testModifyMenuItem() {
		
		System.out.println("Modify MenuItem:");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("###");
		df = new DecimalFormat("#.00");
		MenuItem menuItem = new MenuItem(1L, "PuranPoli", 52.00f, false, new DateUtil().convertToDate("12/12/2019"),
				"Main Course", true);
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		menuItemDaoSqlImpl.modifyMenuItem(menuItem);
		System.out.format("%15d%15s%15s%15s%15s\t%15s%15s\n", menuItem.getId(), menuItem.getName(),df.format(menuItem.getPrice()),
				menuItem.getActive(), sdf.format(menuItem.getDateOfLaunch()), menuItem.getCategory(), menuItem.getFreeDelivery());
		System.out.println("----------------------------------------------------------------------------");
	}

	public static MenuItem testGetMenuItem() {

		System.out.println("Get MenuItem:");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("###");
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		long menuItemId = 3;
		System.out.format("\n%15s%15s%15s%15s\t%15s%15s%15s\n", "ID", "NAME", "PRICE", " ACTIVE", "DATE_OF_LAUNCH",
				"CATEGORY", "FREE_DELIVERY");
		MenuItem menuItem = menuItemDaoSqlImpl.getMenuItem(menuItemId);
		String date = sdf.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
		String price = df.format(menuItem.getPrice());
		System.out.format("%15d%15s%15s%15s%15s\t%15s%15s\n", menuItem.getId(), menuItem.getName(), price,
				menuItem.getActive(), date, menuItem.getCategory(), menuItem.getFreeDelivery());
		System.out.println("----------------------------------------------------------------------------");
		return menuItem;
	}

	public static void main(String[] args) {

		testGetMenuItemAdmin();
		testGetMenuItemCustomer();
		testModifyMenuItem();
		testGetMenuItem();
	}
}
