package com.revature.test;

import java.util.List;

import com.revature.dao.ItemDAO;
import com.revature.model.Item;

public class TestItemDAO {

	public static void main(String[] args) {
		Item item = new Item();
		item.setId(15);
		item.setName("Meals");

		ItemDAO itemDAO = new ItemDAO();

		// itemDAO.save(item);
		// itemDAO.update(item);
		// itemDAO.delete(15);

		List<Item> list = itemDAO.list();
		for (Item i : list) {
			System.out.println(i);
		}

		item = itemDAO.listByName("Dosa");
		System.out.println(item);

		item = itemDAO.listById(14);
		System.out.println(item);

		List<String> itemNames = itemDAO.findItemNames();
		for (String itemName : itemNames) {
			System.out.println(itemName);
		}

	}

}
