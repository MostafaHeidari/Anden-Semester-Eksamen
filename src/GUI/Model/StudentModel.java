package GUI.Model;

import BE.SchoolClass;
import BE.Student;
import BLL.StudentManager;
import BLL.StudentsInClassManager;
import DAL.StudentDAO;
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

    public StudentModel() throws IOException {
        studentManager = new StudentManager();
        classModel = new ClassModel();
        studentsInClassManger = new StudentsInClassManager();
    }

    public void uploadStudentinfo(String studentNavn, String studentEfternavn, String studentEmail, String studentAlder, String userName) throws SQLException {
        studentsList.add(studentManager.uploadStudentinfo(studentNavn,studentEfternavn,studentEmail,studentAlder,userName));
    }


    public ObservableList<Student> getAllStudents() throws IOException {
        studentsList = studentManager.getAllStudents();
        return studentsList;
    }

    // Edits a student using the editStudent method from userManager 3 //

    public void editStudent(Student student) throws Exception {
        studentManager.editStudent(student);
        studentsList.clear();
        studentsList.addAll(studentManager.getAllStudents());
    }

    public void addStudentToClass(SchoolClass selectedClass, Student selectedStudent) throws SQLException {
        studentManager.addStudentToClass(selectedClass,selectedStudent);
        studentInClassesList.add(selectedStudent);
    }


    public ObservableList<Student> setStudentsInClass(int classId){
        studentsList = studentManager.getAllStudentsByClass(classId);
        return studentsList;
    }





    /* Deletes student using the deleteStudent method from StudentManager */

    public void removeStudent (Student selectedStudent) {
        studentManager.removeStudent(selectedStudent);
        studentsList.remove(selectedStudent);
    }

    public void deleteStudentInClass(SchoolClass selectedClass, Student selectedStudentInClass) throws SQLException {
        studentsInClassManger.deleteStudentInClass(selectedClass,selectedStudentInClass);
        studentInClassesList.remove(selectedStudentInClass);
        classModel.uploadKlasseInfo(String.valueOf(selectedClass));
    }
}
