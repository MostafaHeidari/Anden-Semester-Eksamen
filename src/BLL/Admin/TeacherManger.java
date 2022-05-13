package BLL.Admin;

import BE.Student;
import BE.Teacher;
import DAL.db.Admin.TeacherDAO;
import DAL.db.Teacher.StudentDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class TeacherManger {

    TeacherDAO teacherDAO;


    /**
     * Constructor
     * @throws IOException
     */
    public TeacherManger() throws IOException {
        teacherDAO = new TeacherDAO();
    }

    /**
     * Gets the list of getAllTeachers using the getAllTeachers method in teacherDAO.
     * @return a list of getAllTeachers
     */
    public ObservableList<Teacher> getAllTeachers() {
        ObservableList<Teacher> teachersObs = FXCollections.observableArrayList();

        try {
            teachersObs.addAll(teacherDAO.getAllTeachers());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teachersObs;
    }


    /**
     * Gets the uploadTeacherInfo teacherName, teacherLastName, studentEmail and teacherUserName  using uploadTeacherInfo from teacherDAO
     * @param teacherName
     * @param teacherLastName
     * @param teacherEmail
     * @param teacherUserName
     * @return
     * @throws SQLServerException
     */
    public Teacher uploadTeacherInfo(String teacherName, String teacherLastName, String teacherEmail, String teacherUserName) throws SQLException {
        return(teacherDAO.uploadTeacherInfo(teacherName, teacherLastName, teacherEmail, teacherUserName));
    }

    /**
     * Gets the removeTeacher selectedTeacher using removeTeacher from studentDAO
     * @param selectedTeacher
     * @throws SQLServerException
     */
    public void removeTeacher(Teacher selectedTeacher) {
        teacherDAO.removeTeacher(selectedTeacher);
    }
}
