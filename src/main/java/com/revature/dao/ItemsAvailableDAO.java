package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Item;
import com.revature.model.ItemsAvailable;
import com.revature.model.Schedule;
import com.revature.util.ConnectionUtil;

public class ItemsAvailableDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	Logger logger = Logger.getLogger(ItemsAvailableDAO.class.getName());
	final String msg = "No. of rows changed ";

	public void save(ItemsAvailable itemsAvailable) {
		String sql = "insert into items_available(schedule_id,item_id,quantity) values(?,?,?)";
		Object[] params = { itemsAvailable.getScheduleId().getId(), itemsAvailable.getItemId().getId(),
				itemsAvailable.getQuantity() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, msg, rows);
	}

	public void updateItemId(ItemsAvailable itemsAvailable) {
		String sql = "update items_available set item_id=? where id=?";
		Object[] params = { itemsAvailable.getItemId().getId(), itemsAvailable.getId() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, msg, rows);
	}

	public void updateScheduleId(ItemsAvailable itemsAvailable) {
		String sql = "update items_available set schedule_id=? where id=?";
		Object[] params = { itemsAvailable.getScheduleId().getId(), itemsAvailable.getId() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, msg, rows);
	}

	public void updateQuantity(ItemsAvailable itemsAvailable) {
		String sql = "update items_available set quantity=? where id=?";
		Object[] params = { itemsAvailable.getQuantity(), itemsAvailable.getId() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, msg, rows);

	}

	public void delete(int id) {
		String sql = "delete from items_available where id=?";
		int rows = jdbcTemplate.update(sql, id);
		logger.log(Level.INFO, msg, rows);

	}

	public List<ItemsAvailable> list() {
		String sql = "select id,schedule_id,item_id,quantity from items_available";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			return convert(rs);
		});
	}

	public ItemsAvailable listById(int id) {
		String sql = "select id,schedule_id,item_id,quantity from items_available where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			return convert(rs);
		});

	}

	static ItemsAvailable convert(final ResultSet rs) throws SQLException {
		ItemsAvailable itemsAvailable = new ItemsAvailable();
		itemsAvailable.setId(rs.getInt("id"));

		Schedule schedule = new Schedule();
		schedule.setId(rs.getInt("schedule_id"));
		itemsAvailable.setScheduleId(schedule);

		Item item = new Item();
		item.setId(rs.getInt("item_id"));
		itemsAvailable.setItemId(item);
		itemsAvailable.setQuantity(rs.getInt("quantity"));

		return itemsAvailable;
	}
}
