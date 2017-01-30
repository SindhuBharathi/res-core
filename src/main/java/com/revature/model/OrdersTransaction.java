package com.revature.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrdersTransaction {
	private int id;
	private OrderInfo orderId;
	private Item itemId;
	private int quantity;
	private LocalDateTime timeStamp;
	private String status;
}
