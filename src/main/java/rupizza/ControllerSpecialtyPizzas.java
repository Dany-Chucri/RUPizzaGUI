package rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.NumberFormat;
import java.util.List;

/**
 * The ControllerSpecialtyPizzas class controls the user interface for selecting and customizing specialty pizzas.
 * It allows users to choose a specialty pizza, view its image, toppings, and customize its size, sauce, and extras.
 * @author Dany Chucri, Madhur Nutulapati
 */
public class ControllerSpecialtyPizzas {
    private ControllerMainMenu mainController;
    private ObservableList<String> specialtyList;
    private ObservableList<String> toppingsList;
    private ControllerShoppingCart cartController;

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

    /**
     * Initializes the controller by setting up the specialty and toppings lists.
     * Sets the initial values for the total price and sauce.
     */
    public void initialize() {
        specialtyList = FXCollections.observableArrayList("Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni");
        toppingsList = FXCollections.observableArrayList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom");
        specialtyChooser.setItems(specialtyList);
        toppings.setItems(toppingsList);
        totalPrice.appendText("$16.99");
        sauce.appendText("Tomato");
    }

    /**
     * Sets the reference to the main controller.
     *
     * @param controller The main controller to be referenced.
     */
    public void setMainController (ControllerMainMenu controller){
        mainController = controller;
    }

    public void setCartController(ControllerShoppingCart controller) {
        cartController = controller;
    }

    /**
     * Sets the image of the selected specialty pizza.
     *
     * @param selected The name of the selected specialty pizza.
     */
    private void setSpecialtyImage(String selected) {
        switch (selected) {
            case "Deluxe":
                specialtyImage.setImage(new Image(getClass().getResourceAsStream("deluxepizza.png")));
                break;
            case "Supreme":
                specialtyImage.setImage(new Image(getClass().getResourceAsStream("supremepizza.jpg")));
                break;
            case "Meatzza":
                specialtyImage.setImage(new Image(getClass().getResourceAsStream("meatzza.jpg")));
                break;
            case "Seafood":
                specialtyImage.setImage(new Image(getClass().getResourceAsStream("seafoodpizza.jpg")));
                break;
            case "Pepperoni":
                specialtyImage.setImage(new Image(getClass().getResourceAsStream("pepperonipizza.jpg")));
        }
    }

    /**
     * Builds a specialty pizza based on user selections and displays its details.
     *
     * @return The created specialty pizza.
     */
    private Pizza buildSpecialty() {
        String selected = specialtyChooser.getSelectionModel().getSelectedItem();
        setSpecialtyImage(selected);
        Pizza pizza = PizzaMaker.createPizza(selected);
        RadioButton selectedRadioButton = (RadioButton) specialtySize.getSelectedToggle();
        pizza.setSize(selectedRadioButton.getText());
        pizza.setExtraSauce(extraSauce.isSelected());
        pizza.setExtraCheese(extraCheese.isSelected());

        totalPrice.clear();
        sauce.clear();
        toppings.setItems(FXCollections.observableList((List) pizza.toppings));
        NumberFormat.getCurrencyInstance().format(pizza.price());
        totalPrice.appendText(NumberFormat.getCurrencyInstance().format(pizza.price()));
        sauce.appendText(pizza.sauce.toString());

        return pizza;
    }

    /**
     * Handles the selection of a specialty pizza.
     * Builds and displays the selected specialty pizza details.
     */
    @FXML
    void selectSpecialty() {
        buildSpecialty();
    }

    private void handleAddErrors() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Cannot Add Pizza");
        alert.setHeaderText("There was an error in adding this pizza.");
        alert.setContentText("Please try again.");
        alert.showAndWait();
    }

    @FXML
    void addPizza() {
        try {
            Pizza pizza = buildSpecialty();
            cartController.addPizza(pizza);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pizza Added");
            alert.setHeaderText("The follow pizza has been added to your cart:");
            alert.setContentText(pizza.toString());
            alert.showAndWait();
        } catch (Exception e) {
            handleAddErrors();
        }
    }
}
