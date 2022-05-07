package DAL;

import BE.FunctionalAbility;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;

public class FunctionalAbilityDAO {

    private DatabaseConnector DC;

    /**
     * Constructor
     * @throws IOException
     */
    public FunctionalAbilityDAO() throws IOException {
        DC = new DatabaseConnector();
    }

    /**
     * this method gets a uploadCaseID from the database
     * @param condition
     * @param futureCondition
     * @return functionalAbilityCord
     * @throws SQLServerException
     */
    public FunctionalAbility uploadCaseID(String condition, String futureCondition) throws SQLException {
        Connection connection = DC.getConnection();

        String sql = "INSERT INTO FunctionalAbility (condition, fremtidigtilstand) VALUES (?,?);";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, condition);
        ps.setString(2, futureCondition);
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int CaseID = rs.getInt(1);
                FunctionalAbility functionalAbilityCord = new FunctionalAbility(CaseID, condition, futureCondition);
                return functionalAbilityCord;
            }
        }
        return null;
    }


}
