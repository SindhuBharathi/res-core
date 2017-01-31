package com.revature.test;

import com.revature.exception.ItemServiceException;
import com.revature.model.Item;
import com.revature.service.ItemService;

public class TestItemService {
	public static void main(String args[]) {
		ItemService itemService = new ItemService();

		Item item = new Item();

//		item.setId(-1);
		item.setName("");
		try {
			itemService.saveService(item);
		} catch (ItemServiceException e) {
			e.printStackTrace();
 		}
	}
}
