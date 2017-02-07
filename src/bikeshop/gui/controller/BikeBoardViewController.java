/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikeshop.gui.controller;

import bikeshop.gui.model.BikeBoardModel;
import bikeshop.gui.model.BikeModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
public class BikeBoardViewController implements Initializable, ListChangeListener<BikeModel> {

    @FXML
    private FlowPane bikeBoard;
    
    @FXML
    private ScrollPane containerForBikeBoard;
    
    private BikeBoardModel model;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Binds the width of the flowPane to the width of the scrollPane.
        bikeBoard.prefWidthProperty().bind(containerForBikeBoard.widthProperty());
    }
    
    /**
     * Sets the model and ChangeListener to it.
     * @param model 
     */
    public void setModel(BikeBoardModel model){
        this.model = model;
        model.getObservableBikes().addListener(this);
    }

    @Override
    public void onChanged(Change<? extends BikeModel> c) {
        while(c.next()){
            if(c.wasAdded()){
                addNewBikeView(c);
            }
        }
    }

    private void addNewBikeView(Change<? extends BikeModel> c) {
        for(BikeModel model : c.getAddedSubList()){
            try {
                bikeBoard.getChildren().add(getPictureListCellView(model));
            } catch (IOException ex) {
                System.out.println("BAD PRACTICE\n" + ex.getMessage());
            }
        }
    }
    
    /**
     * Creates a node of the bike and sets its model.
     * @param model
     * @return
     * @throws IOException 
     */
    private Node getPictureListCellView(BikeModel model) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bikeshop/gui/view/PictureListCellBikeView.fxml"));
        BorderPane bike = loader.load();
        PictureListCellBikeViewController controller = loader.getController();
        controller.setModel(model);
        return bike;
    }
    
    /**
     * Adds all the bikes to the flowPane.
     */
    public void addBikes(){
        for(BikeModel bikeModel : model.getObservableBikes()){
            try {
                bikeBoard.getChildren().add(getPictureListCellView(bikeModel));
            } catch (IOException ex) {
                System.out.println("BAD BEHAVIOUR");
            }
        }
    }
}
