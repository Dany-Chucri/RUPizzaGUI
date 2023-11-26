package rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class ControllerCustomPizzas {

    private ControllerMainMenu mainController;
    private ObservableList<String> sizeList;
    private ObservableList<String> additionalToppingsList;
    private ObservableList<String> selectedToppingsList;

    @FXML
    private ComboBox<String> sizeChooser;

    @FXML
    private ListView<String> additionalToppings, selectedToppings;

    @FXML
    private TextField totalPrice;

    @FXML
    private CheckBox extraSauce, extraCheese;

    @FXML
    private RadioButton tomatoSauce, alfredoSauce;

    @FXML
    private ToggleGroup sauceType;

    @FXML
    private Button addTopping, removeTopping, addToOrder;

    public void initialize() {
        sizeList = FXCollections.observableArrayList("Small", "Medium", "Large");
        additionalToppingsList = FXCollections.observableArrayList("Sausage", "Chicken", "Beef", "Ham", "Pepperoni", "Shrimp", "Squid", "Crab Meats", "Mushroom", "Green Pepper", "Pineapple", "Black Olive", "Onion");
        selectedToppingsList = FXCollections.observableArrayList("");
        sizeChooser.setItems(sizeList);
        additionalToppings.setItems(additionalToppingsList);
        selectedToppings.setItems(selectedToppingsList);
    }

    //Get the reference to the MainController object
    public void setMainController (ControllerMainMenu controller){
        mainController = controller;
    }
}
