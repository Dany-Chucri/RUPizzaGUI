package rupizza;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The Order object that represents a cart of pizzas.
 * @author Dany Chucri, Madhur Nutulapati
 */
public class Order {
    private int orderNumber;
    private ArrayList<Pizza> pizzas;

    /**
     * Instantiates an Order object.
     */
    public Order(){
        this.orderNumber = 1;
        pizzas = new ArrayList<Pizza>();
    }

    /**
     * Retreieves the order number.
     * @return Number of the order.
     */
    public int getOrderNumber(){
        return this.orderNumber;
    }

    /**
     * Retrieves the list of pizzas in the order.
     * @return An ArrayList of pizzas.
     */
    public List<Pizza> getPizzas(){
        return new ArrayList<>(pizzas);
    }

    /**
     * Adds a pizza to the order.
     * @param pizza The pizza to be added.
     */
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    /**
     * Removes a pizza from the order.
     * @param pizza The pizza to be removed.
     */
    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    /**
     * Sets the order number.
     * @param orderNumber Number to give to an order.
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Calculates the total price of an order.
     * @return The calculated order price.
     */
    public double calcTotalPrice(){
        double total=0;
        for (Pizza pizza:pizzas){
            total += pizza.price();
        }
        total*= Pizza.SALES_TAX;
        return total;
    }

    /**
     * Creates a deep copy of a given Order object.
     * @param order The object to copy.
     */
    public void copyOrder(Order order) {
        this.pizzas = new ArrayList<>();
        this.pizzas.addAll(order.getPizzas());
        this.orderNumber = order.getOrderNumber();
    }
}