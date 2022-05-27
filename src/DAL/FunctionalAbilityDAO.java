package DAL;

import BE.FunctionalAbility;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FunctionalAbilityDAO {

    private final DatabaseConnector DC;

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
     * @return functionalAbilityCord
     * @throws SQLServerException
     */
    public FunctionalAbility uploadCaseID(int CaseID, String tilstand, String fremtidigTilstand, String fagligNotat, String udførelse, String betydningUdførelse, String borgerNotat, int CatID) throws SQLException {
        Connection connection = DC.getConnection();

        String sql = "INSERT INTO FunctionalAbility (CaseID, tilstand, fremtidigTilstand, fagligNotat, udførelse, betydningUdførelse, borgerNotat, CatID ) VALUES (?,?,?,?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, CaseID);
        ps.setString(2, tilstand);
        ps.setString(3, fremtidigTilstand);
        ps.setString(4, fagligNotat);
        ps.setString(5, udførelse);
        ps.setString(6, betydningUdførelse);
        ps.setString(7, borgerNotat);
        ps.setInt(8, CatID);

        ps.execute();
        ResultSet resultSet = ps.getGeneratedKeys();
        int id = 0;
        if (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        FunctionalAbility functionalAbilityCord = new FunctionalAbility(CaseID, tilstand, fremtidigTilstand, fagligNotat, udførelse, betydningUdførelse, borgerNotat, CatID);
        return functionalAbilityCord;

    }

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
                    rs.getString("fagligNotat"),
                    rs.getString("udførelse"),
                    rs.getString("betydningUdførelse"),
                    rs.getString("borgerNotat"),
                    rs.getInt("CatID")
            );
            allFuncionalAbilities.add(functionalAbilityCord);
        }
        return allFuncionalAbilities;
    }

    public void updateFunctionalAbility(int CaseID, String tilstand, String fremtidigTilstand, String fagligNotat, String udførelse, String betydningUdførelse, String borgerNotat, int CatID) throws SQLException {

        String sql = "UPDATE FunctionalAbility SET tilstand = (?), fremtidigTilstand = (?), fagligNotat = (?), udførelse = (?), betydningUdførelse = (?), borgerNotat = (?) WHERE CaseID = (?) AND CatID = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tilstand);
            ps.setString(2, fremtidigTilstand);
            ps.setString(3, fagligNotat);
            ps.setString(4, udførelse);
            ps.setString(5, betydningUdførelse);
            ps.setString(6, borgerNotat);
            ps.setInt(7, CaseID);
            ps.setInt(8, CatID);

            ps.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}
