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
    public JFXButton citizentButton;
    @FXML
    private JFXButton groupBtn;
    @FXML
    private JFXButton BtnCreateStudent1;
    @FXML
    private JFXButton BtnCreatePatient;
    @FXML
    private JFXButton Logout;

    /**
     * Goes to the TeacherKlasseAndStudents view
     */
    public void groupBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) groupBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherGroupAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Classe Manger");
        switcher.setScene(scene);
    }

    /**
     * Goes to the CreateStudent view
     */
    public void CreateStudent(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnCreateStudent1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Student");
        switcher.setScene(scene);
    }

    /**
     * Goes to the CreateCitizen view
     */
    public void CreatePatient(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnCreatePatient.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateCitizen.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Borger");
        switcher.setScene(scene);
    }

    /**
     * Log out and goes to the Login view
     */
    public void LogOut(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Logout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }

    /**
     * Goes to the CitizenInfo view
     */
    public void citizentButtonBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) citizentButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/CitizenInfo.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Borger Informationer");
        switcher.setScene(scene);
    }
}
