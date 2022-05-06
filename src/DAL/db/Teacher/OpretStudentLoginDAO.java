package DAL.db.Teacher;

import BE.Login;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;


public class OpretStudentLoginDAO {
    private final DatabaseConnector connector = DatabaseConnector.getInstance();

    /**
     * Constructor
     * @throws IOException
     */
    public OpretStudentLoginDAO() throws IOException {
    }

    /**
     * this method gets a addStudent from the database
     * @param Username
     * @param Password
     * @return
     * @throws SQLServerException
     */
    public Login addStudent(String Username, String Password) throws SQLException {

        String sql = "INSERT INTO Login(Username, Password, Usertype) VALUES (?,?,?)";
        try(Connection connection = connector.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, Username);
            st.setString(2, Password);
            st.setString(3, "Student");
            int affectedRows = st.executeUpdate();
            if (affectedRows == 1) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt("UserId");
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");
                    String UserType = rs.getString("Usertype");
                    return new Login(id, username, password, UserType);
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Word");
        }
        System.out.println("error");
        return null;
    }
}
