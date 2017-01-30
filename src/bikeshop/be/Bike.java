/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikeshop.be;

/**
 *
 * @author Rasmus
 */
public class Bike {
    private String seller = "Mr. Robot";
    private String type = "Mountain Bike";
    private double price;

    public Bike(String seller, String type, double price) {
        this.seller = seller;
        this.type = type;
        this.price = price;
    }
    
    public Bike(){
        
    }
    
    /**
     * Gets the seller.
     * @return 
     */
    public String getSeller() {
        return seller;
    }
    
    /**
     * Gets the type.
     * @return 
     */
    public String getType() {
        return type;
    }
    
    /**
     * Gets the price.
     * @return 
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Sets the seller.
     * @param seller 
     */
    public void setSeller(String seller) {
        this.seller = seller;
    }
    
    /**
     * Sets the type.
     * @param type 
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * Sets the price.
     * @param price 
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
