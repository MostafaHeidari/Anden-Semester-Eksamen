package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FrontPageController {
    @FXML
    private Button btnLogin;
    public void Login() throws IOException {
        Stage switcher = (Stage) btnLogin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Patient.fxml"));
        switcher.setTitle("Patient");
        Scene scene = new Scene(root);
        switcher.setScene(scene);
    }
}
