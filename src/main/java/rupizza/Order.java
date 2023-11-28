package rupizza;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Order {
    private int orderNumber;
    private ArrayList<Pizza> pizzas;

    public Order(){
        this.orderNumber = 1;
        pizzas = new ArrayList<Pizza>();
    }

    public int getOrderNumber(){
        return this.orderNumber;
    }

    public List<Pizza> getPizzas(){
        return new ArrayList<>(pizzas);
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double calcTotalPrice(){
        double total=0;
        for (Pizza pizza:pizzas){
            total += pizza.price();
        }
        total*= Pizza.SALES_TAX;
        return total;
    }

    public void copyOrder(Order order) {
        this.pizzas = new ArrayList<>();
        this.pizzas.addAll(order.getPizzas());
        this.orderNumber = order.getOrderNumber();
    }
}