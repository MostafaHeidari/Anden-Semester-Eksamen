package GUI.Controller.Student;

import BE.CitizenInfo;
import GUI.Controller.Universal.CreateCaseController;
import GUI.Model.CitizenInfoModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CitizenController implements Initializable {

    public CitizenInfo selectedCitizenInfo;

    private CitizenInfoModel citizenInfoModel;


    @FXML
    public JFXButton caseInfo;
    @FXML
    public JFXButton editCase;
    @FXML
    public JFXButton backToLastPage;
    @FXML
    private JFXButton btnLogout;
    @FXML
    private JFXButton btnInfo;
    @FXML
    private JFXButton createCase;

    @FXML
    public TableView tvPatients;
    @FXML
    public TableColumn tcCitizenId;
    @FXML
    public TableColumn tcCitizenName;
    @FXML
    public TableColumn tcCitizenLastName;
    @FXML
    public TableColumn tcCitizenAddress;
    @FXML
    public TableColumn tcCPR;
    @FXML
    public TableColumn tcCitizenInformation;


    public CitizenController() throws IOException {
        citizenInfoModel = new CitizenInfoModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setStudentTableView();
        tvPatients.setOnMouseClicked((MouseEvent event) -> {
            setSelectedItems();
        });
    }




    /**
     * Log out and goes to the Login view
     */
    public void LogOut(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) btnLogout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }

    public void createCaseBtn(ActionEvent actionEvent) {
        //TODO
        //opret case
    }

    public void caseInfoBtn(ActionEvent actionEvent) {
        //TODO
        //liste af alle cases
    }

    public void editCaseBtn(ActionEvent event) {
    }



    /**
     * Changes selected Name tvCitizenInfo in the adminEventMangerTableViewName
     */
    private void setSelectedItems() {
        if (tvPatients.getSelectionModel().getSelectedItem() != null)
        {
            selectedCitizenInfo = (CitizenInfo) tvPatients.getSelectionModel().getSelectedItem();
        }

    }

    private void setStudentTableView() {
        tcCitizenId.setCellValueFactory(new PropertyValueFactory<>("citizenId"));

        tcCitizenName.setCellValueFactory(new PropertyValueFactory<>("citizenName"));

        tcCitizenLastName.setCellValueFactory(new PropertyValueFactory<>("citizenLastName"));

        tcCitizenAddress.setCellValueFactory(new PropertyValueFactory<>("citizenInformation"));

        tcCPR.setCellValueFactory(new PropertyValueFactory<>("CPR"));

        tcCitizenInformation.setCellValueFactory(new PropertyValueFactory<>("citizenAddress"));


        tvPatients.setItems(citizenInfoModel.getAllCitizens());
    }

}
