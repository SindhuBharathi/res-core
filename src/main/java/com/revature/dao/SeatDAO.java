package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Seat;
import com.revature.util.ConnectionUtil;

public class SeatDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	Logger logger = Logger.getLogger(SeatDAO.class.getName());

	public void save(Seat seat) {
		String sql = "insert into seat(name) values(?)";
		Object[] params = { seat.getName() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No. of row(s) inserted : ", rows);
	}

	public void update(Seat seat) {
		String sql = "update seat set name=? where id=?";
		Object[] params = { seat.getName(), seat.getId() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, "No. of row(s) updated : ", rows);
	}

	public void delete(int id) {
		String sql = "delete from seat where id=?";
		int rows = jdbcTemplate.update(sql, id);
		logger.log(Level.INFO, "No. of row(s) deleted : ", rows);
	}

	public List<Seat> list() {
		String sql = "select id,name,status from seat";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			return convert(rs);
		});
	}

	public List<String> findSeatNames() {
		String sql = "SELECT name FROM seat";
		return jdbcTemplate.queryForList(sql, String.class);
	}

	public Seat listByName(String name) {
		String sql = "select id,name,status from seat where name=?";
		Object[] params = { name };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			return convert(rs);
		});
	}

	public Seat listById(int id) {
		String sql = "select id,name,status from seat where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			return convert(rs);
		});
	}

	static Seat convert(final ResultSet rs) throws SQLException {
		Seat seat = new Seat();
		seat.setId(rs.getInt("id"));
		seat.setName(rs.getString("name"));
		seat.setStatus(rs.getBoolean("status"));
		return seat;
	}

}
