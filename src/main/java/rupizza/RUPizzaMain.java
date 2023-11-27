package rupizza;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The RUPizzaMain class is the main entry point for the RUPizza application.
 * @author Dany Chucri, Madhur Nutulapati
 */
public class RUPizzaMain extends Application {

    /**
     * Starts the RUPizza application by loading the main menu scene.
     *
     * @param stage The primary stage for the application.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RUPizzaMain.class.getResource("MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 550);
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main entry point for the application.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {launch();}
}