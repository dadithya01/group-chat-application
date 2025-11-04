module com.example.groupchat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;


    opens com.example.groupchat.controllers to javafx.fxml;
    exports com.example.groupchat.controllers;
    opens com.example.groupchat to javafx.fxml;
    exports com.example.groupchat;
}