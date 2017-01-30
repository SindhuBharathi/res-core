package com.revature.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.util.ConnectionUtil;

public class FunctionDAO 
{
	
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public int getItemId(String itemName) 
	{
		String sql = "select FN_GET_ITEM_ID(?)";
		Object[] params = { itemName };
		int itemID = jdbcTemplate.queryForObject(sql, params, int.class);
		return itemID;
	}
	
	public int getOrderedSeatId(int orderID) 
	{
		String sql = "select FN_GET_ORDERED_SEAT_ID(?)";
		Object[] params = { orderID };
		int seatID = jdbcTemplate.queryForObject(sql, params, int.class);
		return seatID;
	}
	
	public int getSeatId(String seatName) 
	{
		String sql = "select FN_GET_SEAT_ID(?)";
		Object[] params = { seatName };
		int seatID = jdbcTemplate.queryForObject(sql, params, int.class);
		return seatID;
	}
	
	public int getSessionId(int itemId) 
	{
		String sql = "select FN_GET_SESSION_ID(?)";
		Object[] params = { itemId };
		int sessionID = jdbcTemplate.queryForObject(sql, params, int.class);
		return sessionID;
	}
	
	public boolean isValidItem(String itemName) 
	{
		String sql = "select FN_IS_VALID_ITEM(?)";
		Object[] params = { itemName };
		boolean isAvailable = jdbcTemplate.queryForObject(sql, params, boolean.class);
		return isAvailable;
	}
	
	public boolean isValidOrder(int orderId) 
	{
		String sql = "select FN_IS_VALID_ORDER_ID(?)";
		Object[] params = { orderId };
		boolean isAvailable = jdbcTemplate.queryForObject(sql, params, boolean.class);
		return isAvailable;
	}
	
	public boolean isValidQuantity(int itemId, int sessionId, int quantity) 
	{
		String sql = "select FN_IS_VALID_QUANTITY(?,?,?)";
		Object[] params = { itemId, sessionId, quantity };
		boolean isAvailable = jdbcTemplate.queryForObject(sql, params, boolean.class);
		return isAvailable;
	}
	
	public boolean isValidSeat(String seatName) 
	{
		String sql = "select FN_IS_VALID_SEAT(?)";
		Object[] params = { seatName };
		boolean isAvailable = jdbcTemplate.queryForObject(sql, params, boolean.class);
		return isAvailable;
	}
	
	public boolean isSeatAvailable(int seatId) 
	{
		String sql = "select FN_IS_VALID_SEAT_AVAILABLE(?)";
		Object[] params = { seatId };
		boolean isAvailable = jdbcTemplate.queryForObject(sql, params, boolean.class);
		return isAvailable;
	}
	
	public boolean isServiceTime() 
	{
		String sql = "select FN_IS_VALID_TIME()";
		boolean isAvailable = jdbcTemplate.queryForObject(sql, boolean.class);
		return isAvailable;
	}

}
