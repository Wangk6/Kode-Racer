package level;

import java.util.Arrays;

import javafx.animation.Transition;
import javafx.application.Platform;
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

public class LevelThree {

	Stage stage = new Stage();
	private Pane root = new Pane();

	private int setW = 50;
	private int setH = 50;
	private int strtX = 200;
	private int strtY = 950;
	// Sprite player1 = new Sprite(300, 300, (int)width/25, (int)width/25, "random",
	// Color.RED); //Keep the W & H to 25, because we're moving at 5's
	Sprite player1 = new Sprite(strtX, strtY, setW, setH, "random", Color.TRANSPARENT); // Keep the W & H to 25, because
																						// we're moving at 5's

	private Button play = new Button();
	private Button clear = new Button(); // returns 3

	// Directional Buttons
	// Returns are for the sequence
	private Button directionUp = new Button(); // returns 0
	private Button directionDown = new Button(); // returns 1
	private Button directionLeft = new Button(); // returns 2
	private Button directionRight = new Button(); // returns 3

	private Label displayStep_one = new Label();
	private Label displayStep_two = new Label();
	private Label displayStep_three = new Label();
	private Label displayStep_four = new Label();
	private Label displayStep_five = new Label();
	private Label displayStep_six = new Label();
	private Label displayStep_seven = new Label();
	private Label displayStep_eight = new Label();
	private Label displayStep_nine = new Label();
	private Label displayStep_ten = new Label();

	private int stepCount = 0;

	/*
	 * We will be using two arrays to keep track of our user movements
	 * playerSequence will record all the steps the user puts in playerSequence will
	 * be ran against levelSequence when user hits 'run' If they match you win the
	 * level if not you restart over
	 */

	// levelSequence 200 , 100 , 200 , 100 , 50
	int[] lSequence = { 0, 2, 0, 3, 0, 3, 0, 3, 0 }; // 0, 2, 0, 3, 0, 3, 0, 3, 0
	int[] lSequenceTwo = { 3, 0, 3, 0, 3, 0, 3, 0, 2, 0 }; // 3, 0, 3, 0, 3, 0, 3, 0, 2, 0
	int[] translateLength = { 150, 100, 200, 150, 150, 150, 150, 200, 200 };
	int[] translateLengthTwo = { 150, 100, 150, 150, 100, 200, 100, 200, 100, 200 };
	int seqLen = lSequence.length;
	int seqLenTwo = lSequenceTwo.length;
	Transition[] translations = new Transition[seqLen];
	Transition[] translationsTwo = new Transition[seqLenTwo];
	int[] uSequence = new int[seqLen];
	int[] uSequenceTwo = new int[seqLenTwo];

