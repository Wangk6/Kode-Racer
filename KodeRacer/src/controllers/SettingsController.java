package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kooda.fp.Settings;

public class SettingsController implements Initializable {
    //Track fullscreen, 0-Off 1-toggle
    int toggle = 0;
    Stage sn;
    @FXML
    private AnchorPane landing;
	
    @FXML
    private AnchorPane levelSelect;

    @FXML
    private Button mBtnFullScreen;
    
    @FXML
    private Slider mVolumeSlider;

    @FXML
    void fullScreen(ActionEvent event) {
        
        //switch statement makes more sense here
        //gets the current state of fullscreen from the global object
        //then sets the global object according to the users preference
        switch (Settings.getFullScreen()) {
            case 0:
                toggle = 1;
                Settings.setFullScreen(toggle);
                mBtnFullScreen.setText("Full Screen: ON");
                ((Stage)((Button)event.getSource()).getScene().getWindow()).setResizable(true); //Professor added 
                break;   
            case 1:
                toggle = 0;
                Settings.setFullScreen(toggle);
                mBtnFullScreen.setText("Full Screen: OFF");
                ((Stage)((Button)event.getSource()).getScene().getWindow()).setResizable(false);
                break;
        }
        
        System.out.println(toggle);
    }

    @FXML
    void goHome(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));
        landing.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //when scene is initialized load it with the "saved" settings from the global object
        if(Settings.getFullScreen() == 1){
        	//s.setFullScreen(toggle);
            mBtnFullScreen.setText("Full Screen: ON");
        }else if(Settings.getFullScreen() == 0){
            mBtnFullScreen.setText("Full Screen: OFF");
        }
    }

}
