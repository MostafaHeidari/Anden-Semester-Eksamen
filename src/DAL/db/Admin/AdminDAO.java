package DAL.db.Admin;

import BE.Login;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {


    private DatabaseConnector DC;

    /**
     * Constructor
     * @throws IOException
     */
    public AdminDAO() throws IOException {
        DC = new DatabaseConnector();
    }


    /**
     * This method gets a list of Admin with getAllAdmins from the database
     * @return getAllAdmins from database
     * @throws SQLServerException
     */
    public List<Login> getAllAdmins() throws SQLException {
        Connection con = DC.getConnection();

        List<Login> allAdmins = new ArrayList<>();


        String sql = "SELECT * FROM Login WHERE UserType = 'Admin'";

        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) { // Creates and adds song objects into an array list
            Login adminCord = new Login(rs.getInt("UserId"), rs.getString("Username"),
                    rs.getString("Password"), rs.getString("UserType"));
            allAdmins.add(adminCord);
        }
        return allAdmins;
    }
}
