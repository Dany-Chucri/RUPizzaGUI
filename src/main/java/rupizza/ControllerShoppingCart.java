package rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControllerShoppingCart {
    private ControllerMainMenu mainController;
    private ObservableList<String> pizzaListArr;

    @FXML
    private ListView<String> pizzaList;

    @FXML
    private TextField subtotal, salesTax, orderTotal, orderNumber;

    @FXML
    private Button removePizza, placeOrder;

    public void initialize() {
        pizzaListArr = FXCollections.observableArrayList("Here would be the toString() version of a given pizza object, but for now we will use this sample text space to fill up the text area as a part of testing.");
        pizzaList.setItems(pizzaListArr);
    }

    //Get the reference to the MainController object
    public void setMainController (ControllerMainMenu controller){
        mainController = controller;
    }
}
