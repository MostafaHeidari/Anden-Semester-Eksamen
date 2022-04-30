package GUI.Controller.Teacher;

import GUI.Model.StudentModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CreateStudentController {
    @FXML
    private JFXButton Gemknap;
    @FXML
    private JFXButton BtnTilbage;
    @FXML
    private TextField NavnTxt;
    @FXML
    private TextField EfternavnTxt;
    @FXML
    private TextField EmailTxt;
    @FXML
    private TextField AlderTxt;

    public void GemBtn(ActionEvent actionEvent) throws IOException, SQLException {
        String studentNavn = NavnTxt.getText();
        String studentEfternavn = EfternavnTxt.getText();
        String studentEmail = (EmailTxt.getText());
        String studentAlder = AlderTxt.getText();

        uploadStudentInfo(studentNavn, studentEfternavn, studentEmail, studentAlder);

        cancel(actionEvent);
    }

    private void uploadStudentInfo(String studentNavn, String studentEfternavn, String studentEmail, String studentAlder) throws IOException, SQLException {
        StudentModel studentModelInfo = new StudentModel();

        studentModelInfo.uploadStudentinfo(studentNavn,studentEfternavn,studentEmail,studentAlder);
    }

    public void TilbageBtn(ActionEvent actionEvent) throws IOException {
        cancel(actionEvent);
    }

    private void cancel(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Gemknap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherKlasseAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }

    public void BtnTilbage(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnTilbage.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Forside");
        switcher.setScene(scene);
    }
}
