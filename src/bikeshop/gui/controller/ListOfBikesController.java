/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikeshop.gui.controller;

import bikeshop.gui.controls.BikeListCell;
import bikeshop.gui.model.BikeBoardModel;
import bikeshop.gui.model.BikeModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
public class ListOfBikesController implements Initializable {

    @FXML
    private ListView<BikeModel> lstvList;

    private BikeBoardModel bikeBoardModel;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setCellFactory();
        setMouseListener();
    }
    
    /**
     * Sets the model and add the items to the list.
     * @param model 
     */
    public void setBikeBoardModel(BikeBoardModel model) {
        bikeBoardModel = model;
        lstvList.setItems(model.getObservableBikes());
    }
    
    /**
     * Creates a modal that displays the info of the parsed BikeModel.
     * @param bike
     * @throws IOException 
     */
    private void showBike(BikeModel bike) throws IOException {
        Stage primStage = (Stage) lstvList.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bikeshop/gui/view/ListCellBike.fxml"));
        Parent root = loader.load();
        
        ListCellController controller = loader.getController();
        controller.setBikeModel(bike);
        
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primStage);
        stage.show();
    }
    
    /**
     * Sets a onMouseClickListener that listen for double clicks.
     */
    private void setMouseListener() {
        lstvList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    try {
                        showBike(lstvList.getSelectionModel().getSelectedItem());
                    } catch (IOException ex) {
                        
                    }
                }
            }
        });
    }
    
    /**
     * Sets the cellFactory.
     */
    private void setCellFactory() {
        lstvList.setCellFactory(new Callback<ListView<BikeModel>, ListCell<BikeModel>>() {
            @Override
            public ListCell<BikeModel> call(ListView<BikeModel> param) {
                BikeListCell<BikeModel> cell = new BikeListCell();
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/bikeshop/gui/view/ListCellBike.fxml"));
                    Node node = loader.load();
                    ListCellController controller = loader.getController();
                    cell.setController(controller);
                    cell.setView(node);
                    cell.setGraphic(node);
                    return cell;
                } catch (IOException ex) {

                }
                return cell;
            }
        });
    }
}
