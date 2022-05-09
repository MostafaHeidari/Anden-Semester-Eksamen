package GUI.Controller.Universal;

import GUI.Model.CaseModel;
import GUI.Model.StudentModel;
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
    public JFXButton backTo;
    public JFXButton LogOut;
    public JFXButton saveCase;

    @FXML
    public TextField InformationTxt;
    @FXML
    public TextField caseNameTxt;

    public void saveCaseBtn(ActionEvent event) {

    }

    public void LogOutAction(ActionEvent event) throws IOException {
        Stage switcher = (Stage) LogOut.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }


    public void backToPatientsBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backTo.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/CitizenInfo.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Borger Informationer");
        switcher.setScene(scene);
    }

    /**
     * uploads a student info with the uploadStudentInfo method
     */
    private void uploadCaseInfo(String caseName, String informationTxt) throws IOException, SQLException {
        CaseModel caseModel = new CaseModel();

        caseModel.uploadCaseInfo(caseName, informationTxt);
    }
}
