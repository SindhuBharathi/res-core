package com.revature.test;

import java.time.LocalTime;
import java.util.List;

import com.revature.dao.ScheduleDAO;
import com.revature.model.Schedule;

public class TestScheduleDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Schedule schedule=new Schedule();
		schedule.setName("Brunch");
		schedule.setId(5);
		schedule.setFromTime(LocalTime.parse("11:00:00"));
		schedule.setToTime(LocalTime.parse("12:30:00"));
		
		ScheduleDAO scheduleDAO=new ScheduleDAO();

		scheduleDAO.save(schedule);
//		scheduleDAO.updateName(schedule);
//		scheduleDAO.updateFromTime(schedule);
//		scheduleDAO.updateToTime(schedule);
//		scheduleDAO.delete(5);
		
		List<Schedule> list=scheduleDAO.list();
		for(Schedule s:list)
		{
			System.out.println(s);
		}
		
		schedule=scheduleDAO.listByName("Lunch");
		System.out.println(schedule);
		
		schedule=scheduleDAO.listById(2);
		System.out.println(schedule);
		
		List<String> scheduleNames = scheduleDAO.findScheduleNames();
		for (String scheduleName : scheduleNames) 
		{
			System.out.println(scheduleName);
		}

	}

}
