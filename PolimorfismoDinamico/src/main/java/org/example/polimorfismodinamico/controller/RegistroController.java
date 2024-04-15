package org.example.polimorfismodinamico.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.polimorfismodinamico.App;
import org.example.polimorfismodinamico.models.Servidor;
import org.example.polimorfismodinamico.models.Student;

import java.io.IOException;
import java.util.Random;

public class RegistroController {

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField txtApeMa;

    @FXML
    private TextField txtApePa;

    @FXML
    private TextField txtEdad;


    @FXML
    private TextField txtName;
    private Servidor servidor;
    Random random = new Random();

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    @FXML
    void btnGuardar(MouseEvent event) {
        if (txtName.getText().isEmpty()||txtApePa.getText().isEmpty()||txtApeMa.getText().isEmpty()||txtEdad.getText().isEmpty()){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Campos vacios");
            alerta.setContentText("Rellene todos los campos por favor");
            alerta.showAndWait();
        }else {

        Student student = new Student();
        student.setName(txtName.getText());
        student.setLastName(txtApePa.getText());
        student.setSecondLastName(txtApeMa.getText());

            boolean idRepetido;
            int id;
            do {
                id = random.nextInt(10000);
                idRepetido = false;
                if (servidor.getDataBase01().idRepetido(id)) {
                    idRepetido = true;
                }
            } while (idRepetido);

        student.setId(id);
        student.setAge(txtEdad.getText());
        servidor.getDataBase01().addStudent(student);
        servidor.getDataBase02().addStudent(student);
        servidor.getDataBase03().addStudent(student);

            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Guardado");
            alerta.setHeaderText("Guardado con exito");
            alerta.setContentText("Se agrego correctamente a la lista");
            alerta.showAndWait();

            txtEdad.clear();
            txtApeMa.clear();
            txtName.clear();
            txtApePa.clear();
        }
    }

    @FXML
    void btnVolver(MouseEvent event) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        try {
            Pane root = fxmlLoader.load();
            Scene scene= new Scene(root);
            MenuController menuController= fxmlLoader.getController();
            menuController.setServidor(servidor);
            menuController.initialize();
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
