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
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import kooda.fp.Driver;
import kooda.fp.Settings;
import level.LevelOne;
import java.io.*;

public class MainMenuController implements Initializable {
	
    public static LevelOne one = new LevelOne();
    @FXML
    private AnchorPane landing;
	String backgroundAudio = "Pacman.wav";
    
    Media sound = new Media(new File(backgroundAudio).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);
    
    
    
    @FXML
    protected void pressPlayLevel(ActionEvent event) throws IOException {            	
    	System.out.println("Level One");
        System.out.println(Settings.getFullScreen());
        one.start();
        
        mediaPlayer.setMute(true);
        
        
        //AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/LevelOne.fxml"));
        //landing.getChildren().setAll(pane);
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
	public void initialize(URL location, ResourceBundle resource) {
		// TODO Auto-generated method stub
		
		mediaPlayer.play();		
	    	
		
	}
	
		
		
}
    
   
    
