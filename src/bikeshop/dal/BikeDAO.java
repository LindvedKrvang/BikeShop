/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikeshop.dal;

import bikeshop.be.Bike;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Rasmus
 */
public class BikeDAO {
    private final int PRICE_INTERVAL = 2500;
    private final int LOW_PRICE = 50;
    
    /**
     * Creates a list with 100 bikes with random prices and returns it.
     * @return 
     */
    public ArrayList<Bike> getBikes(){
        ArrayList<Bike> bikes = new ArrayList();
        Random rand = new Random();
        
        for(int i = 0; i < 100; i++){
            Bike b = new Bike();
            b.setSeller(b.getSeller() + "_" + i);
            b.setPrice(PRICE_INTERVAL + LOW_PRICE * rand.nextDouble());
            bikes.add(b);
        }
        
        return bikes;
    }
}
