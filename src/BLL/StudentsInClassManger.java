package BLL;

import BE.SchoolClass;
import BE.Student;
import DAL.StudentInClassesDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.SQLException;

public class StudentsInClassManger {
    private StudentInClassesDAO studentInClassesDAO;

    /**
     * Gets the StudentsInClassManger using StudentsInClassManger from studentInClassesDAO
     * @return
     * @throws SQLServerException
     */
    public StudentsInClassManger() throws IOException {
        studentInClassesDAO = new StudentInClassesDAO();
    }


    /**
     * Gets the deleteStudentInClass selectedClass and selectedStudentInClass using deleteStudentInClass from studentInClassesDAO
     * @param selectedClass
     * @param selectedStudentInClass
     * @return
     * @throws SQLServerException
     */
    public void deleteStudentInClass(SchoolClass selectedClass, Student selectedStudentInClass) throws SQLException {
        studentInClassesDAO.deleteStudentInClass(selectedClass,selectedStudentInClass);

    }
}
