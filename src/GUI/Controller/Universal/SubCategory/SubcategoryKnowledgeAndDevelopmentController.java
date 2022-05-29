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
import java.util.Objects;

public class SubcategoryKnowledgeAndDevelopmentController {

    private CitizenInfo selectedCitizenInfo;


    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnLogOut;

    @FXML
    private Text subCatText;
    @FXML
    private TextArea txtMemoryProblems;
    @FXML
    private TextArea txtTreatmentPurpose;
    @FXML
    private TextArea txtDiseaseInsight;

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
        if (categoryModel.readCategory(caseID,"Memory problems") == null){

            categoryModel.createCategory(caseID,"Memory problems",txtMemoryProblems.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Memory problems",txtMemoryProblems.getText(), "Condition");

        if (categoryModel.readCategory(caseID,"TreatmentProblems") == null){

            categoryModel.createCategory(caseID,"TreatmentProblems",txtTreatmentPurpose.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"TreatmentProblems",txtTreatmentPurpose.getText(), "Condition");

        if (categoryModel.readCategory(caseID,"Disease Insight problems") == null){

            categoryModel.createCategory(caseID,"Disease Insight problems",txtDiseaseInsight.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Disease Insight problems",txtDiseaseInsight.getText(), "Condition");
    }

    /**
     * this method is used to sende information from en controller to other controller
     * @throws SQLException
     */

    public void setId(int caseID) throws SQLException {
        this.caseID = caseID;
        if(categoryModel.readCategory(caseID,"Memory problems") != null){
            txtMemoryProblems.setText(categoryModel.readCategory(caseID,"Memory problems")[0]);
        }
        if(categoryModel.readCategory(caseID,"TreatmentProblems") != null){
            txtTreatmentPurpose.setText(categoryModel.readCategory(caseID,"TreatmentProblems")[0]);
        }
        if(categoryModel.readCategory(caseID,"Disease Insight problems") != null){
            txtDiseaseInsight.setText(categoryModel.readCategory(caseID,"Disease Insight problems")[0]);
        }
    }

    public void setSelectedCitizen(CitizenInfo selectedCitizen) {
        selectedCitizenInfo = selectedCitizen;
    }
}
