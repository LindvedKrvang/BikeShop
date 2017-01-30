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

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
public class ListCellController implements Initializable {

    @FXML
    private Label lblBikeType;
    @FXML
    private Label lblBikeSeller;
    @FXML
    private Label lblBikePrice;
    
    private BikeModel model;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /**
     * Binds the parsed model to the fxml.
     * @param model 
     */
    public void setBikeModel(BikeModel model){
        this.model = model;
        lblBikeType.textProperty().bind(model.typeProperty());
        lblBikeType.requestLayout();
        lblBikeSeller.textProperty().bind(model.sellerProperty());
        lblBikeSeller.requestLayout();
        lblBikePrice.textProperty().bind(model.priceProperty().asString());
        lblBikePrice.requestLayout();
    }
}
