package com.revature.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.OrderInfo;
import com.revature.model.Seat;
import com.revature.util.ConnectionUtil;

public class OrderInfoDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public List<OrderInfo> list() {
		String sql = "select id,seat_id,status from order_info";
		List<OrderInfo> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setId(rs.getInt("id"));

			Seat seat = new Seat();
			seat.setId(rs.getInt("seat_id"));
			orderInfo.setSeatId(seat);

			orderInfo.setStatus(rs.getString("status"));

			return orderInfo;
		});
		return list;
	}

	public OrderInfo listById(int id) {
		OrderInfo orderInfo = null;
		String sql = "select id,seat_id,status from order_info where id=?";
		Object[] params = { id };
		orderInfo = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			OrderInfo o = new OrderInfo();
			o.setId(rs.getInt("id"));

			Seat seat = new Seat();
			seat.setId(rs.getInt("seat_id"));
			o.setSeatId(seat);

			o.setStatus(rs.getString("status"));

			return o;
		});
		return orderInfo;
	}

}
