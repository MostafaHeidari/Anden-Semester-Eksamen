package DAL;

import BE.SchoolClass;
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
     * @param klasseNavn
     * @return
     * @throws SQLServerException
     */
    public SchoolClass uploadClassInfo(String klasseNavn) throws SQLException {
        Connection connection = DC.getConnection();

        String sql = "INSERT INTO ClassTable(ClassName) VALUES (?);";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, klasseNavn);
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int klasseId = rs.getInt(1);
                SchoolClass klasseCord = new SchoolClass(klasseId, klasseNavn);
                return klasseCord;
            }
        }
        return null;
    }

    /**
     * This method gets a list of SchoolClass with getAllClasses from the database
     * @return allClasses from database
     * @throws SQLServerException
     */
    public List<SchoolClass> getAllClasses() throws SQLException {
        Connection con = DC.getConnection();

        List<SchoolClass>  allClasses= new ArrayList<>();


        String sql = "SELECT * FROM ClassTable";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) { // Creates and adds Klasser objects into an array list
            SchoolClass klasseCord = new SchoolClass(rs.getInt("ClassID"), rs.getString("ClassName"));
            allClasses.add(klasseCord);
        }

        return allClasses;
    }

    public void deleteAClass(SchoolClass selectedClass) {
        int pId = selectedClass.getClassId();

        String sql1 = "DELETE FROM ClassStudents WHERE ClassID = (?);";
        String sql2 = "DELETE FROM ClassTable WHERE ClassID = (?);";

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
