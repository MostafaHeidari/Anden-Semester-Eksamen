package GUI.Model.Admin;

import BE.Login;
import BE.Teacher;
import BLL.LoginManager;
import BLL.Admin.TeacherManger;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class TeacherModel {

    // Static variable reference of single_instance
    // of type Singleton
    private static TeacherModel single_instance = null;


    // Static method
    // Static method to create instance of Singleton class
    public static TeacherModel getInstance() throws IOException {
        if (single_instance == null)
            single_instance = new TeacherModel();

        return single_instance;
    }

    private LoginManager loginManager;

    private TeacherManger teacherManger;

    private ObservableList<Teacher> teacherList = FXCollections.observableArrayList();

    /**
     * Constructor
     * @throws IOException
     */
    public TeacherModel() throws IOException {
        loginManager = new LoginManager();
        teacherManger = new TeacherManger();
    }

    /**
     * Gets the list of getAllStudents using the getAllStudents method in studentManager.
     * @return a list of getAllStudents
     */
    public ObservableList<Teacher> getAllTeachers() {
        teacherList = teacherManger.getAllTeachers();
        return teacherList;
    }

    /**
     * Gets the uploadTeacherInfo teacherName, teacherLastName, teacherEmail and teacherUserName using uploadTeacherInfo from teacherManger
     * @param teacherName
     * @param teacherLastName
     * @param teacherEmail
     * @param teacherUserName
     * @throws SQLServerException
     */
    public void uploadTeacherInfo(String teacherName, String teacherLastName, String teacherEmail, String teacherUserName) throws SQLException {
        teacherList.add(teacherManger.uploadTeacherInfo(teacherName,teacherLastName,teacherEmail,teacherUserName));
    }

    /**
     * Gets the removeTeacher selectedTeacher using removeTeacher from teacherManger
     * @param selectedTeacher
     * @throws SQLServerException
     */
    public void removeTeacher(Teacher selectedTeacher) {
        teacherManger.removeTeacher(selectedTeacher);
        teacherList.remove(selectedTeacher);
    }

}
