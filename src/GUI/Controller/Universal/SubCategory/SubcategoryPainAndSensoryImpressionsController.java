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
        if (categoryModel.readCategory(caseID,"Problems with surgical wound") == null){
            categoryModel.createCategory(caseID,"Problems with surgical wound",txtsurgicalWound.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with surgical wound",txtsurgicalWound.getText());


        if (categoryModel.readCategory(caseID,"Problems with diabetic wound") == null){
            categoryModel.createCategory(caseID,"Problems with diabetic wound",txtdiabeticWound.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with diabetic wound",txtdiabeticWound.getText());


        if (categoryModel.readCategory(caseID,"Problems with cancer wound") == null){
            categoryModel.createCategory(caseID,"Problems with cancer wound",txtCancerWound.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with cancer wound",txtCancerWound.getText());


        if (categoryModel.readCategory(caseID,"Problems with pressure wound") == null){
            categoryModel.createCategory(caseID,"Problems with pressure wound",txtPressureWound.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with pressure wound",txtPressureWound.getText());


        if (categoryModel.readCategory(caseID,"Problems with artillery wound") == null){
            categoryModel.createCategory(caseID,"Problems with artillery wound",txtArtilleryWound.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with artillery wound",txtArtilleryWound.getText());


        if (categoryModel.readCategory(caseID,"Problems with venous wound") == null){
            categoryModel.createCategory(caseID,"Problems with venous wound",txtVenousWound.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with venous wound",txtVenousWound.getText());


        if (categoryModel.readCategory(caseID,"Problems with mixed wound") == null){
            categoryModel.createCategory(caseID,"Problems with mixed wound",txtMixedWound.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with mixed wound",txtMixedWound.getText());


        if (categoryModel.readCategory(caseID,"Problems with trauma wound") == null){
            categoryModel.createCategory(caseID,"Problems with trauma wound",txtTraumaWound.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with trauma wound",txtTraumaWound.getText());


        if (categoryModel.readCategory(caseID,"Other problems") == null){
            categoryModel.createCategory(caseID,"Other problems",txtOtherProblems.getText());
        }
        categoryModel.updateCategory(caseID,"Other problems",txtOtherProblems.getText());
    }

    /**
     * this method is used to sende information from en controller to other controller
     * @throws SQLException
     */

    public void setId(int caseID) throws SQLException {
        this.caseID = caseID;
        txtsurgicalWound.setText(categoryModel.readCategory(caseID,"Problems with surgical wound"));
        txtdiabeticWound.setText(categoryModel.readCategory(caseID,"Problems with diabetic wound"));
        txtCancerWound.setText(categoryModel.readCategory(caseID,"Problems with cancer wound"));
        txtPressureWound.setText(categoryModel.readCategory(caseID,"Problems with pressure wound"));
        txtArtilleryWound.setText(categoryModel.readCategory(caseID,"Problems with artillery wound"));
        txtVenousWound.setText(categoryModel.readCategory(caseID,"Problems with venous wound"));
        txtMixedWound.setText(categoryModel.readCategory(caseID,"Problems with mixed wound"));
        txtTraumaWound.setText(categoryModel.readCategory(caseID,"Problems with trauma wound"));
        txtOtherProblems.setText(categoryModel.readCategory(caseID,"Other problems"));
    }

    public void setSelectedCitizen(CitizenInfo selectedCitizen) {
        selectedCitizenInfo = selectedCitizen;

    }
}
