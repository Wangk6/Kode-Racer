package kooda.fp;

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

public class SettingsController implements Initializable {
    //Track fullscreen, 0-Off 1-On
    public static int on = 0;
    //Global settings object
    public static Settings s = new Settings();
    
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
        switch (s.getFullScreen()) {
            case 0:
                SettingsController.on = 1;
                s.setFullScreen(SettingsController.on);
                mBtnFullScreen.setText("Full Screen: ON");
                break;
            case 1:
                SettingsController.on = 0;
                s.setFullScreen(SettingsController.on);
                mBtnFullScreen.setText("Full Screen: OFF");
                break;
            default:
                break;
        }
        
        System.out.println(SettingsController.on);
    }

    @FXML
    void goHome(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        landing.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //when scene is initialized load it with the "saved" settings from the global object
        if(s.getFullScreen() == 1){
            mBtnFullScreen.setText("Full Screen: ON");
        }else if(s.getFullScreen() == 0){
            mBtnFullScreen.setText("Full Screen: OFF");
        }
    }

}
