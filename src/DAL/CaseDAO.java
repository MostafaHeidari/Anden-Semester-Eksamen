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

    /**
     * his method gets a uploadCaseInfo from the database
     * @param caseName
     * @param informationTxt
     * @return uploadCaseInfo
     * @throws SQLServerException
     */
    public Case uploadCaseInfo(String caseName, String informationTxt, int selectedCitizen) throws SQLException {
        Connection connection = DC.getConnection();

        String sql = "INSERT INTO Cases (CaseName,CaseInformation) VALUES (?,?);";

        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, caseName);
        ps.setString(2, informationTxt);


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

    /**
     * This method sets a CaseID in a PatientsID with setCaseCitizen from the database
     * @return setCaseCitizen from database
     * @throws SQLServerException
     */
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

    public void deleteCase(Case selectedCase) {


        String sql1 = "DELETE FROM Cases WHERE CaseID = (?);";
        String sql2 = "DELETE FROM PatientsCases WHERE CaseID = (?);";
        String sql3 = "DELETE FROM FunctionalAbility WHERE CaseID = (?);";

        try (Connection connection = DC.getConnection()) {

            PreparedStatement ps1 = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement ps2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement ps3 = connection.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);

            ps1.setInt(1, selectedCase.getCaseId());
            ps2.setInt(1, selectedCase.getCaseId());
            ps3.setInt(1, selectedCase.getCaseId());

            ps1.executeUpdate();
            ps2.executeUpdate();
            ps3.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
