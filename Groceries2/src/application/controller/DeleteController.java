/**
 * @author TEAM SUNDAY
 *  UTSA CS 3443 - GROUP PROJECT
 *  
 *  DeleteController manages the visual implementation of the DELETE feature in the app
 *  
 **/

package application.controller;

import application.Main;
import application.model.Delete;
import application.model.Update;
import application.model.ViewList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DeleteController {
	
	@FXML
	Button homeButton;
	
	@FXML
	Button searchButton;
	
	@FXML
	TextField idText;
	
	@FXML
	TextField nameText;
	
	@FXML
	TextField quantityText;
	
	@FXML
	TextField costText;
	
	@FXML
	TextField searchBar;
	
	@FXML
	Text messageText;
	
	public static int location;
	
	int flag = 0;
	/**
	 * Option to return to the Home screen
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
	 * User must find the items is going to be deleted first search(), is used for this
	 * purpose by traversing the .csv file
	 */
	  public void search() {
        MainController.currentInventory = new ViewList();
        if (!searchBar.getText().isEmpty()) {

            int key = Integer.parseInt(searchBar.getText());
            int itemNum = Delete.find(key, MainController.currentInventory);
            if (itemNum == -1) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("This ID is Not Found");
                alert.showAndWait();

            } else {
                flag = 1;
                idText.setPromptText(MainController.currentInventory.getInventory().get(itemNum).getId()+"");
                nameText.setPromptText(MainController.currentInventory.getInventory().get(itemNum).getName());
                quantityText.setPromptText(MainController.currentInventory.getInventory().get(itemNum).getQuantity());
                costText.setPromptText(MainController.currentInventory.getInventory().get(itemNum).getPrice());
                
                location = itemNum;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter ID");
            alert.showAndWait();
        }

    }
	  /**
	   * delete() performs the action of removing the selected inventory item
	   * from the .csv database
	   */
    public void delete() {
        if (location != -1 && flag != 0) {
            MainController.currentInventory.getInventory().remove(location);
            Update.updateCsv(MainController.currentInventory);
            messageText.setText("Successfully Deleted item!");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("You have not an Id To Remove");
            alert.showAndWait();
        }
    }

}
