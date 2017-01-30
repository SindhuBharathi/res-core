package com.revature.dao;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Item;
import com.revature.model.ItemsAvailable;
import com.revature.model.Schedule;
import com.revature.util.ConnectionUtil;

public class ItemsAvailableDAO 
{
	
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(ItemsAvailable itemsAvailable) 
	{
		try
		{
			String sql = "insert into items_available(schedule_id,item_id,quantity) values(?,?,?)";
			Object[] params = { itemsAvailable.getScheduleId().getId(), itemsAvailable.getItemId().getId(), itemsAvailable.getQuantity() };
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No. of row(s) inserted : " + rows);
		}
		catch (DuplicateKeyException e)
		{
			System.out.println("Cannot have a duplicate key");
		}
		catch (DataIntegrityViolationException e)
		{
			System.out.println("Foreign key Constarint fails");
		}		
	}
	
	public void updateItemId(ItemsAvailable itemsAvailable) 
	{
		try
		{
			String sql = "update items_available set item_id=? where id=?";
			Object[] params = { itemsAvailable.getItemId().getId(), itemsAvailable.getId() };
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No. of row(s) updated : " + rows);
		}
		catch (EmptyResultDataAccessException e)
		{
			System.out.println("Items Available ID does not exists");
		}
	}
	
	public void updateScheduleId(ItemsAvailable itemsAvailable) 
	{
		try
		{
			String sql = "update items_available set schedule_id=? where id=?";
			Object[] params = { itemsAvailable.getScheduleId().getId(), itemsAvailable.getId() };
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No. of row(s) updated : " + rows);
		}
		catch (EmptyResultDataAccessException e)
		{
			System.out.println("Items Available ID does not exists");
		}
	}
	
	public void updateQuantity(ItemsAvailable itemsAvailable) 
	{
		try
		{
			String sql = "update items_available set quantity=? where id=?";
			Object[] params = { itemsAvailable.getQuantity(), itemsAvailable.getId() };
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No. of row(s) updated : " + rows);
		}
		catch (EmptyResultDataAccessException e)
		{
			System.out.println("Items Available ID does not exists");
		}
	}
	
	public void delete(int id) 
	{
		try
		{
			String sql = "delete from items_available where id=?";
			int rows = jdbcTemplate.update(sql, id);
			System.out.println("No. of row(s) deleted : " + rows);
		}
		catch (EmptyResultDataAccessException e)
		{
			System.out.println("Schedule ID does not exists");
		}
	}
	
	public List<ItemsAvailable> list() 
	{
		String sql = "select id,schedule_id,item_id,quantity from items_available";
		List<ItemsAvailable> list = jdbcTemplate.query(sql, (rs, rowNum) -> 
		{
			ItemsAvailable itemsAvailable = new ItemsAvailable();
			itemsAvailable.setId(rs.getInt("id"));
			
			Schedule schedule = new Schedule();
			schedule.setId(rs.getInt("schedule_id"));
			itemsAvailable.setScheduleId(schedule);
			
			Item item=new Item();
			item.setId(rs.getInt("item_id"));
			itemsAvailable.setItemId(item);
			itemsAvailable.setQuantity(rs.getInt("quantity"));
			
			return itemsAvailable;
		});
		return list;
	}
	
	public ItemsAvailable listById(int id) 
	{
		ItemsAvailable itemsAvailable = null;
		try 
		{
			String sql = "select id,schedule_id,item_id,quantity from items_available where id=?";
			Object[] params = { id };
			itemsAvailable = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> 
			{
				ItemsAvailable i = new ItemsAvailable();
				i.setId(rs.getInt("id"));
				
				Schedule schedule = new Schedule();
				schedule.setId(rs.getInt("schedule_id"));
				i.setScheduleId(schedule);
				
				Item item=new Item();
				item.setId(rs.getInt("item_id"));
				i.setItemId(item);
				i.setQuantity(rs.getInt("quantity"));
				
				return i;
			});
		} 
		catch (EmptyResultDataAccessException e) 
		{
			System.out.println("Schedule Not Available");
		} 
		catch (IncorrectResultSizeDataAccessException e) 
		{
			System.out.println("More records with similar schedule name");
		}
		return itemsAvailable;
	}
	
}
