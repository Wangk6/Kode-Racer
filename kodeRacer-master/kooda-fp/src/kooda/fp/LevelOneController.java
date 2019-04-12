/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kooda.fp;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


public class LevelOneController extends Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //use the init method to set the sequence of each level
        setSequence(0 , "left");
        System.out.println(Arrays.toString(getSequence()));
    }    
    
}
