package GUI.Controller.Universal;

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

    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnLogOut;

    public TextArea txtsurgicalWound;
    public TextArea txtdiabeticWound;
    public TextArea txtCancerWound;

   // this is instance variable is not used to now//
    private int caseID = 27;

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
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/Category.fxml"));
        Scene scene = new Scene(root);
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
    }

    /**
     * this method is used to sende information from en controller to other controller
     * @throws SQLException
     */

    public void setId() throws SQLException {
        txtsurgicalWound.setText(categoryModel.readCategory(caseID,"Problems with surgical wound"));
        txtdiabeticWound.setText(categoryModel.readCategory(caseID,"Problems with diabetic wound"));
        txtCancerWound.setText(categoryModel.readCategory(caseID,"Problems with cancer wound"));
    }
}
