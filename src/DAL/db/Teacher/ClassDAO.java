package DAL.db.Teacher;

import BE.SchoolGroups;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {

    private DatabaseConnector DC;

    /**
     * Constructor
     * @throws IOException
     */
    public ClassDAO() throws IOException
    {
        DC = new DatabaseConnector();
    }

    /**
     * this method gets a uploadClassInfo from the database
     * @param groupName
     * @return
     * @throws SQLServerException
     */
    public SchoolGroups uploadClassInfo(String groupName) throws SQLException {
        Connection connection = DC.getConnection();

        String sql = "INSERT INTO GroupTable(GroupName) VALUES (?);";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, groupName);
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int groupId = rs.getInt(1);
                SchoolGroups classCord = new SchoolGroups(groupId, groupName);
                return classCord;
            }
        }
        return null;
    }

    /**
     * This method gets a list of SchoolClass with getAllClasses from the database
     * @return allClasses from database
     */
    public List<SchoolGroups> getAllClasses() throws SQLException {
        Connection con = DC.getConnection();

        List<SchoolGroups>  allGroups= new ArrayList<>();


        String sql = "SELECT * FROM GroupTable";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) { // Creates and adds classes objects into an array list
            SchoolGroups groupCord = new SchoolGroups(rs.getInt("GroupID"), rs.getString("GroupName"));
            allGroups.add(groupCord);
        }

        return allGroups;
    }

    /**
     * this method gets a deleteAClass from the database
     * @param selectedClass
     * @return
     */
    public void deleteAClass(SchoolGroups selectedClass) {
        int pId = selectedClass.getGroupId();

        String sql2 = "DELETE FROM GroupStudents WHERE GroupID = (?);";
        String sql1 = "DELETE FROM GroupTable WHERE GroupID = (?);";

        try(Connection connection = DC.getConnection())
        {
            PreparedStatement ps1 = connection.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
            PreparedStatement ps2 = connection.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);


            ps1.setInt(1, pId);
            ps2.setInt(1, pId);

            ps1.executeUpdate();
            ps2.executeUpdate();


        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
