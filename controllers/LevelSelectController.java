/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import level.LevelOneEpisodeOne;
import level.LevelOneEpisodeThree;
import level.LevelThreeEpisodeOne;
import level.LevelTwoEpisodeOne;

public class LevelSelectController implements Initializable {
	
	private static LevelOneEpisodeOne one = new LevelOneEpisodeOne();
	private static LevelTwoEpisodeOne two = new LevelTwoEpisodeOne();
	private static LevelThreeEpisodeOne three = new LevelThreeEpisodeOne();

    @FXML
    private AnchorPane levelSelect;
    
    @FXML
    private Button lvlOne;
    
    @FXML
    private Button lvlTwo;
    
    @FXML
    private Button lvlThree;
    
    @FXML
    private Button mysteryOne;
    
    @FXML
    private Button mysteryTwo;
    
    /**
     * Selection to go back to landing splash
     */
      
    @FXML
    private void goHome(ActionEvent event) throws IOException{
        System.out.println("Home");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));
        levelSelect.getChildren().setAll(pane);
    }
    
    /**
     * Selection to go to level one
     * Throws level selection error if something goes wrong
     */
    @FXML
    private void selectLevel(int level) throws IOException{
        switch(level){
            case 1: 
                //Select lvl 1
                System.out.println("Level 1");
                //AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/LevelOne.fxml"));
                //levelSelect.getChildren().setAll(pane);
                one.start();
                break;
            case 2:
                //Select lvl 2
                System.out.println("Level 2");
                two.start();
                break;
            case 3:
                //Select lvl 3
                System.out.println("Level 3");
                three.start();
                break;
            default:
                //Select Level err
                System.err.println("Level Select Error");
                break;
        }
    }

    /**
     * Initializes the controller class.
     */
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvlOne.setOnAction(e -> {
            try {
                selectLevel(1);
            } catch (IOException ex) {
                Logger.getLogger(LevelSelectController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        lvlTwo.setOnAction(e -> {
            try {
                selectLevel(2);
            } catch (IOException ex) {
                Logger.getLogger(LevelSelectController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        lvlThree.setOnAction(e -> {
            try {
                selectLevel(3);
            } catch (IOException ex) {
                Logger.getLogger(LevelSelectController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    
}
