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

public class SubcategoryPsychosocialRelationshipsController {
    private CitizenInfo selectedCitizenInfo;


    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnLogOut;
    @FXML
    private TextArea txtSocialRealitionship;
    @FXML
    private TextArea txtEmotionelleProblems;
    @FXML
    private TextArea txtAbuseProblems;
    @FXML
    private TextArea txtMentalProblems;


    // this is instance variable is not used to now//
    private int caseID = -1;

    CategoryModel categoryModel = new CategoryModel();

    /**
     * Constructor
     * @throws IOException
     */
    public SubcategoryPsychosocialRelationshipsController() throws IOException, SQLException {

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
        if (categoryModel.readCategory(caseID,"Problems with Social Relationship") == null){
            categoryModel.createCategory(caseID,"Problems with Social Relationship",txtSocialRealitionship.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with Social Relationship",txtSocialRealitionship.getText());


        if (categoryModel.readCategory(caseID,"Problems with Emotions") == null){
            categoryModel.createCategory(caseID,"Problems with Emotions",txtEmotionelleProblems.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with Emotions",txtEmotionelleProblems.getText());


        if (categoryModel.readCategory(caseID,"Problems with abuse") == null){
            categoryModel.createCategory(caseID,"Problems with abuse",txtAbuseProblems.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with abuse",txtAbuseProblems.getText());


        if (categoryModel.readCategory(caseID,"Problems with mental") == null){
            categoryModel.createCategory(caseID,"Problems with mental",txtMentalProblems.getText());
        }
        categoryModel.updateCategory(caseID,"Problems with mental",txtMentalProblems.getText());
    }

    /**
     * this method is used to sende information from en controller to other controller
     * @throws SQLException
     */

    public void setId(int caseID) throws SQLException {
        this.caseID = caseID;
        txtSocialRealitionship.setText(categoryModel.readCategory(caseID,"Problems with Social Relationship"));
        txtEmotionelleProblems.setText(categoryModel.readCategory(caseID,"Problems with Emotions"));
        txtAbuseProblems.setText(categoryModel.readCategory(caseID,"Problems with abuse"));
        txtMentalProblems.setText(categoryModel.readCategory(caseID,"Problems with mental"));
    }

    public void setSelectedCitizen(CitizenInfo selectedCitizen) {
        selectedCitizenInfo = selectedCitizen;
    }
}
