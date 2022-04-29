package DAL;

import BE.Student;
import DAL.db.DatabaseConnector;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.*;

public class StudentDAO {
    private DatabaseConnector DC;

    public StudentDAO() throws IOException
    {
        DC = new DatabaseConnector();
    }
    public Student uploadStudentinfo(String studentNavn, String studentEfternavn, String studentEmail, String studentAlder) throws SQLException {
        Connection connection = DC.getConnection();

        String sql = "INSERT INTO StudentTable (NameStudent,LastNameStudent,EmailStudent,StudentAge,Student) VALUES (?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, studentNavn);
        ps.setString(2, studentEfternavn);
        ps.setString(3, studentEmail);
        ps.setString(4, studentAlder);
        ps.setString(5, "Student");
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int studentId = rs.getInt(1);
                Student studentCord = new Student(studentId, studentNavn, studentEfternavn,studentEmail,studentAlder);
                return studentCord;
            }

        }
        return null;
    }
}
