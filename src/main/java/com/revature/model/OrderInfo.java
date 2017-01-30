package com.revature.model;

import lombok.Data;

@Data
public class OrderInfo {
	private int id;
	private Seat seatId;
	private String status;
}
