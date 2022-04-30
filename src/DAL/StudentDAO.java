package DAL;

import BE.Student;
import DAL.db.DatabaseConnector;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.*;

public class StudentDAO {
    private DatabaseConnector DC;

    public StudentDAO() throws IOException {
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
                Student studentCord = new Student(studentId, studentNavn, studentEfternavn, studentEmail, studentAlder);
                return studentCord;
            }

        }
        return null;
    }


    /* Student update */
    public void editStudent(Student studentUpdate) throws Exception {
        try (Connection connection = DC.getConnection()) {
            String sql = "UPDATE Login SET ;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentUpdate.getNavn());
            preparedStatement.setString(2, studentUpdate.getEfternavn());
            preparedStatement.setString(3, studentUpdate.getEmail());
            preparedStatement.setString(4, studentUpdate.getAge());
            preparedStatement.setInt(5, studentUpdate.getStudentId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
