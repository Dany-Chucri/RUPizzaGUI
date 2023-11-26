package rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControllerStoreOrders {

    private ControllerMainMenu mainController;
    private ObservableList<String> pizzaListArr;
    private ObservableList<String> orderNumbers;

    @FXML
    private ListView<String> pizzaList;

    @FXML ComboBox<String> orderNumber;

    @FXML
    private TextField orderTotal;

    @FXML
    private Button cancelOrder, exportOrders;

    public void initialize() {
        pizzaListArr = FXCollections.observableArrayList("Here would be the toString() version of a given pizza object, but for now we will use this sample text space to fill up the text area as a part of testing.");
        orderNumbers = FXCollections.observableArrayList("1", "2", "3");
        pizzaList.setItems(pizzaListArr);
        orderNumber.setItems(orderNumbers);
    }

    //Get the reference to the MainController object
    public void setMainController (ControllerMainMenu controller){
        mainController = controller;
    }
}
