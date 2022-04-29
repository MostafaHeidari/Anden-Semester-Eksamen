package DAL;

import BE.Login;
import DAL.db.DatabaseConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    /*instant variable databasen*/
    private final DatabaseConnector connector = DatabaseConnector.getInstance();

    /*Constractor */
    public LoginDAO() throws IOException {
    }

    /**/
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
