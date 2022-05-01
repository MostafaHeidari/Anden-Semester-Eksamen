package GUI.Controller.Teacher;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherController {
    @FXML
    private JFXButton klasserKnnap;
    @FXML
    private JFXButton BtnOpretStudent;
    @FXML
    private JFXButton BtnOpretBorger;
    @FXML
    private JFXButton Logud;
    @FXML
    private JFXButton BtnLogOutOfBorger;

    public void klasserBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) klasserKnnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherKlasseAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }

    public void OpretStudent(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnOpretStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Student");
        switcher.setScene(scene);
    }

    public void OpretBorger(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnOpretBorger.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/OpretBorger.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Student");
        switcher.setScene(scene);
    }

    public void LogOut(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Logud.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }

    public void Tilbage(ActionEvent actionEvent) {
    }

    public void LogOutOfBorger(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnLogOutOfBorger.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }
}
