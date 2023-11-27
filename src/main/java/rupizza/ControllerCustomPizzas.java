package rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.text.NumberFormat;
import java.util.List;

public class ControllerCustomPizzas {

    private ControllerMainMenu mainController;
    private ObservableList<String> sizeList;
    private ObservableList<String> additionalToppingsList;
    private ObservableList<String> selectedToppingsList;

    protected Pizza pizza;

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
        selectedToppingsList = FXCollections.observableArrayList();
        sizeChooser.setItems(sizeList);
        additionalToppings.setItems(additionalToppingsList);
        selectedToppings.setItems(selectedToppingsList);
        pizza = PizzaMaker.createPizza("buildyourown");
    }

    //Get the reference to the MainController object
    public void setMainController (ControllerMainMenu controller){
        mainController = controller;
    }

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

    @FXML
    void selectTomato() {
        pizza.setSauce("tomato");
        totalPrice.clear();
        NumberFormat.getCurrencyInstance().format(pizza.price());
        totalPrice.appendText(NumberFormat.getCurrencyInstance().format(pizza.price()));
    }

    @FXML
    void selectAlfredo() {
        pizza.setSauce("alfredo");
        totalPrice.clear();
        NumberFormat.getCurrencyInstance().format(pizza.price());
        totalPrice.appendText(NumberFormat.getCurrencyInstance().format(pizza.price()));
    }

    @FXML
    void setExtra() {
        pizza.setExtraSauce(extraSauce.isSelected());
        pizza.setExtraCheese(extraCheese.isSelected());
        totalPrice.clear();
        NumberFormat.getCurrencyInstance().format(pizza.price());
        totalPrice.appendText(NumberFormat.getCurrencyInstance().format(pizza.price()));
    }

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
}
