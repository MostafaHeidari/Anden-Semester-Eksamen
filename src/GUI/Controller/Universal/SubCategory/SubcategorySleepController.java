package GUI.Controller.Universal.SubCategory;

import GUI.Controller.Universal.CategoryController;
import GUI.Model.CategoryModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SubcategorySleepController {
    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnLogOut;

    public Text subCatText;
    public TextArea txtDayProblems;
    public TextArea txtSleepProblems;

    // this is instance variable is not used to now//
    private int caseID = -1;

    CategoryModel categoryModel = new CategoryModel();

    /**
     * Constructor
     * @throws IOException
     */
    public SubcategorySleepController() throws IOException, SQLException {

    }

    /**
     * Goes to Category view
     */

    public void subCategoryBack(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) btnBack.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/Category.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        CategoryController controller = loader.getController();
        controller.setCaseID(caseID);

        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }

    /**
     * Goes to Login view
     */
    public void subCategoryLogOut(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) btnLogOut.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }

    /**
     * this button is used to save the information to databassen. if the databassen is empty
     * @param actionEvent
     * @throws SQLException
     */
    public void subCategorySave(ActionEvent actionEvent) throws SQLException {
        if (categoryModel.readCategory(caseID,"Day problems") == null){

            categoryModel.createCategory(caseID,"Day problems",txtDayProblems.getText());
        }
        categoryModel.updateCategory(caseID,"Day problems",txtDayProblems.getText());

        if (categoryModel.readCategory(caseID,"Sleep problems") == null){

            categoryModel.createCategory(caseID,"Sleep problems",txtSleepProblems.getText());
        }
        categoryModel.updateCategory(caseID,"Sleep problems",txtSleepProblems.getText());
    }

    /**
     * this method is used to sende information from en controller to other controller
     * @throws SQLException
     */

    public void setId(int caseID) throws SQLException {
        this.caseID = caseID;
        txtDayProblems.setText(categoryModel.readCategory(caseID,"Day problems"));
        txtSleepProblems.setText(categoryModel.readCategory(caseID,"Sleep problems"));
    }
}