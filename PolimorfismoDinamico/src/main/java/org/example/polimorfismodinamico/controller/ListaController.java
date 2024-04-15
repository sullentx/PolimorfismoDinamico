package org.example.polimorfismodinamico.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.polimorfismodinamico.App;
import org.example.polimorfismodinamico.models.Servidor;
import org.example.polimorfismodinamico.models.Student;

import java.io.IOException;

public class ListaController {
    @FXML
    private TextField txtApeMa;

    @FXML
    private TextField txtApePa;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtName;

    @FXML
    private ListView<Student> ltsLista;
    private Servidor servidor;
    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }
    @FXML
    void btnCambios(MouseEvent event) {
        int selectedIndex = ltsLista.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            if (txtName.getText().isEmpty() || txtEdad.getText().isEmpty() || txtApePa.getText().isEmpty() || txtApeMa.getText().isEmpty()) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText("Campos vacíos");
                alerta.setContentText("Rellene todos los campos por favor");
                alerta.showAndWait();
            } else {
                Student selectedStudent = servidor.getDataBase01().getDataBase01().get(selectedIndex);

                selectedStudent.setName(txtName.getText());
                selectedStudent.setLastName(txtApePa.getText());
                selectedStudent.setSecondLastName(txtApeMa.getText());
                selectedStudent.setAge(txtEdad.getText());

                servidor.getDataBase01().update(selectedStudent, selectedIndex);
                servidor.getDataBase02().update(selectedStudent, selectedIndex);
                servidor.getDataBase03().update(selectedStudent, selectedIndex);

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Modificado");
                alerta.setHeaderText(null);
                alerta.setContentText("Estudiante modificado con éxito.");
                alerta.showAndWait();
                txtName.clear();
                txtApePa.clear();
                txtApeMa.clear();
                txtEdad.clear();
                mostrarLista();
            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Ningún elemento seleccionado");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, selecciona un estudiante para modificar.");
            alerta.showAndWait();
        }
    }

    @FXML
    void btnMostrar(MouseEvent event) {
        ObservableList<Student> items = FXCollections.observableArrayList();
        for (Student student : servidor.getDataBase01().getDataBase01()) {
            items.add(student);
        }
        ltsLista.setItems(items);
    }

    @FXML
    void btnVolver(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            MenuController menuController= fxmlLoader.getController();
            menuController.initialize();
            menuController.setServidor(servidor);
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
    public void mostrarLista(){
        ObservableList<Student> items = FXCollections.observableArrayList();
        for (Student student : servidor.getDataBase01().getDataBase01()) {
            items.add(student);
        }
        ltsLista.setItems(items);
    }
}
