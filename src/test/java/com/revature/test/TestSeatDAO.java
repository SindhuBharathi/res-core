package com.revature.test;

import java.util.List;

import com.revature.dao.SeatDAO;
import com.revature.model.Seat;

public class TestSeatDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Seat seat=new Seat();
//		seat.setId(11);
//		seat.setName("New");
		
		SeatDAO seatDAO=new SeatDAO();

//		seatDAO.save(seat);
//		seatDAO.update(seat);
//		seatDAO.delete(11);
		
		List<Seat> list=seatDAO.list();
		for(Seat i:list)
		{
			System.out.println(i);
		}
		
		seat=seatDAO.listByName("E");
		System.out.println(seat);
		
		seat=seatDAO.listById(10);
		System.out.println(seat);
		
		List<String> seatNames = seatDAO.findSeatNames();
		for (String seatName : seatNames) 
		{
			System.out.println(seatName);
		}
	
	}

}
