package BLL;

import BE.Student;
import DAL.StudentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentManger {
    StudentDAO studentDAO = new StudentDAO();
    /**
     * Constructor
     * @throws IOException
     */
    public StudentManger() throws IOException {
        studentDAO = new StudentDAO();
    }



    public Student uploadStudentinfo(String studentNavn, String studentEfternavn, String studentEmail, String studentAlder) throws SQLException {
            return(studentDAO.uploadStudentinfo(studentNavn,studentEfternavn,studentEmail,studentAlder));
    }

    public ObservableList<Student> getAllStudents() {
        ObservableList<Student> studentsObs = FXCollections.observableArrayList();

        try {
            studentsObs.addAll(studentDAO.getAllStudents());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsObs;
    }

/*
     // Edits a student using the editStudent method from userDAO //

    public void editStudent(Student student) throws Exception {
        StudentDAO.editStudent(student);
    }

 */

/*
    public void deleteStudent(Student selectedStudent) {
        StudentDAO.deleteStudent(selectedStudent);
    }

 */
}
