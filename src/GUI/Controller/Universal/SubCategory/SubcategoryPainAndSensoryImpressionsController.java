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
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SubcategoryPainAndSensoryImpressionsController {
    private CitizenInfo selectedCitizenInfo;


    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnLogOut;
    @FXML
    private TextArea txtAcutePain;
    @FXML
    private TextArea txtPeriodePain;
    @FXML
    private TextArea txtChronicPain;
    @FXML
    private TextArea txtEyeProblem;
    @FXML
    private TextArea txtSmellProblems;
    @FXML
    private TextArea txthearProblems;
    @FXML
    private TextArea txtTasteProblems;
    @FXML
    private TextArea txtFeelingProblems;


    // this is instance variable is not used to now//
    private int caseID = -1;

    CategoryModel categoryModel = new CategoryModel();

    /**
     * Constructor
     * @throws IOException
     */
    public SubcategoryPainAndSensoryImpressionsController() throws IOException, SQLException {

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
        if (categoryModel.readCategory(caseID,"Acute pain") == null){
            categoryModel.createCategory(caseID,"Acute pain",txtAcutePain.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Acute pain",txtAcutePain.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Periode pain") == null){
            categoryModel.createCategory(caseID,"Periode pain",txtPeriodePain.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Periode pain",txtPeriodePain.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Chronic pain") == null){
            categoryModel.createCategory(caseID,"Chronic pain",txtChronicPain.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Chronic pain",txtChronicPain.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Eye problem") == null){
            categoryModel.createCategory(caseID,"Eye problem",txtEyeProblem.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Eye problem",txtEyeProblem.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Smell problems") == null){
            categoryModel.createCategory(caseID,"Smell problems",txtSmellProblems.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Smell problems",txtSmellProblems.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Hear problems") == null){
            categoryModel.createCategory(caseID,"Hear problems",txthearProblems.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Hear problems",txthearProblems.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Taste problems") == null){
            categoryModel.createCategory(caseID,"Taste problems",txtTasteProblems.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Taste problems",txtTasteProblems.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Feeling problems") == null){
            categoryModel.createCategory(caseID,"Feeling problems",txtFeelingProblems.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"PFeeling problems",txtFeelingProblems.getText(), "Condition");
    }

    /**
     * this method is used to sende information from en controller to other controller
     * @throws SQLException
     */

    public void setId(int caseID) throws SQLException {
        this.caseID = caseID;
        if(categoryModel.readCategory(caseID,"Acute pain") != null){
            txtAcutePain.setText(categoryModel.readCategory(caseID,"Acute pain")[0]);
        }
        if(categoryModel.readCategory(caseID,"Periode pain") != null){
            txtPeriodePain.setText(categoryModel.readCategory(caseID,"Periode pain")[0]);
        }
        if(categoryModel.readCategory(caseID,"Chronic Pain") != null){
            txtChronicPain.setText(categoryModel.readCategory(caseID,"Chronic Pain")[0]);
        }
        if(categoryModel.readCategory(caseID,"Eye problem") != null){
            txtEyeProblem.setText(categoryModel.readCategory(caseID,"Eye problem")[0]);
        }
        if(categoryModel.readCategory(caseID,"Smell problems") != null){
            txtSmellProblems.setText(categoryModel.readCategory(caseID,"Smell problems")[0]);
        }
        if(categoryModel.readCategory(caseID,"Hear problems") != null){
            txthearProblems.setText(categoryModel.readCategory(caseID,"Hear problems")[0]);
        }
        if(categoryModel.readCategory(caseID,"Problems with mixed wound") != null){
            txtTasteProblems.setText(categoryModel.readCategory(caseID,"Problems with mixed wound")[0]);
        }
        if(categoryModel.readCategory(caseID,"Feeling problems") != null){
            txtFeelingProblems.setText(categoryModel.readCategory(caseID,"Feeling problems")[0]);
        }
    }

    public void setSelectedCitizen(CitizenInfo selectedCitizen) {
        selectedCitizenInfo = selectedCitizen;

    }
}
