/*This code is not to replace what is already written in LevelOne.java but to demonstrate a completed version of the layout
 * if we need a fully designed layout. Background image is in asset folder*/
package level;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LvlOneLayout extends Application{
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		primaryStage.setTitle("KodeRacer");
		
		Image background = new Image("file:City2.jpg");//background image
		ImageView mv = new ImageView(background);
		
		mv.setOpacity(0.95);//To allow visual of tile path
		
		//Default Tile Coordinates/Size
		int x, y, l, w;
		x = 5;
		y= 115;
		l = 50;
		w = 50;
		
		Group root = new Group();
		
		/*Horizontal Approach*/
			
		for(int i = 0; i<4; i++) {	
			
				
			Rectangle rectH1 = new Rectangle(x, y, l, w);
			rectH1.setStroke(Color.BLACK);
			rectH1.setStrokeWidth(2);
			rectH1.setFill(null);
			
			x+=50;
			
			root.getChildren().add(rectH1);
		
		
		}
		//Vertical Row
		x = 205;
		y= 115;
		l = 50;
		w = 50;
		
		for(int i = 0; i<3; i++) {	
			
			Rectangle rectV1 = new Rectangle(x, y ,l ,w);
			rectV1.setStroke(Color.BLACK);
			rectV1.setStrokeWidth(2);
			rectV1.setFill(null);
			
			y+=50;					
			
			root.getChildren().add(rectV1);
		
		}
	//2nd Horizontal Row
		x = 205;
		y= 215;
		l = 50;
		w = 50;
			
		for(int i = 0; i<5; i++) {	
				
			Rectangle rectH2 = new Rectangle(x, y ,l ,w);
			rectH2.setStroke(Color.BLACK);
			rectH2.setStrokeWidth(2);
			rectH2.setFill(null);
			
			x+=50;
					
			
			root.getChildren().add(rectH2);
		
		}
		
	//2nd Vertical Row	
		x = 405;
		y= 215;
		l = 50;
		w = 50;
		
		for(int i = 0; i<3; i++) {	
				
			Rectangle rectV2 = new Rectangle(x, y ,l ,w);
			rectV2.setStroke(Color.BLACK);
			rectV2.setStrokeWidth(2);
			rectV2.setFill(null);
			
			y+=50;
					
			
			root.getChildren().add(rectV2);
		
		}
		
		//Final Row
		x = 405;
		y= 315;
		l = 50;
		w = 50;
			
		for(int i = 0; i<10; i++) {	
				
			Rectangle rectH2 = new Rectangle(x, y ,l ,w);
			rectH2.setStroke(Color.BLACK);
			rectH2.setStrokeWidth(2);
			rectH2.setFill(null);
			
			x+=50;
					
			
			root.getChildren().add(rectH2);
		
		}
		
		
		root.getChildren().addAll(mv);
		Scene scene = new Scene(root, 1301, 815);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		}
		

}
