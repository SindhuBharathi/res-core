package com.revature.dao;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Seat;
import com.revature.util.ConnectionUtil;

public class SeatDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Seat seat) 
	{
		try
		{
			String sql = "insert into seat(name) values(?)";
			Object[] params = { seat.getName() };
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No. of row(s) inserted : " + rows);
		}
		catch (DuplicateKeyException e)
		{
			System.out.println("Cannot have a duplicate key");
		}
	}

	public void update(Seat seat) 
	{
		try
		{
			String sql = "update seat set name=? where id=?";
			Object[] params = { seat.getName(), seat.getId() };
			int rows = jdbcTemplate.update(sql, params);
			System.out.println("No. of row(s) updated : " + rows);
		}
		catch (EmptyResultDataAccessException e)
		{
			System.out.println("Seat ID does not exists");
		}
	}

	public void delete(int id) 
	{
		try
		{
			String sql = "delete from seat where id=?";
			int rows = jdbcTemplate.update(sql, id);
			System.out.println("No. of row(s) deleted : " + rows);
		}
		catch (EmptyResultDataAccessException e)
		{
			System.out.println("Seat ID does not exists");
		}
	}

	public List<Seat> list() 
	{
		String sql = "select id,name,status from seat";
		List<Seat> list = jdbcTemplate.query(sql, (rs, rowNum) -> 
		{
			Seat seat = new Seat();
			seat.setId(rs.getInt("id"));
			seat.setName(rs.getString("name"));
			seat.setStatus(rs.getBoolean("status"));
			return seat;
		});
		return list;
	}
	
	public List<String> findSeatNames() 
	{
		String sql = "SELECT name FROM seat";
		List<String> seatNameList = jdbcTemplate.queryForList(sql, String.class);
		return seatNameList;
	}

	public Seat listByName(String name) 
	{
		Seat seat = null;
		try 
		{
			String sql = "select id,name,status from seat where name=?";
			Object[] params = { name };
			seat = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> 
			{
				Seat s = new Seat();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setStatus(rs.getBoolean("status"));
				return s;
			});
		} 
		catch (EmptyResultDataAccessException e) 
		{
			System.out.println("Seat Not exists");
		} 
		return seat;
	}

	public Seat listById(int id) 
	{
		Seat seat = null;
		try 
		{
			String sql = "select id,name,status from seat where id=?";
			Object[] params = { id };
			seat = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> 
			{
				Seat s = new Seat();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setStatus(rs.getBoolean("status"));
				return s;
			});
		} 
		catch (EmptyResultDataAccessException e) 
		{
			System.out.println("Seat ID Not Exists");
		} 
		return seat;
	}

}
