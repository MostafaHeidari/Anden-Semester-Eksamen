package GUI.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CategoryController {
    @FXML
    private javafx.scene.layout.HBox HBox;
    public void Test(MouseEvent mouseEvent) throws IOException {
        Stage switcher = (Stage) HBox.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Patient.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }
}
