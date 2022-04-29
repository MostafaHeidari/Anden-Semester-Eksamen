package DAL;

import BE.Login;
import BE.OpretStudent;
import DAL.db.DatabaseConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OpretStudentDAO {
    private final DatabaseConnector connector = DatabaseConnector.getInstance();

    public OpretStudentDAO() throws IOException {
    }

    public Login addStudent(String Username, String Password) throws SQLException {

        String sql = "INSERT INTO Login(Username, Password, Usertype) VALUES (?,?,Student)";
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
