package GUI.Controller.Teacher;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateCitizenController {
    @FXML
    private JFXButton BtnLogOutOfPatient;
    @FXML
    private JFXButton BtnBack;

    /**
     * Goes to TeacherKlasseAndStudents view
     */
    public void btnBackGroups(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherGroupAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Klasse Manager");
        switcher.setScene(scene);
    }

    /**
     * Goes to CitizenInfo view
     */
    public void citizenInformationBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnLogOutOfPatient.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/CitizenInfo.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Borger Informationer");
        switcher.setScene(scene);
    }

    /**
     * Goes to CreateStudent view
     */
    public void btnBackStudent(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnLogOutOfPatient.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Student");
        switcher.setScene(scene);
    }

    /**
     * Goes to Teacher view
     */
    public void BtnBack(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnLogOutOfPatient.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }

    /**
     * Goes to Login view
     */
    public void LogOutOfPatient(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnLogOutOfPatient.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }
}
