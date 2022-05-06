package DAL;

import BE.Login;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        String sql = "SELECT * FROM Login WHERE Username =? AND Password =?;";
        try(Connection connection = connector.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, Username);
            st.setString(2, Password);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                int id = rs.getInt("UserID");
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String UserType = rs.getString("Usertype");
                return new Login(id, username, password, UserType);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Word");
        }
        System.out.println("error");
        return null;
    }
}
