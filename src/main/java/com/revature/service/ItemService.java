package com.revature.service;

import com.revature.dao.ItemDAO;
import com.revature.exception.ItemServiceException;
import com.revature.exception.NegativeValueFoundException;
import com.revature.exception.NullValueFoundException;
import com.revature.model.Item;
import com.revature.validator.ItemValidator;

public class ItemService {
	public void saveService(Item item) throws ItemServiceException
	{
		ItemValidator itemValidator=new ItemValidator();
		ItemDAO itemDAO=new ItemDAO();
		try
		{
			itemValidator.validateSave(item);
			itemDAO.save(item);
		}
		catch(NullValueFoundException e)
		{
			throw new ItemServiceException("Item Name cannot be null");
		}
	}
	
	public void updateService(Item item) throws ItemServiceException
	{
		ItemValidator itemValidator=new ItemValidator();
		ItemDAO itemDAO=new ItemDAO();
		try
		{
			itemValidator.validateUpdate(item);
			itemDAO.update(item);
		}
		catch(NullValueFoundException e)
		{
			throw new ItemServiceException("Item Name cannot be null");
		}
	}
	
	public void deleteService(int id) throws ItemServiceException
	{
		ItemValidator itemValidator=new ItemValidator();
		ItemDAO itemDAO=new ItemDAO();
		try
		{
			itemValidator.validateDelete(id);;
			itemDAO.delete(id);
		}
		catch(NegativeValueFoundException e)
		{
			throw new ItemServiceException("Item id cannot be negative");
		}
	}

}
