package rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import java.io.File;


public class ControllerStoreOrders {

    private ControllerMainMenu mainController;
    private ObservableList<String> pizzaListArr;
    private ObservableList<String> orderNumbers;

    @FXML
    private ListView<String> pizzaList;

    @FXML ComboBox<String> orderNumber;

    @FXML
    private TextField orderTotal;

    @FXML
    private Button cancelOrder, exportOrders;
    @FXML
    private StoreOrders storeOrders;

    public void initialize() {
        pizzaListArr = FXCollections.observableArrayList("Here would be the toString() version of a given pizza object, but for now we will use this sample text space to fill up the text area as a part of testing.");
        orderNumbers = FXCollections.observableArrayList("1", "2", "3");
        
        pizzaList.setItems(pizzaListArr);
        orderNumber.setItems(orderNumbers);
        storeOrders = new StoreOrders();

    }

    //Get the reference to the MainController object
    public void setMainController (ControllerMainMenu controller){
        mainController = controller;
    }
    @FXML
    private void handleCancelOrder() {
        String selectedOrder = orderNumber.getValue();
        if (selectedOrder != null) {
            orderNumbers.remove(selectedOrder);
        } else {
//            System.out.println("No order selected for cancellation.");
        }
    }
    @FXML
    private void handleExportOrders() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Orders");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            String filePath = file.getAbsolutePath();
            storeOrders.export(filePath);
        } else {
//            System.out.println("Export canceled by the user.");
        }
    }
    @FXML
    private void handleOrderNum(){
        String selectedOrderNum = orderNumber.getValue();
        if (selectedOrderNum != null) {
        //
        }
    }
    public StoreOrders getStoreOrders() {
        return storeOrders;
    }
}
