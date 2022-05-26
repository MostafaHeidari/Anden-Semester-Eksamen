package GUI.Controller.Universal.SubCategory;

import BE.CitizenInfo;
import GUI.Controller.Universal.CategoryController;
import GUI.Model.CategoryModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SubcategoryMovingApparatController {

    private CitizenInfo selectedCitizenInfo;


    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnLogOut;
    @FXML
    private TextArea txtMovingApparatNotat;
    @FXML
    private TextArea txtMovingApparatPresent;
    @FXML
    private TextArea txtMovingApparatDate;
    @FXML
    private JFXComboBox jfxComboBox;


   // this is instance variable is not used to now//
    private int caseID = -1;

    CategoryModel categoryModel = new CategoryModel();

    /**
     * Constructor
     * @throws IOException
     */
    public SubcategoryMovingApparatController() throws IOException, SQLException {

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
        if (categoryModel.readCategory(caseID,"Notat") == null){

            categoryModel.createCategory(caseID,"Notat",txtMovingApparatNotat.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Notat",txtMovingApparatNotat.getText(), "Condition");


        if (categoryModel.readCategory(caseID,"Present") == null){

            categoryModel.createCategory(caseID,"Present",txtMovingApparatPresent.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Present",txtMovingApparatPresent.getText(), "Condition");



        if (categoryModel.readCategory(caseID,"Date") == null){

            categoryModel.createCategory(caseID,"Date",txtMovingApparatDate.getText(), "Condition");
        }
        categoryModel.updateCategory(caseID,"Date",txtMovingApparatDate.getText(), "Condition");


        // jfxComboBox.getSelectionModel().getSelectedItem();
    }

    /**
     * this method is used to sende information from en controller to other controller
     * @throws SQLException
     */

    public void setId(int caseID) throws SQLException {
        this.caseID = caseID;
        txtMovingApparatNotat.setText(categoryModel.readCategory(caseID,"Notat")[0]);
        txtMovingApparatPresent.setText(categoryModel.readCategory(caseID,"Present")[0]);
        txtMovingApparatDate.setText(categoryModel.readCategory(caseID,"Date")[0]);
    }
    public void setSelectedCitizen(CitizenInfo selectedCitizen) {
        selectedCitizenInfo = selectedCitizen;
    }


}
