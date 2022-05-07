package GUI.Model;

import BLL.CategoryManager;
import BLL.LoginManager;
import DAL.CategoryDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.SQLException;

public class CategoryModel {
    private CategoryManager categoryManager;

    /**
     * Constructor
     * @throws IOException
     */
    public CategoryModel() throws IOException {
        categoryManager = new CategoryManager();
    }

    /**
     * Gets the createCategory caseID, ProblemName and ProblemDescription using createCategory from CategoryManager
     * @param caseID
     * @param ProblemName
     * @param ProblemDescription
     * @throws SQLServerException
     */
    public void createCategory(int caseID, String ProblemName, String ProblemDescription) throws SQLException{
        categoryManager.createCategory(caseID, ProblemName, ProblemDescription);
    }

    /**
     * Gets the readCategory caseID and ProblemName using readCategory from CategoryManager
     * @param caseID
     * @param ProblemName
     * @return
     * @throws SQLServerException
     */
    public String readCategory(int caseID, String ProblemName) throws SQLException{
        return categoryManager.readCategory(caseID, ProblemName);
    }

    /**
     * Gets the updateCategory caseID, ProblemName and ProblemDescription using updateCategory from CategoryManager
     * @param caseID
     * @param ProblemName
     * @param ProblemDescription
     * @throws SQLServerException
     */
    public void updateCategory(int caseID, String ProblemName, String ProblemDescription) throws SQLException{
        categoryManager.updateCategory(caseID, ProblemName, ProblemDescription);
    }
}
