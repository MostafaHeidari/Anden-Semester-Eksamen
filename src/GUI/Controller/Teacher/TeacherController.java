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
    public JFXButton citizentBoutten;
    @FXML
    private JFXButton klasserKnnap;
    @FXML
    private JFXButton BtnOpretStudent;
    @FXML
    private JFXButton BtnOpretBorger;
    @FXML
    private JFXButton Logud;


    public void klasserBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) klasserKnnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherKlasseAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Classe Manger");
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
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateCitizen.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Borger");
        switcher.setScene(scene);
    }

    public void LogOut(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Logud.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Unvesial/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }

    public void citizentBouttenBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) citizentBoutten.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Unvesial/CitizenInfo.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Borger Informationer");
        switcher.setScene(scene);
    }



}
