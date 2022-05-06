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
    private JFXButton BtnLogOutOfBorger;
    @FXML
    private JFXButton BtnTilbage;

    public void btnTilbageKlasser(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnTilbage.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherKlasseAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Classe Manger");
        switcher.setScene(scene);
    }

    public void citizenInfomationBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnLogOutOfBorger.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Unvesial/CitizenInfo.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Borger Informationer");
        switcher.setScene(scene);
    }

    public void btnTilbageElever(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnLogOutOfBorger.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Student");
        switcher.setScene(scene);
    }

    public void BtnTilbage(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnLogOutOfBorger.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }

    public void LogOutOfBorger(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnLogOutOfBorger.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Unvesial/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }
}
