/**
 * @author TEAM SUNDAY
 *  UTSA CS 3443 - GROUP PROJECT
 *  UpdateController takes care of the user implementation that occurs within the Update.fxml scene view
 *  
 *  
 **/
package application.controller;

import application.Main;
import application.model.Item;
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

public class UpdateController {
	
	@FXML
	TextField idText;
	
	@FXML
	TextField nameText;
	
	@FXML
	TextField quantityText;
	
	@FXML
	TextField costText;
	
	@FXML
	Text updateStatus;
	
	@FXML
	Button updateButton;
	
	
	public static int location;
	int flag = 0;
	
	/**
	 * Option to return to Home screene of app
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
	 * search() look for a matching ID element of the ViewList Item array list
	 */
    public void search() {

        MainController.currentInventory = new ViewList();
        if (!idText.getText().isEmpty()) {
            int key = Integer.parseInt(idText.getText());
            int itemNum = Update.find(key, MainController.currentInventory);

            if (itemNum == -1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("This ID is Not Found");
                alert.showAndWait();
            } else {
                flag = 1;
                Item found = MainController.currentInventory.getInventory().get(itemNum);
                location = itemNum;
                nameText.setText(found.getName());
                quantityText.setText(found.getQuantity());
                costText.setText(found.getPrice());
                
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
     * 
     * update() makes proper changes to designated item within list
     * @param event
     */
    public void update(ActionEvent event) {

        MainController.currentInventory.getInventory().get(location).setName(nameText.getText());
        MainController.currentInventory.getInventory().get(location).setQuantity(Integer.parseInt(quantityText.getText()));
        MainController.currentInventory.getInventory().get(location).setPrice(Double.parseDouble(costText.getText()));
        
        
        Update.updateCsv(MainController.currentInventory);
        updateStatus.setText("Item successfully updated!");
    }
	
	
}
