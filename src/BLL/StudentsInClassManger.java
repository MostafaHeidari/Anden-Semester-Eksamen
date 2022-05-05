package BLL;

import BE.SchoolClass;
import BE.Student;
import DAL.StudentInClassesDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.SQLException;

public class StudentsInClassManger {
    private StudentInClassesDAO studentInClassesDAO;

    public StudentsInClassManger() throws IOException {
        studentInClassesDAO = new StudentInClassesDAO();
    }

    public void deleteStudentInClass(SchoolClass selectedClass, Student selectedStudentInClass) throws SQLException {
        studentInClassesDAO.deleteStudentInClass(selectedClass,selectedStudentInClass);

    }
}
