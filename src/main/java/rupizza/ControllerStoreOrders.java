package rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;


public class ControllerStoreOrders {

    private ControllerMainMenu mainController;
    private ObservableList<String> pizzaListArr;
    private ObservableList<String> orderNumbers;
    private StoreOrders storeOrders;

    @FXML
    private ListView<String> pizzaList;

    @FXML ComboBox<String> orderNumber;

    @FXML
    private TextField orderTotal;

    @FXML
    private Button cancelOrder, exportOrders;

    public void initialize() {
        pizzaListArr = FXCollections.observableArrayList();
        orderNumbers = FXCollections.observableArrayList();
        storeOrders = new StoreOrders();
    }

    //Get the reference to the MainController object
    public void setMainController (ControllerMainMenu controller){
        mainController = controller;
    }

    public void addCartOrder(Order order) {
        orderNumber.getItems().add("" + storeOrders.getNextAvailableOrderNum());
        storeOrders.addOrder(order);
        storeOrders.nextOrder();
    }

    @FXML
    private void handleCancelOrder() {
        try {
            int selectedOrder = Integer.parseInt(orderNumber.getSelectionModel().getSelectedItem());
            int comboNum = orderNumber.getSelectionModel().getSelectedIndex();
            for (Order order : storeOrders.getOrders()) {
                if (selectedOrder == order.getOrderNumber()) {
                    storeOrders.cancelOrder(order);
                }
            }

            orderTotal.clear();
            orderNumber.getItems().remove(comboNum);
            pizzaList.getItems().clear();
            if (!orderNumber.getSelectionModel().isEmpty()) {
                selectedOrder = Integer.parseInt(orderNumber.getSelectionModel().getSelectedItem());
                for (Order order : storeOrders.getOrders()) {
                    if (selectedOrder == order.getOrderNumber()) {
                        for (Pizza pizza : order.getPizzas()) {
                            pizzaList.getItems().add(pizza.toString());
                        }
                    }
                }
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Cancelled");
            alert.setHeaderText("The selected order has been canceled.");
            alert.showAndWait();
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Cancellation Error");
            alert.setHeaderText("Could not cancel selected order, if any.");
            alert.setContentText("Please try again.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleExportOrders() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Orders");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(null);
        try {
            String filePath = file.getAbsolutePath();
            storeOrders.export(filePath);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Export Info");
            alert.setHeaderText("Store Orders exported!");
            alert.setContentText("Store orders have been written to " + filePath);
            alert.showAndWait();
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Export Error");
            alert.setHeaderText("Could not export selected order, if any.");
            alert.setContentText("Please try again.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleOrderNum(){
        String selectedOrderNum = orderNumber.getValue();
        if (selectedOrderNum != null) {
            for (Order order : storeOrders.getOrders()) {
                if (Integer.parseInt(selectedOrderNum) == order.getOrderNumber()) {
                    pizzaList.getItems().clear();
                    for (Pizza pizza : order.getPizzas()){
                        pizzaList.getItems().add(pizza.toString());
                    }
                    orderTotal.setText(NumberFormat.getCurrencyInstance().format(order.calcTotalPrice()));
                }
            }
        }
    }

    public StoreOrders getStoreOrders() {
        return storeOrders;
    }
}
