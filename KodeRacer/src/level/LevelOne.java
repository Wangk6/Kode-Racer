package level;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;

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
    
	
	
    
    private Button play = new Button();
    
    //Directional Buttons
    //Returns are for the sequence
    private Button directionUp = new Button(); //returns 0
    private Button directionDown = new Button(); //returns 1
    private Button directionLeft = new Button(); //returns 2
    private Button directionRight = new Button(); //returns 3
    
    
    private int stepCount = 0;
    
    /*
	 * We will be using two arrays to keep track of our user movements
	 * playerSequence will record all the steps the user puts in
	 * playerSequence will be ran against levelSequence when user hits 'run'
	 * If they match you win the level if not you restart over
	 */
	
	//levelSequence
    int[] lSequence = {0 , 1 , 2 , 3 , 0 , 1};
    int seqLen = lSequence.length;
    int[] uSequence = new int[seqLen];
    /*
	 * 0 - up
	 * 1 - down
	 * 2 - left
	 * 3 - right
	 */
    

	private Parent createContent() {
		//Set the level size
		root.setPrefSize(900, 900);
		root.getChildren().add(player1);
		
		//Directional Buttons
		
		directionUp.setPrefWidth(50);
		directionUp.setPrefHeight(50);
		directionUp.setLayoutX(0);
		directionUp.setLayoutY(0);
		directionUp.setText("U");
		
		directionDown.setPrefWidth(50);
		directionDown.setPrefHeight(50);
		directionDown.setLayoutX(50);
		directionDown.setLayoutY(0);
		directionDown.setText("D");
		
		directionLeft.setPrefWidth(50);
		directionLeft.setPrefHeight(50);
		directionLeft.setLayoutX(100);
		directionLeft.setLayoutY(0);
		directionLeft.setText("L");
		
		directionRight.setPrefWidth(50);
		directionRight.setPrefHeight(50);
		directionRight.setLayoutX(150);
		directionRight.setLayoutY(0);
		directionRight.setText("R");
		
		play.setPrefWidth(50);
		play.setPrefHeight(50);
		play.setLayoutX(200);
		play.setLayoutY(0);
		play.setText("P");
		
		
		
		root.getChildren().add(directionUp); 
		root.getChildren().add(directionDown);
		root.getChildren().add(directionLeft);
		root.getChildren().add(directionRight);
		root.getChildren().add(play);
		
		directionUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(stepCount < seqLen) {
            		//Add sequence to user array
            		uSequence[stepCount] = player1.Up();
            		stepCount += 1;
            	}else {
            		System.err.println("Out of Bounds"); //Handle this better
            	}
            }
        });
		
		directionDown.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(stepCount < seqLen) {
            		//Add sequence to user array
            		uSequence[stepCount] = player1.Down();
            		stepCount += 1;
            	}else {
            		System.err.println("Out of Bounds");
            	}
            }
        });
		
		directionLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(stepCount < seqLen) {
            		//Add sequence to user array
            		uSequence[stepCount] = player1.Left();
            		stepCount += 1;
            	}else {
            		System.err.println("Out of Bounds");
            	}
            }
        });
		
		directionRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(stepCount < seqLen) {
            		//Add sequence to user array
            		uSequence[stepCount] = player1.Right();
            		stepCount += 1;
            	}else {
            		System.err.println("Out of Bounds");
            	}
            }
        });
		
		//Directional Buttons
		
		play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("Level: " + Arrays.toString(lSequence));
            	System.out.println("User: " + Arrays.toString(uSequence));
            	for(int i = 0; i < seqLen; i++) {
            		if(lSequence[i] == uSequence[i]) {
            			
            			int temp = uSequence[i];
            			
            			switch(temp) {
            			//Animate the sprite *** IMPORTANT!!!
            				case 0:
            					player1.moveUp();
            					break;
            				case 1:
            					player1.moveDown();
            					break;
            				case 2:
            					player1.moveLeft();
            					break;
            				case 3:
            					player1.moveRight();
            					break;
            			}
            			
            		}else {
            			//do jitter animation
            			System.err.println("Wrong Sequence");
            		}
            	}
            }
        });
		
		
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
