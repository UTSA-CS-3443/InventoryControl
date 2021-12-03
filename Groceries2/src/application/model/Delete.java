/**
 * @author TEAM SUNDAY
 *  UTSA CS 3443 - GROUP PROJECT
 *  
 *  Delete.java locates the chosen key value as it is searched for in the ID number of each Item object.
 *  Returns an int if a match is found
 **/
package application.model;

public class Delete {
	
	
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
		
	

}
