package BLL;

import BE.Student;
import DAL.CategoryDAO;

import java.io.IOException;
import java.sql.SQLException;

public class CategoryManager {

    CategoryDAO categoryDAO = new CategoryDAO();

    public CategoryManager() throws IOException {
    }

    //this method sender information til categoryDAO //
    public void createCategory(int caseID, String ProblemNavn, String ProblemBeskrivelse) throws SQLException {
        categoryDAO.createCategory(caseID,ProblemNavn,ProblemBeskrivelse);
    }


    // read category method
    public String readCategory(int caseID, String ProblemNavn) throws SQLException {
        return categoryDAO.readCategory(caseID,ProblemNavn);
    }

    //update category method
    public void updateCategory(int caseID, String ProblemNavn, String ProblemBeskrivelse) throws SQLException{
        categoryDAO.updateCategory(caseID,ProblemNavn,ProblemBeskrivelse);
    }
}
