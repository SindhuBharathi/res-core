package com.revature.dao;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.revature.util.ConnectionUtil;

public class ProcedureDAO 
{
	
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public String placeOrder(String seatName, String itemNameList, String itemQuantityList, String message) 
	{

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		call.withProcedureName("PR_IS_VALID_INPUT");
		call.declareParameters(new SqlParameter("in_seat_name", Types.VARCHAR),
				new SqlParameter("in_item_name", Types.VARCHAR), new SqlParameter("in_item_qty", Types.VARCHAR),
				new SqlOutParameter("out_msg", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);

		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("in_seat_name", seatName);
		in.addValue("in_item_name", itemNameList);
		in.addValue("in_item_qty", itemQuantityList);
		in.addValue("out_msg", message);

		Map<String, Object> execute = call.execute(in);

		String status = (String) execute.get("out_msg");
		return status;

	}
	
	public String cancelOrder(int orderId, String message)
	{
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		call.withProcedureName("PR_CANCEL_ORDER");
		call.declareParameters(new SqlParameter("param_order_id", Types.INTEGER),
				new SqlOutParameter("param_msg", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);

		MapSqlParameterSource in = new MapSqlParameterSource().addValue("param_order_id", orderId).addValue("param_msg", message);

		Map<String, Object> execute = call.execute(in);
		
		String status=(String) execute.get("param_msg");
		return status;
	
	}

}
