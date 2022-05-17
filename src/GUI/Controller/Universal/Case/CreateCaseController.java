package GUI.Controller.Universal.Case;

import BE.CitizenInfo;
import GUI.Model.CaseModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CreateCaseController {

    public CitizenInfo selectedCitizenInfo;;

    public JFXButton backTo;
    public JFXButton LogOut;
    public JFXButton saveCase;

    @FXML
    public TextField InformationTxt;
    @FXML
    public TextField caseNameTxt;

    /**
     * Saves a Case info with the uploadCaseInfo method
     */
    public void saveCaseBtn(ActionEvent event) throws SQLException, IOException {
        String uploadCaseName = caseNameTxt.getText();
        String uploadCaseInformation = InformationTxt.getText();
        uploadCaseInfo(uploadCaseName, uploadCaseInformation, selectedCitizenInfo.getCitizenId());
        backToPatientsBtn(event);
    }


    /**
     * Returns to Login with the LogOutAction method
     */
    public void LogOutAction(ActionEvent event) throws IOException {
        Stage switcher = (Stage) LogOut.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }

    /**
     * Returns to CitizenInfo with the backToPatientsBtn method
     */
    public void backToPatientsBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backTo.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/CitizenInfo.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Borger Informationer");
        switcher.setScene(scene);
    }

    /**
     * uploads a Case info with the uploadCaseInfo method
     */
    private void uploadCaseInfo(String caseName, String informationTxt, int selectedCitizen) throws IOException, SQLException {
        CaseModel caseModel = new CaseModel();

        caseModel.uploadCaseInfo(caseName, informationTxt,selectedCitizen);
    }

    public void setCitizenID(CitizenInfo citizenInfo) {
        selectedCitizenInfo = citizenInfo;
    }
}
