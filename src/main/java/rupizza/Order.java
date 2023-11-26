package rupizza;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextOrderNum=1;
    private int OrderNumber;
    private List<Pizza>pizzas;

    public Order(){
        this.OrderNumber=nextOrderNum+=1;
        this.pizzas=new ArrayList<>();
    }
    public int getOrderNumber(){
        return this.OrderNumber;
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