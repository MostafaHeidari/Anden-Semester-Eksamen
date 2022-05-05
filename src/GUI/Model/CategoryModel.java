package GUI.Model;

import BLL.CategoryManager;
import BLL.LoginManager;
import DAL.CategoryDAO;

import java.io.IOException;

public class CategoryModel {
    private CategoryManager categoryManager;

    /**
     * Constructor
     * @throws IOException
     */
    public CategoryModel() throws IOException {
        categoryManager = new CategoryManager();
    }
}
