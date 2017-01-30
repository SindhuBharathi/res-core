package com.revature.dao;

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
		List<OrdersTransaction> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
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
		});
		return list;
	}

	public OrdersTransaction listById(int id) {
		OrdersTransaction ordersTransaction = null;
		String sql = "select id,order_id,item_id,quantity,time_stamp,status from orders_transaction where id=?";
		Object[] params = { id };
		ordersTransaction = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			OrdersTransaction o = new OrdersTransaction();
			o.setId(rs.getInt("id"));

			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setId(rs.getInt("order_id"));
			o.setOrderId(orderInfo);

			Item item = new Item();
			item.setId(rs.getInt("item_id"));
			o.setItemId(item);

			o.setQuantity(rs.getInt("quantity"));
			o.setTimeStamp(rs.getTimestamp("time_stamp").toLocalDateTime());
			o.setStatus(rs.getString("status"));

			return o;
		});
		return ordersTransaction;
	}

	public List<OrdersTransaction> listByToday() {
		String sql = "select id,order_id,item_id,quantity,time_stamp,status from orders_transaction where date(time_stamp)=curdate()";
		List<OrdersTransaction> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
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
		});
		return list;
	}

}
