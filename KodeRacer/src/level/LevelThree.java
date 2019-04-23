package level;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LevelThree extends Application{

	public static void main(String[] args) {
		launch (args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		primaryStage.setTitle("KodeRacer");
		
		Image background = new Image("file:City3.jpg");//background image
		ImageView mv = new ImageView(background);
		
		mv.setOpacity(0.95);//To allow visual of path
		
		//Default Tile Coordinates/Size
		int x, y, l, w;
		x = 308;
		y= 217;
		l = 50;
		w = 50;
		
		Group root = new Group();
		
		/*Beginning of Tile Path - Vertical Approach*/
		for(int i = 0; i<12; i++) {	
				
			Rectangle rectV1 = new Rectangle(x, y ,l ,w);
			rectV1.setStroke(Color.BLACK);
			rectV1.setStrokeWidth(2);
			rectV1.setFill(null);
			
			y+=50;					
			
			root.getChildren().add(rectV1);
		
		}
		
		/*Horizontal Approach*/
		x = 308;
		y= 217;
		l = 50;
		w = 50;
		
		for(int i = 0; i<14; i++) {	
			
				
			Rectangle rectH1 = new Rectangle(x, y, l, w);
			rectH1.setStroke(Color.BLACK);
			rectH1.setStrokeWidth(2);
			rectH1.setFill(null);
			
			x+=50;
			
			root.getChildren().add(rectH1);
		
		
		}
		/*Last Vertical Line up of Tiles - End of Game*/
		x = 958;
		y= 217;
		l = 50;
		w = 50;
			
		for(int i = 0; i<6; i++) {	
				
			Rectangle rectV2 = new Rectangle(x, y ,l ,w);
			rectV2.setStroke(Color.BLACK);
			rectV2.setStrokeWidth(2);
			rectV2.setFill(null);
			
			y-=50;
					
			
			root.getChildren().add(rectV2);
		
		}
		
		/*Last Horizontal Line up of Tiles*/
		x = 308;
		y= 567;
		l = 50;
		w = 50;
			
		for(int i = 0; i<6; i++) {	
				
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
