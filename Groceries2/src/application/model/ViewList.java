/**
 * @author TEAM SUNDAY
 *  UTSA CS 3443 - GROUP PROJECT
 *
 *ViewList.java handles the logic for ViewList type objects, which are an ArrayList of Item type objects
 **/
package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewList {
	
	ArrayList<Item> inventory;
	/**
	 * Constructor for a ViewList object calls parseSheet()
	 */
	public ViewList() {
		
		inventory = parseSheet();
	}
	
	/**
	 * ParseSheet() parses and creates an ArrayList of Item type objects from a designated csv file
	 * @return
	 */
	public ArrayList<Item> parseSheet(){
		ArrayList<Item> scan = new ArrayList<Item>();
		
		
		File log = new File("data/groceries.csv");
		
		String line = new String();
		
		try {
			Scanner view = new Scanner(log);
			while(view.hasNextLine() != false) {
				
				line = view.nextLine();
				String[] token = line.split(",");
								
				String id = token[0];
				int idInt = Integer.parseInt(id);
				String name = token[1];
				String quant = token[2];
				int quantity = Integer.parseInt(quant);
				String priceIn = token[3];
				double price = Double.parseDouble(priceIn);
				
				
				Item item = new Item(idInt,name,quantity,price);
				scan.add(item);
					
				}

			view.close();
			
		}
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		return scan;
	}
	

		
	public String toString() {
		
		String all = new String();
		
		for(Item i:inventory) {
			
			all = all + i;
		}
		
		
		return all;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	

}
