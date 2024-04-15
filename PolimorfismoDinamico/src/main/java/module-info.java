module org.example.polimorfismodinamico {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.polimorfismodinamico to javafx.fxml;
    exports org.example.polimorfismodinamico;
    exports org.example.polimorfismodinamico.controller;
    opens org.example.polimorfismodinamico.controller to javafx.fxml;
}