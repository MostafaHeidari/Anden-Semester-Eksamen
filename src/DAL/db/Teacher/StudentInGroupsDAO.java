package DAL.db.Teacher;

import BE.SchoolGroups;
import BE.Student;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentInGroupsDAO {

    private DatabaseConnector DC;

    /**
     * Constructor
     * @throws IOException
     */
    public StudentInGroupsDAO() throws IOException {
        DC = new DatabaseConnector();
    }

    /**
     * his method gets a addStudentToClass from the database
     * @param selectedGroup
     * @param selectedStudent
     * @throws SQLServerException
     */
    public void addStudentToGroup(SchoolGroups selectedGroup, Student selectedStudent) throws SQLException {
        Connection connection = DC.getConnection();
        int cId = selectedGroup.getGroupId();
        int sId = selectedStudent.getStudentId();

        String sql = "INSERT INTO ClassStudents (ClassID , StudentID) VALUES ((?), (?)); ";

        PreparedStatement pst = connection.prepareStatement(sql);

        pst.setInt(1, cId);
        pst.setInt(2, sId);

        pst.executeUpdate();
    }


    /**
     * This method gets a list of Student with getAllStudentsInClass from the database
     * @param classId
     * @return allStudentsInClasses from database
     * @throws SQLServerException
     */
    public List<Student> getAllStudentsInGroups(int classId) {
        ArrayList<Student> allStudentsInGroups = new ArrayList<>();

        try (Connection connection = DC.getConnection()) {

            String sql = "SELECT StudentTable.* FROM StudentTable INNER JOIN GroupStudents ON StudentTable.StudentID = GroupStudents.StudentID WHERE GroupStudents.GroupID = (?);";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, classId);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                String name = rs.getString("NameStudent");
                String lastName = rs.getString("LastNameStudent");
                String username = rs.getString("UserName");
                int id = rs.getInt("StudentID");

                allStudentsInGroups.add(new Student(id, name, lastName, username));

            }
            return allStudentsInGroups;
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allStudentsInGroups;
    }

    /**
     * his method gets a deleteStudentInClass from the database
     * @param selectedGroup
     * @param selectedStudentInClass
     * @throws SQLServerException
     */
    public void deleteStudentInGroups(SchoolGroups selectedGroup, Student selectedStudentInClass) throws SQLException {
        Connection connection = DC.getConnection();
        int cId = selectedGroup.getGroupId();
        int mId = selectedStudentInClass.getStudentId();

        String sql = "DELETE FROM GroupStudents WHERE ClassID = (?) AND StudentID = (?); ";

        PreparedStatement pst = connection.prepareStatement(sql);

        pst.setInt(1, cId);
        pst.setInt(2, mId);

        pst.executeUpdate();
    }
}
