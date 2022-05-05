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
     * Gets the createCategory caseID, ProblemNavn and ProblemBeskrivelse using createCategory from CategoryManager
     * @param caseID
     * @param ProblemNavn
     * @param ProblemBeskrivelse
     * @throws SQLServerException
     */
    public void createCategory(int caseID, String ProblemNavn, String ProblemBeskrivelse) throws SQLException{
        categoryManager.createCategory(caseID, ProblemNavn, ProblemBeskrivelse);
    }

    /**
     * Gets the readCategory caseID and ProblemNavn using readCategory from CategoryManager
     * @param caseID
     * @param ProblemNavn
     * @return
     * @throws SQLServerException
     */
    public String readCategory(int caseID, String ProblemNavn) throws SQLException{
        return categoryManager.readCategory(caseID, ProblemNavn);
    }

    /**
     * Gets the updateCategory caseID, ProblemNavn and ProblemBeskrivelse using updateCategory from CategoryManager
     * @param caseID
     * @param ProblemNavn
     * @param ProblemBeskrivelse
     * @throws SQLServerException
     */
    public void updateCategory(int caseID, String ProblemNavn, String ProblemBeskrivelse) throws SQLException{
        categoryManager.updateCategory(caseID, ProblemNavn, ProblemBeskrivelse);
    }
}
