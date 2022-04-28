package DAL;

import BE.Login;
import DAL.db.DatabaseConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    private final DatabaseConnector connector = DatabaseConnector.getInstance();

    public LoginDAO() throws IOException {
    }


    public Login login(String Username, String Password) {
        String sql = "SELECT * FROM Login WHERE username =? AND password =?;";
        try(Connection connection = connector.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, Username);
            st.setString(2, Password);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                int id = rs.getInt("LoginID");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String UserType = rs.getString("UserType");
                return new Login(id, username, password, UserType);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
}
