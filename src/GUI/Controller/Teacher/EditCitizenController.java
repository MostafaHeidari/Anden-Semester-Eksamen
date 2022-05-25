package GUI.Controller.Teacher;

import BE.CitizenInfo;
import GUI.Model.CitizenInfoModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EditCitizenController {

    @FXML
    public TextField txtFieldCitizenFirstNameEdit;
    @FXML
    public TextField txtFieldCitizenLastNameEdit;
    @FXML
    public TextField txtFieldCitizenAgeEdit;


    @FXML
    public JFXButton BtnLogOutOfPatient;
    @FXML
    public JFXButton btnSaveCitizenEdit;

    @FXML
    public JFXButton BtnBack;


    private final CitizenInfoModel citizenInfoModel = new CitizenInfoModel();

    private CitizenInfo selectedCitizen;

    /**
     * Constructor
     */
    public EditCitizenController() throws IOException {
    }


    public void LogOutOfPatient(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnLogOutOfPatient.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }

    public void BtnBack(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnLogOutOfPatient.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateCitizen.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Student");
        switcher.setScene(scene);
    }

    //edit Citizen button //
    public void btnHandleSaveCitizenEdit(ActionEvent actionEvent) throws Exception {

        String updateCitizenName = txtFieldCitizenFirstNameEdit.getText();
        String updateCitizenLastName = txtFieldCitizenLastNameEdit.getText();
        String updateCitizenCPR = txtFieldCitizenAgeEdit.getText();

        this.selectedCitizen.setCitizenName(updateCitizenName);
        this.selectedCitizen.setCitizenLastName(updateCitizenLastName);
        this.selectedCitizen.setAge(updateCitizenCPR);



        citizenInfoModel.editCitizen(this.selectedCitizen);

        /*turn back to Create student window*/
        Stage switcher = (Stage) BtnBack.getScene().getWindow();
        switcher.setTitle("Create Citizen");
        switcher.close();

    }



    /**
     * Set selected CitizenInfo
     * @param citizenInfo
     */
    public void setSelectedCitizen(CitizenInfo citizenInfo) {
        txtFieldCitizenFirstNameEdit.setText(citizenInfo.getCitizenName());
        txtFieldCitizenLastNameEdit.setText(citizenInfo.getCitizenLastName());
        txtFieldCitizenAgeEdit.setText(citizenInfo.getAge());


       this.selectedCitizen = citizenInfo;
    }

    public void setSelectedTable(TableView tvCitizen) {
        tvCitizen.getItems().clear();

        try {
            tvCitizen.setItems(citizenInfoModel.getAllCitizens());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
