module com.example.rupizzagui {
    requires javafx.controls;
    requires javafx.fxml;
    opens rupizza to javafx.fxml;
    exports rupizza;
}