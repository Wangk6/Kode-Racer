/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kooda.fp.Driver;
import kooda.fp.Settings;
import level.LevelOneEpisodeOne;
import level.LevelOneEpisodeThree;
import java.io.*;
import sun.audio.*;

public class MainMenuController implements Initializable {
	
    public static LevelOneEpisodeOne one = new LevelOneEpisodeOne();
    @FXML
    private AnchorPane landing;
    
    
    @FXML
    protected void pressPlayLevel(ActionEvent event) throws IOException {
        System.out.println("Level One");
        one.start();
    }
    
    @FXML
    private void pressLevelSelect(ActionEvent event) throws IOException {
        System.out.println("Loaded");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/LevelSelect.fxml"));
        landing.getChildren().setAll(pane);
    }
    
    
    @FXML //Settings menu
    private void pressSettings(ActionEvent event) throws IOException {
    	System.out.println("Settings");
    	//AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/SettingsPage.fxml"));
        //landing.getChildren().setAll(pane);
    	FXMLLoader fxm = new FXMLLoader(getClass().getResource("/fxml/SettingsPage.fxml"));
    	
    	AnchorPane pane=fxm.load();
        landing.getChildren().setAll(pane);
        SettingsController sc=(SettingsController)fxm.getController();
    
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
        stage.getIcons().add(new Image(this.getClass().getResource("/assets/gameIcon.png").toString()));  
        
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    	    // ... user chose OK
    		System.exit(1);
    	}
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	//themeSong("/assets/Pacman.wav");
    }
    
    public static void themeSong(String filepath) {
    	
    	InputStream sound;
    	try {
    		
    		sound = new FileInputStream(new File(filepath));
    		AudioStream audio = new AudioStream(sound);
    		AudioPlayer.player.start(audio);
    		   		
    	}
    	catch(Exception e) {
    		
    		JOptionPane.showMessageDialog(null, "Error playing sound file");
    		
    	}
    }
 	
  }

