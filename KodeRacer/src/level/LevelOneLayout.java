package level;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

	public class LevelOneLayout extends Application {
		
		public static void main(String[] args) {
			launch (args);
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception{
			
			primaryStage.setTitle("KodeRacer");
			
			//Image background = new Image("file:City1.jpg"); background image for level 1
			//ImageView mv = new ImageView(background);
			
			Rectangle rectH1 = new Rectangle(24, 164, 115, 133 );
			rectH1.setStroke(Color.BLACK);
			rectH1.setStrokeWidth(2);
			rectH1.setFill(null);
			
			Rectangle rectH2 = new Rectangle(139, 164, 115, 133 );
			rectH2.setStroke(Color.BLACK);
			rectH2.setStrokeWidth(2);
			rectH2.setFill(null);
			
			Rectangle rectH3 = new Rectangle(254, 164, 115, 133 );
			rectH3.setStroke(Color.BLACK);
			rectH3.setStrokeWidth(2);
			rectH3.setFill(null);
			
			Rectangle rectH4 = new Rectangle(369, 164, 115, 133 );
			rectH4.setStroke(Color.BLACK);
			rectH4.setStrokeWidth(2);
			rectH4.setFill(null);
			
			Rectangle rectV1 = new Rectangle(369, 297, 115, 133 );
			rectV1.setStroke(Color.BLACK);
			rectV1.setStrokeWidth(2);
			rectV1.setFill(null);
			
			Rectangle rectV2 = new Rectangle(369, 430, 115, 133 );
			rectV2.setStroke(Color.BLACK);
			rectV2.setStrokeWidth(2);
			rectV2.setFill(null);
			
			Rectangle rectH5 = new Rectangle(484, 430, 115, 133 );
			rectH5.setStroke(Color.BLACK);
			rectH5.setStrokeWidth(2);
			rectH5.setFill(null);
			
			Rectangle rectH6 = new Rectangle(599, 430, 115, 133 );
			rectH6.setStroke(Color.BLACK);
			rectH6.setStrokeWidth(2);
			rectH6.setFill(null);
			
			Rectangle rectH7 = new Rectangle(714, 430, 115, 133 );
			rectH7.setStroke(Color.BLACK);
			rectH7.setStrokeWidth(2);
			rectH7.setFill(null);
		
			Rectangle rectH8 = new Rectangle(829, 430, 115, 133 );
			rectH8.setStroke(Color.BLACK);
			rectH8.setStrokeWidth(2);
			rectH8.setFill(null);
					
			Group root = new Group(rectH1, rectH2, rectH3, rectH4, rectH5, rectH6, rectH7, rectH8, rectV1, rectV2);
			//mv.toBack(); Attempted to index the image behind the tiles
			//root.getChildren().addAll(mv);
			Scene scene = new Scene(root, 600, 800);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}
		
		

	}

