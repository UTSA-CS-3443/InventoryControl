/**
 * @author TEAM SUNDAY
 *  UTSA CS 3443 - GROUP PROJECT
 *  
 *  MainController handles the implementation of the home screen of the application
 */
package application.controller;

import application.Main;
import application.model.ViewList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
	
	@FXML
	Button createButton;
	
	@FXML
	Button updateButton;
	
	@FXML
	Button viewButton;
	
	@FXML
	Button deleteButton;
	

	public static ViewList currentInventory ;
	public static Stage stage;
	
	/**
	 * Each function below represents the action that will occur depending on the button that is pressed
	 * in order to take the user to the appropriate scene within the app
	 * @param event
	 */
	public void createPage(ActionEvent event) {

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../view/Create.fxml"));
			Main.stage.setScene(new Scene(root, 600,600));
			Main.stage.show();				

		} 
		catch(Exception e) {
				e.printStackTrace();
		}	
	}
	
	public void updatePage(ActionEvent event) {

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../view/Update.fxml"));
			Main.stage.setScene(new Scene(root, 600,600));
			Main.stage.show();				

		} 
		catch(Exception e) {
				e.printStackTrace();
		}	
	}
	public void viewPage(ActionEvent event) {

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../view/ViewList.fxml"));
			Main.stage.setScene(new Scene(root, 600,600));
			Main.stage.show();				

		} 
		catch(Exception e) {
				e.printStackTrace();
		}	
	}
	
	public void deletePage(ActionEvent event) {

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../view/Delete.fxml"));
			Main.stage.setScene(new Scene(root, 600,600));
			Main.stage.show();				

		} 
		catch(Exception e) {
				e.printStackTrace();
		}	
	}
	

}
