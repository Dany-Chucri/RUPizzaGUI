package rupizza;

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
    public void export(String filePath){
    }
}