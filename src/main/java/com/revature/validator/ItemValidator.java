package com.revature.validator;

import com.revature.exception.NegativeIdFoundException;
import com.revature.exception.NullItemFoundException;
import com.revature.model.Item;

public class ItemValidator 
{
	
	public void validateSave(Item item)
	{
		if("".equals(item.getName()))
		{
			try
			{
				throw new NullItemFoundException ("Item name cannot be null");
			}
			catch (NullItemFoundException e)
			{
				System.out.println("Exception caught - "+e);
			}
		}
	}
	
	public void validateUpdate(Item item)
	{
		if("".equals(item.getName()))
		{
			try
			{
				throw new NullItemFoundException ("Item name cannot be null");
			}
			catch (NullItemFoundException e)
			{
				System.out.println("Exception caught - "+e);
			}
		}
	}
	
	public void validateDelete(int id)
	{
		if(id<0)
		{
			try
			{
				throw new NegativeIdFoundException("ID cannot be negative");
			}
			catch (NegativeIdFoundException e)
			{
				System.out.println("Exception caught - "+e);
			}
		}
	}

}
