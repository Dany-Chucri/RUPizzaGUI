package rupizza;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * The StoreOrders class represents the store's order management system.
 * It keeps track of orders, generates order numbers, and provides methods for managing and exporting orders.
 * @author Dany Chucri, Madhur Nutulapati
 */
public class StoreOrders {
    private static int nextAvailableOrderNum = 1;
    private List<Order> orders;

    /**
     * Constructs a new StoreOrders object with an empty list of orders.
     */
    public StoreOrders(){
        this.orders=new ArrayList<>();
    }

    /**
     * Retrieves the next available order number and increments the counter.
     *
     * @return The next available order number.
     */
    public int getNextAvailableOrderNum(){//getter
        return nextAvailableOrderNum++;
    }

    /**
     * Retrieves a copy of the list of orders.
     *
     * @return A list containing copies of the orders.
     */
    public List<Order>getOrders(){//getter
        return new ArrayList<>(orders);
    }

    /**
     * Adds a new order to the list of orders.
     *
     * @param order The Order object to be added.
     */
    public void addOrder(Order order) {
        orders.add(order);
    }

    /**
     * Cancels an existing order by removing it from the list of orders.
     *
     * @param order The Order object to be canceled.
     */
    public void cancelOrder(Order order) {
        orders.remove(order);
    }

    /**
     * Exports the list of orders to an external text file.
     *
     * @param filePath The path to the file where the orders will be exported.
     */
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