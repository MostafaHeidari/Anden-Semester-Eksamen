package DAL;

import BE.GeneralInformation;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;

public class GeneralInformationDAO {

    private DatabaseConnector DC;

    /**
     * Constructor
     * @throws IOException
     */
    public GeneralInformationDAO(DatabaseConnector DC) {
        this.DC = DC;
    }

    public GeneralInformation createGeneralInformation(String mestring, String motivation, String resources, String roles, String habits, String educationAndJob, String lifestory, String healthInformation, String AssistiveDevices,  String homeLayout,String network) throws SQLException {
        try (Connection connection = DC.getConnection()) {
            String sql = "INSERT INTO GeneralInformation (Mestring, motivation, Resources, Roles, Habits," +
                    "EducationAndJob, Lifestory, Network, HealthInformation, AssistiveDevices, Homelayout) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
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
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                int id = 0;
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                }

                GeneralInformation generalInformation = new GeneralInformation(id, mestring, motivation, resources,
                        roles, habits, educationAndJob, lifestory,healthInformation, AssistiveDevices,homeLayout, network
                        );
                return generalInformation;
            }
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
