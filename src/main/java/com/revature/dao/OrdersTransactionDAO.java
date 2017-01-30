package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Item;
import com.revature.model.OrderInfo;
import com.revature.model.OrdersTransaction;
import com.revature.util.ConnectionUtil;

public class OrdersTransactionDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public List<OrdersTransaction> list() {
		String sql = "select id,order_id,item_id,quantity,time_stamp,status from orders_transaction";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));
	}

	public OrdersTransaction listById(int id) {
		String sql = "select id,order_id,item_id,quantity,time_stamp,status from orders_transaction where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> convert(rs));
	}

	public List<OrdersTransaction> listByToday() {
		String sql = "select id,order_id,item_id,quantity,time_stamp,status from orders_transaction where date(time_stamp)=curdate()";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));

	}

	static OrdersTransaction convert(final ResultSet rs) throws SQLException {
		OrdersTransaction ordersTransaction = new OrdersTransaction();
		ordersTransaction.setId(rs.getInt("id"));

		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setId(rs.getInt("order_id"));
		ordersTransaction.setOrderId(orderInfo);

		Item item = new Item();
		item.setId(rs.getInt("item_id"));
		ordersTransaction.setItemId(item);

		ordersTransaction.setQuantity(rs.getInt("quantity"));
		ordersTransaction.setTimeStamp(rs.getTimestamp("time_stamp").toLocalDateTime());
		ordersTransaction.setStatus(rs.getString("status"));

		return ordersTransaction;
	}
}
