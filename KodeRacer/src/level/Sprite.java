package level;

import javafx.animation.Animation.Status;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Sprite extends Rectangle {
    String type; 
    
	public Sprite(int x, int y, int w, int h, String type, Color color){
		super(w, h);
		this.type = type;
		setLayoutX(x);
		setLayoutY(y);
		Image s = new Image("assets/pimpmywheel.gif");
		setFill(new ImagePattern(s));
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
		TranslateTransition left = new TranslateTransition();
		left.setDuration(Duration.millis(700)); 
		left.setNode(this); 
		left.setByX(-translate); //left
		left.setAutoReverse(true);
		return left;
	}
	TranslateTransition moveRight(int translate) {
		TranslateTransition right = new TranslateTransition();
		right.setDuration(Duration.millis(700)); 
		right.setNode(this); 
		right.setByX(translate); //right 
		right.setAutoReverse(true); 
		return right;
	}
	TranslateTransition moveUp(int translate) {
		TranslateTransition up = new TranslateTransition();
		up.setDuration(Duration.millis(700)); 
		up.setNode(this); 
		up.setByY(-translate); //up 
		up.setAutoReverse(true); 
		return up;
	}
	TranslateTransition moveDown(int translate) {
		TranslateTransition down = new TranslateTransition();
		down.setDuration(Duration.millis(700)); 
		down.setNode(this); 
		down.setByY(translate); //down
		down.setAutoReverse(true); 
		return down;
	}
	
	
}
