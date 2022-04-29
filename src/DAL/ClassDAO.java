package DAL;

import BE.Class;
import DAL.db.DatabaseConnector;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {

    private DatabaseConnector DC;

    public ClassDAO() throws IOException
    {
        DC = new DatabaseConnector();
    }

    public Class uploadClassInfo(String klasseNavn) throws SQLException {
        Connection connection = DC.getConnection();

        String sql = "INSERT INTO ClassTable(ClassName,Class) VALUES (?,?);";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, klasseNavn);;
        ps.setString(2, "Class");
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int klasseId = rs.getInt(1);
                Class klasseCord = new Class(klasseId, klasseNavn);
                return klasseCord;
            }

        }
        return null;
    }


    public List<Class> getAllClasses() throws SQLException {
        Connection con = DC.getConnection();

        List<Class>  allClasses= new ArrayList<>();


        String sql = "SELECT * FROM ClassTable";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) { // Creates and adds Klasser objects into an array list
            Class klasseCord = new Class(rs.getInt("ClassID"), rs.getString("ClassName"));
            allClasses.add(klasseCord);
        }
        return allClasses;
    }
}
