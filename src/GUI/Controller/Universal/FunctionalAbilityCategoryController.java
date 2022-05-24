package GUI.Controller.Universal;

import BE.CitizenInfo;
import GUI.Controller.Universal.Case.CasesController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FunctionalAbilityCategoryController {

    private CitizenInfo selectedCitizenInfo;
    private int selectedCaseID;

    @FXML
    AnchorPane Pane;

    public void backToLastPageBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/Case/Cases.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        CasesController controller = loader.getController();
        controller.setSelectedCitizen(selectedCitizenInfo);
        switcher.setTitle("FunktionsevneTilstand Kategori");
        switcher.setScene(scene);
    }

    public void cat1Btn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/FunctionalAbilitySubCategory1.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("FunktionsevneTilstand Kategori");
        switcher.setScene(scene);
    }

    public void cat2Btn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/FunctionalAbilitySubCategory2.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("FunktionsevneTilstand Kategori");
        switcher.setScene(scene);
    }

    public void cat3Btn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/FunctionalAbilitySubCategory2.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("FunktionsevneTilstand Kategori");
        switcher.setScene(scene);
    }

    public void cat4Btn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/FunctionalAbilitySubCategory4.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("FunktionsevneTilstand Kategori");
        switcher.setScene(scene);
    }

    public void cat5Btn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/FunctionalAbilitySubCategory5.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("FunktionsevneTilstand Kategori");
        switcher.setScene(scene);
    }

    public void setCaseID(int caseId) {
        selectedCaseID = caseId;
    }

    public void setSelectedCitizen(CitizenInfo selectedCitizen) {
        selectedCitizenInfo = selectedCitizen;
    }
}
