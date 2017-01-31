package com.revature.dao;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.revature.util.ConnectionUtil;

public class ProcedureDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public String placeOrder(String seatName, String itemNameList, String itemQuantityList, String message) {
		final String local = "out_msg";

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		call.withProcedureName("PR_IS_VALID_INPUT");
		call.declareParameters(new SqlParameter("in_seat_name", Types.VARCHAR),
				new SqlParameter("in_item_name", Types.VARCHAR), new SqlParameter("in_item_qty", Types.VARCHAR),
				new SqlOutParameter(local, Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);

		MapSqlParameterSource in = new MapSqlParameterSource().addValue("in_seat_name", seatName)
				.addValue("in_item_name", itemNameList).addValue("in_item_qty", itemQuantityList)
				.addValue(local, message);

		Map<String, Object> execute = call.execute(in);

		return (String) execute.get(local);

	}

	public String cancelOrder(int orderId, String message) {
		final String local = "param_msg";
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		call.withProcedureName("PR_CANCEL_ORDER");
		call.declareParameters(new SqlParameter("param_order_id", Types.INTEGER),
				new SqlOutParameter(local, Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);

		MapSqlParameterSource in = new MapSqlParameterSource().addValue("param_order_id", orderId).addValue(local,
				message);

		Map<String, Object> execute = call.execute(in);

		return (String) execute.get(local);

	}

}
