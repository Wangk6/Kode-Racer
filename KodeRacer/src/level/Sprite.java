package level;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sprite extends Rectangle {
    String type; 
	
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
		setTranslateX(getTranslateX() - translate); //Move left
	}
	void moveRight(int translate) {
		setTranslateX(getTranslateX() + translate); //Move right
	}
	void moveUp(int translate) {
		setTranslateY(getTranslateY() - translate); //Move up
		
	}
	void moveDown(int translate) {
		setTranslateX(getTranslateY() + translate); //Move down
	}
	
}
