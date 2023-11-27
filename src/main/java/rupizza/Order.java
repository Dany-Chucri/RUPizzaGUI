package rupizza;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Order {
    private static int nextOrderNum=1;
    private int orderNumber;
    private ObservableList<Pizza>pizzas;

    public Order(){
        this.orderNumber=nextOrderNum+=1;
        FXCollections.observableArrayList();
//        this.pizzas=new ArrayList<>();
    }

//    public Order(int orderNumber, List<Pizza> pizzas) {
//        this.orderNumber=nextOrderNum+=1;
//        this.pizzas = pizzas;
//    }

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
    public double calcTotalPrice(){
        double total=0;
        for (Pizza pizza:pizzas){
            total += pizza.price();
        }
        return total;
    }
}