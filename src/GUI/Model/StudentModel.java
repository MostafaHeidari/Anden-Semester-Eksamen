package GUI.Model;

import BE.Student;
import BLL.StudentManger;
import DAL.StudentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class StudentModel {
    StudentDAO studentDAO = new StudentDAO();


    private ObservableList<Student> studentsList = FXCollections.observableArrayList();

    private StudentManger studentManger;

    public StudentModel() throws IOException {
        studentManger = new StudentManger();
    }

    public void uploadStudentinfo(String studentNavn, String studentEfternavn, String studentEmail, String studentAlder) throws SQLException {
        studentsList.add(studentManger.uploadStudentinfo(studentNavn,studentEfternavn,studentEmail,studentAlder));
    }


    /* Edits a student using the editStudent method from userManager */



    public void editStudent(Student student) throws Exception {
        studentManger.editStudent(student);
    }
}
