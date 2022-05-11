package DAL;

import BE.CitizenInfo;
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

    /**
     * Constructor
     * @throws IOException
     */
    public CitizenInfoDAO() throws IOException
    {
        DC = new DatabaseConnector();
    }

    /**
     * Gets a list of getAllCitizens
     * @throws IOException
     */
    public List<CitizenInfo> getAllCitizens() throws SQLException {
        Connection con = DC.getConnection();

        List<CitizenInfo> allCitizenInfos = new ArrayList<>();


        String sql = "SELECT * FROM Patients";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) { // Creates and adds song objects into an array list
            CitizenInfo citizenInfoCord = new CitizenInfo(rs.getInt("PatientID"), rs.getString("PatientName"), rs.getString("PatientLastName"),
                    rs.getString("PatientAge"));
            allCitizenInfos.add(citizenInfoCord);
        }
        return allCitizenInfos;

    }
}
