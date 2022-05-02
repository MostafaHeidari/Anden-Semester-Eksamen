package GUI.Controller;

import BE.Login;
import GUI.Model.OpretStudentLoginModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class OpretStudentLoginController {

    @FXML
    private JFXButton OpretStudent;

    @FXML
    private TextField Brugernavn;

    @FXML
    private TextField Adgangskode;

    @FXML
    private TableView OpretStudentTableView;

    private OpretStudentLoginModel opretStudentModel = new OpretStudentLoginModel();

    public OpretStudentLoginController() throws IOException {
    }

    public void OpretStudent(ActionEvent actionEvent) throws SQLException {
        System.out.println(Brugernavn.getText());
        System.out.println(Adgangskode.getText());


        Login login = opretStudentModel.opretStudent(Brugernavn.getText(), Adgangskode.getText());

    }

    public void RedigereStudent(ActionEvent actionEvent) {

    }

}
