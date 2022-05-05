package GUI.Model;

import BE.SchoolClass;
import BE.Student;
import BLL.StudentManger;
import DAL.StudentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class StudentModel {


    StudentDAO studentDAO = new StudentDAO();
    private ClassModel classModel;


    private ObservableList<Student> studentsList = FXCollections.observableArrayList();
    private ObservableList<Student> studentInClassesList = FXCollections.observableArrayList();




    private StudentManger studentManger;

    public StudentModel() throws IOException {
        studentManger = new StudentManger();
        classModel = new ClassModel();
    }

    public void uploadStudentinfo(String studentNavn, String studentEfternavn, String studentEmail, String studentAlder, String userName) throws SQLException {
        //studentsList.add(studentManger.uploadStudentinfo(studentNavn,studentEfternavn,studentEmail,studentAlder,userName));
    }


    public ObservableList<Student> getAllStudents() throws IOException {
        studentsList = studentManger.getAllStudents();
        return studentsList;
    }

    // Edits a student using the editStudent method from userManager 3 //

    public void editStudent(Student student) throws Exception {
        studentManger.editStudent(student);
        studentsList.clear();
        studentsList.addAll(studentManger.getAllStudents());
    }

    public void addStudentToClass(SchoolClass selectedClass, Student selectedStudent) throws SQLException {
        studentManger.addStudentToClass(selectedClass,selectedStudent);
        studentInClassesList.add(selectedStudent);
    }


    public ObservableList<Student> setStudentsInClass(int classId){
        studentsList = studentManger.getAllStudentsByClass(classId);
        return studentsList;
    }





    /* Deletes student using the deleteStudent method from StudentManager */

    public void removeStudent (Student selectedStudent) {
        studentManger.removeStudent(selectedStudent);
        studentsList.remove(selectedStudent);
    }
}
