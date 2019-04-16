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
	int moveLeft() {
		setTranslateX(getTranslateX() - 5); //Move left 5
		return 2;
	}
	int moveRight() {
		setTranslateX(getTranslateX() + 5); //Move left 5
		return 3;
	}
	int moveUp() {
		setTranslateY(getTranslateY() - 5); //Move left 5
		return 0;
	}
	int moveDown() {
		setTranslateX(getTranslateY() + 5); //Move left 5
		return 1;
	}
	
}
