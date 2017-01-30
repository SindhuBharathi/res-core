package com.revature.dao;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Item;
import com.revature.util.ConnectionUtil;

public class ItemDAO 
{

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Item item) 
	{
		try
		{
			String sql = "insert into item(name) values(?)";
			Object[] params = { item.getName() };
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No. of row(s) inserted : " + rows);	
		}
		catch (DuplicateKeyException e)
		{
			System.out.println("Cannot have a duplicate key");
		}
	}

	public void update(Item item) 
	{
		try
		{
			String sql = "update item set name=? where id=?";
			Object[] params = { item.getName(), item.getId() };
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No. of row(s) updated : " + rows);
		}
		catch (EmptyResultDataAccessException e)
		{
			System.out.println("Item ID does not exists");
		}
	}

	public void delete(int id) 
	{
		try
		{
			String sql = "delete from item where id=?";
			int rows = jdbcTemplate.update(sql, id);
			System.out.println("No. of row(s) deleted : " + rows);
		}
		catch (EmptyResultDataAccessException e)
		{
			System.out.println("Item ID does not exists");
		}
	}

	public List<Item> list() 
	{
		String sql = "select id,name from item";
		List<Item> list = jdbcTemplate.query(sql, (rs, rowNum) -> 
		{
			Item item = new Item();
			item.setId(rs.getInt("id"));
			item.setName(rs.getString("name"));
			return item;
		});
		return list;
	}
	
	public List<String> findItemNames() 
	{
		String sql = "SELECT name FROM item";
		List<String> itemNameList = jdbcTemplate.queryForList(sql, String.class);
		return itemNameList;
	}

	public Item listByName(String name) 
	{
		Item item = null;
		try 
		{
			String sql = "select id,name from item where name=?";
			Object[] params = { name };
			item = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> 
			{
				Item i = new Item();
				i.setId(rs.getInt("id"));
				i.setName(rs.getString("name"));
				return i;
			});
		} 
		catch (EmptyResultDataAccessException e) 
		{
			System.out.println("Item Not Available");
		} 
		catch (IncorrectResultSizeDataAccessException e) 
		{
			System.out.println("More records with similar item name");
		}
		return item;
	}

	public Item listById(int id) 
	{
		Item item = null;
		try 
		{
			String sql = "select id,name from item where id=?";
			Object[] params = { id };
			item = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> 
			{
				Item i = new Item();
				i.setId(rs.getInt("id"));
				i.setName(rs.getString("name"));
				return i;
			});
		} 
		catch (EmptyResultDataAccessException e) 
		{
			System.out.println("Item Not Available");
		} 
		catch (IncorrectResultSizeDataAccessException e) 
		{
			System.out.println("More records with similar item name");
		}
		return item;
	}
	
}
