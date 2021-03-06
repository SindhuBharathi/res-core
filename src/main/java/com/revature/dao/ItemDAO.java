package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Item;
import com.revature.util.ConnectionUtil;

public class ItemDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	Logger logger = Logger.getLogger(ItemDAO.class.getName());
	static final String MSG = "No. of rows changed ";

	public void save(Item item) {
		String sql = "insert into item(name) values(?)";
		Object[] params = { item.getName() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, MSG, rows);
	}

	public void update(Item item) {
		String sql = "update item set name=? where id=?";
		Object[] params = { item.getName(), item.getId() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, MSG, rows);
	}

	public void delete(int id) {
		String sql = "delete from item where id=?";
		int rows = jdbcTemplate.update(sql, id);
		logger.log(Level.INFO, MSG, rows);
	}

	public List<Item> list() {
		String sql = "select id,name from item";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));
	}

	public List<String> findItemNames() {
		String sql = "SELECT name FROM item";
		return jdbcTemplate.queryForList(sql, String.class);
	}

	public Item listByName(String name) {
		String sql = "select id,name from item where name=?";
		Object[] params = { name };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> convert(rs));
	}

	public Item listById(int id) {
		String sql = "select id,name from item where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> convert(rs));
	}

	static Item convert(final ResultSet rs) throws SQLException {
		Item i = new Item();
		i.setId(rs.getInt("id"));
		i.setName(rs.getString("name"));
		return i;
	}
}
