package GUI.Model;

import BE.SchoolClass;
import BE.Student;
import BLL.StudentManager;
import BLL.StudentsInClassManager;
import DAL.db.Teacher.StudentDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class StudentModel {

    StudentDAO studentDAO = new StudentDAO();
    private ClassModel classModel;
    private StudentsInClassManager studentsInClassManger;

    private ObservableList<Student> studentsList = FXCollections.observableArrayList();
    private ObservableList<Student> studentInClassesList = FXCollections.observableArrayList();


    private StudentManager studentManager;

    /**
     * Constructor
     * @throws IOException
     */
    public StudentModel() throws IOException {
        studentManager = new StudentManager();
        classModel = new ClassModel();
        studentsInClassManger = new StudentsInClassManager();
    }

    /**
     * Gets the uploadStudentinfo studentNavn, studentEfternavn, studentEmail, studentAlder and userName using uploadStudentinfo from studentManager
     * @param studentNavn
     * @param studentEfternavn
     * @param studentEmail
     * @param studentAlder
     * @param userName
     * @throws SQLServerException
     */
    public void uploadStudentinfo(String studentNavn, String studentEfternavn, String studentEmail, String studentAlder, String userName) throws SQLException {
        studentsList.add(studentManager.uploadStudentinfo(studentNavn,studentEfternavn,studentEmail,studentAlder,userName));
    }


    /**
     * Gets the list of getAllStudents using the getAllStudents method in studentManager.
     * @return a list of getAllStudents
     */
    public ObservableList<Student> getAllStudents() throws IOException {
        studentsList = studentManager.getAllStudents();
        return studentsList;
    }

    /**
     * Gets the editStudent student using editStudent from studentManager
     * @param student
     * @throws SQLServerException
     */
    public void editStudent(Student student) throws Exception {
        studentManager.editStudent(student);
        studentsList.clear();
        studentsList.addAll(studentManager.getAllStudents());
    }

    /**
     * Gets the addStudentToClass selectedClass and selectedStudent using updateCategory from studentManager
     * @param selectedClass
     * @param selectedStudent
     * @throws SQLServerException
     */
    public void addStudentToClass(SchoolClass selectedClass, Student selectedStudent) throws SQLException {
        studentManager.addStudentToClass(selectedClass,selectedStudent);
        studentInClassesList.add(selectedStudent);
    }


    /**
     * Gets the list of setStudentsInClass using the setStudentsInClass method in studentManager.
     * @return a list of setStudentsInClass
     */
    public ObservableList<Student> setStudentsInClass(int classId){
        studentsList = studentManager.getAllStudentsByClass(classId);
        return studentsList;
    }





    /**
     * Gets the removeStudent selectedStudent using removeStudent from studentManager
     * @param selectedStudent
     * @throws SQLServerException
     */
    public void removeStudent (Student selectedStudent) {
        studentManager.removeStudent(selectedStudent);
        studentsList.remove(selectedStudent);
    }

    /**
     * Gets the deleteStudentInClass selectedClass and selectedStudentInClass using deleteStudentInClass from studentsInClassManger
     * @param selectedClass
     * @param selectedStudentInClass
     * @throws SQLServerException
     */
    public void deleteStudentInClass(SchoolClass selectedClass, Student selectedStudentInClass) throws SQLException {
        studentsInClassManger.deleteStudentInClass(selectedClass,selectedStudentInClass);
        studentInClassesList.remove(selectedStudentInClass);
        classModel.uploadKlasseInfo(String.valueOf(selectedClass));
    }
}
