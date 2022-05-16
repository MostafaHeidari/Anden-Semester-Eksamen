package GUI.Controller.Teacher;

import BE.CitizenInfo;
import GUI.Model.CitizenInfoModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CreateCitizenController {
    //textFiled
    @FXML
    public TextField txtFieldCitizenFirstName;
    @FXML
    public TextField txtFieldCitizenLastName;
    @FXML
    public TextField txtFieldCitizenCPR;
    @FXML
    public TextField txtFieldCitizenAddresse;
    @FXML
    public TextArea txtAreaCitizenGeneralInfo;


    @FXML
    public JFXButton backClasses;
    @FXML
    public JFXButton backStudent;
    @FXML
    public JFXButton citizenInformation;

    @FXML
    public JFXButton btnSaveCitizen;
    @FXML
    private JFXButton BtnLogOutOfPatient;
    @FXML
    private JFXButton BtnBack;


    public void btnHandleSaveCitizen() throws Exception {
        String firstName = txtFieldCitizenFirstName.getText();
        String lastName = txtFieldCitizenLastName.getText();
        String Address = txtFieldCitizenAddresse.getText();
        String cpr = txtFieldCitizenCPR.getText();
        String info = txtAreaCitizenGeneralInfo.getText();

        uploadCitizenInfo(firstName, lastName, Address, cpr, info);

    }

    public void uploadCitizenInfo(String firstName, String lastName, String address, String cpr, String info) throws IOException, SQLException {

        CitizenInfoModel citizenInfo = new CitizenInfoModel();
        citizenInfo.createCitizen(firstName, lastName, address, cpr, info);
    }

    /**
     * Goes to TeacherKlasseAndStudents view
     */
    public void btnBackGroups(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherGroupAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Klasse Manager");
        switcher.setScene(scene);
    }

    /**
     * Goes to CitizenInfo view
     */
    public void citizenInformationBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnLogOutOfPatient.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/CitizenInfo.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Borger Informationer");
        switcher.setScene(scene);
    }

    /**
     * Goes to CreateStudent view
     */
    public void btnBackStudent(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnLogOutOfPatient.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Student");
        switcher.setScene(scene);
    }

    /**
     * Goes to Teacher view
     */
    public void BtnBack(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnLogOutOfPatient.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }

    /**
     * Goes to Login view
     */
    public void LogOutOfPatient(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnLogOutOfPatient.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }
}

