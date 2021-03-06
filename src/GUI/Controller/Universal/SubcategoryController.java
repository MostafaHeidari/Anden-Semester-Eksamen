package GUI.Controller.Universal;

import BE.CitizenInfo;
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
import java.util.Objects;

public class SubcategoryController {

    private CitizenInfo selectedCitizenInfo;

    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnLogOut;

    public Text subCatText;
    public TextArea txtDescription;

   // this is instance variable is not used to now//
    private int caseID = 27;
    private String problemName;

    CategoryModel categoryModel = new CategoryModel();

    /**
     * Constructor
     * @throws IOException
     */
    public SubcategoryController() throws IOException {
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
        controller.setSelectedCitizen(selectedCitizenInfo);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }

    /**
     * Goes to Login view
     */
    public void subCategoryLogOut(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) btnLogOut.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/View/Universal/Login.fxml")));
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
        if (categoryModel.readCategory(caseID,problemName) == null){

            categoryModel.createCategory(caseID,problemName,txtDescription.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,problemName,txtDescription.getText(), "Condition");
    }

    /**
     * this method is used to sende information from en controller to other controller
     * @param problemName
     * @throws SQLException
     */
    public void setId(String problemName) throws SQLException {
        this.problemName = problemName;
        txtDescription.setText(categoryModel.readCategory(caseID,problemName)[0]);
        subCatText.setText(problemName);
    }

    public void setSelectedCitizen(CitizenInfo selectedCitizen) {
        selectedCitizenInfo = selectedCitizen;
    }
}
