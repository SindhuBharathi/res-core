package com.revature.test;

import java.util.List;

import com.revature.dao.OrdersTransactionDAO;
import com.revature.model.OrdersTransaction;

public class TestOrdersTransaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrdersTransaction ordersTransaction=new OrdersTransaction();
		OrdersTransactionDAO ordersTransactionDAO=new OrdersTransactionDAO();
		
		List<OrdersTransaction> list=ordersTransactionDAO.list();
		for(OrdersTransaction i:list)
		{
			System.out.println(i.getId()+"\t"+
					i.getOrderId().getId()+"\t"+i.getItemId().getId()+"\t"+
					i.getQuantity()+"\t"+i.getTimeStamp()+"\t"+i.getStatus());
		}
		
		ordersTransaction=ordersTransactionDAO.listById(105);
		System.out.println(ordersTransaction.getId()+"\t"+
				ordersTransaction.getOrderId().getId()+"\t"+ordersTransaction.getItemId().getId()+"\t"+
				ordersTransaction.getQuantity()+"\t"+ordersTransaction.getTimeStamp()+"\t"+ordersTransaction.getStatus());
		
		List<OrdersTransaction> listDate=ordersTransactionDAO.listByToday();
		for(OrdersTransaction i:listDate)
		{
			System.out.println(i.getId()+"\t"+
					i.getOrderId().getId()+"\t"+i.getItemId().getId()+"\t"+
					i.getQuantity()+"\t"+i.getTimeStamp()+"\t"+i.getStatus());
		}

	}

}
