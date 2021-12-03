/**
 * @author TEAM SUNDAY
 * UTSA CS 3443 - GROUP PROJECT
 *
 *Update handles the logic for finding an item within the array list, and making the proper changes to the list
 **/
package application.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Update {
	
	
	
	public static int find(int key,ViewList list) {
		int i = 0;
		
		for(i=0; i < list.inventory.size(); ++i) {
			
			if(key == list.inventory.get(i).getId()) {
				
				System.out.println(list.inventory.get(i));
				return i;
			}
			
		}
		
		return -1;
	}
	/**
	 * Writes and updates to .csv database with new changes
	 * @param newList
	 */
	public static void updateCsv(ViewList newList) {
		

		try {
			Files.write(Paths.get("data/groceries.csv"), ("").getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < newList.getInventory().size(); ++i) {
			
			Item addition = newList.getInventory().get(i);
			try {
				Files.write(Paths.get("data/groceries.csv"), (addition.getId()+","+addition.getName()+","+addition.getQuantity()+","+addition.getPrice()+"\n").getBytes(), StandardOpenOption.APPEND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
