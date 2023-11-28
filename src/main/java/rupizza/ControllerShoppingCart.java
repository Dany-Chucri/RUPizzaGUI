package rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.NumberFormat;

/**
 * The ControllerShoppingCart class controls the user interface for the current order cart.
 * It allows view current pizzas being ordered, as well as their price, and to remove pizzas or place an order.
 * @author Dany Chucri, Madhur Nutulapati
 */
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

    /**
     * Initializes the controller by creating an Order object.
     */
    public void initialize() {
        pizzaListArr = FXCollections.observableArrayList();
        pizzaList.setItems(pizzaListArr);
        shoppingCart = new Order();
    }

    /**
     * Sets the reference to the main controller.
     *
     * @param controller The main controller to be referenced.
     */
    public void setMainController (ControllerMainMenu controller){
        mainController = controller;
    }

    /**
     * Sets a reference to the shopping cart.
     * @param storeOrdersController the store ordedrs controller to be referenced.
     */
    public void setStoreOrdersController(ControllerStoreOrders storeOrdersController) {
        this.storeOrdersController = storeOrdersController;
    }

    /**
     * Retrieves a shopping cart.
     * @return Order object representing the shopping cart
     */
    public Order getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Adds a pizza to the current order.
     * @param pizza The pizza be added.
     */
    public void addPizza(Pizza pizza) {
        shoppingCart.addPizza(pizza);
        pizzaList.getItems().add(pizza);
        updatePrices();
    }

    /**
     * Adds a pizza to the current order.
     * @param pizza The pizza be removed.
     */
    public void removePizza(Pizza pizza) {
        shoppingCart.removePizza(pizza);
        pizzaList.getItems().remove(pizza);
        updatePrices();
    }

    /**
     * Updates the prices in the shopping cart.
     */
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

    /**
     * Removes a pizza from the shopping cart.
     */
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

    /**
     * Places an order based on the info in the shopping cart.
     */
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

    /**
     * Clears the shopping cart of all pizzas
     */
    private void clearCart(){
        for (Pizza pizza : shoppingCart.getPizzas()) {
            shoppingCart.removePizza(pizza);
        }
        updatePrices();
        pizzaListArr.clear();
        orderNumber.setText("" + shoppingCart.getOrderNumber());
    }
}
