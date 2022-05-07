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

public class SubcategoryController {

    @FXML
    private JFXButton btnTilbage;
    @FXML
    private JFXButton btnLogud;

    public Text subCatText;
    public TextArea txtBeskrivelse;

   // this is instance variable is not used to now//
    private int caseID = 27;
    private String problemName;

    CategoryModel categoryModel = new CategoryModel();

    /**
     * Constructor
     * @throws IOException
     */
    public SubcategoryController() throws IOException {
    }

    /**
     * Goes to Category view
     */
    public void subCategoryTilbage(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) btnTilbage.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/Category.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }

    /**
     * Goes to Login view
     */
    public void subCategoryLogud(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) btnLogud.getScene().getWindow();
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
        if (categoryModel.readCategory(caseID,problemName) == null){

            categoryModel.createCategory(caseID,problemName,txtBeskrivelse.getText());
        }
        categoryModel.updateCategory(caseID,problemName,txtBeskrivelse.getText());
    }

    /**
     * this method is used to sende information from en controller to other controller
     * @param problemName
     * @throws SQLException
     */
    public void setId(String problemName) throws SQLException {
        this.problemName = problemName;
        txtBeskrivelse.setText(categoryModel.readCategory(caseID,problemName));
        subCatText.setText(problemName);
    }
}
