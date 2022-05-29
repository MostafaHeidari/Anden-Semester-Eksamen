package DAL;

import BE.GeneralInformation;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneralInformationDAO {

    private final DatabaseConnector DC;

    /**
     * Constructor
     *
     * @throws IOException
     */
    public GeneralInformationDAO() throws IOException {
        DC = new DatabaseConnector();
    }

    public GeneralInformation createGeneralInformation(String mestring, String motivation, String resources, String roles, String habits, String educationAndJob, String lifestory, String healthInformation, String AssistiveDevices, String homeLayout, String network, int PatientID) throws SQLException {
        try (Connection connection = DC.getConnection()) {
            String sql = "INSERT INTO GeneralInfo (Mestring, Motivation, Ressourcer, Roller, Vaner, UddanelseJob, Livhistorie, HelbredsOplysninger, Hjælpemidler, BoligensIndretning, Netværk, PatientID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, mestring);
                preparedStatement.setString(2, motivation);
                preparedStatement.setString(3, resources);
                preparedStatement.setString(4, roles);
                preparedStatement.setString(5, habits);
                preparedStatement.setString(6, educationAndJob);
                preparedStatement.setString(7, lifestory);
                preparedStatement.setString(9, healthInformation);
                preparedStatement.setString(10, AssistiveDevices);
                preparedStatement.setString(11, homeLayout);
                preparedStatement.setString(8, network);
                preparedStatement.setInt(12, PatientID);
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                int id = 0;
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                }

                GeneralInformation generalInformation = new GeneralInformation(mestring, motivation, resources,
                        roles, habits, educationAndJob, lifestory, healthInformation, AssistiveDevices, homeLayout, network, PatientID
                );
                return generalInformation;
            }
        }
    }
    public void updateMestring(String Mestring, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET Mestring = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, Mestring);
            preparedStatement.setInt(2, PatientID);


            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateMotivation(String Motivation, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET Motivation = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, Motivation);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateRessourcer(String Ressourcer, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET Ressourcer = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, Ressourcer);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateRoller(String Roles, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET Roller = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, Roles);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateVaner(String Habit, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET Vaner = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, Habit);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateUddanelseJob(String EducationAndJob, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET UddanelseJob = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, EducationAndJob);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateLivhistorie(String lifestory, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET Livhistorie = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, lifestory);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateHelbredsOplysninger(String healthInformation, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET HelbredsOplysninger = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, healthInformation);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateHjælpemidler(String AssistiveDevices, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET Hjælpemidler = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, AssistiveDevices);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateBoligensIndretning(String HomeLayout, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET BoligensIndretning = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, HomeLayout);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateNetværk(String Network, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET Netværk = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, Network);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public List<GeneralInformation> getAllGeneralInformation(int citizenId) {

        List<GeneralInformation> allGeneralInformation = new ArrayList<>();
        try (Connection connection = DC.getConnection()) {

            String select = "SELECT Mestring, Motivation, Ressourcer, Roller, Vaner, UddanelseJob, Livshistorie, HelbredsOplysninger, Hjælpemidler, BoligensOplysninger, Netværk, PatientID\n" +
                    "                FROM GeneralInfo Where PatientID = ?";

            PreparedStatement ps = connection.prepareStatement(select, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, citizenId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                GeneralInformation aGeneralInformation = new GeneralInformation(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12));
                allGeneralInformation.add(aGeneralInformation);
            }

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allGeneralInformation;
    }

    public String getMestring(int PatientID) throws SQLException {

        String getString;
        try (Connection connection = DC.getConnection()) {
            String sql = "SELECT Mestring FROM GeneralInfo WHERE PatientID = (?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, PatientID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            getString = rs.getString(1);
        }
        return getString;
    }

    public String getMotivation(int PatientID) throws SQLException {

        String getString;
        try (Connection connection = DC.getConnection()) {
            String sql = "SELECT Motivation FROM GeneralInfo WHERE PatientID = (?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, PatientID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            getString = rs.getString(1);
        }
        return getString;
    }

    public String getRessourcer(int PatientID) throws SQLException {

        String getString;
        try (Connection connection = DC.getConnection()) {
            String sql = "SELECT Ressourcer FROM GeneralInfo WHERE PatientID = (?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, PatientID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            getString = rs.getString(1);
        }
        return getString;
    }

    public String getRoller(int PatientID) throws SQLException {

        String getString;
        try (Connection connection = DC.getConnection()) {
            String sql = "SELECT Roller FROM GeneralInfo WHERE PatientID = (?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, PatientID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            getString = rs.getString(1);
        }
        return getString;
    }

    public String getVaner(int PatientID) throws SQLException {

        String getString;
        try (Connection connection = DC.getConnection()) {
            String sql = "SELECT Vaner FROM GeneralInfo WHERE PatientID = (?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, PatientID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            getString = rs.getString(1);
        }
        return getString;
    }

    public String getUddanelseJob(int PatientID) throws SQLException {

        String getString;
        try (Connection connection = DC.getConnection()) {
            String sql = "SELECT UddanelseJob FROM GeneralInfo WHERE PatientID = (?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, PatientID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            getString = rs.getString(1);
        }
        return getString;
    }

    public String getLivshistorie(int PatientID) throws SQLException {

        String getString;
        try (Connection connection = DC.getConnection()) {
            String sql = "SELECT Livhistorie FROM GeneralInfo WHERE PatientID = (?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, PatientID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            getString = rs.getString(1);
        }
        return getString;
    }

    public String getHelbredsOplysninger(int PatientID) throws SQLException {

        String getString;
        try (Connection connection = DC.getConnection()) {
            String sql = "SELECT HelbredsOplysninger FROM GeneralInfo WHERE PatientID = (?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, PatientID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            getString = rs.getString(1);
        }
        return getString;
    }

    public String getHjælpemidler(int PatientID) throws SQLException {

        String getString;
        try (Connection connection = DC.getConnection()) {
            String sql = "SELECT Hjælpemidler FROM GeneralInfo WHERE PatientID = (?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, PatientID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            getString = rs.getString(1);
        }
        return getString;
    }

    public String getBoligIndretning(int PatientID) throws SQLException {

        String getString;
        try (Connection connection = DC.getConnection()) {
            String sql = "SELECT BoligensIndretning FROM GeneralInfo WHERE PatientID = (?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, PatientID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            getString = rs.getString(1);
        }
        return getString;
    }

    public String getNetværk(int PatientID) throws SQLException {

        String getString;
        try (Connection connection = DC.getConnection()) {
            String sql = "SELECT Netværk FROM GeneralInfo WHERE PatientID = (?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, PatientID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            getString = rs.getString(1);
        }
        return getString;
    }
}
