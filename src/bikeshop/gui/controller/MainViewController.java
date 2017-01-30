/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikeshop.gui.controller;

import bikeshop.gui.model.BikeBoardModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Rasmus
 */
public class MainViewController implements Initializable {    
    
    @FXML
    private BorderPane borderPane;
    
    private BikeBoardModel bikeBoardModel;
    
    public  MainViewController(){
        bikeBoardModel = new BikeBoardModel();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            borderPane.setCenter(getListView());
        } catch (IOException ex) {
            
        }
    }    

    private Node getListView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bikeshop/gui/view/ListOfBikes.fxml"));
        Node node = loader.load();
        ListOfBikesController controller = loader.getController();
        controller.setBikeBoardModel(bikeBoardModel);
        return node;
    }
    
}
