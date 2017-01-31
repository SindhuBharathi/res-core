package com.revature.validator;

import com.revature.exception.NegativeValueFoundException;
import com.revature.exception.NullValueFoundException;
import com.revature.model.Item;

public class ItemValidator {

	public void validateSave(Item item) throws NullValueFoundException {
		if ("".equals(item.getName())) {
			throw new NullValueFoundException("Item name cannot be null");
		}
	}

	public void validateUpdate(Item item) throws NullValueFoundException {
		if ("".equals(item.getName())) {
			throw new NullValueFoundException("Item name cannot be null");
		}
	}

	public void validateDelete(int id) throws NegativeValueFoundException {
		if (id < 0) {
			throw new NegativeValueFoundException("ID cannot be negative");
		}
	}

}
