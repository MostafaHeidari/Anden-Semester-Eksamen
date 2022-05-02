package DAL;

import BE.Student;
import DAL.db.DatabaseConnector;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            preparedStatement.setString(1, studentUpdate.getStduentName());
            preparedStatement.setString(2, studentUpdate.getEfternavn());
            preparedStatement.setString(3, studentUpdate.getEmail());
            preparedStatement.setString(4, studentUpdate.getAge());
            preparedStatement.setInt(5, studentUpdate.getStudentId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /*
     * Deletes a student
     */
    public void deleteStudent(Student student) {
        String sql1 = "DELETE FROM UserTable WHERE UserID = (?);";
        try (Connection connection = DC.getConnection()) {
            PreparedStatement ps1 = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            ps1.setInt(1, student.getStudentId());
            ps1.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public List<Student> getAllStudents() throws SQLException {
        Connection con = DC.getConnection();

        List<Student> allStudents = new ArrayList<>();


        String sql = "SELECT * FROM StudentTable";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) { // Creates and adds song objects into an array list
            Student studentCord = new Student(rs.getInt("StudentID"),rs.getString("NameStudent"),rs.getString("LastNameStudent"),
                    rs.getString("EmailStudent"),rs.getString("StudentAge"));
            allStudents.add(studentCord);
        }
        return allStudents;
    }




}
