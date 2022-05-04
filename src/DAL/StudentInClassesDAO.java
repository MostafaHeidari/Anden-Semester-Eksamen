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

    public List<Student> getAllStudentsInClasses(int ClassId) {
        ArrayList<Student> allStudentsInClasses = new ArrayList<>();

        try (Connection connection = DC.getConnection()) {

            String sql = "SELECT * FROM StudentTable INNER JOIN ClassStudents ON ClassStudents.StudentID = Student.Id WHERE ClassStudents.ClassID = ?;";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, ClassId);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                String name = rs.getString("NameStudent");
                String lastName = rs.getString("LastNameStudent");
                String email = rs.getString("EmailStudent");
                String age = rs.getString("StudentAge");
                String username = rs.getString("UserName");
                int id = rs.getInt("Id");

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


}
