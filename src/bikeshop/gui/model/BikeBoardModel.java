/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikeshop.gui.model;

import bikeshop.be.Bike;
import bikeshop.bll.BikeManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Rasmus
 */
public class BikeBoardModel {
    
    private final ObservableList<BikeModel> BIKES_FOR_SALE;   
    private final BikeManager BIKE_MANAGER = new BikeManager();
    
    public BikeBoardModel(){
        BIKES_FOR_SALE = FXCollections.observableArrayList();
        getAllBikes();
    }
    
    /**
     * Calls the BikeManager and gets all the bikes and puts it in an ObservableList.
     */
    private void getAllBikes() {
        for(Bike bike : BIKE_MANAGER.getBikes()){
            BIKES_FOR_SALE.add(new BikeModel(bike));
        }
    }
    
    /**
     * Gets the observable list with all the bikeModels.
     * @return 
     */
    public ObservableList<BikeModel> getObservableBikes(){
        return BIKES_FOR_SALE;
    }
}
