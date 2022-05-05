package DAL;

import BE.Login;
import BE.SchoolClass;
import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private DatabaseConnector DC;

    /**
     * Constructor
     * @throws IOException
     */
    public CategoryDAO() throws IOException
    {
        DC = new DatabaseConnector();
    }

    /**
     * this method gets a createCategory from the database
     * @param caseID
     * @param ProblemNavn
     * @param ProblemBeskrivelse
     * @throws SQLServerException
     */
    public void createCategory(int caseID, String ProblemNavn, String ProblemBeskrivelse) throws SQLException {

        String sql = "INSERT INTO Helbredstilstande(caseID,ProblemNavn,ProblemBeskrivelse) VALUES (?,?,?);";

        try(Connection connection = DC.getConnection()){

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, caseID);
            ps.setString(2, ProblemNavn);
            ps.setString(3, ProblemBeskrivelse);

            int affectedRows = ps.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    /**
     * this method gets a readCategory from the database
     * @param caseID
     * @param ProblemNavn
     * @throws SQLServerException
     */
    public String readCategory(int caseID, String ProblemNavn) throws SQLException {

        String sql = "SELECT ProblemBeskrivelse FROM Helbredstilstande WHERE caseID = (?) AND ProblemNavn = (?);";

        try(Connection connection = DC.getConnection()){

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, caseID);
            ps.setString(2, ProblemNavn);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String result = rs.getString(1);
                System.out.println(result);
                return result;
            }

            return null;

        } catch (SQLException sqlException) {
            System.out.println("test3");
            sqlException.printStackTrace();
        }
        return null;
    }

    /**
     * this method gets a updateCategory from the database
     * @param caseID
     * @param ProblemNavn
     * @param ProblemBeskrivelse
     * @throws SQLServerException
     */
    public void updateCategory(int caseID, String ProblemNavn, String ProblemBeskrivelse) throws SQLException {

        String sql = "UPDATE Helbredstilstande SET ProblemBeskrivelse = (?)  WHERE caseID = (?) AND ProblemNavn = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ProblemBeskrivelse);
            ps.setInt(2, caseID);
            ps.setString(3, ProblemNavn);

            int affectedRows = ps.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    /**
     * this method gets a deleteCategory from the database
     * @param caseID
     * @param ProblemNavn
     * @param ProblemBeskrivelse
     * @throws SQLServerException
     */
    public void deleteCategory(int caseID, String ProblemNavn, String ProblemBeskrivelse) throws SQLException {
        String sql = "DELETE FROM Helbredstilstande WHERE caseID = ? AND ProblemNavn = ?;";

        try(Connection connection = DC.getConnection()){

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, caseID);
            ps.setString(2, ProblemNavn);

            int affectedRows = ps.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
