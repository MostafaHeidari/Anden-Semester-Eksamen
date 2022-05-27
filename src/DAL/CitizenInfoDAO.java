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
                    rs.getString("Age"));
            allCitizenInfos.add(citizenInfoCord);
        }
        return allCitizenInfos;
    }

    //This method is used to Creating Citizen by inserting information in Patients table in a database.
    public CitizenInfo createCitizen(String citizenName, String citizenLastName, String Age) throws SQLException {

        try (Connection connection = DC.getConnection()) {

            String sql = "INSERT INTO Patients (PatientName, PatientLastName, Age) VALUES (?,?,?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, citizenName);
            ps.setString(2, citizenLastName);
            ps.setString(3, Age);



            int affectedRows = ps.executeUpdate();

            if (affectedRows == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int citizenId = rs.getInt(1);
                    CitizenInfo citizenCord = new CitizenInfo(citizenId, citizenName, citizenLastName, Age);
                    return citizenCord;
                }

            }
        } catch (SQLServerException throwables) {
            throw new SQLException();
        }

        return null;
    }

    /**
     * this method update the citizen info from DB.
     *
     * @param citizenInfoUpdate
     * @throws SQLServerException
     */
    public void editCitizen(CitizenInfo citizenInfoUpdate) throws Exception {
        try (Connection connection = DC.getConnection()) {
            String sql = "UPDATE Patients SET PatientName = (?), PatientLastName =(?),  Age = (?) WHERE PatientID = (?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, citizenInfoUpdate.getCitizenName());
            preparedStatement.setString(2, citizenInfoUpdate.getCitizenLastName());
            preparedStatement.setString(3, citizenInfoUpdate.getAge());
            preparedStatement.setInt(4, citizenInfoUpdate.getCitizenId());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * @param citizenInfo
     * @throws SQLServerException
     */
    public void removeCitizen(CitizenInfo citizenInfo) {
        String sql1 = "DELETE FROM Patients WHERE PatientID = (?);";
        String sql2 = "DELETE FROM PatientsCases WHERE PatientsID = (?);";





        try (Connection connection = DC.getConnection()) {
            PreparedStatement ps1 = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement ps2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);

            ps1.setInt(1, citizenInfo.getCitizenId());
            ps2.setInt(1, citizenInfo.getCitizenId());


            ps2.executeUpdate();
            ps1.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


