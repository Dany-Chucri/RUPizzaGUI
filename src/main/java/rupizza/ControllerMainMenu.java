package rupizza;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The ControllerMainMenu class controls the main menu of the RUPizza application.
 * @author Dany Chucri, Madhur Nutulapati
 */
public class ControllerMainMenu {
    private StoreOrders storeOrders;

    @FXML
    private Button specialtyPizzas, customPizzas, shoppingCart, ordersList;
    private ControllerStoreOrders storeOrdersController;
    private ControllerShoppingCart shoppingCartController;
    private Stage cartStage;
    private Stage ordersStage;

    /**
     * Initializes the controller by setting up the shopping cart and store orders.
     */
    public void initialize() {
        ordersStage = new Stage();
        AnchorPane root2;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreOrders.fxml"));
            root2 = (AnchorPane) loader.load();
            Scene scene = new Scene(root2, 700, 400);
            ordersStage.setTitle("Store Orders");
            ordersStage.setScene(scene);
            storeOrdersController = loader.getController();
            storeOrdersController.setMainController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading StoreOrders.fxml.");
            alert.setContentText("Couldn't load StoreOrders.fxml.");
            alert.showAndWait();
        }
        cartStage = new Stage();
        AnchorPane root1;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ShoppingCart.fxml"));
            root1 = (AnchorPane) loader.load();
            Scene scene = new Scene(root1, 700, 400);
            cartStage.setTitle("Checkout");
            cartStage.setScene(scene);
            shoppingCartController = loader.getController();
            shoppingCartController.setMainController(this);
            shoppingCartController.setStoreOrdersController(storeOrdersController);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading ShoppingCart.fxml.");
            alert.setContentText("Couldn't load ShoppingCart.fxml.");
            alert.showAndWait();
        }
    }

    /**
     * Opens the window for Specialty Pizzas.
     */
    @FXML
    protected void openSpecialties() {
        Stage specialties = new Stage();
        AnchorPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SpecialtyPizzas.fxml"));
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root, 500, 580);
            specialties.setTitle("Specialty Pizzas");
            specialties.setScene(scene);
            specialties.show();
            ControllerSpecialtyPizzas controllerSpecialtyPizzas = loader.getController();
            controllerSpecialtyPizzas.setMainController(this);
            controllerSpecialtyPizzas.setCartController(shoppingCartController);

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading SpecialtyPizzas.fxml.");
            alert.setContentText("Couldn't load SpecialtyPizzas.fxml.");
            alert.showAndWait();
        }
    }

    /**
     * Opens the window for Custom Pizzas.
     */
    @FXML
    protected void openCustoms() {
        Stage pizzaBuilder = new Stage();
        AnchorPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomPizzas.fxml"));
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root, 500, 580);
            pizzaBuilder.setTitle("Build Your Own Pizza");
            pizzaBuilder.setScene(scene);
            pizzaBuilder.show();
            ControllerCustomPizzas controllerCustomPizzas = loader.getController();
            controllerCustomPizzas.setMainController(this);
            controllerCustomPizzas.setCartController(shoppingCartController);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading CustomPizzas.fxml.");
            alert.setContentText("Couldn't load CustomPizzas.fxml.");
            alert.showAndWait();
        }
    }

    /**
     * Opens the shopping cart window for checkout.
     */
    @FXML
    protected void openCart() {
        cartStage.show();
    }

    /**
     * Opens the window for viewing store orders.
     */
    @FXML
    protected void openOrders() {
        ordersStage.show();
    }

    /**
     * Retrieves the store orders controller.
     * @return The ControllerStoreOrders instance.
     */
    public ControllerStoreOrders getStoreOrdersController() {
        return storeOrdersController;
    }

    /**
     * Sets the store orders controller.
     * @param storeOrdersController The ControllerStoreOrders instance to set.
     */
    public void setStoreOrdersController(ControllerStoreOrders storeOrdersController) {
        this.storeOrdersController = storeOrdersController;
    }

    /**
     * Retrieves the shopping cart controller.
     * @return The ControllerShoppingCart instance.
     */
    public ControllerShoppingCart getShoppingCartController() {
        return shoppingCartController;
    }

    /**
     * Sets the shopping cart controller.
     * @param shoppingCartController The ControllerShoppingCart instance to set.
     */
    public void setShoppingCartController(ControllerShoppingCart shoppingCartController) {
        this.shoppingCartController = shoppingCartController;
    }
}