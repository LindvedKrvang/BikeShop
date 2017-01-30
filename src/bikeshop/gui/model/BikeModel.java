/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikeshop.gui.model;

import bikeshop.be.Bike;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Rasmus
 */
public class BikeModel {
    
    private final StringProperty type = new SimpleStringProperty();
    private final StringProperty seller = new SimpleStringProperty();
    private final DoubleProperty price = new SimpleDoubleProperty();
    
    private Bike bike;
    
    public BikeModel(Bike bike){
        this.bike = bike;
        type.set(bike.getType());
        seller.set(bike.getSeller());
        price.set(bike.getPrice());
    }
    
    /**
     * Gets the bike.
     * @return 
     */
    public Bike getBike() {
        return bike;
    }
    
    /**
     * Sets the bike.
     * @param bike 
     */
    public void setBike(Bike bike) {
        this.bike = bike;
    }
    
    /**
     * Gets the property of type.
     * @return 
     */
    public StringProperty typeProperty(){
        return type;
    }
    
    /**
     * Gets the property of seller.
     * @return 
     */
    public StringProperty sellerProperty(){
        return seller;
    }
    
    /**
     * Gets the propert of price.
     * @return 
     */
    public DoubleProperty priceProperty(){
        return price;
    }
    
    /**
     * Gets the type.
     * @return 
     */
    public String getType(){
        return type.get();
    }
    
    /**
     * Gets the seller.
     * @return 
     */
    public String getSeller(){
        return seller.get();
    }
    
    /**
     * Gets the price.
     * @return 
     */
    public double getPrice(){
        return price.get();
    }
    
    /**
     * Sets the type.
     * @param value 
     */
    public void setTyp(String value){
        type.set(value);
        bike.setType(value);
    }
    
    /**
     * Sets the seller.
     * @param value 
     */
    public void setSeller(String value){
        seller.set(value);
        bike.setSeller(value);
    }
    
    /**
     * Sets the price.
     * @param value 
     */
    public void setPrice(double value){
        price.set(value);
        bike.setPrice(value);
    }
}
