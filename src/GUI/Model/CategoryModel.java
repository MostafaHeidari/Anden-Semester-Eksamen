package GUI.Model;

import BLL.CategoryManager;
import BLL.LoginManager;
import DAL.CategoryDAO;

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

    public void createCategory(int caseID, String ProblemNavn, String ProblemBeskrivelse) throws SQLException{
        categoryManager.createCategory(caseID, ProblemNavn, ProblemBeskrivelse);
    }

    public String readCategory(int caseID, String ProblemNavn) throws SQLException{
        return categoryManager.readCategory(caseID, ProblemNavn);
    }

    public void updateCategory(int caseID, String ProblemNavn, String ProblemBeskrivelse) throws SQLException{
        categoryManager.updateCategory(caseID, ProblemNavn, ProblemBeskrivelse);
    }
}
