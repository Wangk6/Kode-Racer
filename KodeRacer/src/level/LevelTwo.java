package level;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Arrays;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import kooda.fp.Settings;

public class LevelTwo {
	
	Stage stage = new Stage();
	
	boolean fullScreen = false;
	
	//Get the screen size
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	
	//Note if full screen is enabled. If it is, we change the pixel value
	
	private Pane root = new Pane();
	
    //Sprite player1 = new Sprite(300, 300, (int)width/25, (int)width/25, "random", Color.RED); //Keep the W & H to 25, because we're moving at 5's
    Sprite player1 = new Sprite(0 , 200 , 50, 50, "random", Color.TRANSPARENT); //Keep the W & H to 25, because we're moving at 5's
    
    private Button play = new Button();
    private Button clear = new Button(); //returns 3
    
    //Directional Buttons
    //Returns are for the sequence
    private Button directionUp = new Button(); //returns 0
    private Button directionDown = new Button(); //returns 1
    private Button directionLeft = new Button(); //returns 2
    private Button directionRight = new Button(); //returns 3
    
    private Label displayStep_one = new Label();
    private Label displayStep_two = new Label();
    private Label displayStep_three = new Label();
    private Label displayStep_four = new Label();
    private Label displayStep_five = new Label();
    private Label displayStep_six = new Label();
    
    private int stepCount = 0;
    
    /*
	 * We will be using two arrays to keep track of our user movements
	 * playerSequence will record all the steps the user puts in
	 * playerSequence will be ran against levelSequence when user hits 'run'
	 * If they match you win the level if not you restart over
	 */
	
	//levelSequence 200 , 100 , 200 , 100 , 50
    int[] lSequence = {3 , 1 , 3 , 0 , 3};
    int[] translateLength = {150 , 400 , 250 , 100 , 450};
    int seqLen = lSequence.length;
    Transition[] translations = new Transition[seqLen];
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
		
		//Level Tiles
		//Level Tiles
		//Level Tiles
		//Level Tiles
		
		//Starting Tile
		Rectangle startTile = new Rectangle();
		startTile.setWidth(50);
		startTile.setHeight(50);
		startTile.setFill(Color.LAWNGREEN);
		
		startTile.setLayoutX(0); //STARTING POINT OF CHARACTER
		startTile.setLayoutY(200); //STARTING POINT OF CHARACTER
		//Starting Tile
		
		int pathX = 50;
		int pathY = 0;
		
		for(int i = 0 ; i < 2; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(50);
			pathTile.setHeight(50);
			pathTile.setLayoutX(pathX);
			pathTile.setLayoutY(200);
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			pathX += 50;
			root.getChildren().add(pathTile);
		}
		
		pathY = 200;
		for(int i = 0 ; i < 9; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(50);
			pathTile.setHeight(50);
			pathTile.setLayoutX(150);
			pathTile.setLayoutY(pathY);
			pathY += 50;
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
		}
		
		pathX = 200;
		for(int i = 0 ; i < 4; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(50);
			pathTile.setHeight(50);
			pathTile.setLayoutX(pathX);
			pathTile.setLayoutY(600);
			pathX += 50;
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
		}
		
		pathY = 500;
		for(int i = 0 ; i < 3; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(50);
			pathTile.setHeight(50);
			pathTile.setLayoutX(400);
			pathTile.setLayoutY(pathY);
			pathY += 50;
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
		}
		
		pathX = 450;
		for(int i = 0 ; i < 8; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(50);
			pathTile.setHeight(50);
			pathTile.setLayoutX(pathX);
			pathTile.setLayoutY(500);
			pathX += 50;
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
		}
		
		
		
		//Ending Tile
		Rectangle endTile = new Rectangle();
		endTile.setWidth(50);
		endTile.setHeight(50);
		endTile.setFill(Color.ORANGERED);
		
		endTile.setLayoutX(850); //STARTING POINT OF CHARACTER
		endTile.setLayoutY(500); //STARTING POINT OF CHARACTER
		//Ending Tile
		
		
		root.getChildren().add(startTile);
		root.getChildren().add(endTile);
		
