package com.revature.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.util.ConnectionUtil;

public class FunctionDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public int getItemId(String itemName) {
		String sql = "select FN_GET_ITEM_ID(?)";
		Object[] params = { itemName };
		return (jdbcTemplate.queryForObject(sql, params, int.class));
	}

	public int getOrderedSeatId(int orderID) {
		String sql = "select FN_GET_ORDERED_SEAT_ID(?)";
		Object[] params = { orderID };
		return (jdbcTemplate.queryForObject(sql, params, int.class));
	}

	public int getSeatId(String seatName) {
		String sql = "select FN_GET_SEAT_ID(?)";
		Object[] params = { seatName };
		return (jdbcTemplate.queryForObject(sql, params, int.class));
	}

	public int getSessionId(int itemId) {
		String sql = "select FN_GET_SESSION_ID(?)";
		Object[] params = { itemId };
		return (jdbcTemplate.queryForObject(sql, params, int.class));
	}

	public boolean isValidItem(String itemName) {
		String sql = "select FN_IS_VALID_ITEM(?)";
		Object[] params = { itemName };
		return (jdbcTemplate.queryForObject(sql, params, boolean.class));
	}

	public boolean isValidOrder(int orderId) {
		String sql = "select FN_IS_VALID_ORDER_ID(?)";
		Object[] params = { orderId };
		return (jdbcTemplate.queryForObject(sql, params, boolean.class));
	}

	public boolean isValidQuantity(int itemId, int sessionId, int quantity) {
		String sql = "select FN_IS_VALID_QUANTITY(?,?,?)";
		Object[] params = { itemId, sessionId, quantity };
		return (jdbcTemplate.queryForObject(sql, params, boolean.class));
	}

	public boolean isValidSeat(String seatName) {
		String sql = "select FN_IS_VALID_SEAT(?)";
		Object[] params = { seatName };
		return (jdbcTemplate.queryForObject(sql, params, boolean.class));
	}

	public boolean isSeatAvailable(int seatId) {
		String sql = "select FN_IS_VALID_SEAT_AVAILABLE(?)";
		Object[] params = { seatId };
		return (jdbcTemplate.queryForObject(sql, params, boolean.class));
	}

	public boolean isServiceTime() {
		String sql = "select FN_IS_VALID_TIME()";
		return (jdbcTemplate.queryForObject(sql, boolean.class));
	}

}
