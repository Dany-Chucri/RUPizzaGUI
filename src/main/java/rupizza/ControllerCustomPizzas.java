package rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.text.NumberFormat;
import java.util.List;
/**
 * The ControllerCustomPizzas class controls the user interface for creating custom pizzas.
 * It allows users to select pizza size, sauce type, toppings, and view the total price.
 * @author Dany Chucri, Madhur Nutulapati
 */
public class ControllerCustomPizzas {

    private ControllerMainMenu mainController;
    private ControllerShoppingCart cartController;
    private ObservableList<String> sizeList;
    private ObservableList<String> additionalToppingsList;
    private ObservableList<String> selectedToppingsList;

    private Pizza pizza;

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

    /**
     * Initializes the controller by setting up the lists and creating a new build-your-own pizza.
     */
    public void initialize() {
        sizeList = FXCollections.observableArrayList("Small", "Medium", "Large");
        additionalToppingsList = FXCollections.observableArrayList("Sausage", "Chicken", "Beef", "Ham", "Pepperoni", "Shrimp", "Squid", "Crab Meats", "Mushroom", "Green Pepper", "Pineapple", "Black Olive", "Onion");
        selectedToppingsList = FXCollections.observableArrayList();
        sizeChooser.setItems(sizeList);
        additionalToppings.setItems(additionalToppingsList);
        selectedToppings.setItems(selectedToppingsList);
        pizza = PizzaMaker.createPizza("buildyourown");
    }

    /**
     * Sets the reference to the main controller.
     *
     * @param controller The main controller to be referenced.
     */
    public void setMainController (ControllerMainMenu controller){
        mainController = controller;
    }

    public void setCartController (ControllerShoppingCart controller) {
        cartController = controller;
    }

    /**
     * Handles the selection of pizza size.
     * Enables/disables relevant controls and updates the pizza size.
     */
    @FXML
    void selectSize() {
        tomatoSauce.setDisable(false);
        alfredoSauce.setDisable(false);
        extraSauce.setDisable(false);
        extraCheese.setDisable(false);

        String size = sizeChooser.getSelectionModel().getSelectedItem();
        pizza.setSize(size);
        pizza.setExtraSauce(extraSauce.isSelected());
        pizza.setExtraCheese(extraCheese.isSelected());

        totalPrice.clear();
        NumberFormat.getCurrencyInstance().format(pizza.price());
        totalPrice.appendText(NumberFormat.getCurrencyInstance().format(pizza.price()));

        addTopping.setDisable(false);
        removeTopping.setDisable(false);
    }

    /**
     * Handles the selection of tomato sauce.
     * Updates the pizza sauce type and total price.
     */
    @FXML
    void selectTomato() {
        pizza.setSauce("tomato");
        totalPrice.clear();
        NumberFormat.getCurrencyInstance().format(pizza.price());
        totalPrice.appendText(NumberFormat.getCurrencyInstance().format(pizza.price()));
    }

    /**
     * Handles the selection of alfredo sauce.
     * Updates the pizza sauce type and total price.
     */
    @FXML
    void selectAlfredo() {
        pizza.setSauce("alfredo");
        totalPrice.clear();
        NumberFormat.getCurrencyInstance().format(pizza.price());
        totalPrice.appendText(NumberFormat.getCurrencyInstance().format(pizza.price()));
    }

    /**
     * Handles the selection of extra sauce/cheese.
     * Updates the pizza's extra sauce/cheese status and total price.
     */
    @FXML
    void setExtra() {
        pizza.setExtraSauce(extraSauce.isSelected());
        pizza.setExtraCheese(extraCheese.isSelected());
        totalPrice.clear();
        NumberFormat.getCurrencyInstance().format(pizza.price());
        totalPrice.appendText(NumberFormat.getCurrencyInstance().format(pizza.price()));
    }

    /**
     * Handles the selection of additional toppings.
     * Adds the selected topping to the pizza and updates the lists and total price.
     */
    @FXML
    void selectTopping() {
        if (additionalToppings.getItems().isEmpty() || additionalToppings.getItems().size() == Pizza.MAX_TOPPINGS-1) return;
        if (additionalToppings.getSelectionModel().getSelectedItem() == null) return;
        String selected = additionalToppings.getSelectionModel().getSelectedItem();
        pizza.addTopping(selected);
        int selectedIndex = additionalToppings.getSelectionModel().getSelectedIndex();
        additionalToppings.getItems().remove(selectedIndex);
        selectedToppings.getItems().add(selected);

        totalPrice.clear();
        NumberFormat.getCurrencyInstance().format(pizza.price());
        totalPrice.appendText(NumberFormat.getCurrencyInstance().format(pizza.price()));
    }

    /**
     * Handles the deselection of selected toppings.
     * Removes the selected topping from the pizza and updates the lists and total price.
     */
    @FXML
    void deselectTopping() {
        if (pizza.toppings.isEmpty()) return;
        if (selectedToppings.getSelectionModel().getSelectedItem() == null) return;
        String selected = selectedToppings.getSelectionModel().getSelectedItem();
        pizza.removeTopping(selected);
        int selectedIndex = selectedToppings.getSelectionModel().getSelectedIndex();
        selectedToppings.getItems().remove(selectedIndex);
        additionalToppings.getItems().add(selected);

        totalPrice.clear();
        NumberFormat.getCurrencyInstance().format(pizza.price());
        totalPrice.appendText(NumberFormat.getCurrencyInstance().format(pizza.price()));
    }

    /**
     *
     * @return
     */
    private int handleAddErrors() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Cannot Add Pizza");
        if (sizeChooser.getSelectionModel().getSelectedItem() == null) {
            alert.setHeaderText("You have not selected a size.");
            alert.setContentText("Please select a size before adding your pizza.");
            alert.showAndWait();
            return -1;
        }
        if(!(tomatoSauce.isSelected() || alfredoSauce.isSelected())) {
            alert.setHeaderText("You have not selected a sauce.");
            alert.setContentText("Please select a sauce before adding your pizza.");
            alert.showAndWait();
            return -1;
        }
        if (pizza.toppings.size() < 3) {
            alert.setHeaderText("You have not selected at least 3 toppings.");
            alert.setContentText("Please select at least 3 toppings before adding your pizza.");
            alert.showAndWait();
            return -1;
        }
        return 0;
    }


    @FXML
    void addPizza() {
        try {
            if (handleAddErrors() != 0) return;
            Pizza newPizza = PizzaMaker.createPizza("buildyourown");
            newPizza.copyPizza(pizza);
            cartController.addPizza(newPizza);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pizza Added");
            alert.setHeaderText("The follow pizza has been added to your cart:");
            alert.setContentText(pizza.toString());
            alert.showAndWait();
        }
        catch (Exception e) {
            handleAddErrors();
        }
    }
}
