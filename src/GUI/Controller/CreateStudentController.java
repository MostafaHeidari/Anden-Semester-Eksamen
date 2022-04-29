package GUI.Controller;

import GUI.Model.StudentModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CreateStudentController {
    public JFXButton Gemknap;
    public JFXButton TilbageKnap;
    public TextField NavnTxt;
    public TextField EfternavnTxt;
    public TextField EmailTxt;
    public TextField AlderTxt;

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
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/TeacherKlasseAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }
}
