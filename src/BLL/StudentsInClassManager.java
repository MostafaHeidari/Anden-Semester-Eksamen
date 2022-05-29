package BLL;

import BE.SchoolGroups;
import BE.Student;
import DAL.db.Teacher.StudentInGroupsDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.SQLException;

public class StudentsInClassManager {
    private StudentInGroupsDAO studentInGroupsDAO;

    /**
     * Gets the StudentsInClassManger using StudentsInClassManger from studentInClassesDAO
     * @return
     * @throws SQLServerException
     */
    public StudentsInClassManager() throws IOException {
        studentInGroupsDAO = new StudentInGroupsDAO();
    }


    /**
     * Gets the deleteStudentInClass selectedClass and selectedStudentInClass using deleteStudentInClass from studentInClassesDAO
     * @param selectedClass
     * @param selectedStudentInClass
     * @throws SQLServerException
     */
    public void deleteStudentInGroups(SchoolGroups selectedClass, Student selectedStudentInClass) throws SQLException {
        studentInGroupsDAO.deleteStudentInGroups(selectedClass,selectedStudentInClass);
    }
}
