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
    public TextField txtnameEditStudentField;
    @FXML
    public TextField txtLastnameEditStudentField;

    @FXML
    public TextField txtUserNameEditField;

    @FXML
    private JFXButton BtnBackCreateStudent;
    @FXML
    private JFXButton Logout;



    private Student selectedStudent;

    private final StudentModel studentModel = new StudentModel();

    /**
     * Constructor
     * @throws IOException
     */
    public EditStudentController() throws IOException {
    }

    /**
     * Student update action.This method save the information of student
     */
    public void SaveInformationActionButton(ActionEvent actionEvent) throws Exception {
        String updateStudentName = txtnameEditStudentField.getText();
        String updateStudentEfterNavn = txtLastnameEditStudentField.getText();
        String updateStudentUser = txtUserNameEditField.getText();

        this.selectedStudent.setStudentName(updateStudentName);
        this.selectedStudent.setLastName(updateStudentEfterNavn);
        this.selectedStudent.setUserName(updateStudentUser);


        studentModel.editStudent(this.selectedStudent);

        /*turn back to Create student window*/
        Stage switcher = (Stage) BtnBackCreateStudent.getScene().getWindow();
        switcher.setTitle("Create student");
        switcher.close();
    }

    /**
     * Set selected student
     * @param student
     */
    public void setSelectedStudent(Student student) {
        txtnameEditStudentField.setText(student.getStudentName());
        txtLastnameEditStudentField.setText(student.getLastName());
        txtUserNameEditField.setText(student.getUserName());

        this.selectedStudent = student;
    }


    /**
     * Log out and goes to the Login view
     */
    public void LogOutAction(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Logout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Create student");
        switcher.setScene(scene);
    }

    /**
     * Goes to the previous view
     */
    public void BtnBackCreateStudentAction(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnBackCreateStudent.getScene().getWindow();
        switcher.setTitle("Create student");
        switcher.close();

    }

    /**
     * Clear the selectedTable
     * @param tvStudent
     */
    public void setSelectedTable(TableView tvStudent) {
        tvStudent.getItems().clear();

        try {
            tvStudent.setItems(studentModel.getAllStudents());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