		//Level Tiles
		//Level Tiles
		//Level Tiles
		//Level Tiles
		
		//Directional Buttons & Buttons
		//Directional Buttons & Buttons
		//Directional Buttons & Buttons
		//Directional Buttons & Buttons
		
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
		
		clear.setPrefWidth(50);
		clear.setPrefHeight(50);
		clear.setLayoutX(250);
		clear.setLayoutY(0);
		clear.setText("X");
		
		displayStep_one.setPrefWidth(50);
		displayStep_one.setPrefHeight(50);
		displayStep_one.setLayoutX(0);
		displayStep_one.setLayoutY(50);
		displayStep_one.setStyle("-fx-border-color: black;");
		displayStep_one.setAlignment(Pos.CENTER);
		
		displayStep_two.setPrefWidth(50);
		displayStep_two.setPrefHeight(50);
		displayStep_two.setLayoutX(50);
		displayStep_two.setLayoutY(50);
		displayStep_two.setStyle("-fx-border-color: black;");
		displayStep_two.setAlignment(Pos.CENTER);
		
		displayStep_three.setPrefWidth(50);
		displayStep_three.setPrefHeight(50);
		displayStep_three.setLayoutX(100);
		displayStep_three.setLayoutY(50);
		displayStep_three.setStyle("-fx-border-color: black;");
		displayStep_three.setAlignment(Pos.CENTER);
		
		displayStep_four.setPrefWidth(50);
		displayStep_four.setPrefHeight(50);
		displayStep_four.setLayoutX(150);
		displayStep_four.setLayoutY(50);
		displayStep_four.setStyle("-fx-border-color: black;");
		displayStep_four.setAlignment(Pos.CENTER);
		
		displayStep_five.setPrefWidth(50);
		displayStep_five.setPrefHeight(50);
		displayStep_five.setLayoutX(200);
		displayStep_five.setLayoutY(50);
		displayStep_five.setStyle("-fx-border-color: black;");
		displayStep_five.setAlignment(Pos.CENTER);
		
		displayStep_six.setPrefWidth(50);
		displayStep_six.setPrefHeight(50);
		displayStep_six.setLayoutX(250);
		displayStep_six.setLayoutY(50);
		displayStep_six.setStyle("-fx-border-color: black;");
		displayStep_six.setAlignment(Pos.CENTER);
		
		root.getChildren().add(directionUp); 
		root.getChildren().add(directionDown);
		root.getChildren().add(directionLeft);
		root.getChildren().add(directionRight);
		root.getChildren().add(play);
		root.getChildren().add(clear);
		
		root.getChildren().add(displayStep_one);
		root.getChildren().add(displayStep_two);
		root.getChildren().add(displayStep_three);
		root.getChildren().add(displayStep_four);
		root.getChildren().add(displayStep_five);
		root.getChildren().add(displayStep_six);
		
		player1.toFront();
		
		directionUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(stepCount < seqLen) {
            		//Add sequence to user array
            		uSequence[stepCount] = player1.Up();
            		setDirectionDisplay(stepCount , uSequence[stepCount]);
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
            		setDirectionDisplay(stepCount , uSequence[stepCount]);
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
            		setDirectionDisplay(stepCount , uSequence[stepCount]);
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
            		setDirectionDisplay(stepCount , uSequence[stepCount]);
            		stepCount += 1;
            	}else {
            		System.err.println("Out of Bounds");
            	}
            }
        });
		
		//Directional Buttons & Buttons
		//Directional Buttons & Buttons
		//Directional Buttons & Buttons
		//Directional Buttons & Buttons
		
		
		//Play & Clear Buttons
		//Play & Clear Buttons
		//Play & Clear Buttons
		//Play & Clear Buttons
		
		play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	boolean flag = false;
            	
            	System.out.println("Level: " + Arrays.toString(lSequence));
            	System.out.println("User: " + Arrays.toString(uSequence));
            	
            	for(int i = 0; i < seqLen; i++) {
            		if(lSequence[i] == uSequence[i]) {
            			flag = true;
            		}else {
            			flag = false;
            			System.err.println("Wrong Sequence");
            		}
            	}
            	
            	if(flag == true) {
            		
            		/*
            		SequentialTransition s = new SequentialTransition(player1);
                	s.getChildren().add(player1.moveRight(200));
                	s.getChildren().add(player1.moveDown(100));
                	
                	SequentialTransition sa = new SequentialTransition(player1);
                	sa.getChildren().add(player1.moveRight(200));
                	sa.getChildren().add(player1.moveDown(100));
                	
                	SequentialTransition sb = new SequentialTransition(player1);
                	sb.getChildren().add(player1.moveRight(450));
                	
                	SequentialTransition master = new SequentialTransition(player1 , s , sa , sb);
                	master.play();*/
            		
            		for(int i = 0; i < seqLen; i++) {
                		if(lSequence[i] == uSequence[i]) {
                			
                			int temp = uSequence[i]; // sequence of translation
                			int transTemp = translateLength[i]; //how much translation should happen
                			
                			
                			switch(temp) {
                				case 0:
                					
                					translations[i] = player1.moveUp(transTemp);
                					break;
                				case 1:
                					
                					translations[i] = player1.moveDown(transTemp);
                					break;
                				case 2:
                					
                					translations[i] = player1.moveLeft(transTemp);
                					break;
                				case 3:
                					
                					translations[i] = player1.moveRight(transTemp);
                					break;
                			}
                			
                		}else {
                			//do jitter animation
                			System.err.println("Wrong Sequence");
                		}
                	}
                	
                	translations[0].play();
                	translations[0].setOnFinished(e ->{
                		translations[1].play();
                		translations[1].setOnFinished(f ->{
                			translations[2].play();
                			translations[2].setOnFinished(g ->{
                				translations[3].play();
                				translations[3].setOnFinished(h ->{
                					translations[4].play();
                					translations[4].setOnFinished(i ->{
                						translations[5].play();
                    					translations[5].setOnFinished(j ->{
                    						translations[5].stop();
                    					});
                					});
                				});
                			});
                		});
                	});
                	
            	}
            	
            }
        });
		
		clear.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				clearDirec();
				System.out.println(Arrays.toString(uSequence));
			}
			
		});
		
		//Play & Clear Buttons
		//Play & Clear Buttons
		//Play & Clear Buttons
		//Play & Clear Buttons
		
		return root;
	}
	
	public void setDirectionDisplay(int index , int direction) {
		String dispDirec = "";
		
		switch(direction) {
			case 0:
				dispDirec = "Up";
				break;
			case 1:
				dispDirec = "Down";
				break;
			case 2:
				dispDirec = "Left";
				break;
			case 3:
				dispDirec = "Right";
				break;
		}
		
		switch(index) {
			case 0:
				displayStep_one.setText(dispDirec);
				break;
			case 1:
				displayStep_two.setText(dispDirec);
				break;
			case 2:
				displayStep_three.setText(dispDirec);
				break;
			case 3:
				displayStep_four.setText(dispDirec);
				break;
			case 4:
				displayStep_five.setText(dispDirec);
				break;
			case 5:
				displayStep_six.setText(dispDirec);
				break;
		}
		
	}
	
	public void clearDirec() {
		
		/*
		 * Put back player in start position
		 * 
		 * 
		 * 
		player1.setLayoutX();
		player1.setLayoutY();
		*/
		
		stepCount = 0;
		
		uSequence = new int[uSequence.length];
		translations = new Transition[translations.length];
		
		displayStep_one.setText(null);
		displayStep_two.setText(null);
		displayStep_three.setText(null);
		displayStep_four.setText(null);
		displayStep_five.setText(null);
		displayStep_six.setText(null);
		
	}
	
	public void levelFinishSucces() {
		/*
		 * 
		 * If the level is finished successfully
		 * 
		 */
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
		stage.setTitle("Level Two");
		stage.setOnCloseRequest(e -> closeProgram());
        stage.getIcons().add(new Image(this.getClass().getResource("/assets/gameIcon.png").toString()));
		stage.setScene(
			new Scene(createContent())
		);
		stage.show();
		
	}
	
	//Close window properly
	private void closeProgram() {
		stage.close();
	}
	
}