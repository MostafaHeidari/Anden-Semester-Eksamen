package DAL;

import BE.FunctionalAbility;
import DAL.db.DatabaseConnector;

import java.io.IOException;
import java.sql.*;

public class FunctionalAbilityDAO {

    private DatabaseConnector DC;

    public FunctionalAbilityDAO() throws IOException {
        DC = new DatabaseConnector();
    }

    public FunctionalAbility uploadCaseID(String tilstand, String fremtidigTilstand) throws SQLException {
        Connection connection = DC.getConnection();

        String sql = "INSERT INTO FunctionalAbility (tilstand, fremtidigtilstand) VALUES (?,?);";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, tilstand);
        ps.setString(2, fremtidigTilstand);
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int CaseID = rs.getInt(1);
                FunctionalAbility functionalAbilityCord = new FunctionalAbility(CaseID, tilstand, fremtidigTilstand);
                return functionalAbilityCord;
            }

        }
        return null;
    }


}
