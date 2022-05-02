package GUI.Controller.Teacher;

import BE.Student;
import GUI.Model.StudentModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;



public class editStudentController {


    public TextField txtnavnEditStudentField;
    public TextField txtEfterNavnEditStudentField;
    public TextField txtEmailEditStudentField;
    public TextField txtTelefonField;
    public TextField txtAlderEditStudentFiled;
    public JFXButton BtnGamOplysinger;

    private StudentModel studentModel = new StudentModel();

    public editStudentController() throws IOException {
    }
/*
    public void OpretElevActionButton(ActionEvent actionEvent) throws Exception {
        String studentNavn = txtnavnEditStudentField.getText();
        String studentEfternavn = txtEfterNavnEditStudentField.getText();
        String studentEmail = (txtEmailEditStudentField.getText());
        String studentAlder = txtAlderEditStudentFiled.getText();
        Student student = new Student(studentId, studentNavn, studentEfternavn ,studentEmail, studentAlder);
        studentModel.editStudent(student);
        cancel(actionEvent);
    }

    public void GamOplysingerActionButton(ActionEvent actionEvent) {
    }

 */
}
