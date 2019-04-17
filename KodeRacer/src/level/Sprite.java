package level;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Sprite extends Rectangle {
    String type; 
    
    TranslateTransition moveSprite = new TranslateTransition();
	
	public Sprite(int x, int y, int w, int h, String type, Color color){
		super(w, h);
		this.type = type;
		setLayoutX(x);
		setLayoutY(y);
		setFill(color);
	}
	/*
	 * 0 - up
	 * 1 - down
	 * 2 - left
	 * 3 - right
	 */
	
	int Up() {
		return 0;
	}
	int Down() {
		return 1;
	}
	int Left() {
		return 2;
	}
	int Right() {
		return 3;
	}
	//Takes a parameter of translate so according the level the motion will happen
	void moveLeft(int translate) {
		TranslateTransition left = new TranslateTransition();
		left.setDuration(Duration.millis(1000)); 
		left.setNode(this); 
		left.setByX(-translate); //left
		left.setCycleCount(1); 
		left.setAutoReverse(false); 
		left.play();
	}
	void moveRight(int translate) {
		TranslateTransition right = new TranslateTransition();
		right.setDuration(Duration.millis(1000)); 
		right.setNode(this); 
		right.setByX(translate); //right
		right.setCycleCount(1); 
		right.setAutoReverse(false); 
		right.play();
	}
	void moveUp(int translate) {
		TranslateTransition up = new TranslateTransition();
		up.setDuration(Duration.millis(1000)); 
		up.setNode(this); 
		up.setByY(-translate); //up 
		up.setCycleCount(1); 
		up.setAutoReverse(false); 
		up.play();
	}
	void moveDown(int translate) {
		TranslateTransition down = new TranslateTransition();
		down.setDuration(Duration.millis(1000)); 
		down.setNode(this); 
		down.setByY(translate); //down
		down.setCycleCount(1); 
		down.setAutoReverse(false); 
		down.play();
	}
	
}
