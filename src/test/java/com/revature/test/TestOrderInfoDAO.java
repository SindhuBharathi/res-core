package com.revature.test;

import java.util.List;

import com.revature.dao.OrderInfoDAO;
import com.revature.model.OrderInfo;

public class TestOrderInfoDAO {

	public static void main(String[] args) {
		OrderInfo orderInfo = new OrderInfo();
		OrderInfoDAO orderInfoDAO = new OrderInfoDAO();
		List<OrderInfo> list = orderInfoDAO.list();
		for (OrderInfo i : list) {
			System.out.println(i.getId() + "\t" + i.getSeatId().getId() + "\t" + i.getStatus());
		}

		orderInfo = orderInfoDAO.listById(15);
		System.out.println(orderInfo.getId() + "\t" + orderInfo.getSeatId().getId() + "\t" + orderInfo.getStatus());

	}

}
