/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kooda.fp;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import level.Sprite;

public abstract class Player extends Pane{
	//Player Config////////////////////////////////
	ImageView playermodel;
	int offsetX = 0;
	int offsetY = 0;
	//Default Character size
	int height = 32;
	int width = 32;
	
	//Current players model
	String playerModel = "default";
	//Character fuel/life 
	int fuel = 2; 
	
    public Player(ImageView playermodel) {
    	this.playermodel = playermodel;
    	this.playermodel.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        Sprite player1 = new Sprite(200, 200, height, width, playerModel, Color.RED);
    	getChildren().addAll(playermodel);
    }
    
	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}
	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	/* Fuel
	 * How much fuel the player has
	 * Fuel determines the amount of tries the player has until he reaches the end of the level
	 * Fuel has increase from picking up fuel depots from the map
	 * Fuel is transferred to the next stage
	 * Fuel is used to unlock player vehicles
	 */
    public abstract int getFuel();
    public abstract void setFuel(int fuel);

    
}
