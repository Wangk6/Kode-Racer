/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kooda.fp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Player extends Pane{
    
    /*
    * This class takes care of controls and sequence
    * setSequence is used a levels init method
    * Up to 6 steps in a sequence - we have to expand on this
    * The concept is to match the level sequence and user sequence (both arrays)
    * If the sequences match then animate the character if not tell the user
      he's wrong 
    */
	
	//Player Config////////////////////////////////
	ImageView playermodel;
	int offsetX = 0;
	int offsetY = 0;
	//Character size
	int height = 32;
	int width = 32;

	//Character fuel/life 
	int fuel = 2; 
	
    
    Rectangle removeFuel = null;
    SpriteAnimation animation;
    public Player(ImageView playermodel) {
    	this.playermodel = playermodel;
    	this.playermodel.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
    	animation = new SpriteAnimation(imageView,Duration.millis(200), count, columns, offsetX, offsetY, width, height);
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
    public int getFuel() {
    	return fuel;
    }
    public void setFuel(int fuel) {
    	this.fuel = fuel;
    }
    /*
    private String controlLeft = "left";
    private String controlRight = "right";
    private String controlUp= "up";
    private String controlDown = "down";
    private String[] Sequence = new String[5];

    public void setSequence(int index , String s){
        if(index < 0 || index > 5){
            System.exit(0);
            //Handle this error if setting index out of bounds
        }else{
            Sequence[index] = s;
        }
    }(
    public String[] getSequence(){
        return Sequence;
    }
    
    public String controlLeft(){
        return controlLeft;
    }
    
    public String controlRight(){
        return controlRight;
    }
    
    public String controlUp(){
        return controlUp;
    }
    
    public String controlDown(){
        return controlDown;
    }*/
    
}