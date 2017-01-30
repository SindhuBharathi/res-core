package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.OrderInfo;
import com.revature.model.Seat;
import com.revature.util.ConnectionUtil;

public class OrderInfoDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	Logger logger = Logger.getLogger(ItemDAO.class.getName());

	public List<OrderInfo> list() {
		String sql = "select id,seat_id,status from order_info";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			return convert(rs);
		});
	}

	public OrderInfo listById(int id) {
		String sql = "select id,seat_id,status from order_info where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			return convert(rs);
		});
	}

	static OrderInfo convert(final ResultSet rs) throws SQLException {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setId(rs.getInt("id"));

		Seat seat = new Seat();
		seat.setId(rs.getInt("seat_id"));
		orderInfo.setSeatId(seat);

		orderInfo.setStatus(rs.getString("status"));

		return orderInfo;
	}

}
