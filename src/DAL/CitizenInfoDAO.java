package DAL;

import BE.CitizenInfo;
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
        while (rs.next()) {
            CitizenInfo citizenInfoCord = new CitizenInfo(
                    rs.getInt("PatientID"),
                    rs.getString("PatientName"),
                    rs.getString("PatientLastName"),
                     rs.getString("PatientEmail"),
                    rs.getString("PatientSex"),
                    rs.getString("PatientGenInfo"));
            allCitizenInfos.add(citizenInfoCord);
        }
        return allCitizenInfos;
    }

    //This method is used to Creating Citizen by inserting information in Patients table in a database.
    public CitizenInfo createCitizen(String citizenName, String citizenLastName, String citizenAddress, String CPR, String citizenInformation) throws SQLException {
        try (Connection connection = DC.getConnection()) {

            String sql = "INSERT INTO Patients (PatientID, PatientName , PatientLastName, PatientGenInfo, Cpr) VALUES (?,?,?,?,?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, citizenName);
                preparedStatement.setString(2, citizenLastName);
                preparedStatement.setString(3, citizenAddress);
                preparedStatement.setString(4, CPR);
                preparedStatement.setString(5, citizenInformation);
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                int id = 0;
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                }

                CitizenInfo citizen = new CitizenInfo(id, citizenName, citizenLastName,citizenAddress, CPR, citizenInformation);
                return citizen;
            }

        } catch (SQLServerException throwables) {
            throw new SQLException();
        }
    }
}
