package com.revature.test;

import com.revature.dao.FunctionDAO;

public class TestFunctionDAO {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		FunctionDAO functionDAO=new FunctionDAO();
		
		int itemId = functionDAO.getItemId("Tea");
		System.out.println("Item id is "+itemId);
		
		int orderedSeatId =functionDAO.getOrderedSeatId(50);
		System.out.println("Seat id of order id 50 is "+orderedSeatId);
		
		int seatId =functionDAO.getSeatId("A");
		System.out.println("Seat id of seat id A is "+seatId);
		
		int sessionId =functionDAO.getSessionId(7);
		System.out.println("Seat id of item id 7 is "+sessionId);
		
		boolean isAvailableItem =functionDAO.isValidItem("Chat");
		System.out.println("Availability of item is "+isAvailableItem);
		
		boolean isAvailableOrder =functionDAO.isValidOrder(150);
		System.out.println("Availability of order is "+isAvailableOrder);
		
		boolean isAvailableQty =functionDAO.isValidQuantity(6,3,300);
		System.out.println("Availability of quantity is "+isAvailableQty);
		
		boolean isAvailableSeat =functionDAO.isValidSeat("Z");
		System.out.println("Validity of seat is "+isAvailableSeat);
		
		boolean isSeatAvail =functionDAO.isSeatAvailable(2);
		System.out.println("Availability of seat is "+isSeatAvail);
		
		boolean isAvailableService =functionDAO.isServiceTime();
		System.out.println("Availability of the service is "+isAvailableService);

	}

}
