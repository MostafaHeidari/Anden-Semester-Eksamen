package GUI.Controller.Teacher;

import BE.CitizenInfo;
import BE.Student;
import GUI.Model.CitizenInfoModel;
import GUI.Model.StudentModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateCitizenController implements Initializable {
    CitizenInfoModel citizenInfo;

    public CitizenInfoModel citizenInfoModel;

    // table view of Citizen
    public TableView tvCitizen;
    @FXML
    public TableColumn tcId;
    @FXML
    public TableColumn tcNameCitizen;
    @FXML
    public TableColumn tcLastCitizen;
    @FXML
    public TableColumn tcCitizenCPR;
    @FXML
    public TableColumn tcCitizenAdresse;

    @FXML
    public JFXButton BtnDeleteCitizen;
    @FXML
    public JFXButton BtnEditCitizen;

    //edit Citizen
    @FXML
    public TextField txtFieldCitizenFirstNameEdit;
    @FXML
    public TextField txtFieldCitizenLastNameEdit;
    @FXML
    public TextField txtFieldCitizenCPREdit;
    @FXML
    public TextField txtFieldCitizenAddresseEdit;
    @FXML
    public TextArea txtAreaCitizenGeneralInfoEdit;

    @FXML
    public JFXButton btnSaveCitizenEdit;




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

    public CreateCitizenController() throws IOException {
        citizenInfo = new CitizenInfoModel();
        this.citizenInfoModel= new CitizenInfoModel();
    }

    public CitizenInfo seletedCitizen;

    /**
     * initialize method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setCitizenTableView();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tvCitizen.setOnMouseClicked((MouseEvent event) -> {
            setSelectedCitizen();
        });

    }

    public void btnHandleSaveCitizen() throws Exception {
        String firstName = txtFieldCitizenFirstName.getText();
        String lastName = txtFieldCitizenLastName.getText();
        String Address = txtFieldCitizenAddresse.getText();
        String cpr = txtFieldCitizenCPR.getText();
        String info = txtAreaCitizenGeneralInfo.getText();

        uploadCitizenInfo(firstName, lastName, Address, cpr, info);

    }

    public void uploadCitizenInfo(String firstName, String lastName, String address, String cpr, String info) throws SQLException {

        citizenInfo.createCitizen(firstName, lastName, address, cpr, info);

        txtFieldCitizenFirstName.clear();
        txtFieldCitizenLastName.clear();
        txtFieldCitizenAddresse.clear();
        txtFieldCitizenCPR.clear();
        txtAreaCitizenGeneralInfo.clear();
    }


    /**
     * here we set the information in the tableView
     * @throws IOException
     */
    public void setCitizenTableView() throws IOException {
        tcId.setCellValueFactory(new PropertyValueFactory<>("studentId"));

        tcNameCitizen.setCellValueFactory(new PropertyValueFactory<>("studentName"));

        tcLastCitizen.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tcCitizenCPR.setCellValueFactory(new PropertyValueFactory<>("CPR"));

        tcCitizenAdresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));

        tvCitizen.setItems(citizenInfoModel.getAllCitizens());
    }



    /**
     * selects a student with the setSelectedStudent method
     */
    private void setSelectedCitizen() {
        if (tvCitizen.getSelectionModel().getSelectedItem() != null)
        {
           seletedCitizen = (CitizenInfo) tvCitizen.getSelectionModel().getSelectedItem();
        }
    }


    //edit Citizen button //
    public void btnHandleSaveCitizenEdit(ActionEvent actionEvent) {

    }


    public void DeleteCitizenAction(ActionEvent actionEvent) {
    }

    public void EditCitizenAction(ActionEvent actionEvent) {
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

