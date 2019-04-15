package level;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import kooda.fp.Settings;

public class LevelOne{
	Stage stage = new Stage();
	
	boolean fullScreen = false;
	
	//Get the screen size
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	
	
	//Note if full screen is enabled. If it is, we change the pixel value
	
	private Pane root = new Pane();
	
    Sprite player1 = new Sprite(300, 300, (int)width/22, (int)width/22, "random", Color.RED);
    
	private Parent createContent() {
		//Set the level size
		root.setPrefSize(900, 900);
		root.getChildren().add(player1);
		return root;
	}
	public void start() {
		System.out.println(Settings.getFullScreen());
		if (Settings.getFullScreen() == 1) {
			fullScreen = true;
			stage.setResizable(true);
			stage.setFullScreen(true);
			stage.setFullScreenExitHint("ESC");
		} else if (Settings.getFullScreen() == 0) {
			stage.setResizable(false);
		}
		stage.setTitle("Level One");
		stage.setOnCloseRequest(e -> closeProgram());
        stage.getIcons().add(new Image(this.getClass().getResource("/assets/gameIcon.png").toString()));
		stage.setScene(new Scene(createContent()));
		stage.show();
	}
	
	//Close window properly
	private void closeProgram() {
		stage.close();
	}
	

}
