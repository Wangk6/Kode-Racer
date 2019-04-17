package level;

import javafx.animation.Animation.Status;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Sprite extends Rectangle {
    String type; 
    
    TranslateTransition left = new TranslateTransition();
    TranslateTransition right = new TranslateTransition();
    TranslateTransition up = new TranslateTransition();
    TranslateTransition down = new TranslateTransition();
    
	
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
	TranslateTransition moveLeft(int translate) {
		left.setDuration(Duration.millis(1000)); 
		left.setNode(this); 
		left.setByX(-translate); //left
		left.setCycleCount(1); 
		left.setAutoReverse(false); 
		left.play();
		return left;
	}
	TranslateTransition moveRight(int translate) {
		right.setDuration(Duration.millis(1000)); 
		right.setNode(this); 
		right.setByX(translate); //right
		right.setCycleCount(1); 
		right.setAutoReverse(false); 
		right.play();
		return right;
	}
	TranslateTransition moveUp(int translate) {
		up.setDuration(Duration.millis(1000)); 
		up.setNode(this); 
		up.setByY(-translate); //up 
		up.setCycleCount(1); 
		up.setAutoReverse(false); 
		up.play();
		return up;
	}
	TranslateTransition moveDown(int translate) {
		down.setDuration(Duration.millis(1000)); 
		down.setNode(this); 
		down.setByY(translate); //down
		down.setCycleCount(1); 
		down.setAutoReverse(false); 
		down.play();
		return down;
	}
	
}
