package GUI.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class SubcategoryController {

    public Text subCatText;
    @FXML
    private JFXButton btnTilbage;

    @FXML
    private JFXButton btnLogud;

    private String knap;


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

    public void subCategorySave(ActionEvent actionEvent) {
        //Stage switcher = (Stage) btnTilbage.getScene().getWindow();
        //knap = switcher.getTitle();
        //subCatText.setText(knap);

    }
    public void setId(String knap){
        this.knap = knap;
        subCatText.setText(knap);
    }
}
