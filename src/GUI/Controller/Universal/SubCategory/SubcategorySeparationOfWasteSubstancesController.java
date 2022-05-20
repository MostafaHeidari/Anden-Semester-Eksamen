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

public class SubcategorySeparationOfWasteSubstancesController {

    private CitizenInfo selectedCitizenInfo;


    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnLogOut;
    @FXML
    private TextArea txturination;
    @FXML
    private TextArea txtIUrinaryIncontinence;
    @FXML
    private TextArea txtWeightChange;
    @FXML
    private TextArea txtOverWeight;
    @FXML
    private TextArea txtUnderWeight;


    // this is instance variable is not used to now//
    private int caseID = -1;

    CategoryModel categoryModel = new CategoryModel();

    /**
     * Constructor
     * @throws IOException
     */
    public SubcategorySeparationOfWasteSubstancesController() throws IOException, SQLException {

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
        if (categoryModel.readCategory(caseID,"Problems with urination") == null){
            categoryModel.createCategory(caseID,"Problems with urination",txturination.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with urination",txturination.getText());


        if (categoryModel.readCategory(caseID,"Problems with urinary incontinence") == null){
            categoryModel.createCategory(caseID,"Problems with urinary incontinence",txtIUrinaryIncontinence.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with urinary incontinence",txtIUrinaryIncontinence.getText());


        if (categoryModel.readCategory(caseID,"Inappropriate weight change") == null){
            categoryModel.createCategory(caseID,"Inappropriate weight change",txtWeightChange.getText());
        }
        categoryModel.updateCategory(caseID,"Inappropriate weight change",txtWeightChange.getText());


        if (categoryModel.readCategory(caseID,"Problems with over weight") == null){
            categoryModel.createCategory(caseID,"Problems with over weight",txtOverWeight.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with over weight",txtOverWeight.getText());


        if (categoryModel.readCategory(caseID,"Problems with under weight") == null){
            categoryModel.createCategory(caseID,"Problems with under weight",txtUnderWeight.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with under weight",txtUnderWeight.getText());
    }

    /**
     * this method is used to sende information from en controller to other controller
     * @throws SQLException
     */

    public void setId(int caseID) throws SQLException {
        this.caseID = caseID;
        txturination.setText(categoryModel.readCategory(caseID,"Problems with urination"));
        txtIUrinaryIncontinence.setText(categoryModel.readCategory(caseID,"Problems with urinary incontinence"));
        txtWeightChange.setText(categoryModel.readCategory(caseID,"Inappropriate weight change"));
        txtOverWeight.setText(categoryModel.readCategory(caseID,"Problems with over weight"));
        txtUnderWeight.setText(categoryModel.readCategory(caseID,"Problems with under weight"));
    }

    public void setSelectedCitizen(CitizenInfo selectedCitizen) {
        selectedCitizenInfo = selectedCitizen;
    }
}
