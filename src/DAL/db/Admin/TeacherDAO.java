package DAL.db.Admin;

import BE.Teacher;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {
    private DatabaseConnector DC;

    /**
     * Constructor
     * @throws IOException
     */
    public TeacherDAO() throws IOException {
        DC = new DatabaseConnector();
    }

    /**
     * This method gets a list of Teacher with getAllTeachers from the database
     * @return getAllTeachers from database
     * @throws SQLServerException
     */
    public List<Teacher> getAllTeachers() throws SQLException {
        Connection con = DC.getConnection();

        List<Teacher> allTeachers = new ArrayList<>();


        String sql = "SELECT * FROM Teachers";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) { // Creates and adds song objects into an array list
            Teacher teacherCord = new Teacher(rs.getInt("teacherId"), rs.getString("teacherName"),
                    rs.getString("teacherLastName") ,rs.getString("teacherUserName"));
            allTeachers.add(teacherCord);
        }
        return allTeachers;
    }


    /**
     * his method gets a uploadTeacherInfo from the database
     * @param teacherName
     * @param teacherLastName
     * @param teacherUserName
     * @return uploadTeacherInfo
     * @throws SQLServerException
     */
    public Teacher uploadTeacherInfo(String teacherName, String teacherLastName, String teacherUserName) throws SQLException {
        Connection connection = DC.getConnection();

        String sql = "INSERT INTO Teachers (TeacherName,TeacherLastName,TeacherUserName) VALUES (?,?,?);";

        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, teacherName);
        ps.setString(2, teacherLastName);
        ps.setString(3, teacherUserName);

        int affectedRows = ps.executeUpdate();

        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int teacherId = rs.getInt(1);
                Teacher teacherCord = new Teacher(teacherId, teacherName, teacherLastName,teacherUserName);
                return teacherCord;
            }

        }
        return null;

    }

    /**
     * his method gets a removeTeacher from the database
     * @param selectedTeacher
     * @throws SQLServerException
     */
    public void removeTeacher(Teacher selectedTeacher) {

        String sql1 = "DELETE FROM Teachers WHERE TeacherID = (?);";
        String sql2 = "DELETE FROM Login WHERE Username = (?);";

        try (Connection connection = DC.getConnection()) {


            PreparedStatement ps1 = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement ps2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);


            ps1.setInt(1, selectedTeacher.getTeacherId());
            ps2.setString(1, selectedTeacher.getTeacherUserName());


            ps1.executeUpdate();
            ps2.executeUpdate();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
