package DAL;

import BE.Case;
import BE.Student;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CaseDAO {

    private DatabaseConnector DC;

    /**
     * Constructor
     * @throws IOException
     */
    public CaseDAO() throws IOException {
        DC = new DatabaseConnector();
    }



    /**
     * Gets a list of getAllCases that are inner joined on PatientsCases
     * @throws IOException
     */
    public List<Case> getAllCases(int citizenId) {

        List<Case> allCases = new ArrayList<>();
        try (Connection connection = DC.getConnection()) {

            String select = "SELECT ct.CaseID AS CaseID, ct.CaseName, ct.CaseInformation\n" +
                    "                FROM Cases AS ct INNER JOIN PatientsCases AS ec ON ct.CaseID = ec.CaseID\n" +
                    "                    WHERE ec.PatientsID = ?";

            PreparedStatement ps = connection.prepareStatement(select, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, citizenId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { // Creates and adds song objects into an array list

                Case aCase = new Case(rs.getInt(1), rs.getString(2),
                        rs.getString(3));
                allCases.add(aCase);
            }

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allCases;
    }

    public Case uploadCaseInfo(String caseName, String informationTxt, int selectedCitizen) throws SQLException {
        Connection connection = DC.getConnection();

        String sql = "INSERT INTO Cases (CaseID,CaseName,CaseInformation) VALUES (?,?,?);";

        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, caseName);
        ps.setString(2, informationTxt);
        ps.setInt(3,);

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int caseId = rs.getInt(1);
                //Add relation between case and citizen
                setCaseCitizen(caseId, selectedCitizen);
                Case caseCord = new Case(caseId, caseName, informationTxt);
                return caseCord;
            }

        }
        return null;
    }

    public void setCaseCitizen(int caseId, int citizenId){
        try (Connection connection = DC.getConnection()) {
            String sql = "INSERT INTO PatientsCases (CaseID, PatientsID) VALUES (?,?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, caseId);
            ps.setInt(2, citizenId);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                //Add relation between Customer and Event
            }
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
