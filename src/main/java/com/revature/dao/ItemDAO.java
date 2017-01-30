package com.revature.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Item;
import com.revature.util.ConnectionUtil;

public class ItemDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Item item) {
		String sql = "insert into item(name) values(?)";
		Object[] params = { item.getName() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No. of row(s) inserted : " + rows);
	}

	public void update(Item item) {
		String sql = "update item set name=? where id=?";
		Object[] params = { item.getName(), item.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No. of row(s) updated : " + rows);
	}

	public void delete(int id) {
		String sql = "delete from item where id=?";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No. of row(s) deleted : " + rows);
	}

	public List<Item> list() {
		String sql = "select id,name from item";
		List<Item> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Item item = new Item();
			item.setId(rs.getInt("id"));
			item.setName(rs.getString("name"));
			return item;
		});
		return list;
	}

	public List<String> findItemNames() {
		String sql = "SELECT name FROM item";
		List<String> itemNameList = jdbcTemplate.queryForList(sql, String.class);
		return itemNameList;
	}

	public Item listByName(String name) {
		Item item = null;
		String sql = "select id,name from item where name=?";
		Object[] params = { name };
		item = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Item i = new Item();
			i.setId(rs.getInt("id"));
			i.setName(rs.getString("name"));
			return i;
		});
		return item;
	}

	public Item listById(int id) {
		Item item = null;
		String sql = "select id,name from item where id=?";
		Object[] params = { id };
		item = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Item i = new Item();
			i.setId(rs.getInt("id"));
			i.setName(rs.getString("name"));
			return i;
		});
		return item;
	}

}
