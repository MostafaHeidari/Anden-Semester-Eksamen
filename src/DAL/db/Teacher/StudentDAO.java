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
    public Student uploadStudentinfo(String studentName, String studentLastname, String studentEmail, String studentAge, String userName ) throws SQLException {
        // This is the method to create a EventCoordinator in the Database. This is also where the EventCoordinator gets an ID.

        try (Connection connection = DC.getConnection()) {
            String sql = "INSERT INTO CustomerTable (NameCustomer,LastNameCustomer,PhoneNumberCustomer, EmailCustomer,is_checked,Customer) VALUES (?,?,?,?,?,?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, studentName);
            ps.setString(2, studentLastname);


            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                //Add relation between Customer and Event
                setCaseCitizen(id, eventID);
                return new Customer(id, name, lastName, phoneNumber, email, uploadOver12År);
            }
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
            String sql = "UPDATE StudentTable SET NameStudent= (?), LastNameStudent=(?), EmailStudent=(?), StudentAge=(?), UserName= (?) WHERE StudentID = (?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentUpdate.getStudentName());
            preparedStatement.setString(2, studentUpdate.getLastName());
            preparedStatement.setString(3, studentUpdate.getEmail());
            preparedStatement.setString(4, studentUpdate.getAge());
            preparedStatement.setString(5, studentUpdate.getUserName());
            preparedStatement.setInt(6, studentUpdate.getStudentId());
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

            /* ikke brugt*/

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
            Student studentCord = new Student(rs.getInt("StudentID"), rs.getString("NameStudent"), rs.getString("LastNameStudent"),
                    rs.getString("EmailStudent"), rs.getString("StudentAge"),rs.getString("UserName"));
            allStudents.add(studentCord);
        }
        return allStudents;
    }


    public void setCaseCitizen(int customerId, int eventId){
        try (Connection connection = DC.getConnection()) {
            String sql = "INSERT INTO EventCustomer(CustomerID, EventID) VALUES (?,?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, customerId);
            ps.setInt(2, eventId);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                //Add relation between Customer and Event
            }
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
