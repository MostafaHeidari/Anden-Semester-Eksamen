package GUI.Controller.Student;

import GUI.Controller.Universal.CreateCaseController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CitizenController {



    @FXML
    private JFXButton btnLogout;
    @FXML
    private JFXButton btnInfo;
    @FXML
    private JFXButton createCase;

    /**
     * Log out and goes to the Login view
     */
    public void LogOut(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) btnLogout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }

    public void createCaseBtn(ActionEvent actionEvent) {
        //TODO
        //opret case
    }

    public void caseInfoBtn(ActionEvent actionEvent) {
        //TODO
        //liste af alle cases
    }
}
