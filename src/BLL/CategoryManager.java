package BLL;

import BE.Student;
import DAL.CategoryDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.SQLException;

public class CategoryManager {

    CategoryDAO categoryDAO = new CategoryDAO();
    /**
     * Constructor
     * @throws IOException
     */
    public CategoryManager() throws IOException {
    }

    /**
     * Gets the createCategory caseID, ProblemNavn and ProblemBeskrivelse using createCategory from CategoryDAO
     * @param caseID
     * @param ProblemNavn
     * @param ProblemBeskrivelse
     * @throws SQLServerException
     */
    public void createCategory(int caseID, String ProblemNavn, String ProblemBeskrivelse) throws SQLException {
        categoryDAO.createCategory(caseID,ProblemNavn,ProblemBeskrivelse);
    }


    /**
     * Gets the readCategory caseID, ProblemNavn and ProblemBeskrivelse using createCategory from CategoryDAO
     * @param caseID
     * @param ProblemNavn
     * @return
     * @throws SQLServerException
     */
    public String readCategory(int caseID, String ProblemNavn) throws SQLException {
        return categoryDAO.readCategory(caseID,ProblemNavn);
    }

    /**
     * Gets the updateCategory caseID, ProblemNavn and ProblemBeskrivelse using createCategory from CategoryDAO
     * @param caseID
     * @param ProblemNavn
     * @param ProblemBeskrivelse
     * @throws SQLServerException
     */
    public void updateCategory(int caseID, String ProblemNavn, String ProblemBeskrivelse) throws SQLException{
        categoryDAO.updateCategory(caseID,ProblemNavn,ProblemBeskrivelse);
    }
}
