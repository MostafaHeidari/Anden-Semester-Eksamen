package GUI.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SubcategoryController {

    @FXML
    private JFXButton btnTilbage;

    @FXML
    private JFXButton btnLogud;

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
}
