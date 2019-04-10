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
    @FXML
    private AnchorPane landing;
	//Track fullscreen, 0-Off 1-On
	int on = 0;
    @FXML
    private AnchorPane levelSelect;

    @FXML
    private Button mBtnFullScreen;

    @FXML
    private Slider mVolumeSlider;

    @FXML
    void fullScreen(ActionEvent event) {
    	//String text = mBtnFullScreen.getText();
    	if(on == 0) {
    		//Set fullscreen button text to on
    		mBtnFullScreen.setText("Full Screen: ON");
    		//Make on = 1 so we can reverse
    		on = 1;
    	} else if (on == 1) {
    		mBtnFullScreen.setText("Full Screen: OFF");
    		on = 0;
    	}
    }

    @FXML
    void goHome(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        landing.getChildren().setAll(pane);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
