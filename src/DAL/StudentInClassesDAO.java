package DAL;

import BE.SchoolClass;
import BE.Student;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentInClassesDAO {

    private DatabaseConnector DC;

    public StudentInClassesDAO() throws IOException {
        DC = new DatabaseConnector();
    }
    public void addStudentToClass(SchoolClass selectedClass, Student selectedStudent) throws SQLException {
        Connection connection = DC.getConnection();
        int cId = selectedClass.getClassId();
        int sId = selectedStudent.getStudentId();

        String sql = "INSERT INTO ClassStudents (ClassID , StudentID) VALUES ((?), (?)); ";

        PreparedStatement pst = connection.prepareStatement(sql);

        pst.setInt(1, cId);
        pst.setInt(2, sId);

        pst.executeUpdate();
    }

    public List<Student> getAllStudentsInClass(int classId) {
        ArrayList<Student> allStudentsInClasses = new ArrayList<>();

        try (Connection connection = DC.getConnection()) {

            String sql = "SELECT StudentTable.* FROM StudentTable INNER JOIN ClassStudents ON StudentTable.StudentID = ClassStudents.StudentID WHERE ClassStudents.ClassID = (?);";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, classId);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                String name = rs.getString("NameStudent");
                String lastName = rs.getString("LastNameStudent");
                String email = rs.getString("EmailStudent");
                String age = rs.getString("StudentAge");
                String username = rs.getString("UserName");
                int id = rs.getInt("StudentID");

                allStudentsInClasses.add(new Student(id, name, lastName, email, age, username));

            }
            return allStudentsInClasses;
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allStudentsInClasses;
    }

    //removes a Student from a single Class
    //@param Class
    //@param Student
    public void deleteStudentInClass(SchoolClass selectedClass, Student selectedStudentInClass) throws SQLException {
        Connection connection = DC.getConnection();
        int cId = selectedClass.getClassId();
        int mId = selectedStudentInClass.getStudentId();

        String sql = "DELETE FROM ClassStudents WHERE ClassID = (?) AND StudentID = (?); ";

        PreparedStatement pst = connection.prepareStatement(sql);

        pst.setInt(1, cId);
        pst.setInt(2, mId);

        pst.executeUpdate();
    }
}
