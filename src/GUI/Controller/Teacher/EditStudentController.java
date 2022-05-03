package GUI.Controller.Teacher;

import GUI.Controller.SimpleDialogController;
import BE.Student;
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


public class EditStudentController {

    @FXML
    public TextField txtnavnEditStudentField;
    @FXML
    public TextField txtEfterNavnEditStudentField;
    @FXML
    public TextField txtEmailEditStudentField;
    @FXML
    public TextField txtTelefonField;
    @FXML
    public TextField txtAlderEditStudentFiled;

    @FXML
    private JFXButton BtnGamOplysinger;
    @FXML
    private JFXButton BtnTilbageOpretStudent;
    @FXML
    private JFXButton Logud;

    @FXML
    private JFXButton BtnSletElev;


    private Student selectedStudent;

    private final StudentModel studentModel = new StudentModel();

    public EditStudentController() throws IOException {
    }

    public static void updateStudentInfo(Object selectedStudent) {
    }

    public void GamOplysingerActionButton(ActionEvent actionEvent) throws Exception {
        String updateStudentName = txtnavnEditStudentField.getText();
        String updateStudentEfterNavn = txtEfterNavnEditStudentField.getText();
        String updateStudentAlder = txtAlderEditStudentFiled.getText();
        String updateStudentEmail = txtEmailEditStudentField.getText();

        this.selectedStudent.setStudentName(updateStudentName);
        this.selectedStudent.setLastName(updateStudentEfterNavn);
        this.selectedStudent.setEmail(updateStudentAlder);
        this.selectedStudent.setAge(updateStudentEmail);

        studentModel.editStudent(this.selectedStudent);

        Stage switcher = (Stage) BtnTilbageOpretStudent.getScene().getWindow();
        switcher.setTitle("Create student");
        switcher.close();



        /*
        String studentNavn = txtnavnEditStudentField.getText();
        String studentEfternavn = txtEfterNavnEditStudentField.getText();
        String studentEmail = (txtEmailEditStudentField.getText());
        String studentAlder = txtAlderEditStudentFiled.getText();
        Student student = new Student(studentId, studentNavn, studentEfternavn ,studentEmail, studentAlder);
        studentModel.editStudent(student);

         */
    }

    public void setSelectedStudent(Student student) {
        txtnavnEditStudentField.setText(student.getStudentName());
        txtEfterNavnEditStudentField.setText(student.getLastName());
        txtEmailEditStudentField.setText(student.getEmail());
        txtAlderEditStudentFiled.setText(student.getAge());
        txtEmailEditStudentField.setText(student.getEmail());

        this.selectedStudent = student;
    }


    /* log ud button */
    public void LogOutAction(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Logud.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Create student");
        switcher.setScene(scene);


    }

    /* tilbage button*/
    public void BtnTilbageOpretStudentAction(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnTilbageOpretStudent.getScene().getWindow();
        switcher.setTitle("Create student");
        switcher.close();

    }
}