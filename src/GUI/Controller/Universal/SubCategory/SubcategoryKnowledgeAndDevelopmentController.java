package GUI.Controller.Universal.SubCategory;

import BE.CitizenInfo;
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

public class SubcategoryKnowledgeAndDevelopmentController {
    private CitizenInfo selectedCitizenInfo;


    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnLogOut;

    @FXML
    public Text subCatText;
    @FXML
    public TextArea txtMemoryProblems;
    @FXML
    public TextArea txtTreatmentPurpose;
    @FXML
    public TextArea txtDiseaseInsight;

    // this is instance variable is not used to now//
    private int caseID = -1;

    CategoryModel categoryModel = new CategoryModel();

    /**
     * Constructor
     * @throws IOException
     */
    public SubcategoryKnowledgeAndDevelopmentController() throws IOException, SQLException {

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
        controller.setSelectedCitizen(selectedCitizenInfo);

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
        if (categoryModel.readCategory(caseID,"Memory problems") == null){

            categoryModel.createCategory(caseID,"Memory problems",txtMemoryProblems.getText());
        }
        categoryModel.updateCategory(caseID,"Memory problems",txtMemoryProblems.getText());

        if (categoryModel.readCategory(caseID,"TreatmentProblems") == null){

            categoryModel.createCategory(caseID,"TreatmentProblems",txtTreatmentPurpose.getText());
        }
        categoryModel.updateCategory(caseID,"TreatmentProblems",txtTreatmentPurpose.getText());

        if (categoryModel.readCategory(caseID,"Disease Insight problems") == null){

            categoryModel.createCategory(caseID,"Disease Insight problems",txtDiseaseInsight.getText());
        }
        categoryModel.updateCategory(caseID,"Disease Insight problems",txtDiseaseInsight.getText());
    }

    /**
     * this method is used to sende information from en controller to other controller
     * @throws SQLException
     */

    public void setId(int caseID) throws SQLException {
        this.caseID = caseID;
        txtMemoryProblems.setText(categoryModel.readCategory(caseID,"Memory problems"));
        txtTreatmentPurpose.setText(categoryModel.readCategory(caseID,"TreatmentProblems"));
        txtDiseaseInsight.setText(categoryModel.readCategory(caseID,"Disease Insight problems"));
    }

    public void setSelectedCitizen(CitizenInfo selectedCitizen) {
        selectedCitizenInfo = selectedCitizen;
    }

}
