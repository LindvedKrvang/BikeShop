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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
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
    
    private Node LIST_VIEW;
    private Node BIKE_BOARD_VIEW;
    
    private BikeBoardModel bikeBoardModel;
    
    private boolean inListView;
    
    public  MainViewController(){
        bikeBoardModel = new BikeBoardModel();
        inListView = true;
            
        try {            
            LIST_VIEW = createListView();
            BIKE_BOARD_VIEW = createBikeBoardView();
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            borderPane.setCenter(LIST_VIEW);
    }    

    private Node createListView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bikeshop/gui/view/ListOfBikes.fxml"));
        Node node = loader.load();
        ListOfBikesController controller = loader.getController();
        controller.setBikeBoardModel(bikeBoardModel);
        return node;
    }

    @FXML
    private void handleSwitchViewButton(ActionEvent event) throws IOException {
        if(inListView){
            borderPane.setCenter(BIKE_BOARD_VIEW);
            inListView = false;
        }else{
            borderPane.setCenter(LIST_VIEW);
            inListView = true;
        }
    }
    
    /**
     * 
     * @return
     * @throws IOException 
     */
    private Node createBikeBoardView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bikeshop/gui/view/BikeBoardView.fxml"));
        Node node = loader.load();
        BikeBoardViewController controller = loader.getController();
        controller.setModel(bikeBoardModel);
        controller.addBikes();
        return node;
    }
    
}
