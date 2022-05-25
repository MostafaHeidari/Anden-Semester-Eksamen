package BLL;

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
     * Gets the createCategory caseID, ProblemName and ProblemDescription using createCategory from CategoryDAO
     * @param caseID
     * @param ProblemName
     * @param ProblemDescription
     * @throws SQLServerException
     */
    public void createCategory(int caseID, String ProblemName, String ProblemDescription, String ExpectedCondition) throws SQLException {
        categoryDAO.createCategory(caseID,ProblemName,ProblemDescription, ExpectedCondition);
    }


    /**
     * Gets the readCategory caseID, ProblemName using createCategory from CategoryDAO
     * @param caseID
     * @param ProblemName
     * @return
     * @throws SQLServerException
     */
    public String[] readCategory(int caseID, String ProblemName) throws SQLException {
        return categoryDAO.readCategory(caseID,ProblemName);
    }

    /**
     * Gets the updateCategory caseID, ProblemName and ProblemDescription using createCategory from CategoryDAO
     * @param caseID
     * @param ProblemName
     * @param ProblemDescription
     * @throws SQLServerException
     */
    public void updateCategory(int caseID, String ProblemName, String ProblemDescription, String ExpectedCondition) throws SQLException{
        categoryDAO.updateCategory(caseID,ProblemName,ProblemDescription, ExpectedCondition);
    }
}
