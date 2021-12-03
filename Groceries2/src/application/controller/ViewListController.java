/**
 * @author TEAM SUNDAY
 *  UTSA CS 3443 - GROUP PROJECT
 *  
 *  ViewListController handles the appearance and behavior of ViewLilst.fxml scene
 **/
package application.controller;

import application.Main;
import application.model.ViewList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;

public class ViewListController {
	
	@FXML
	TextArea listArea;
	
	/**
	 * Option to return to hom scree
	 * @param event
	 */
	public void firstScreen(ActionEvent event) {
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
			Main.stage.setScene(new Scene(root, 600,600));
			Main.stage.show();				

		} 
		catch(Exception e) {
				e.printStackTrace();
		}	
		
	}
	/**
	 * Formatting and presentation of screen once it is initialized
	 */
	public void initialize() {
		
		ViewList inventory = new ViewList();
		System.out.println(inventory.toString());
		listArea.setText(inventory.toString());
		
	}

	public TextArea getListArea() {
		return listArea;
	}

	public void setListArea(TextArea listArea) {
		this.listArea = listArea;
	}
	
	
	
}






