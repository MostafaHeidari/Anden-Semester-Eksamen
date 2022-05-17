package DAL;

import BE.CitizenInfo;
import BE.Student;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitizenInfoDAO {

    private DatabaseConnector DC;

    /**
     * Constructor
     *
     * @throws IOException
     */
    public CitizenInfoDAO() throws IOException {
        DC = new DatabaseConnector();
    }

    /**
     * Gets a list of getAllCitizens
     *
     * @throws IOException
     */
    public List<CitizenInfo> getAllCitizens() throws SQLException {
        Connection con = DC.getConnection();

        List<CitizenInfo> allCitizenInfos = new ArrayList<>();


        String sql = "SELECT * FROM Patients";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            CitizenInfo citizenInfoCord = new CitizenInfo(
                    rs.getInt("PatientID"),
                    rs.getString("PatientName"),
                    rs.getString("PatientLastName"),
                    rs.getString("PatientGenInfo"),
                    rs.getString("Cpr"),
                    rs.getString("PatientAddress"));
            allCitizenInfos.add(citizenInfoCord);
        }
        return allCitizenInfos;
    }

    //This method is used to Creating Citizen by inserting information in Patients table in a database.
    public CitizenInfo createCitizen(String citizenName, String citizenLastName, String citizenAddress, String CPR, String citizenInformation) throws SQLException {

        try (Connection connection = DC.getConnection()) {

            String sql = "INSERT INTO Patients (PatientName, PatientLastName , PatientGenInfo, Cpr, PatientAddress) VALUES (?,?,?,?,?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, citizenName);
            ps.setString(2, citizenLastName);
            ps.setString(5, citizenInformation);
            ps.setString(4, CPR);
            ps.setString(3, citizenAddress);


            int affectedRows = ps.executeUpdate();

            if (affectedRows == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int citizenId = rs.getInt(1);
                    CitizenInfo citizenCord = new CitizenInfo(citizenId, citizenName, citizenLastName, citizenAddress, CPR, citizenInformation);
                    return citizenCord;
                }

            }
        }
        catch (SQLServerException throwables) {
        throw new SQLException();
        }

        return null;
    }
}


