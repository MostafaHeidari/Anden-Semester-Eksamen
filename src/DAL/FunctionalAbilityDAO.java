package DAL;

import BE.FunctionalAbility;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
     * @param tilstand
     * @param fremtidigTilstand
     * @param borgerTilstand
     * @return functionalAbilityCord
     * @throws SQLServerException
     */
    public FunctionalAbility uploadCaseID(int CaseID, String tilstand, String fremtidigTilstand, String borgerTilstand) throws SQLException {
        Connection connection = DC.getConnection();

        String sql = "INSERT INTO FunctionalAbility (CaseID, tilstand, fremtidigTilstand, borgerTilstand) VALUES (?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, CaseID);
        ps.setString(2, tilstand);
        ps.setString(3, fremtidigTilstand);
        ps.setString(4, borgerTilstand);
        ps.execute();
        ResultSet resultSet = ps.getGeneratedKeys();
        int id = 0;
        if (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        FunctionalAbility functionalAbilityCord = new FunctionalAbility(CaseID, tilstand, fremtidigTilstand, borgerTilstand);
        return functionalAbilityCord;

    }
/*
    public List<FunctionalAbility> getAllFuncionalAbilities() throws SQLException {
        Connection con = DC.getConnection();

        List<FunctionalAbility> allFuncionalAbilities = new ArrayList<>();


        String sql = "SELECT * FROM FunctionalAbility";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            FunctionalAbility functionalAbilityCord = new FunctionalAbility(
                    rs.getInt("CaseID"),
                    rs.getString("tilstand"),
                    rs.getString("fremtidigTilstand"),
                    rs.getString("borgerTilstand"));
            allFuncionalAbilities.add(functionalAbilityCord);
        }
        return allFuncionalAbilities;
    }

 */
}
