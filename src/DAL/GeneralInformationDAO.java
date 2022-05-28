package DAL;

import BE.GeneralInformation;
import DAL.db.DatabaseConnector;

import java.io.IOException;
import java.sql.*;

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

        String sql = "UPDATE GeneralInfo SET Habit = (?) WHERE PatientID = (?);";

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

        String sql = "UPDATE GeneralInfo SET EducationAndJob = (?) WHERE PatientID = (?);";

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

        String sql = "UPDATE GeneralInfo SET lifestory = (?) WHERE PatientID = (?);";

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

        String sql = "UPDATE GeneralInfo SET healthInformation = (?) WHERE PatientID = (?);";

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

        String sql = "UPDATE GeneralInfo SET AssistiveDevices = (?) WHERE PatientID = (?);";

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

        String sql = "UPDATE GeneralInfo SET HomeLayout = (?) WHERE PatientID = (?);";

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

        String sql = "UPDATE GeneralInfo SET Network = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, Network);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
