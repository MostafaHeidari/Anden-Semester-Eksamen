package GUI.Controller.Unvesial;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BogerInfoContoller {

    public JFXButton BtnTilbage;
    public JFXButton tilbageKlasser;
    public JFXButton tilbageBogerBtn;

    public void BtnTilbage(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnTilbage.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Forside");
        switcher.setScene(scene);
    }

    public void btnTilbageKlasser(ActionEvent event) {
    }

    public void btnTilbageBoger(ActionEvent event) {
    }
}
