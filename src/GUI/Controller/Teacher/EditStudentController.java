package GUI.Controller.Teacher;

import BE.Student;
import GUI.Model.StudentModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;


public class EditStudentController {


    public TextField txtnavnEditStudentField;
    public TextField txtEfterNavnEditStudentField;
    public TextField txtEmailEditStudentField;
    public TextField txtTelefonField;
    public TextField txtAlderEditStudentFiled;
    public JFXButton BtnGamOplysinger;

    private Student selectedStudent;

    private StudentModel studentModel = new StudentModel();

    public EditStudentController() throws IOException {
    }

    public static void updateStudentInfo(Object selectedStudent) {
    }

    public void OpretElevActionButton(ActionEvent actionEvent) throws Exception {
        String updateStudentName = txtnavnEditStudentField.getText();
        String updateStudentEfterNavn = txtEfterNavnEditStudentField.getText();
        String updateStudentAlder = txtAlderEditStudentFiled.getText();
        String updateStudentEmail = txtEmailEditStudentField.getText();

        this.selectedStudent.setStudentName(updateStudentName);
        this.selectedStudent.setLastName(updateStudentEfterNavn);
        this.selectedStudent.setEmail(updateStudentAlder);
        this.selectedStudent.setAge(updateStudentEmail);
        studentModel.editStudent(this.selectedStudent);



        /*
        String studentNavn = txtnavnEditStudentField.getText();
        String studentEfternavn = txtEfterNavnEditStudentField.getText();
        String studentEmail = (txtEmailEditStudentField.getText());
        String studentAlder = txtAlderEditStudentFiled.getText();
        Student student = new Student(studentId, studentNavn, studentEfternavn ,studentEmail, studentAlder);
        studentModel.editStudent(student);

         */
    }

    public void setSelectedStudent(Student student){
        txtnavnEditStudentField.setText(student.getStudentName());
        txtEfterNavnEditStudentField.setText(student.getLastName());
        txtEmailEditStudentField.setText(student.getEmail());
        txtAlderEditStudentFiled.setText(student.getAge());
        this.selectedStudent = student;
    }


    public void GamOplysingerActionButton(ActionEvent actionEvent) {
    }

    public void LogOutAction(ActionEvent actionEvent) {
    }

    public void BtnTilbageOpretStudentAction(ActionEvent actionEvent) {
    }
}
