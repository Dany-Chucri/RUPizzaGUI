package rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControllerShoppingCart {
    private ControllerMainMenu mainController;
    private ObservableList<String> pizzaListArr;

    @FXML
    private ListView<String> pizzaList;

    @FXML
    private TextField subtotal, salesTax, orderTotal, orderNumber;

    @FXML
    private Button removePizza, placeOrder;
    @FXML
    private StoreOrders storeOrders;

    public void initialize() {
        pizzaListArr = FXCollections.observableArrayList("Here would be the toString() version of a given pizza object, but for now we will use this sample text space to fill up the text area as a part of testing.");
        pizzaList.setItems(pizzaListArr);
    }

    //Get the reference to the MainController object
    public void setMainController (ControllerMainMenu controller){
        mainController = controller;
    }

    @FXML
    private void handleRemovePizza() {
        String selectedPizza = pizzaList.getSelectionModel().getSelectedItem();
        if(selectedPizza!=null){
            pizzaListArr.remove(selectedPizza);
            updateTotals();
        }
        else{
            //No pizza selected for removal
        }
    }
    @FXML
    private void handlePlaceOrder() {
        if(!pizzaListArr.isEmpty()){
            Order order = new Order(nextOrderNumber(), new ArrayList<>());

            mainController.getStoreOrdersController().getStoreOrders().addOrder(order);

            storeOrders.addOrder(order);

            //update order number //!!


            //"Order placed successfully!

            clearCart();
        }
        else{
            //Your shopping cart is empty"
        }
    }
    private int nextOrderNumber() {
        return storeOrders.getNextAvailableOrderNum();
    }
    private void updateTotals(){
        //update - sales tax,subtotal,order total.
        double subtotalVal = 0.00;

        List<Pizza> pizzaListArr = getPizzasInOrder();

        for (Pizza pizza : pizzaListArr) {
            // Assuming each pizza has a price() method
            subtotalVal += pizza.price();
        }

        double salesTaxVal = .06625 * subtotalVal;
        double grandTotal = subtotalVal + salesTaxVal;

        subtotal.setText(String.format("%.2f", subtotalVal));
        salesTax.setText(String.format("%.2f", salesTaxVal));
        orderTotal.setText(String.format("%.2f", grandTotal));
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
        pizzaListArr.clear();
        updateTotals();
    }
}
