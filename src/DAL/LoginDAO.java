package DAL;

import BE.Login;
import BE.Student;
import DAL.crypto.BCrypt;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;

public class LoginDAO {

    private final DatabaseConnector connector = DatabaseConnector.getInstance();

    /**
     * Constructor
     * @throws IOException
     */
    public LoginDAO() throws IOException {
    }

    /**
     * this method gets a login from the database
     * @param Username
     * @param Password
     * @return
     * @throws SQLServerException
     */
    public Login login(String Username, String Password) {
        //Get all users where
        String sql = "SELECT * FROM Login WHERE Username =?;";
        try(Connection connection = connector.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, Username);


            ResultSet rs = st.executeQuery();
            while (rs.next()){
                if(rs.getString("Password").equals(BCrypt.hashpw(Password, rs.getString("Salt")))){
                    int id = rs.getInt("UserID");
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

    public Login uploadLogin(String studentUsername, String hashedPassword, String salt) throws SQLException {
        Connection connection = connector.getConnection();

        String sql = "INSERT INTO Login (Username,Password,Usertype, Salt) VALUES (?,?,?, ?);";

        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, studentUsername);
        ps.setString(2, hashedPassword);
        ps.setString(3, "Student");
        ps.setString(4, salt);

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int loginId = rs.getInt(1);
                Login LoginCord = new Login(loginId, studentUsername, hashedPassword,"Student");
                return LoginCord;
            }

        }
        return null;
    }

    public Login uploadLoginTeacher(String userNameTeacher, String hashpw, String salt) throws SQLException {
        Connection connection = connector.getConnection();

        String sql = "INSERT INTO Login (Username,Password,Usertype, Salt) VALUES (?,?,?,?);";

        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, userNameTeacher);
        ps.setString(2, hashpw);
        ps.setString(3, "Teacher");
        ps.setString(4, salt);

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int loginId = rs.getInt(1);
                Login LoginCord = new Login(loginId, userNameTeacher, hashpw,"Teacher");
                return LoginCord;
            }

        }
        return null;
    }

    public Login uploadLoginAdmin(String userNameAdmin, String hashpw, String salt) throws SQLException {
        Connection connection = connector.getConnection();

        String sql = "INSERT INTO Login (Username,Password,Usertype, Salt) VALUES (?,?,?,?);";

        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, userNameAdmin);
        ps.setString(2, hashpw);
        ps.setString(3, "Admin");
        ps.setString(4, salt);

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int loginId = rs.getInt(1);
                Login LoginCord = new Login(loginId, userNameAdmin, hashpw,"Teacher");
                return LoginCord;
            }

        }
        return null;
    }


    /**
     * his method gets a removeAdmin from the database
     * @param selectedAdmin
     * @throws SQLServerException
     */
    public void removeAdmin(Login selectedAdmin) {

        String sql1 = "DELETE FROM Login WHERE UserID = (?);";

        try (Connection connection = connector.getConnection()) {


            PreparedStatement ps1 = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);


            ps1.setInt(1, selectedAdmin.getId());


            ps1.executeUpdate();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
