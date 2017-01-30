package com.revature.model;

import lombok.Data;

@Data
public class ItemsAvailable {
	private int id;
	private Schedule scheduleId;
	private Item itemId;
	private int quantity;
}
