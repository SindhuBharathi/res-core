package com.revature.test;

import com.revature.model.Item;
import com.revature.validator.ItemValidator;

public class TestItemValidator {

	public static void main(String[] args) {
		Item item = new Item();
		item.setName("");

		ItemValidator itemValidator = new ItemValidator();

		itemValidator.validateSave(item);
		itemValidator.validateUpdate(item);
		itemValidator.validateDelete(-2);

	}

}
