package GUI.Controller.Universal;

import BE.CitizenInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FunctionalAbilitySubCategory1Controller {

    private int selectedCaseId;

    private CitizenInfo selectedCitizenId;

    private int selectedCategoryId;

    @FXML
    AnchorPane Pane;

    public void backToLastPageBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/FunctionalAbilityCategory.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        FunctionalAbilityCategoryController controller = loader.getController();
        controller.setSelectedCitizen(selectedCitizenId);
        controller.setCaseID(selectedCaseId);
        switcher.setTitle("FunktionsevneTilstand Kategori");
        switcher.setScene(scene);
    }

    public void cat1Btn(ActionEvent actionEvent) throws IOException {
        selectedCategoryId = 1;
        Stage switcher = (Stage) Pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/FunctionalAbility.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        FunctionalAbilityController controller = loader.getController();
        controller.setSelectedCitizen(selectedCitizenId);
        controller.setCaseID(selectedCaseId);
        controller.setCatID(selectedCategoryId);
        switcher.setTitle("FunktionsevneTilstand");
        switcher.setScene(scene);
    }

    public void cat2Btn(ActionEvent actionEvent) throws IOException {
        selectedCategoryId = 2;
        Stage switcher = (Stage) Pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/FunctionalAbility.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        FunctionalAbilityController controller = loader.getController();
        controller.setSelectedCitizen(selectedCitizenId);
        controller.setCaseID(selectedCaseId);
        controller.setCatID(selectedCategoryId);
        switcher.setTitle("FunktionsevneTilstand");
        switcher.setScene(scene);
    }

    public void cat3Btn(ActionEvent actionEvent) throws IOException {
        selectedCategoryId = 3;
        Stage switcher = (Stage) Pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/FunctionalAbility.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        FunctionalAbilityController controller = loader.getController();
        controller.setSelectedCitizen(selectedCitizenId);
        controller.setCaseID(selectedCaseId);
        controller.setCatID(selectedCategoryId);
        switcher.setTitle("FunktionsevneTilstand");
        switcher.setScene(scene);
    }

    public void cat4Btn(ActionEvent actionEvent) throws IOException {
        selectedCategoryId = 4;
        Stage switcher = (Stage) Pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/FunctionalAbility.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        FunctionalAbilityController controller = loader.getController();
        controller.setSelectedCitizen(selectedCitizenId);
        controller.setCaseID(selectedCaseId);
        controller.setCatID(selectedCategoryId);
        switcher.setTitle("FunktionsevneTilstand");
        switcher.setScene(scene);
    }

    public void cat5Btn(ActionEvent actionEvent) throws IOException {
        selectedCategoryId = 5;
        Stage switcher = (Stage) Pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/FunctionalAbility.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        FunctionalAbilityController controller = loader.getController();
        controller.setSelectedCitizen(selectedCitizenId);
        controller.setCaseID(selectedCaseId);
        controller.setCatID(selectedCategoryId);
        switcher.setTitle("FunktionsevneTilstand");
        switcher.setScene(scene);
    }

    public void cat6Btn(ActionEvent actionEvent) throws IOException {
        selectedCategoryId = 6;
        Stage switcher = (Stage) Pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/FunctionalAbility.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        FunctionalAbilityController controller = loader.getController();
        controller.setSelectedCitizen(selectedCitizenId);
        controller.setCaseID(selectedCaseId);
        controller.setCatID(selectedCategoryId);
        switcher.setTitle("FunktionsevneTilstand");
        switcher.setScene(scene);
    }

    public void cat7Btn(ActionEvent actionEvent) throws IOException {
        selectedCategoryId = 7;
        Stage switcher = (Stage) Pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/FunctionalAbility.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        FunctionalAbilityController controller = loader.getController();
        controller.setSelectedCitizen(selectedCitizenId);
        controller.setCaseID(selectedCaseId);
        controller.setCatID(selectedCategoryId);
        switcher.setTitle("FunktionsevneTilstand");
        switcher.setScene(scene);
    }

    public void cat8Btn(ActionEvent actionEvent) throws IOException {
        selectedCategoryId = 8;
        Stage switcher = (Stage) Pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/FunctionalAbility.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        FunctionalAbilityController controller = loader.getController();
        controller.setSelectedCitizen(selectedCitizenId);
        controller.setCaseID(selectedCaseId);
        controller.setCatID(selectedCategoryId);
        switcher.setTitle("FunktionsevneTilstand");
        switcher.setScene(scene);
    }

    public void setSelectedCitizen(CitizenInfo citizenId) {
        selectedCitizenId = citizenId;
    }

    public void setSelectedCase(int caseId) {
        selectedCaseId = caseId;
    }
    public void setCatID(int catID){
        selectedCategoryId = catID;
    }
}
