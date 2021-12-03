/**
 * @author TEAM SUNDAY
 *  UTSA CS 3443 - GROUP PROJECT
 * 
 * CreateController serves to handle the acitons and elements needed for a user to create
 * a new item within the inventory list
 * 
 * */

package application.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import javafx.geometry.Insets;
import application.Main;
import application.model.Item;
import application.model.ViewList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateController {
	
	@FXML
	Button home;
	
	@FXML
	TextField idText;
	
	@FXML
	TextField nameText;
	
	@FXML
	Text statusUpdate;
	
	@FXML
	TextField quantityText;
	@FXML
	TextField costText;
	

	/**
	 * firstScreen() loads Main.fxml and displays the appropriate dimensions
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
		 * addItem() is the called once the user presses the CREATE button
		 * 
		 */
	   public void addItem() {

	        if (nameText.getText().isEmpty() || idText.getText().isEmpty()) {
	            Alert alert = new Alert(Alert.AlertType.WARNING);
	            alert.setTitle("Information Dialog");
	            alert.setHeaderText(null);
	            alert.setContentText("You Must Enter Id/Name");
	            alert.showAndWait();
	        } else {
	            String newName = nameText.getText();
	            String newId = idText.getText();
	            int id = Integer.parseInt(newId);
	            
	            String quantString = quantityText.getText();
	            String priceString = costText.getText();
	            
	            
	            if (!findID(id)) {
	                try {
	                    Files.write(Paths.get("data/groceries.csv"), (newId + "," + newName + ","+quantString+","+priceString+"\n").getBytes(), StandardOpenOption.APPEND);
	                    statusUpdate.setText("New item successfully added!");
	                } catch (IOException e) {
	                }
	            } else {
	                Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setTitle("Information Dialog");
	                alert.setHeaderText(null);
	                alert.setContentText("This ID is Already Found");
	                alert.showAndWait();
	            }
	        }
	        
	        
	    }
	   /**
	    * findId() checks to see if the special id already exists.
	    * @param id
	    * @return
	    */
	    boolean findID(int id) {
	        ViewList v = new ViewList();
	        ArrayList<Item> items = v.getInventory();
	        for (Item item : items) {
	            if (item.getId() == id) {
	                return true;
	            }
	        }
	        return false;
	    }

}
