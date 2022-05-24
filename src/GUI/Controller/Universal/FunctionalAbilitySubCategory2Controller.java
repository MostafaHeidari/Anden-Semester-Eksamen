package GUI.Controller.Universal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FunctionalAbilitySubCategory2Controller {

    @FXML
    AnchorPane Pane;

    public void backToLastPageBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/FunctionalAbilityCategory.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("FunktionsevneTilstand Kategori");
        switcher.setScene(scene);
    }

    public void cat1Btn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/FunctionalAbilityCategory.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("FunktionsevneTilstand Kategori");
        switcher.setScene(scene);
    }

    public void cat2Btn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/FunctionalAbilityCategory.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("FunktionsevneTilstand Kategori");
        switcher.setScene(scene);
    }

    public void cat3Btn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/FunctionalAbilityCategory.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("FunktionsevneTilstand Kategori");
        switcher.setScene(scene);
    }

    public void cat4Btn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/FunctionalAbilityCategory.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("FunktionsevneTilstand Kategori");
        switcher.setScene(scene);
    }
}
