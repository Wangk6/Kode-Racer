package level;
import java.io.File;
import java.util.Arrays;

import javafx.animation.Transition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LevelThreeEpisodeTwo {
	private int setW = 50;
	private int setH = 50;
	private int strtX = 350;
	private int strtY = 350;
	Stage stage = new Stage();
	private Pane root = new Pane();
	
	String backgroundAudio = "src/assets/Level8.mp3";
	
	Media sound = new Media(new File(backgroundAudio).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound); 
	
    //Sprite player1 = new Sprite(300, 300, (int)width/25, (int)width/25, "random", Color.RED); //Keep the W & H to 25, because we're moving at 5's
    Sprite player1 = new Sprite(strtX , strtY, 50, 50, "random", Color.TRANSPARENT); //Keep the W & H to 25, because we're moving at 5's
    Image coin = new Image("assets/coin.png");
    
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
    
    private Rectangle coinImage = new Rectangle();
    private Label coinCount = new Label();
    
    private int stepCount = 0;
    private int totalCoin = 0;
    
    /*
	 * We will be using two arrays to keep track of our user movements
	 * playerSequence will record all the steps the user puts in
	 * playerSequence will be ran against levelSequence when user hits 'run'
	 * If they match you win the level if not you restart over
	 */
	
	//levelSequence 200 , 100 , 200 , 100 , 50
    int[] lSequence = {3 , 1, 2, 0, 3, 1};
    int[] translateLength = {150, 200, 250, 300, 350, 350};
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
		root.setPrefSize(900, 800);
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
		startTile.setOpacity(0.3);
		
		startTile.setLayoutX(strtX); //STARTING POINT OF CHARACTER
		startTile.setLayoutY(strtY); //STARTING POINT OF CHARACTER
		//Starting Tile
		//Right 3
		for (int i = 0; i < 3; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(strtX+=50);
			pathTile.setLayoutY(strtY);
			pathTile.setFill(Color.DARKGREY);
			//pathTile.setStroke(Color.WHITESMOKE);
			pathTile.setOpacity(0);
			root.getChildren().add(pathTile);
		}
		
		//Down 4
		for (int i = 0; i < 4; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(strtX);
			pathTile.setLayoutY(strtY+=50);
			pathTile.setFill(Color.DARKGREY);
			//pathTile.setStroke(Color.WHITESMOKE);
			pathTile.setOpacity(0);
			root.getChildren().add(pathTile);
		}
		Rectangle pathTileCoin = new Rectangle();
		pathTileCoin.setWidth(50);
		pathTileCoin.setHeight(50);
		pathTileCoin.setLayoutX(strtX);
		pathTileCoin.setLayoutY(strtY);
		pathTileCoin.setFill(new ImagePattern(coin));
		//pathTileCoin.setStroke(Color.WHITESMOKE);
		root.getChildren().add(pathTileCoin);
		//left 5
		for (int i = 0; i < 5; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(strtX-=50);
			pathTile.setLayoutY(strtY);
			pathTile.setFill(Color.DARKGREY);
			//pathTile.setStroke(Color.WHITESMOKE);
			pathTile.setOpacity(0);
			root.getChildren().add(pathTile);
		}
		Rectangle pathTileCoin2 = new Rectangle();
		pathTileCoin2.setWidth(50);
		pathTileCoin2.setHeight(50);
		pathTileCoin2.setLayoutX(strtX);
		pathTileCoin2.setLayoutY(strtY);
		pathTileCoin2.setFill(new ImagePattern(coin));
		//pathTileCoin2.setStroke(Color.WHITESMOKE);
		//Up 6
		for (int i = 0; i < 6; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(strtX);
			pathTile.setLayoutY(strtY-=50);
			pathTile.setFill(Color.DARKGREY);
			//pathTile.setStroke(Color.WHITESMOKE);
			pathTile.setOpacity(0);
			root.getChildren().add(pathTile);
		}
		//Right 7
		for (int i = 0; i < 7; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(strtX+=50);
			pathTile.setLayoutY(strtY);
			pathTile.setFill(Color.DARKGREY);
			//pathTile.setStroke(Color.WHITESMOKE);
			pathTile.setOpacity(0);
			root.getChildren().add(pathTile);
		}
		//Down 6
		for (int i = 0; i < 8; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(strtX);
			pathTile.setLayoutY(strtY+=50);
			pathTile.setFill(Color.DARKGREY);
			//pathTile.setStroke(Color.WHITESMOKE);
			pathTile.setOpacity(0);
			root.getChildren().add(pathTile);
		}
		

		
		
		
		//Ending Tile
		Rectangle endTile = new Rectangle();
		endTile.setWidth(50);
		endTile.setHeight(50);
		endTile.setFill(Color.ORANGERED);
		endTile.setOpacity(0);
		
		endTile.setLayoutX(strtX); //STARTING POINT OF CHARACTER
		endTile.setLayoutY(strtY); //STARTING POINT OF CHARACTER
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
		
		coinImage.setWidth(50);
		coinImage.setHeight(50);
		coinImage.setLayoutX(800);
		coinImage.setLayoutY(0);
		coinImage.setFill(new ImagePattern(coin));
		
		coinCount.setPrefWidth(50);
		coinCount.setPrefHeight(50);
		coinCount.setLayoutX(850);
		coinCount.setLayoutY(0);
		coinCount.setStyle("-fx-border-color: black;");
		coinCount.setAlignment(Pos.CENTER);
		coinCount.setText(Integer.toString(totalCoin));
		
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
		
		root.getChildren().add(coinImage);
		root.getChildren().add(coinCount);
		
		root.setStyle(
				"-fx-background-image:url('assets/Level3E2.JPG');"
				+ "-fx-background-size: cover;");//pane background
		
		mediaPlayer.play();//play audio
		
		player1.toFront();
		
		directionUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(stepCount < seqLen) {
            		if(stepCount==0)
            		player1.setRotate(0);
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
            		if(stepCount==0)
            		player1.setRotate(180);
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
            		if(stepCount==0)
            		player1.setRotate(270);
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
            		if(stepCount==0)
            		player1.setRotate(90);
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
				if(stepCount >= seqLen) {
            	for(int i = 0; i < seqLen; i++) {
            		if(lSequence[i] == uSequence[i]) {
            			flag = true;
            		}else {
            			flag = false;
            			System.err.println("Wrong Sequence");
            		}
            	}
            	
            	if(flag == true) {
            		
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
                			wrongSequence();
                		}
                	}
                	player1.setRotate(90);
                	translations[0].play();
                	
                	translations[0].setOnFinished(e ->{
                		player1.setRotate(180);
                		translations[1].play();
                		
						Task<Void> eatCoin = new Task<Void>() {
							@Override
							protected Void call() throws Exception {
								try {
									Thread.sleep(200);
								} catch (InterruptedException e) {
								}
								return null;
							}
						};

						eatCoin.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
							@Override
							public void handle(WorkerStateEvent event) {
								totalCoin++;
								coinCount.setText(Integer.toString(totalCoin));
								pathTileCoin.setFill(Color.TRANSPARENT);
							}
						});

						new Thread(eatCoin).start();
						translations[1].setOnFinished(f -> {
							player1.setRotate(270);
							translations[2].play();
                			translations[2].setOnFinished(g ->{
                				player1.setRotate(0);
                				translations[3].play();
                				translations[3].setOnFinished(h ->{
                					player1.setRotate(90);
                					translations[4].play();
                					translations[4].setOnFinished(i ->{
                    					player1.setRotate(180);
                        					translations[5].play();
                        					translations[5].setOnFinished(k ->{
                            						translations[5].stop();
                            						levelFinishSuccess();
                    					});
                					});
                				});
                			});
                		});
                	});
            	}
            	
            }
				else {
				System.out.println("Finish the sequence");
				wrongSequence();
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

		if (stepCount>= seqLen) {
		player1.setX(0);
		player1.setY(0);
		player1.toFront();
		}
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
	
	public void levelFinishSuccess() {
		Label win = new Label();
		win.setPrefHeight(450);
		win.setPrefWidth(450);
		win.setLayoutX(225);
		win.setLayoutY(225);
		win.setText("Proceeding to Episode Three");
		win.setAlignment(Pos.BASELINE_CENTER);
		win.setFont(Font.font(25));
		win.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		win.toFront();
		mediaPlayer.setMute(true);
		
		
		root.getChildren().add(win);
		
		Task<Void> displayWin = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        
        displayWin.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
            	LevelThreeEpisodeThree three = new LevelThreeEpisodeThree();
        		closeProgram();
        		three.start();
            }
        });
        
        new Thread(displayWin).start();
	}
	
	public void wrongSequence() {

		Label wrong = new Label();
		wrong.setPrefHeight(50);
		wrong.setPrefWidth(300);
		wrong.setLayoutX(0);
		wrong.setLayoutY(100);
		wrong.setText("Wrong sequence try again");
		wrong.setAlignment(Pos.BASELINE_CENTER);
		wrong.setFont(Font.font(20));
		wrong.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		wrong.toFront();
		

		root.getChildren().add(wrong);

		Task<Void> wrongSequence = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				try {
					Thread.sleep(10);;
				} catch (InterruptedException e) {
				}
				return null;
			}
		};

		new Thread(wrongSequence).start();
	}

	
	public void start() {
		if(startedGame == true)
			startedGame();
		try {
		stage.setResizable(false);
		stage.setTitle("Level Three - EP2");
		stage.setOnCloseRequest(e -> closeProgram());
        stage.getIcons().add(new Image(this.getClass().getResource("/assets/gameIcon.png").toString()));
		stage.setScene(
			new Scene(createContent())
		);
		//Set started game to true
		startedGame = true;
		stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Keep track of if game stage was created, if so just start
	boolean startedGame = false;
	private void startedGame() {
		if(startedGame == true) {
			Platform.runLater( () -> new LevelThreeEpisodeTwo() .start());
		}
	}
	
	//Close window properly
	private void closeProgram() {
		stage.close();
	}
	
}
