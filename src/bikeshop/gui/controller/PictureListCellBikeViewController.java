/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikeshop.gui.controller;

import bikeshop.gui.model.BikeModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
public class PictureListCellBikeViewController implements Initializable {

    @FXML
    private Label lblBikeType;
    @FXML
    private Label lblBikeSeller;
    @FXML
    private Label lblBikePrice;
    
    private BikeModel model;
    @FXML
    private ImageView image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    /**
     * Sets the model and binds the properties.
     * @param model 
     */
    public void setModel(BikeModel model){
        this.model = model;
        lblBikeType.textProperty().bind(model.typeProperty());
        lblBikeSeller.textProperty().bind(model.sellerProperty());
        lblBikePrice.textProperty().bind(model.priceProperty().asString());
    }
    
    /**
     * Gets the model.
     * @return 
     */
    public BikeModel getModel(){
        return model;
    }
}
