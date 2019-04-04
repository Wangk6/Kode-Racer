/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kooda.fp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;

/**
 *
 * @author qbillah
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane landing;
    
    @FXML
    private void loadSecond(ActionEvent event) throws IOException {
        System.out.println("Loaded");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("LevelSelect.fxml"));
        landing.getChildren().setAll(pane);
    }
    
    @FXML
    private void startLevel(ActionEvent event) throws IOException {
        System.out.println("Level One");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("LevelOne.fxml"));
        landing.getChildren().setAll(pane);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
