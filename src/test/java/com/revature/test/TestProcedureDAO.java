package com.revature.test;

import com.revature.dao.ProcedureDAO;

public class TestProcedureDAO {

	public static void main(String[] args) {
		ProcedureDAO dao = new ProcedureDAO();

		/*
		 * String status=dao.placeOrder("B", "Coffee", "5", "@message");
		 * System.out.println(status);
		 */
		String status = dao.cancelOrder(100, "@param_msg");
		System.out.println(status);

	}

}
