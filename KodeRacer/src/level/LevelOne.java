package level;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	
    Sprite player1 = new Sprite(300, 300, (int)width/25, (int)width/25, "random", Color.RED); //Keep the W & H to 25, because we're moving at 5's
    
    //Directional Buttons
    private Button directionUp = new Button();
    private Button directionDown = new Button();
    private Button directionLeft = new Button();
    private Button directionRight = new Button();
    
    
	private Parent createContent() {
		//Set the level size
		root.setPrefSize(900, 900);
		root.getChildren().add(player1);
		
		//Directional Buttons
		
		directionUp.setPrefWidth(50);
		directionUp.setPrefHeight(50);
		directionUp.setLayoutX(0);
		directionUp.setLayoutY(0);
		
		directionDown.setPrefWidth(50);
		directionDown.setPrefHeight(50);
		directionDown.setLayoutX(50);
		directionDown.setLayoutY(0);
		
		directionLeft.setPrefWidth(50);
		directionLeft.setPrefHeight(50);
		directionLeft.setLayoutX(100);
		directionLeft.setLayoutY(0);
		
		directionRight.setPrefWidth(50);
		directionRight.setPrefHeight(50);
		directionRight.setLayoutX(150);
		directionRight.setLayoutY(0);
		
		
		
		root.getChildren().add(directionUp); 
		root.getChildren().add(directionDown);
		root.getChildren().add(directionLeft);
		root.getChildren().add(directionRight);
		
		directionUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	player1.moveUp();
            }
        });
		
		directionDown.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	player1.moveDown();
            }
        });
		
		directionLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	player1.moveLeft();
            }
        });
		
		directionRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	player1.moveRight();
            }
        });
		
		//Directional Buttons
		
		
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
