/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikeshop.bll;

import bikeshop.be.Bike;
import bikeshop.dal.BikeDAO;
import java.util.ArrayList;

/**
 *
 * @author Rasmus
 */
public class BikeManager {
    private final BikeDAO BIKE_DAO = new BikeDAO();
    
    /**
     * Calls the BikeDAO and returns a list of 100 bikes.
     * @return 
     */
    public ArrayList<Bike> getBikes(){
        return BIKE_DAO.getBikes();
    }
}
