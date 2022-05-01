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
    private JFXButton BtnTilbage;
    @FXML
    private JFXButton BtnOpretElev;
    @FXML
    private JFXButton BtnRedigerElev;
    @FXML
    private JFXButton BtnSletElev;

    @FXML
    private JFXButton BtnTilbageOpretStudent;
    @FXML
    private JFXButton Logud;

    @FXML
    private TextField txtnavnField;
    @FXML
    private TextField txtefterNavnField;
    @FXML
    private TextField txtEmailField;
    @FXML
    private TextField txtAlderFiled;

    @FXML
    private JFXButton BtnGamOplysinger;


    public void OpretElevActionButton(ActionEvent actionEvent) throws IOException, SQLException {
        String studentNavn = txtnavnField.getText();
        String studentEfternavn = txtefterNavnField.getText();
        String studentEmail = (txtEmailField.getText());
        String studentAlder = txtAlderFiled.getText();
        uploadStudentInfo(studentNavn, studentEfternavn, studentEmail, studentAlder);
        cancel(actionEvent);
    }

    private void uploadStudentInfo(String studentNavn, String studentEfternavn, String studentEmail, String studentAlder) throws IOException, SQLException {
        StudentModel studentModelInfo = new StudentModel();

        studentModelInfo.uploadStudentinfo(studentNavn, studentEfternavn, studentEmail, studentAlder);
    }

    public void TilbageBtn(ActionEvent actionEvent) throws IOException {
        cancel(actionEvent);
    }

    private void cancel(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnOpretElev.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherKlasseAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }

    /* this button turn back to teacher window*/
    public void BtnTilbage(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnTilbage.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Forside");
        switcher.setScene(scene);
    }

    /* this button turn back to createStudent window*/
    public void BtnTilbageOpretStudentAction(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnTilbageOpretStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml"));
        Scene scene = new Scene(root);
        switcher.setScene(scene);
    }


    /* this button edit the Student*/
    public void RedigerElevAction(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnRedigerElev.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/EditStudent.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Rediger Elev");
        switcher.setScene(scene);
    }

    /*this button must to log out*/
    public void LogOutAction(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Logud.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setScene(scene);
    }

    /*this button must to delete the selected student*/
    public void SletElevAction(ActionEvent event) throws IOException {

    }

    /*this button must to save the selected students information*/
    public void GamOplysingerActionButton(ActionEvent actionEvent) {
    }

}
