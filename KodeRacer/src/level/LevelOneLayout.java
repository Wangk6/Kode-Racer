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
			
			Image background = new Image("file:City2.jpg");
			ImageView mv = new ImageView(background);
			
			Rectangle rectH1 = new Rectangle(0, 70, 115, 96 );
			rectH1.setStroke(Color.BLACK);
			rectH1.setStrokeWidth(2);
			rectH1.setFill(null);
			mv.setOpacity(0.9);
			
			Rectangle rectH2 = new Rectangle(115, 70, 115, 96 );
			rectH2.setStroke(Color.BLACK);
			rectH2.setStrokeWidth(2);
			rectH2.setFill(null);
			
			Rectangle rectH3 = new Rectangle(230, 70, 115, 96 );
			rectH3.setStroke(Color.BLACK);
			rectH3.setStrokeWidth(2);
			rectH3.setFill(null);
			
			Rectangle rectV1 = new Rectangle(230, 166, 115, 96 );
			rectV1.setStroke(Color.BLACK);
			rectV1.setStrokeWidth(2);
			rectV1.setFill(null);
			
			Rectangle rectV2 = new Rectangle(230, 262, 115, 96 );
			rectV2.setStroke(Color.BLACK);
			rectV2.setStrokeWidth(2);
			rectV2.setFill(null);
			
			Rectangle rectV3 = new Rectangle(230, 358, 115, 96 );
			rectV3.setStroke(Color.BLACK);
			rectV3.setStrokeWidth(2);
			rectV3.setFill(null);		
			
			Rectangle rectH5 = new Rectangle(230, 454, 115, 96 );
			rectH5.setStroke(Color.BLACK);
			rectH5.setStrokeWidth(2);
			rectH5.setFill(null);
			
			Rectangle rectH6 = new Rectangle(345, 454, 115, 96 );
			rectH6.setStroke(Color.BLACK);
			rectH6.setStrokeWidth(2);
			rectH6.setFill(null);
			
			Rectangle rectH7 = new Rectangle(460, 454, 115, 96 );
			rectH7.setStroke(Color.BLACK);
			rectH7.setStrokeWidth(2);
			rectH7.setFill(null);
		
			Rectangle rectH8 = new Rectangle(575, 454, 115, 96 );
			rectH8.setStroke(Color.BLACK);
			rectH8.setStrokeWidth(2);
			rectH8.setFill(null);			
			
			Group root = new Group(rectH1, rectH2, rectH3, rectH5, rectH6, rectH7, rectH8, rectV1, rectV2, rectV3);
			mv.toBack();
			root.getChildren().addAll(mv);
			Scene scene = new Scene(root, 658, 552);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}
		

	}

