package kooda.fp;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MiniGame {
	
	Stage stage = new Stage();
	private Pane root = new Pane();
	
	Image orange = new Image("assets/orange.jpg");
	
	private Label time = new Label();
	
	private int count = 0;
	
	private Parent createContent(){
		
		root.setPrefSize(900, 900);
		
		Label title = new Label();
		Button oj = new Button();
		
		//TITLE
		title.setPrefWidth(450);
		title.setPrefHeight(50);
		title.setLayoutX(225);
		title.setLayoutY(0);
		title.setAlignment(Pos.CENTER);
		title.setText("Click 20 times for surprise!");
		title.setFont(Font.font(20));
		//TITLE
		
		//OJ
		oj.setPrefHeight(100);
		oj.setPrefWidth(100);
		oj.setBackground(new Background(new BackgroundImage(orange, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER , BackgroundSize.DEFAULT)));
		oj.setLayoutX(400);
		oj.setLayoutY(400);
		
		oj.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				count++;
				if(count >= 20) {
					Desktop desktop = Desktop.getDesktop();
					try {
						desktop.browse(new URL("https://yasin.design/").toURI());
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		
		root.getChildren().add(title);
		root.getChildren().add(time);
		root.getChildren().add(oj);
		return root;
	}
	
	public void start() {
		stage.setResizable(false);
		stage.setTitle("Mini Game");
		//stage.getIcons().add(new Image(this.getClass().getResource("/assets/gameIcon.png").toString()));
		stage.setScene(new Scene(createContent()));
		stage.show();
	}

	private void closeProgram() {
		stage.close();
	}
	
}
