package com.revature.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Schedule;
import com.revature.util.ConnectionUtil;

public class ScheduleDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Schedule schedule) {
		String sql = "insert into schedule(name,from_time,to_time) values(?,?,?)";
		Object[] params = { schedule.getName(), schedule.getFromTime(), schedule.getToTime() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No. of row(s) inserted : " + rows);

	}

	public void updateName(Schedule schedule) {
		String sql = "update schedule set name=? where id=?";
		Object[] params = { schedule.getName(), schedule.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No. of row(s) updated : " + rows);
	}

	public void updateFromTime(Schedule schedule) {
		String sql = "update schedule set from_time=? where id=?";
		Object[] params = { schedule.getFromTime(), schedule.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No. of row(s) updated : " + rows);
	}

	public void updateToTime(Schedule schedule) {
		String sql = "update schedule set to_time=? where id=?";
		Object[] params = { schedule.getToTime(), schedule.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No. of row(s) updated : " + rows);
	}

	public void delete(int id) {
		String sql = "delete from schedule where id=?";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No. of row(s) deleted : " + rows);
	}

	public List<Schedule> list() {
		String sql = "select id,name,from_time,to_time from schedule";
		List<Schedule> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Schedule schedule = new Schedule();
			schedule.setId(rs.getInt("id"));
			schedule.setName(rs.getString("name"));
			schedule.setFromTime(rs.getTime("from_time").toLocalTime());
			schedule.setToTime(rs.getTime("to_time").toLocalTime());
			return schedule;
		});
		return list;
	}

	public List<String> findScheduleNames() {
		String sql = "SELECT name FROM schedule";
		List<String> scheduleNameList = jdbcTemplate.queryForList(sql, String.class);
		return scheduleNameList;
	}

	public Schedule listByName(String name) {
		Schedule schedule = null;
		String sql = "select id,name,from_time,to_time from schedule where name=?";
		Object[] params = { name };
		schedule = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Schedule s = new Schedule();
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setFromTime(rs.getTime("from_time").toLocalTime());
			s.setToTime(rs.getTime("to_time").toLocalTime());
			return s;
		});
		return schedule;
	}

	public Schedule listById(int id) {
		Schedule schedule = null;
		String sql = "select id,name,from_time,to_time from schedule where id=?";
		Object[] params = { id };
		schedule = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Schedule s = new Schedule();
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setFromTime(rs.getTime("from_time").toLocalTime());
			s.setToTime(rs.getTime("to_time").toLocalTime());
			return s;
		});
		return schedule;
	}

}
