package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Schedule;
import com.revature.util.ConnectionUtil;

public class ScheduleDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	Logger logger = Logger.getLogger(ScheduleDAO.class.getName());
	static final String msg = "No. of rows changed ";

	public void save(Schedule schedule) {
		String sql = "insert into schedule(name,from_time,to_time) values(?,?,?)";
		Object[] params = { schedule.getName(), schedule.getFromTime(), schedule.getToTime() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, msg, rows);

	}

	public void updateName(Schedule schedule) {
		String sql = "update schedule set name=? where id=?";
		Object[] params = { schedule.getName(), schedule.getId() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, msg, rows);
	}

	public void updateFromTime(Schedule schedule) {
		String sql = "update schedule set from_time=? where id=?";
		Object[] params = { schedule.getFromTime(), schedule.getId() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, msg, rows);
	}

	public void updateToTime(Schedule schedule) {
		String sql = "update schedule set to_time=? where id=?";
		Object[] params = { schedule.getToTime(), schedule.getId() };
		int rows = jdbcTemplate.update(sql, params);
		logger.log(Level.INFO, msg, rows);
	}

	public void delete(int id) {
		String sql = "delete from schedule where id=?";
		int rows = jdbcTemplate.update(sql, id);
		logger.log(Level.INFO, msg, rows);
	}

	public List<Schedule> list() {
		String sql = "select id,name,from_time,to_time from schedule";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));
	}

	public List<String> findScheduleNames() {
		String sql = "SELECT name FROM schedule";
		return jdbcTemplate.queryForList(sql, String.class);
	}

	public Schedule listByName(String name) {
		String sql = "select id,name,from_time,to_time from schedule where name=?";
		Object[] params = { name };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> convert(rs));

	}

	public Schedule listById(int id) {
		String sql = "select id,name,from_time,to_time from schedule where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> convert(rs));
	}

	static Schedule convert(final ResultSet rs) throws SQLException {
		Schedule schedule = new Schedule();
		schedule.setId(rs.getInt("id"));
		schedule.setName(rs.getString("name"));
		schedule.setFromTime(rs.getTime("from_time").toLocalTime());
		schedule.setToTime(rs.getTime("to_time").toLocalTime());
		return schedule;
	}

}
