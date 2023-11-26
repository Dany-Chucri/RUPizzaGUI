package rupizza;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoreOrders {
    private static int nextAvailableOrderNum = 1;
    private List<Order> orders;
    public StoreOrders(){
        this.orders=new ArrayList<>();
    }
    public int getNextAvailableOrderNum(){//getter
        return nextAvailableOrderNum++;
    }
    public List<Order>getOrders(){//getter
        return new ArrayList<>(orders);
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
    public void cancelOrder(Order order) {
        orders.remove(order);
    }
    public void export(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Order order : orders) {
                writer.write("Order number: " + order.getOrderNumber() + "\n");
                for(Pizza pizza : order.getPizzas()){
                    writer.write("Pizza type: " + pizza.getClass().getSimpleName()+"\n");
                    //Anything else to add ?
                }
                writer.write("Total: $"+order.calcTotalPrice()+ "/n/n");
            }
        } catch (IOException e) {
            System.err.println("Error exporting saving the store orders to an external text file: " + e.getMessage());
        }
    }
}