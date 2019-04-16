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
