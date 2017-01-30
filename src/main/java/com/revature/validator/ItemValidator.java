package com.revature.validator;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.revature.dao.ItemDAO;
import com.revature.exception.NegativeIdFoundException;
import com.revature.exception.NullItemFoundException;
import com.revature.model.Item;

public class ItemValidator {
	Logger logger = Logger.getLogger(ItemDAO.class.getName());

	public void validateSave(Item item) {
		if ("".equals(item.getName())) {
			try {
				throw new NullItemFoundException("Item name cannot be null");
			} catch (NullItemFoundException e) {
				logger.log(Level.SEVERE, "Exception: " + e);
			}
		}
	}

	public void validateUpdate(Item item) {
		if ("".equals(item.getName())) {
			try {
				throw new NullItemFoundException("Item name cannot be null");
			} catch (NullItemFoundException e) {
				logger.log(Level.SEVERE, "Exception: " + e);
			}
		}
	}

	public void validateDelete(int id) {
		if (id < 0) {
			try {
				throw new NegativeIdFoundException("ID cannot be negative");
			} catch (NegativeIdFoundException e) {
				logger.log(Level.SEVERE, "Exception: " + e);
			}
		}
	}

}
