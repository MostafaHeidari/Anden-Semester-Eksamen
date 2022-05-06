package DAL;

import BE.Citizen;
import DAL.db.DatabaseConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CitizenInfoDAO {

    private DatabaseConnector DC;

    public CitizenInfoDAO() throws IOException
    {
        DC = new DatabaseConnector();
    }

    public List<Citizen> getAllCitizens() throws SQLException {
        Connection con = DC.getConnection();

        List<Citizen> allCitizens = new ArrayList<>();


        String sql = "SELECT * FROM Patients";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) { // Creates and adds song objects into an array list
            Citizen citizenCord = new Citizen(rs.getInt("PatientID"), rs.getString("PatientName"), rs.getString("PatientLastName"),
                    rs.getString("PatientAge"));
            allCitizens.add(citizenCord);
        }
        return allCitizens;

    }
}
