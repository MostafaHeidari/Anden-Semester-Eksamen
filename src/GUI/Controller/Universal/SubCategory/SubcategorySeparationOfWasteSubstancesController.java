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
    private TextArea txtFecalIncontinence;
    @FXML
    private TextArea txtStomachAndIntestines;
    @FXML
    private TextArea txtFluidFromSinks;


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
            categoryModel.createCategory(caseID,"Problems with urination",txturination.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Problems with urination",txturination.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Problems with urinary incontinence") == null){
            categoryModel.createCategory(caseID,"Problems with urinary incontinence",txtIUrinaryIncontinence.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Problems with urinary incontinence",txtIUrinaryIncontinence.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Problems with fecal incontinence") == null){
            categoryModel.createCategory(caseID,"Problems with fecal incontinence",txtFecalIncontinence.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Problems with fecal incontinence",txtFecalIncontinence.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Problems with stomach and intestines") == null){
            categoryModel.createCategory(caseID,"Problems with stomach and intestines",txtStomachAndIntestines.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Problems with stomach and intestines",txtStomachAndIntestines.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Problems with fluid from sinks") == null){
            categoryModel.createCategory(caseID,"Problems with fluid from sinks",txtFluidFromSinks.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Problems with fluid from sinks",txtFluidFromSinks.getText(), "Condition");
    }

    /**
     * this method is used to sende information from en controller to other controller
     * @throws SQLException
     */

    public void setId(int caseID) throws SQLException {
        this.caseID = caseID;
        if(categoryModel.readCategory(caseID,"Problems with urination") != null){
            txturination.setText(categoryModel.readCategory(caseID,"Problems with urination")[0]);
        }
        if(categoryModel.readCategory(caseID,"Problems with urinary incontinence") != null){
            txtIUrinaryIncontinence.setText(categoryModel.readCategory(caseID,"Problems with urinary incontinence")[0]);
        }
        if(categoryModel.readCategory(caseID,"Problems with fecal incontinence") != null){
            txtFecalIncontinence.setText(categoryModel.readCategory(caseID,"Problems with fecal incontinence")[0]);
        }
        if(categoryModel.readCategory(caseID,"Problems with stomach and intestines") != null){
            txtStomachAndIntestines.setText(categoryModel.readCategory(caseID,"Problems with stomach and intestines")[0]);
        }
        if(categoryModel.readCategory(caseID,"Problems with fluid from sinks") != null){
            txtFluidFromSinks.setText(categoryModel.readCategory(caseID,"Problems with fluid from sinks")[0]);
        }
    }

    public void setSelectedCitizen(CitizenInfo selectedCitizen) {
        selectedCitizenInfo = selectedCitizen;
    }
}
