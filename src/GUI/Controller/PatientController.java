package GUI.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PatientController {
    @FXML
    private JFXButton btnLogout;

    public void LogOut(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) btnLogout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }
}
