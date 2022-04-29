package GUI.Controller;

import BE.Login;
import GUI.Model.OpretStudentModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class OpretStudentController {

    @FXML
    private JFXButton OpretStudent;

    @FXML
    private TextField Brugernavn;

    @FXML
    private TextField Adgangskode;

    @FXML
    private TableView OpretStudentTableView;

    private OpretStudentModel opretStudentModel = new OpretStudentModel();

    public OpretStudentController() throws IOException {
    }

    public void OpretStudent(ActionEvent actionEvent) throws SQLException {
        System.out.println(Brugernavn.getText());
        System.out.println(Adgangskode.getText());


        Login login = opretStudentModel.opretStudent(Brugernavn.getText(), Adgangskode.getText());

    }

    public void RedigereStudent(ActionEvent actionEvent) {

    }

}
