package BLL;

import BE.SchoolClass;
import BE.Student;
import DAL.StudentDAO;
import DAL.StudentInClassesDAO;
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





    public ObservableList<Student> getAllStudents() {
        ObservableList<Student> studentsObs = FXCollections.observableArrayList();

        try {
            studentsObs.addAll(studentDAO.getAllStudents());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsObs;
    }



     // Edits a student using the editStudent method from userDAO 2 //
    public void editStudent(Student student) throws Exception {
        studentDAO.editStudent(student);
    }

    public void addStudentToClass(SchoolClass selectedClass, Student selectedStudent) throws SQLException {
        studentInClassesDAO.addStudentToClass(selectedClass, selectedStudent);
    }


    public void removeStudent(Student selectedStudent) {
        studentDAO.removeStudent(selectedStudent);
    }

    public ObservableList<Student> getAllStudentsByClass(int classId) {
        ObservableList<Student> studentsObs = FXCollections.observableArrayList();

        try {
            studentsObs.addAll(studentInClassesDAO.getAllStudentsInClass(classId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsObs;
    }
}
