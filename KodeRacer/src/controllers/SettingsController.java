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

public class SettingsController implements Initializable {
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
    void goHome(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));
        landing.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        }

}
