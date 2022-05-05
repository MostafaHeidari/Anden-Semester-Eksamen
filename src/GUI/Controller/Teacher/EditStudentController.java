package GUI.Controller.Teacher;

import BE.Student;
import GUI.Model.StudentModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
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
    public TextField txtUserNameEditField;

    @FXML
    private JFXButton BtnTilbageOpretStudent;
    @FXML
    private JFXButton Logud;



    private Student selectedStudent;

    private final StudentModel studentModel = new StudentModel();

    public EditStudentController() throws IOException {
    }



   /*Student update action.This method save the information of student*/
    public void GamOplysingerActionButton(ActionEvent actionEvent) throws Exception {
        String updateStudentName = txtnavnEditStudentField.getText();
        String updateStudentEfterNavn = txtEfterNavnEditStudentField.getText();
        String updateStudentEmail = txtEmailEditStudentField.getText();
        String updateStudentAlder = txtAlderEditStudentFiled.getText();
        String updateStudentUser = txtUserNameEditField.getText();




        this.selectedStudent.setStudentName(updateStudentName);
        this.selectedStudent.setLastName(updateStudentEfterNavn);
        this.selectedStudent.setEmail(updateStudentEmail);
        this.selectedStudent.setUserName(updateStudentUser);
        this.selectedStudent.setAge(updateStudentAlder);

        studentModel.editStudent(this.selectedStudent);

        /*turn back to Create student window*/
        Stage switcher = (Stage) BtnTilbageOpretStudent.getScene().getWindow();
        switcher.setTitle("Create student");
        switcher.close();
    }

    public void setSelectedStudent(Student student) {
        txtnavnEditStudentField.setText(student.getStudentName());
        txtEfterNavnEditStudentField.setText(student.getLastName());
        txtEmailEditStudentField.setText(student.getEmail());
        txtUserNameEditField.setText(student.getUserName());
        txtAlderEditStudentFiled.setText(student.getAge());

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


    public void setSelectedTable(TableView tvStudent) {
        tvStudent.getItems().clear();

        try {
            tvStudent.setItems(studentModel.getAllStudents());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


