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
    private JFXButton BtnOpretElev;
    @FXML
    private JFXButton BtnRedigerElev;
    @FXML
    private JFXButton BtnSletElev;


    @FXML
    private TextField navnField;
    @FXML
    private TextField efterNavnField;
    @FXML
    private TextField EmailField;
    @FXML
    private TextField AlderFiled;

    public void GemBtn(ActionEvent actionEvent) throws IOException, SQLException {
        String studentNavn = navnField.getText();
        String studentEfternavn = efterNavnField.getText();
        String studentEmail = (EmailField.getText());
        String studentAlder = AlderFiled.getText();

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


    public void OpretElevAction(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnOpretElev.getScene().getWindow();
    }

    public void SletElevAction(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnRedigerElev.getScene().getWindow();

    }

    public void RedigerElevAction(ActionEvent event)  throws IOException{
        Stage switcher = (Stage) BtnSletElev.getScene().getWindow();
    }
}
