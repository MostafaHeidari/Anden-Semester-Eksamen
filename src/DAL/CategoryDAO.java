package DAL;

import DAL.db.DatabaseConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;

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
     * @param ProblemName
     * @param ProblemDescription
     * @throws SQLServerException
     */
    public void createCategory(int caseID, String ProblemName, String ProblemDescription, String ExpectedCondition) throws SQLException {

        String sql = "INSERT INTO HealthConditions(caseID,ProblemName,ProblemDescription, ExpectedCondition) VALUES (?,?,?,?);";

        System.out.println("Create 4");
        try(Connection connection = DC.getConnection()){

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, caseID);
            ps.setString(2, ProblemName);
            ps.setString(3, ProblemDescription);
            ps.setString(4, ExpectedCondition);

            int affectedRows = ps.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    /**
     * this method gets a readCategory from the database
     * @param caseID
     * @param ProblemName
     * @throws SQLServerException
     */
    public String[] readCategory(int caseID, String ProblemName) throws SQLException {

        String sql = "SELECT ProblemDescription, ExpectedCondition FROM HealthConditions WHERE caseID = (?) AND ProblemName = (?);";

        try(Connection connection = DC.getConnection()){

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, caseID);
            ps.setString(2, ProblemName);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String[] result = new String[2];
                result[0] = rs.getString(1);
                result[1] = rs.getString(2);

                System.out.println(result);
                return result;
            }
            return null;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    /**
     * this method gets a updateCategory from the database
     * @param caseID
     * @param ProblemName
     * @param ProblemDescription
     * @throws SQLServerException
     */
    public void updateCategory(int caseID, String ProblemName, String ProblemDescription, String ExpectedCondition) throws SQLException {

        String sql = "UPDATE HealthConditions SET ProblemDescription = (?), ExpectedCondition = (?) WHERE caseID = (?) AND ProblemName = (?);";

        try(Connection connection = DC.getConnection()){
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ProblemDescription);
            ps.setString(2, ExpectedCondition);
            ps.setInt(3, caseID);
            ps.setString(4, ProblemName);

            int affectedRows = ps.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    /**
     * this method gets a deleteCategory from the database
     * @param caseID
     * @param ProblemName
     * @param ProblemDescription
     * @throws SQLServerException
     */
    public void deleteCategory(int caseID, String ProblemName, String ProblemDescription) throws SQLException {
        String sql = "DELETE FROM HealthConditions WHERE caseID = ? AND ProblemName = ?;";

        try(Connection connection = DC.getConnection()){

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, caseID);
            ps.setString(2, ProblemName);

            int affectedRows = ps.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
