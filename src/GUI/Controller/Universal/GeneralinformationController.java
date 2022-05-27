package GUI.Controller.Universal;

import BE.CitizenInfo;
import GUI.Controller.Universal.Case.CasesController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class GeneralinformationController {
    @FXML
    public Button BtnMestring;
    @FXML
    public Button BtnMotivation;
    @FXML
    public Button BtnRessourcer;
    @FXML
    public Button BtnRoller;
    @FXML
    public Button BtnVaner;
    @FXML
    public Button BtnUddannelse;
    @FXML
    public Button BtnLivsHistorie;
    @FXML
    public Button BtnHelbred;
    @FXML
    public Button BtnHelp;
    @FXML
    public Button BtnBolige;
    @FXML
    public Button BtnNetwork;
    @FXML
    public JFXButton BtnBack;

    private CitizenInfo selectedCitizenId;


    public void BtnBack(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnBack.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/Case/Cases.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        CasesController controller = loader.getController();
        controller.setSelectedCitizen(selectedCitizenId);
        switcher.setTitle("Sager");
        switcher.setScene(scene);
    }

    public void btnHandleSaveCitizen(ActionEvent actionEvent) {
    }

    public void setSelectedCitizen(CitizenInfo selectedCitizen) {
        selectedCitizenId = selectedCitizen;
    }
}