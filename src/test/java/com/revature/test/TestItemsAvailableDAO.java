package com.revature.test;

import java.util.Iterator;
import java.util.List;

import com.revature.dao.ItemsAvailableDAO;
import com.revature.model.Item;
import com.revature.model.ItemsAvailable;
import com.revature.model.Schedule;

public class TestItemsAvailableDAO {

	public static void main(String[] args) {
		ItemsAvailable itemsAvailable=new ItemsAvailable();
		
		Schedule schedule=new Schedule();
//		schedule.setName("Brunch");
		itemsAvailable.setScheduleId(schedule);
		
		Item item=new Item();
//		item.setName("Special Meals");
		itemsAvailable.setItemId(item);
		
		itemsAvailable.setQuantity(50);
		
		ItemsAvailableDAO itemsAvailableDAO=new ItemsAvailableDAO();
//		itemsAvailableDAO.save(itemsAvailable);

//		itemsAvailable.setId(21);
//		schedule.setId(4);
//		itemsAvailableDAO.updateScheduleId(itemsAvailable);

//		itemsAvailable.setId(21);
//		item.setId(1);
//		itemsAvailableDAO.updateItemId(itemsAvailable);
		
//		itemsAvailable.setId(21);
//		itemsAvailable.setQuantity(80);
//		itemsAvailableDAO.updateQuantity(itemsAvailable);
	
//		itemsAvailableDAO.delete(42);

/*	Displays null for the foreign key fields which are not present in the table 
  		for(ItemsAvailable i:list)
		{
			System.out.println(i);
		}
*/
/*	To avoid that -- Method 1		*/
 		List<ItemsAvailable> list=itemsAvailableDAO.list();
		Iterator<ItemsAvailable> i=list.iterator();
		while(i.hasNext())
		{
			ItemsAvailable itemsAvailableVar=(ItemsAvailable) i.next();
			System.out.println(itemsAvailableVar.getId()+"\t"+
					itemsAvailableVar.getScheduleId().getId()+"\t"+
					itemsAvailableVar.getItemId().getId()+"\t"+
					itemsAvailableVar.getQuantity());
		}
		
/*	To avoid that -- Method 2 		*/		
		itemsAvailable=itemsAvailableDAO.listById(15);
		System.out.println(itemsAvailable.getId()+"\t"+itemsAvailable.getScheduleId().getId()+"\t"+itemsAvailable.getItemId().getId()+"\t"+itemsAvailable.getQuantity());
		
	}

}
