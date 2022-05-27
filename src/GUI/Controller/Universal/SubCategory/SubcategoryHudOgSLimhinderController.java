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

public class SubcategoryHudOgSLimhinderController {

    private CitizenInfo selectedCitizenInfo;


    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnLogOut;
    @FXML
    private TextArea txtsurgicalWound;
    @FXML
    private TextArea txtdiabeticWound;
    @FXML
    private TextArea txtCancerWound;
    @FXML
    private TextArea txtPressureWound;
    @FXML
    private TextArea txtArtilleryWound;
    @FXML
    private TextArea txtVenousWound;
    @FXML
    private TextArea txtMixedWound;
    @FXML
    private TextArea txtTraumaWound;
    @FXML
    private TextArea txtOtherProblems;


   // this is instance variable is not used to now//
    private int caseID = -1;

    CategoryModel categoryModel = new CategoryModel();

    /**
     * Constructor
     * @throws IOException
     */
    public SubcategoryHudOgSLimhinderController() throws IOException, SQLException {

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
        if (categoryModel.readCategory(caseID,"Problems with surgical wound") == null){
            categoryModel.createCategory(caseID,"Problems with surgical wound",txtsurgicalWound.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Problems with surgical wound",txtsurgicalWound.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Problems with diabetic wound") == null){
            categoryModel.createCategory(caseID,"Problems with diabetic wound",txtdiabeticWound.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Problems with diabetic wound",txtdiabeticWound.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Problems with cancer wound") == null){
            categoryModel.createCategory(caseID,"Problems with cancer wound",txtCancerWound.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Problems with cancer wound",txtCancerWound.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Problems with pressure wound") == null){
            categoryModel.createCategory(caseID,"Problems with pressure wound",txtPressureWound.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Problems with pressure wound",txtPressureWound.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Problems with artillery wound") == null){
            categoryModel.createCategory(caseID,"Problems with artillery wound",txtArtilleryWound.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Problems with artillery wound",txtArtilleryWound.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Problems with venous wound") == null){
            categoryModel.createCategory(caseID,"Problems with venous wound",txtVenousWound.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Problems with venous wound",txtVenousWound.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Problems with mixed wound") == null){
            categoryModel.createCategory(caseID,"Problems with mixed wound",txtMixedWound.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Problems with mixed wound",txtMixedWound.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Problems with trauma wound") == null){
            categoryModel.createCategory(caseID,"Problems with trauma wound",txtTraumaWound.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Problems with trauma wound",txtTraumaWound.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Other problems") == null){
            categoryModel.createCategory(caseID,"Other problems",txtOtherProblems.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Other problems",txtOtherProblems.getText(), "Condition");
    }

    /**
     * this method is used to sende information from en controller to other controller
     * @throws SQLException
     */

    public void setId(int caseID) throws SQLException {
        this.caseID = caseID;
        if(categoryModel.readCategory(caseID,"Problems with surgical wound") != null){
            txtsurgicalWound.setText(categoryModel.readCategory(caseID,"Problems with surgical wound")[0]);
        }
        if(categoryModel.readCategory(caseID,"Problems with cancer wound") != null){
            txtdiabeticWound.setText(categoryModel.readCategory(caseID,"Problems with diabetic wound")[0]);
        }
        if(categoryModel.readCategory(caseID,"Problems with cancer wound") != null){
            txtCancerWound.setText(categoryModel.readCategory(caseID,"Problems with cancer wound")[0]);
        }
        if(categoryModel.readCategory(caseID,"Problems with pressure wound") != null){
            txtPressureWound.setText(categoryModel.readCategory(caseID,"Problems with pressure wound")[0]);
        }
        if(categoryModel.readCategory(caseID,"Problems with artillery wound") != null){
            txtArtilleryWound.setText(categoryModel.readCategory(caseID,"Problems with artillery wound")[0]);
        }
        if(categoryModel.readCategory(caseID,"Problems with venous wound") != null){
            txtVenousWound.setText(categoryModel.readCategory(caseID,"Problems with venous wound")[0]);
        }
        if(categoryModel.readCategory(caseID,"Problems with mixed wound") != null){
            txtMixedWound.setText(categoryModel.readCategory(caseID,"Problems with mixed wound")[0]);
        }
        if(categoryModel.readCategory(caseID,"Problems with trauma wound") != null){
            txtTraumaWound.setText(categoryModel.readCategory(caseID,"Problems with trauma wound")[0]);
        }
        if(categoryModel.readCategory(caseID,"Other problems") != null){
            txtOtherProblems.setText(categoryModel.readCategory(caseID,"Other problems")[0]);
        }
    }

    public void setSelectedCitizen(CitizenInfo selectedCitizen) {
        selectedCitizenInfo = selectedCitizen;

    }
}
