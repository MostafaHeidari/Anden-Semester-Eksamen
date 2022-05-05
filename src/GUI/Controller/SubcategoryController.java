package GUI.Controller;

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

    public Text subCatText;
    public TextArea txtBeskrivelse;
    @FXML
    private JFXButton btnTilbage;

    @FXML
    private JFXButton btnLogud;

   // this is instance variable is not used to now//
    private int caseID = 27;
    private String problemName;

    CategoryModel categoryModel = new CategoryModel();

    public SubcategoryController() throws IOException {
    }


    public void subCategoryTilbage(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) btnTilbage.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Category.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }

    public void subCategoryLogud(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) btnLogud.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }

    // this button is used to save the information to databassen. if the databassen is empty //
    public void subCategorySave(ActionEvent actionEvent) throws SQLException {
        if (categoryModel.readCategory(caseID,problemName) == null){

            categoryModel.createCategory(caseID,problemName,txtBeskrivelse.getText());
        }
        categoryModel.updateCategory(caseID,problemName,txtBeskrivelse.getText());
    }

    //
    public void setId(String knap) throws SQLException {
        this.problemName = knap;
        txtBeskrivelse.setText(categoryModel.readCategory(caseID,knap));
        subCatText.setText(knap);
    }
}
