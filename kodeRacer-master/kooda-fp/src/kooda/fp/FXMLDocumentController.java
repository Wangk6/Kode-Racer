/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kooda.fp;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane landing;
    
    @FXML
    private void pressLevelSelect(ActionEvent event) throws IOException {
        System.out.println("Loaded");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("LevelSelect.fxml"));
        landing.getChildren().setAll(pane);
    }
    
    @FXML
    private void pressPlayLevel(ActionEvent event) throws IOException {
        System.out.println("Level One");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("LevelOne.fxml"));
        landing.getChildren().setAll(pane);
    }
    
    
    @FXML //Settings menu
    private void pressSettings(ActionEvent event) throws IOException {
    	System.out.println("Settings");
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("SettingsPage.fxml"));
        landing.getChildren().setAll(pane);
    }

    @FXML
    void quitApp(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Kode Racer");
    	alert.setHeaderText(null);
    	alert.setContentText("Are you sure you want to quit?");
    	//Set icon next to confirmation exit page
    	//alert.setGraphic(new ImageView(this.getClass().getResource("gameIcon.png").toString()));
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("gameIcon.png").toString()));  
        
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    	    // ... user chose OK
    		System.exit(1);
    	}
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
