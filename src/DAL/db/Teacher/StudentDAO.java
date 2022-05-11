package DAL.db.Teacher;

import BE.SchoolClass;
import BE.Student;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private DatabaseConnector DC;

    /**
     * Constructor
     * @throws IOException
     */
    public StudentDAO() throws IOException {
        DC = new DatabaseConnector();
    }

    /**
     * his method gets a uploadStudentinfo from the database
     * @param studentName
     * @param studentLastname
     * @return uploadStudentinfo
     * @throws SQLServerException
     */
    public Student uploadStudentinfo(String studentName, String studentLastname, String userName ) throws SQLException {
        Connection connection = DC.getConnection();

        String sql = "INSERT INTO StudentTable (NameStudent,LastNameStudent,UserName) VALUES (?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, studentName);
        ps.setString(2, studentLastname);
        ps.setString(3, userName);
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int studentId = rs.getInt(1);
                Student studentCord = new Student(studentId, studentName, studentLastname,userName);
                return studentCord;
            }

        }
        return null;
    }


    /**
     * his method gets a editStudent from the database
     * @param studentUpdate
     * @throws SQLServerException
     */
    public void editStudent(Student studentUpdate) throws Exception {
        try (Connection connection = DC.getConnection()) {
            String sql = "UPDATE StudentTable SET NameStudent= (?), LastNameStudent=(?), UserName= (?) WHERE StudentID = (?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentUpdate.getStudentName());
            preparedStatement.setString(2, studentUpdate.getLastName());
            preparedStatement.setString(3, studentUpdate.getUserName());
            preparedStatement.setInt(4, studentUpdate.getStudentId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * his method gets a removeStudent from the database
     * @param student
     * @throws SQLServerException
     */
    public void removeStudent(Student student) {
        String sql1 = "DELETE FROM ClassStudents WHERE StudentID = (?);";
        String sql2 = "DELETE FROM StudentTable WHERE StudentID = (?);";

        try (Connection connection = DC.getConnection()) {

            PreparedStatement ps1 = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement ps2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);

            ps1.setInt(1, student.getStudentId());
            ps2.setInt(1, student.getStudentId());

            ps1.executeUpdate();
            ps2.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * This method gets a list of Student with getAllStudents from the database
     * @return getAllStudents from database
     * @throws SQLServerException
     */
    public List<Student> getAllStudents() throws SQLException {
        Connection con = DC.getConnection();

        List<Student> allStudents = new ArrayList<>();


        String sql = "SELECT * FROM StudentTable";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) { // Creates and adds song objects into an array list
            Student studentCord = new Student(rs.getInt("StudentID"), rs.getString("NameStudent"),
                    rs.getString("LastNameStudent") ,rs.getString("UserName"));
            allStudents.add(studentCord);
        }
        return allStudents;
    }


}
