/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;

/**
 *
 * @author qbillah
 */
public class Controller {
    
    /*
    * This class takes care of controls and sequence
    * setSequence is used a levels init method
    * Upto 6 steps in a sequence - we have to expand on this
    * The concept is to match the level sequence and user sequence (both arrays)
    * If the sequences match then animate the character if not tell the user
      he's wrong 
    */
    
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
    }
    
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
    }
    
}
