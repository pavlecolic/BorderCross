module com.example.bordercrossing {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bordercrossing to javafx.fxml;
    exports com.example.bordercrossing;
}