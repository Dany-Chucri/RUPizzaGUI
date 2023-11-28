package rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControllerShoppingCart {
    private ControllerMainMenu mainController;
    private ObservableList<Pizza> pizzaListArr;
    private ControllerStoreOrders storeOrdersController;
    private Order shoppingCart;

    @FXML
    private ListView<Pizza> pizzaList;

    @FXML
    private TextField subtotal, salesTax, orderTotal, orderNumber;

    @FXML
    private Button removePizza, placeOrder;

    public void initialize() {
        pizzaListArr = FXCollections.observableArrayList();
        pizzaList.setItems(pizzaListArr);
        shoppingCart = new Order();
    }

    //Get the reference to the MainController object
    public void setMainController (ControllerMainMenu controller){
        mainController = controller;
    }

    public void setStoreOrdersController(ControllerStoreOrders storeOrdersController) {
        this.storeOrdersController = storeOrdersController;
    }

    public Order getShoppingCart() {
        return shoppingCart;
    }

    public void addPizza(Pizza pizza) {
        shoppingCart.addPizza(pizza);
        pizzaList.getItems().add(pizza);
        updatePrices();
    }

    public void removePizza(Pizza pizza) {
        shoppingCart.removePizza(pizza);
        pizzaList.getItems().remove(pizza);
        updatePrices();
    }

    public void updatePrices() {
        double total = 0;
        for (Pizza pizza : shoppingCart.getPizzas()){
            total += pizza.price();
        }
        double taxAmount = (total * Pizza.SALES_TAX) - total;
        double totalPrice = total+ taxAmount;

        NumberFormat.getCurrencyInstance().format(total);
        subtotal.setText(NumberFormat.getCurrencyInstance().format(total));
        NumberFormat.getCurrencyInstance().format(taxAmount);
        salesTax.setText(NumberFormat.getCurrencyInstance().format(taxAmount));
        NumberFormat.getCurrencyInstance().format(totalPrice);
        orderTotal.setText(NumberFormat.getCurrencyInstance().format(totalPrice));
    }

    @FXML
    private void handleRemovePizza() {
        try {
            Pizza selectedPizza = pizzaList.getSelectionModel().getSelectedItem();
            removePizza(selectedPizza);
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Removal Error");
            alert.setHeaderText("Could not remove selected pizza, if any.");
            alert.setContentText("Please try again.");
            alert.showAndWait();
        }

    }

    @FXML
    private void handlePlaceOrder() {
        try {
            Order newOrder = new Order();
            newOrder.copyOrder(shoppingCart);
            storeOrdersController.addCartOrder(newOrder);

            shoppingCart.setOrderNumber(storeOrdersController.getStoreOrders().getNextAvailableOrderNum());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Info");
            alert.setHeaderText("Order Placed!");
            alert.setContentText("The store has received your order.");
            alert.showAndWait();
            clearCart();

        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Purchase error");
            alert.setHeaderText("Could not place order.");
            alert.setContentText("Please try again after checking your information.");
            alert.showAndWait();
        }
    }

    private List<Pizza> getPizzasInOrder() {
        List<String> pizzaTypes = Arrays.asList("Deluxe", "Supreme", "Pepperoni", "BuildYourOwn", "Meatzza", "Seafood");
        List<Pizza> pizzaListArr = new ArrayList<>();
        for (String pizzaType : pizzaTypes) {
            Pizza pizza = PizzaMaker.createPizza(pizzaType);
            pizzaListArr.add(pizza);
        }
        return pizzaListArr;
    }

    private void clearCart(){
        for (Pizza pizza : shoppingCart.getPizzas()) {
            shoppingCart.removePizza(pizza);
        }
        updatePrices();
        pizzaListArr.clear();
        orderNumber.setText("" + shoppingCart.getOrderNumber());
    }
}
