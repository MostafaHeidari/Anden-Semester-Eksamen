package GUI.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherController {
    public JFXButton klasserKnnap;

    public void klasserBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) klasserKnnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/TeacherKlasseAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }
}