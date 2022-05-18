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
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SubcategoryNutritionController {

    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnLogOut;
    @FXML
    private TextArea txtFluidIntake;
    @FXML
    private TextArea txtFoodIntake;
    @FXML
    private TextArea txtCancerWound;
    @FXML
    private TextArea txtPressureWound;
    @FXML
    private TextArea txtArtilleryWound;


   // this is instance variable is not used to now//
    private int caseID = -1;

    CategoryModel categoryModel = new CategoryModel();

    /**
     * Constructor
     * @throws IOException
     */
    public SubcategoryNutritionController() throws IOException, SQLException {

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
        if (categoryModel.readCategory(caseID,"Problems with fluid intake") == null){
            categoryModel.createCategory(caseID,"Problems with fluid intake",txtFluidIntake.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with fluid intake",txtFluidIntake.getText());


        if (categoryModel.readCategory(caseID,"Problems with food intake") == null){
            categoryModel.createCategory(caseID,"Problems with food intake",txtFoodIntake.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with food intake",txtFoodIntake.getText());


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
    }

    /**
     * this method is used to sende information from en controller to other controller
     * @throws SQLException
     */

    public void setId(int caseID) throws SQLException {
        this.caseID = caseID;
        txtFluidIntake.setText(categoryModel.readCategory(caseID,"Problems with fluid intake"));
        txtFoodIntake.setText(categoryModel.readCategory(caseID,"Problems with food intake"));
        txtCancerWound.setText(categoryModel.readCategory(caseID,"Problems with cancer wound"));
        txtPressureWound.setText(categoryModel.readCategory(caseID,"Problems with pressure wound"));
        txtArtilleryWound.setText(categoryModel.readCategory(caseID,"Problems with artillery wound"));
    }
}
