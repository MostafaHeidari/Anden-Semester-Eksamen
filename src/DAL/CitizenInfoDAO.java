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
                    rs.getString("PatientAge"),
                    rs.getInt("PatientPhone"),
                    rs.getString("PatientEmail"),
                    rs.getBoolean("PatientSex"),
                    rs.getString("PatientGenInfo"));
            allCitizenInfos.add(citizenInfoCord);
        }
        return allCitizenInfos;
    }

    public CitizenInfo createCitizen(String citizenName, String citizenLastName, String citizenAge, int phoneNumber, String address, String sex, String information) throws SQLException {
        try (Connection connection = DC.getConnection()) {
            String sql = "INSERT INTO Citizen (firstName, lastName , SSN, address, sex, info) VALUES (?,?,?,?,?,?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, citizenName);
                preparedStatement.setString(2, citizenLastName);
                preparedStatement.setString(3, citizenAge);
                preparedStatement.setInt(4, phoneNumber);
                preparedStatement.setString(5, address);
                preparedStatement.setBoolean(6, Boolean.parseBoolean(sex));
                preparedStatement.setString(7, information);
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                int id = 0;
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                }

                CitizenInfo citizen = new CitizenInfo(id, citizenName, citizenLastName, citizenAge, phoneNumber,address, sex, information);
                return citizen;
            }
        } catch (SQLServerException throwables) {
            throw new SQLException();
        }
    }
}
