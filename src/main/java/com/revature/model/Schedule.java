package com.revature.model;

import java.time.LocalTime;

import lombok.Data;

@Data
public class Schedule {
	private int id;
	private String name;
	private LocalTime fromTime;
	private LocalTime toTime;
}
