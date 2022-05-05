package BLL;

import BE.Student;
import DAL.CategoryDAO;

import java.io.IOException;
import java.sql.SQLException;

public class CategoryManager {

    CategoryDAO categoryDAO = new CategoryDAO();

    public CategoryManager() throws IOException {
    }

    //this method is used to create category
    public void createCategory(int caseID, String ProblemNavn, String ProblemBeskrivelse) throws SQLException {

    }
}
