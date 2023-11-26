package rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class ControllerSpecialtyPizzas {

    private ControllerMainMenu mainController;
    private ObservableList<String> specialtyList;
    private ObservableList<String> toppingsList;

    @FXML
    private ImageView specialtyImage;

    @FXML
    private ComboBox<String> specialtyChooser;

    @FXML
    private ListView<String> toppings;

    @FXML
    private TextField sauce, totalPrice;

    @FXML
    private CheckBox extraSauce, extraCheese;

    @FXML
    private ToggleGroup specialtySize;

    @FXML
    private RadioButton small, medium, large;

    @FXML
    private Button addToOrder;

    public void initialize() {
        specialtyList = FXCollections.observableArrayList("Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni");
        toppingsList = FXCollections.observableArrayList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom");
        specialtyChooser.setItems(specialtyList);
        toppings.setItems(toppingsList);
    }

    //Get the reference to the MainController object
    public void setMainController (ControllerMainMenu controller){
        mainController = controller;
    }
}
