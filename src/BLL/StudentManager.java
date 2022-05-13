package BLL;

import BE.SchoolGroups;
import BE.Student;
import DAL.db.Teacher.StudentDAO;
import DAL.db.Teacher.StudentInGroupsDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class StudentManager {
    StudentDAO studentDAO;
    StudentInGroupsDAO studentInGroupsDAO;

    /**
     * Constructor
     * @throws IOException
     */
    public StudentManager() throws IOException {
        studentDAO = new StudentDAO();
        studentInGroupsDAO = new StudentInGroupsDAO();
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
     * @throws SQLServerException
     */
    public void editStudent(Student student) throws Exception {
        studentDAO.editStudent(student);
    }

    /**
     * Gets the addStudentToClass selectedClass and selectedStudent using addStudentToClass from studentDAO
     * @param selectedGroup
     * @param selectedStudent
     * @throws SQLServerException
     */
    public void addStudentToGroup(SchoolGroups selectedGroup, Student selectedStudent) throws SQLException {
        studentInGroupsDAO.addStudentToGroup(selectedGroup, selectedStudent);
    }

    /**
     * Gets the removeStudent selectedStudent using removeStudent from studentDAO
     * @param selectedStudent
     * @throws SQLServerException
     */
    public void removeStudent(Student selectedStudent) {
        studentDAO.removeStudent(selectedStudent);
    }


    /**
     * Gets the list of getAllStudentsByClass using the getAllStudentsByClass method in studentInClassesDAO.
     * @return a list of studentInClassesDAO
     */
    public ObservableList<Student> getAllStudentsInGroups(int groupId) {
        ObservableList<Student> studentsObs = FXCollections.observableArrayList();

        try {
            studentsObs.addAll(studentInGroupsDAO.getAllStudentsInGroups(groupId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsObs;
    }

    /**
     * Gets the uploadStudentinfo studentName, studentLastname and userName using uploadStudentinfo from studentDAO
     * @param studentName
     * @param studentLastname
     * @param userName
     * @return
     * @throws SQLServerException
     */
    public Student uploadStudentinfo(String studentName, String studentLastname, String userName) throws SQLException {
        return(studentDAO.uploadStudentinfo(studentName, studentLastname, userName));
    }
}
