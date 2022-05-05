package BLL;

import BE.SchoolClass;
import BE.Student;
import DAL.StudentDAO;
import DAL.StudentInClassesDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentManger {
    StudentDAO studentDAO;
    StudentInClassesDAO studentInClassesDAO;

    /**
     * Constructor
     * @throws IOException
     */
    public StudentManger() throws IOException {
        studentDAO = new StudentDAO();
        studentInClassesDAO = new StudentInClassesDAO();
    }

    /**
     * Gets the list of getAllStudents using the getAllStudents method in studentDAO.
     * @return a list of getAllStudents
     */
    public ObservableList<Student> getAllStudents() {
        ObservableList<Student> studentsObs = FXCollections.observableArrayList();

        try {
            studentsObs.addAll(studentDAO.getAllStudents());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsObs;
    }



    /**
     * Gets the editStudent student using editStudent from studentDAO
     * @param student
     * @return
     * @throws SQLServerException
     */
    public void editStudent(Student student) throws Exception {
        studentDAO.editStudent(student);
    }

    /**
     * Gets the addStudentToClass selectedClass and selectedStudent using addStudentToClass from studentDAO
     * @param selectedClass
     * @param selectedStudent
     * @return
     * @throws SQLServerException
     */
    public void addStudentToClass(SchoolClass selectedClass, Student selectedStudent) throws SQLException {
        studentInClassesDAO.addStudentToClass(selectedClass, selectedStudent);
    }

    /**
     * Gets the removeStudent selectedStudent using removeStudent from studentDAO
     * @param selectedStudent
     * @return
     * @throws SQLServerException
     */
    public void removeStudent(Student selectedStudent) {
        studentDAO.removeStudent(selectedStudent);
    }


    /**
     * Gets the list of getAllStudentsByClass using the getAllStudentsByClass method in studentInClassesDAO.
     * @return a list of studentInClassesDAO
     */
    public ObservableList<Student> getAllStudentsByClass(int classId) {
        ObservableList<Student> studentsObs = FXCollections.observableArrayList();

        try {
            studentsObs.addAll(studentInClassesDAO.getAllStudentsInClass(classId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsObs;
    }

    /**
     * Gets the uploadStudentinfo studentNavn, studentEfternavn, studentEmail, studentAlder and userName using uploadStudentinfo from studentDAO
     * @param studentNavn
     * @param studentEfternavn
     * @param studentEmail
     * @param studentAlder
     * @param userName
     * @return
     * @throws SQLServerException
     */
    public Student uploadStudentinfo(String studentNavn, String studentEfternavn, String studentEmail, String studentAlder, String userName) throws SQLException {
        return(studentDAO.uploadStudentinfo(studentNavn,studentEfternavn,studentEmail,studentAlder, userName));
    }
}