	/*
	 * 0 - up 1 - down 2 - left 3 - right
	 */
	private Parent createContent() {
		// Set the level size
		root.setPrefSize(1000, 1000);
		root.getChildren().add(player1);

		// Level Tiles
		// Starting Tile
		Rectangle startTile = new Rectangle();
		startTile.setWidth(setW);
		startTile.setHeight(setH);
		startTile.setFill(Color.LAWNGREEN);

		startTile.setLayoutX(strtX); // STARTING POINT OF CHARACTER
		startTile.setLayoutY(strtY); // STARTING POINT OF CHARACTER

		// Route One
		int pathXOne = strtX;
		int pathYOne = strtY;

		// Right Three
		for (int i = 0; i < 3; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(pathXOne += 50);
			pathTile.setLayoutY(pathYOne);
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
		}
		// Up Two
		for (int i = 0; i < 2; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(pathXOne);
			pathTile.setLayoutY(pathYOne -= 50);
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
		}

		// Right Four
		for (int i = 0; i < 4; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(pathXOne += 50);
			pathTile.setLayoutY(pathYOne);
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
			System.out.println("P1" + pathXOne + " " + pathYOne);
			if (i == 2) {
				int pathXOneZero = pathXOne;
				int pathYOneZero = pathYOne;
				// Up Three
				for (int j = 0; j < 3; j++) {
					Rectangle pathTile2 = new Rectangle();
					pathTile2.setWidth(setW);
					pathTile2.setHeight(setH);
					pathTile2.setLayoutX(pathXOneZero);
					pathTile2.setLayoutY(pathYOneZero -= 50);
					pathTile2.setFill(Color.DARKGREY);
					pathTile2.setStroke(Color.WHITESMOKE);
					root.getChildren().add(pathTile2);
				}
				// Right two
				for (int j = 0; j < 2; j++) {
					Rectangle pathTile2 = new Rectangle();
					pathTile2.setWidth(setW);
					pathTile2.setHeight(setH);
					pathTile2.setLayoutX(pathXOneZero += 50);
					pathTile2.setLayoutY(pathYOneZero);
					pathTile2.setFill(Color.DARKGREY);
					pathTile2.setStroke(Color.WHITESMOKE);
					root.getChildren().add(pathTile2);
				}
				// Up Four
				for (int j = 0; j < 4; j++) {
					Rectangle pathTile2 = new Rectangle();
					pathTile2.setWidth(setW);
					pathTile2.setHeight(setH);
					pathTile2.setLayoutX(pathXOneZero);
					pathTile2.setLayoutY(pathYOneZero -= 50);
					pathTile2.setFill(Color.DARKGREY);
					pathTile2.setStroke(Color.WHITESMOKE);
					root.getChildren().add(pathTile2);
				}
				// Right two
				for (int j = 0; j < 2; j++) {
					Rectangle pathTile2 = new Rectangle();
					pathTile2.setWidth(setW);
					pathTile2.setHeight(setH);
					pathTile2.setLayoutX(pathXOneZero += 50);
					pathTile2.setLayoutY(pathYOneZero);
					pathTile2.setFill(Color.DARKGREY);
					pathTile2.setStroke(Color.WHITESMOKE);
					root.getChildren().add(pathTile2);
				}
				// Up Four
				for (int j = 0; j < 4; j++) {
					Rectangle pathTile2 = new Rectangle();
					pathTile2.setWidth(setW);
					pathTile2.setHeight(setH);
					pathTile2.setLayoutX(pathXOneZero);
					pathTile2.setLayoutY(pathYOneZero -= 50);
					pathTile2.setFill(Color.DARKGREY);
					pathTile2.setStroke(Color.WHITESMOKE);
					root.getChildren().add(pathTile2);
				}
			}
		}

		// Alternate path for route one
		int pathXOneOne = pathXOne;
		int pathYOneOne = pathYOne;

		// Down One
		for (int i = 0; i < 1; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(pathXOneOne);
			pathTile.setLayoutY(pathYOneOne += 50);
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
		}

		// Right Four
		for (int i = 0; i < 4; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(pathXOneOne += 50);
			pathTile.setLayoutY(pathYOneOne);
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
		}

		// Up Four
		for (int i = 0; i < 4; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(pathXOneOne);
			pathTile.setLayoutY(pathYOneOne -= 50);
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
		}

		// Route Two
		int pathXTwo = strtX;
		int pathYTwo = strtY;

		// Up Three
		for (int i = 0; i < 3; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(pathXTwo);
			pathTile.setLayoutY(pathYTwo -= 50);
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
		}

		// Left Two
		for (int i = 0; i < 2; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(pathXTwo -= 50);
			pathTile.setLayoutY(pathYTwo);
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
		}

		// Up Four
		for (int i = 0; i < 4; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(pathXTwo);
			pathTile.setLayoutY(pathYTwo -= 50);
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
		}

		// Right Three
		for (int i = 0; i < 3; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(pathXTwo += 50);
			pathTile.setLayoutY(pathYTwo);
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
		}

		// Up Three
		for (int i = 0; i < 3; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(pathXTwo);
			pathTile.setLayoutY(pathYTwo -= 50);
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
			if (i == 2) {
				int pathXTwoZero = pathXTwo;
				int pathYTwoZero = pathYTwo;
				// Left Two
				for (int j = 0; j < 3; j++) {
					Rectangle pathTile2 = new Rectangle();
					pathTile2.setWidth(setW);
					pathTile2.setHeight(setH);
					pathTile2.setLayoutX(pathXTwoZero -= 50);
					pathTile2.setLayoutY(pathYTwoZero);
					pathTile2.setFill(Color.DARKGREY);
					pathTile2.setStroke(Color.WHITESMOKE);
					root.getChildren().add(pathTile2);
				}
				// Up 3
				for (int j = 0; j < 3; j++) {
					Rectangle pathTile2 = new Rectangle();
					pathTile2.setWidth(setW);
					pathTile2.setHeight(setH);
					pathTile2.setLayoutX(pathXTwoZero);
					pathTile2.setLayoutY(pathYTwoZero -= 50);
					pathTile2.setFill(Color.DARKGREY);
					pathTile2.setStroke(Color.WHITESMOKE);
					root.getChildren().add(pathTile2);
				}
			}
		}

		// Right Three
		for (int i = 0; i < 3; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(pathXTwo += 50);
			pathTile.setLayoutY(pathYTwo);
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
			if (i == 2) {
				// Down Three
				int pathXTwoOne = pathXTwo;
				int pathYTwoOne = pathYTwo;
				for (int j = 0; j < 3; j++) {
					Rectangle pathTile2 = new Rectangle();
					pathTile2.setWidth(setW);
					pathTile2.setHeight(setH);
					pathTile2.setLayoutX(pathXTwoOne);
					pathTile2.setLayoutY(pathYTwoOne += 50);
					pathTile2.setFill(Color.DARKGREY);
					pathTile2.setStroke(Color.WHITESMOKE);
					root.getChildren().add(pathTile2);
				}
				// Right One
				for (int h = 0; h < 2; h++) {
					Rectangle pathTile3 = new Rectangle();
					pathTile3.setWidth(setW);
					pathTile3.setHeight(setH);
					pathTile3.setLayoutX(pathXTwoOne += 50);
					pathTile3.setLayoutY(pathYTwoOne);
					pathTile3.setFill(Color.DARKGREY);
					pathTile3.setStroke(Color.WHITESMOKE);
					root.getChildren().add(pathTile3);
				}
			}
		}

		// Up Three
		for (int i = 0; i < 3; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(pathXTwo);
			pathTile.setLayoutY(pathYTwo -= 50);
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
		}

		// Right Six
		for (int i = 0; i < 6; i++) {
			Rectangle pathTile = new Rectangle();
			pathTile.setWidth(setW);
			pathTile.setHeight(setH);
			pathTile.setLayoutX(pathXTwo += 50);
			pathTile.setLayoutY(pathYTwo);
			pathTile.setFill(Color.DARKGREY);
			pathTile.setStroke(Color.WHITESMOKE);
			root.getChildren().add(pathTile);
			if (i == 3) {
				// Up Three
				int pathXTwoTwo = pathXTwo;
				int pathYTwoTwo = pathYTwo;
				for (int j = 0; j < 3; j++) {
					Rectangle pathTile2 = new Rectangle();
					pathTile2.setWidth(setW);
					pathTile2.setHeight(setH);
					pathTile2.setLayoutX(pathXTwoTwo);
					pathTile2.setLayoutY(pathYTwoTwo -= 50);
					pathTile2.setFill(Color.DARKGREY);
					pathTile2.setStroke(Color.WHITESMOKE);
					root.getChildren().add(pathTile2);
					if (j == 2) {
						// Ending Tile
						Rectangle endTile = new Rectangle();
						endTile.setWidth(50);
						endTile.setHeight(50);
						endTile.setFill(Color.ORANGERED);

						endTile.setLayoutX(pathXTwoTwo); // STARTING POINT OF CHARACTER
						endTile.setLayoutY(pathYTwoTwo -= 50); // STARTING POINT OF CHARACTER
						// Ending Tile
						root.getChildren().add(startTile);
						root.getChildren().add(endTile);
					}
				}
			}
		}

		// Directional Buttons & Buttons

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

		displayStep_seven.setPrefWidth(50);
		displayStep_seven.setPrefHeight(50);
		displayStep_seven.setLayoutX(300);
		displayStep_seven.setLayoutY(50);
		displayStep_seven.setStyle("-fx-border-color: black;");
		displayStep_seven.setAlignment(Pos.CENTER);

		displayStep_eight.setPrefWidth(50);
		displayStep_eight.setPrefHeight(50);
		displayStep_eight.setLayoutX(350);
		displayStep_eight.setLayoutY(50);
		displayStep_eight.setStyle("-fx-border-color: black;");
		displayStep_eight.setAlignment(Pos.CENTER);

		displayStep_nine.setPrefWidth(50);
		displayStep_nine.setPrefHeight(50);
		displayStep_nine.setLayoutX(400);
		displayStep_nine.setLayoutY(50);
		displayStep_nine.setStyle("-fx-border-color: black;");
		displayStep_nine.setAlignment(Pos.CENTER);

		displayStep_ten.setPrefWidth(50);
		displayStep_ten.setPrefHeight(50);
		displayStep_ten.setLayoutX(450);
		displayStep_ten.setLayoutY(50);
		displayStep_ten.setStyle("-fx-border-color: black;");
		displayStep_ten.setAlignment(Pos.CENTER);

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
		root.getChildren().add(displayStep_seven);
		root.getChildren().add(displayStep_eight);
		root.getChildren().add(displayStep_nine);
		root.getChildren().add(displayStep_ten);
		player1.toFront();

		directionUp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (stepCount < seqLenTwo) {
					//First Move
					if(stepCount==0) {
						player1.setRotate(0);
						uSequence[stepCount] = player1.Up();
						uSequenceTwo[stepCount] = player1.Up();
					} else if (uSequence[0] == 0) {
						// Add sequence to user array
					
						uSequence[stepCount] = player1.Up();
					} else if (uSequenceTwo[0] == 3) {
						// Add sequence to user array
						uSequenceTwo[stepCount] = player1.Up();
					}
				}
				setDirectionDisplay(stepCount, 0);
				stepCount += 1;
			}
		});

		directionDown.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (stepCount < seqLenTwo) {
					//First Move
					if(stepCount==0) {
						player1.setRotate(180);
						uSequence[stepCount] = player1.Down();
						uSequenceTwo[stepCount] = player1.Down();
					} else if (uSequence[0] == 0) {
						// Add sequence to user array
					
						uSequence[stepCount] = player1.Down();
					} else if (uSequenceTwo[0] == 3) {
						// Add sequence to user array
						uSequenceTwo[stepCount] = player1.Down();
					} 
					setDirectionDisplay(stepCount, 1);
					stepCount += 1;
				}
			}
		});

		directionLeft.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (stepCount < seqLenTwo) {
					//First Move
					if(stepCount==0) {
						player1.setRotate(270);
						uSequence[stepCount] = player1.Left();
						uSequenceTwo[stepCount] = player1.Left();
					} else if (uSequence[0] == 0) {
						// Add sequence to user array
						player1.setRotate(270);
						uSequence[stepCount] = player1.Left();
					} else if (uSequenceTwo[0] == 3) {
						// Add sequence to user array
						uSequenceTwo[stepCount] = player1.Left();
					}
					setDirectionDisplay(stepCount, 2);
					stepCount += 1;
				}
			}
		});

		directionRight.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (stepCount < seqLenTwo) {
					//First Move
					if(stepCount==0) {
						player1.setRotate(90);
						uSequence[stepCount] = player1.Right();
						uSequenceTwo[stepCount] = player1.Right();
					} else if (uSequence[0] == 0) {
						// Add sequence to user array
						player1.setRotate(90);
						uSequence[stepCount] = player1.Right();
					} else if (uSequenceTwo[0] == 3) {
						// Add sequence to user array
						uSequenceTwo[stepCount] = player1.Right();
					}
					setDirectionDisplay(stepCount, 3);
					stepCount += 1;
				}
			}
		});

		// Directional Buttons & Buttons
		// Directional Buttons & Buttons
		// Directional Buttons & Buttons
		// Directional Buttons & Buttons

		// Play & Clear Buttons
		// Play & Clear Buttons
		// Play & Clear Buttons
		// Play & Clear Buttons

		play.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				boolean flag = false;

				System.out.println("Level: " + Arrays.toString(lSequence));
				System.out.println("User: " + Arrays.toString(uSequence));
				System.out.println("Level: " + Arrays.toString(lSequenceTwo));

				// If the first input is up, play this
				if(stepCount >= seqLen) {
				if (uSequence[0] == 0) {
					for (int i = 0; i < seqLen; i++) {
						if (lSequence[i] == uSequence[i]) {
							flag = true;
						} else {
							flag = false;
							System.err.println("Wrong Sequence");
						}
					}

					if (flag == true) {

						for (int i = 0; i < seqLen; i++) {
							if (lSequence[i] == uSequence[i]) {

								int temp = uSequence[i]; // sequence of translation
								int transTemp = translateLength[i]; // how much translation should happen

								switch (temp) {
								case 0:
									player1.setRotate(0);
									translations[i] = player1.moveUp(transTemp);
									break;
								case 1:
									player1.setRotate(180);
									translations[i] = player1.moveDown(transTemp);
									break;
								case 2:
									player1.setRotate(270);
									translations[i] = player1.moveLeft(transTemp);
									break;
								case 3:
									player1.setRotate(90);
									translations[i] = player1.moveRight(transTemp);
									break;
								}

							} else {
								// do jitter animation
								System.err.println("Wrong Sequence");
							}
						}
						player1.setRotate(0);
						translations[0].play();
						translations[0].setOnFinished(e -> {
							player1.setRotate(270);
							translations[1].play();
							translations[1].setOnFinished(f -> {
								player1.setRotate(0);
								translations[2].play();
								translations[2].setOnFinished(g -> {
									player1.setRotate(90);
									translations[3].play();
									translations[3].setOnFinished(h -> {
										player1.setRotate(0);
										translations[4].play();
										translations[4].setOnFinished(i -> {
											player1.setRotate(90);
											translations[5].play();
											translations[5].setOnFinished(j -> {
												player1.setRotate(0);
												translations[6].play();
												translations[6].setOnFinished(k -> {
													player1.setRotate(90);
													translations[7].play();
													translations[7].setOnFinished(l -> {
														player1.setRotate(0);
														translations[8].play();
														translations[8].setOnFinished(m -> {
															translations[8].stop();
															levelFinishSuccess();
														});
													});
												});
											});
										});
									});
								});
							});
						});
					}
				}

				else if (uSequenceTwo[0] == 3) {
					for (int i = 0; i < seqLenTwo; i++) {
						if (lSequenceTwo[i] == uSequenceTwo[i]) {
							flag = true;
						} else {
							flag = false;
							System.err.println("Wrong Sequence");
						}
					}
					if (flag == true) {

						for (int i = 0; i < seqLenTwo; i++) {
							if (lSequenceTwo[i] == uSequenceTwo[i]) {

								int temp = uSequenceTwo[i]; // sequence of translation
								int transTemp = translateLengthTwo[i]; // how much translation should happen

								switch (temp) {
								case 0:
									player1.setRotate(0);
									translationsTwo[i] = player1.moveUp(transTemp);
									break;
								case 1:
									player1.setRotate(180);
									translationsTwo[i] = player1.moveDown(transTemp);
									break;
								case 2:
									player1.setRotate(270);
									translationsTwo[i] = player1.moveLeft(transTemp);
									break;
								case 3:
									player1.setRotate(90);
									translationsTwo[i] = player1.moveRight(transTemp);
									break;
								}

							} else {
								// do jitter animation
								System.err.println("Wrong Sequence");
							}
						}
						player1.setRotate(90);
						translationsTwo[0].play();
						translationsTwo[0].setOnFinished(e -> {
							player1.setRotate(0);
							translationsTwo[1].play();
							translationsTwo[1].setOnFinished(f -> {
								player1.setRotate(90);
								translationsTwo[2].play();
								translationsTwo[2].setOnFinished(g -> {
									player1.setRotate(0);
									translationsTwo[3].play();
									translationsTwo[3].setOnFinished(h -> {
										player1.setRotate(90);
										translationsTwo[4].play();
										translationsTwo[4].setOnFinished(i -> {
											player1.setRotate(0);
											translationsTwo[5].play();
											translationsTwo[5].setOnFinished(j -> {
												player1.setRotate(90);
												translationsTwo[6].play();
												translationsTwo[6].setOnFinished(k -> {
													player1.setRotate(0);
													translationsTwo[7].play();
													translationsTwo[7].setOnFinished(l -> {
														player1.setRotate(270);
														translationsTwo[8].play();
														translationsTwo[8].setOnFinished(m -> {
															player1.setRotate(0);
															translationsTwo[9].play();
															translationsTwo[9].setOnFinished(n -> {
																translationsTwo[9].stop();
																levelFinishSuccess();
															});
														});
													});
												});
											});
										});
									});
								});
							});
						});

					}
				}

			}
				else {
				System.out.println("Finish the sequence");
			}
			}
		});
		clear.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				clearDirec();
			}

		});

		// Play & Clear Buttons
		// Play & Clear Buttons
		// Play & Clear Buttons
		// Play & Clear Buttons

		return root;
	}

	public void setDirectionDisplay(int index, int direction) {
		String dispDirec = "";

		switch (direction) {
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

		switch (index) {
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
		case 6:
			displayStep_seven.setText(dispDirec);
			break;
		case 7:
			displayStep_eight.setText(dispDirec);
			break;
		case 8:
			displayStep_nine.setText(dispDirec);
			break;
		case 9:
			displayStep_ten.setText(dispDirec);
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
		translationsTwo = new Transition[translationsTwo.length];

		displayStep_one.setText(null);
		displayStep_two.setText(null);
		displayStep_three.setText(null);
		displayStep_four.setText(null);
		displayStep_five.setText(null);
		displayStep_six.setText(null);
		displayStep_seven.setText(null);
		displayStep_eight.setText(null);
		displayStep_nine.setText(null);
		displayStep_ten.setText(null);

	}

	public void levelFinishSuccess() {
		/* Add completion screen */
		System.out.println("Game Finished");
	}

	public void start() {
		if (startedGame == true)
			startedGame();
		try {
			stage.setResizable(false);
			stage.setTitle("Level One");
			stage.setOnCloseRequest(e -> closeProgram());
			stage.getIcons().add(new Image(this.getClass().getResource("/assets/gameIcon.png").toString()));
			stage.setScene(new Scene(createContent()));
			// Set started game to true
			startedGame = true;
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Keep track of if game stage was created, if so just start
	boolean startedGame = false;

	private void startedGame() {
		if (startedGame == true) {
			Platform.runLater(() -> new LevelOne().start());
		}
	}

	// Close window properly
	private void closeProgram() {
		stage.close();
	}

}
