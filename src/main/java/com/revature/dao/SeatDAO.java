package com.revature.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Seat;
import com.revature.util.ConnectionUtil;

public class SeatDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Seat seat) {
		String sql = "insert into seat(name) values(?)";
		Object[] params = { seat.getName() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No. of row(s) inserted : " + rows);
	}

	public void update(Seat seat) {
		String sql = "update seat set name=? where id=?";
		Object[] params = { seat.getName(), seat.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No. of row(s) updated : " + rows);
	}

	public void delete(int id) {
		String sql = "delete from seat where id=?";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No. of row(s) deleted : " + rows);
	}

	public List<Seat> list() {
		String sql = "select id,name,status from seat";
		List<Seat> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Seat seat = new Seat();
			seat.setId(rs.getInt("id"));
			seat.setName(rs.getString("name"));
			seat.setStatus(rs.getBoolean("status"));
			return seat;
		});
		return list;
	}

	public List<String> findSeatNames() {
		String sql = "SELECT name FROM seat";
		List<String> seatNameList = jdbcTemplate.queryForList(sql, String.class);
		return seatNameList;
	}

	public Seat listByName(String name) {
		Seat seat = null;
		String sql = "select id,name,status from seat where name=?";
		Object[] params = { name };
		seat = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Seat s = new Seat();
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setStatus(rs.getBoolean("status"));
			return s;
		});
		return seat;
	}

	public Seat listById(int id) {
		Seat seat = null;
		String sql = "select id,name,status from seat where id=?";
		Object[] params = { id };
		seat = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Seat s = new Seat();
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setStatus(rs.getBoolean("status"));
			return s;
		});
		return seat;
	}

}
