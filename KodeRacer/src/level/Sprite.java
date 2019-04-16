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
	
	void moveLeft() {
		setTranslateX(getTranslateX() - 5); //Move left 5
	}
	void moveRight() {
		setTranslateX(getTranslateX() + 5); //Move left 5
	}
	void moveUp() {
		setTranslateY(getTranslateY() - 5); //Move left 5
		
	}
	void moveDown() {
		setTranslateX(getTranslateY() + 5); //Move left 5
	}
	
}
