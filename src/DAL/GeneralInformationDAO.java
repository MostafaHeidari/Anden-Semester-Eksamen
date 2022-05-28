package DAL;

import BE.GeneralInformation;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

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

    public GeneralInformation createGeneralInformation(String Mestring, String Motivation, String Ressourcer, String Roller, String Vaner, String UddanelseJob, String Livhistorie, String HelbredsOplysninger, String Hjælpemidler, String BoligensIndretning, String Netværk, int PatientID) throws SQLException {
        try (Connection connection = DC.getConnection()) {
            String sql = "INSERT INTO GeneralInfo (Mestring, Motivation, Ressourcer, Roller, Vaner, UddanelseJob, Livhistorie, HelbredsOplysninger, Hjælpemidler, BoligensIndretning, Netværk, PatientID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, Mestring);
                preparedStatement.setString(2, Motivation);
                preparedStatement.setString(3, Ressourcer);
                preparedStatement.setString(4, Roller);
                preparedStatement.setString(5, Vaner);
                preparedStatement.setString(6, UddanelseJob);
                preparedStatement.setString(7, Livhistorie);
                preparedStatement.setString(8, HelbredsOplysninger);
                preparedStatement.setString(9, Hjælpemidler);
                preparedStatement.setString(10, BoligensIndretning);
                preparedStatement.setString(11, Netværk);
                preparedStatement.setInt(12, PatientID);
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                int id = 0;
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                }

                GeneralInformation generalInformation = new GeneralInformation(Mestring, Motivation, Ressourcer,
                        Roller, Vaner, UddanelseJob, Livhistorie, HelbredsOplysninger, Hjælpemidler, BoligensIndretning, Netværk, PatientID
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

    public void updateRoller(String Roller, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET Roller = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, Roller);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateVaner(String Vaner, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET Vaner = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, Vaner);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateUddanelseJob(String UddanelseJob, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET UddanelseJob = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, UddanelseJob);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateLivhistorie(String Livhistorie, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET Livhistorie = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, Livhistorie);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateHelbredsOplysninger(String HelbredsOplysninger, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET HelbredsOplysninger = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, HelbredsOplysninger);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateHjælpemidler(String Hjælpemidler, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET Hjælpemidler = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, Hjælpemidler);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateBoligensIndretning(String BoligensIndretning, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET BoligensIndretning = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, BoligensIndretning);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void updateNetværk(String Netværk, int PatientID) throws SQLException {

        String sql = "UPDATE GeneralInfo SET Netværk = (?) WHERE PatientID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, Netværk);
            preparedStatement.setInt(2, PatientID);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

}
