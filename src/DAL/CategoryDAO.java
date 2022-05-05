package DAL;

import BE.Login;
import BE.SchoolClass;
import DAL.db.DatabaseConnector;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private DatabaseConnector DC;

    public CategoryDAO() throws IOException
    {
        DC = new DatabaseConnector();
    }

    public void createCategory(int caseID, String ProblemNavn, String ProblemBeskrivelse) throws SQLException {

        String sql = "INSERT INTO ProblemBeskrivelse(caseID,ProblemNavn,ProblemBeskrivelse) VALUES (?,?,?);";

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


    public String readCategory(int caseID, String ProblemNavn) throws SQLException {

        String sql = "SELECT ProblemBeskrivelse FROM Helbredstilstande WHERE caseID = ? AND ProblemNavn = ?;";

        try(Connection connection = DC.getConnection()){

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, caseID);
            ps.setString(2, ProblemNavn);

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {

                    return rs.getString(1);
                }
            }
            return null;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public void updateCategory(int caseID, String ProblemNavn, String ProblemBeskrivelse) throws SQLException {

        String sql = "UPDATE ProblemBeskrivelse SET ProblemBeskrivelse = (?)  WHERE caseID = ? AND ProblemNavn = ?;";

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

    public void deleteCategory(int caseID, String ProblemNavn, String ProblemBeskrivelse) throws SQLException {
        String sql = "DELETE FROM ProblemBeskrivelse WHERE caseID = ? AND ProblemNavn = ?;";

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
