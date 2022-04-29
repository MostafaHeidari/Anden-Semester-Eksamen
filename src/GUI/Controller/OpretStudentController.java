package GUI.Controller;

import GUI.Model.OpretStudentModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class OpretStudentController {

    @FXML
    private JFXButton OpretStudent;

    @FXML
    private TextField Brugernavn;

    @FXML
    private TextField Adgangskode;

    private OpretStudentModel opretStudentModel = new OpretStudentModel();

    public OpretStudentController() throws IOException {
    }

    public void OpretStudent(ActionEvent actionEvent) {
        System.out.println(OpretStudent.getText());
        System.out.println(Brugernavn.getText());
    }

    public void RedigereStudent(ActionEvent actionEvent) {

    }

}
