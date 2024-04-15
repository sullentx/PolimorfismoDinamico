package org.example.polimorfismodinamico.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.polimorfismodinamico.App;
import org.example.polimorfismodinamico.models.Servidor;

import java.io.IOException;

public class MenuController {

    private Servidor servidor = new Servidor();

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    @FXML
    void btnLista(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("lista-view.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            ListaController listaController= fxmlLoader.getController();
            listaController.initialize();
            listaController.setServidor(servidor);
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();
    }
    @FXML
    void btnRegistro(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("registro-view.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            RegistroController resgistroController= fxmlLoader.getController();
            resgistroController.initialize();
            resgistroController.setServidor(servidor);
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Node source = (Node) event.getSource();
        stage = (Stage) source.getScene().getWindow();stage.close();
    }

    public void initialize() {
        this.servidor = servidor;
    }
}
