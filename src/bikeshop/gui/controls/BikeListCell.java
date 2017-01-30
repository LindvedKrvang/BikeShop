/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikeshop.gui.controls;

import bikeshop.gui.controller.ListCellController;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

/**
 *
 * @author Rasmus
 */
public class BikeListCell<BikeModel> extends ListCell<BikeModel> {
    
    private Node view;
    
    private ListCellController controller;
    
    public BikeListCell(){        
    }
    
    /**
     * Updates the list cell to its newly set item. 
     * This is the important stuff.
     * @param item
     * @param empty 
     */
    @Override
    protected void updateItem(BikeModel item, boolean empty) {
        super.updateItem(item, empty);
        if(empty){
            setGraphic(null);
        }else{
            controller.setBikeModel((bikeshop.gui.model.BikeModel) item);
            setGraphic(view);
        }
    }    
    
    /**
     * Set the controller for this ListCell.
     * @param controller 
     */
    public void setController(ListCellController controller){
        this.controller = controller;
    }
    
    /**
     * Sets the view to display this ListCell.
     * @param view 
     */
    public void setView(Node view){
        this.view = view;
    }
}
