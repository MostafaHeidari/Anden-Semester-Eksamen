package GUI.Controller.Student;

import BE.CitizenInfo;
import GUI.Controller.Universal.Case.CasesController;
import GUI.Controller.Universal.Case.CasesEditController;
import GUI.Controller.Universal.Case.CreateCaseController;
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
    private JFXButton btnLogout;


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
        try {
            setStudentTableView();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void createCaseBtn(ActionEvent actionEvent) throws IOException {
        CitizenInfo citizenInfo = (CitizenInfo) tvPatients.getSelectionModel().getSelectedItem();
        Parent root1;
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/GUI/View/Universal/Case/CreateCase.fxml"));
        root1 = (Parent) fxmlLoader1.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));

        fxmlLoader1.<CreateCaseController>getController().setCitizenID(citizenInfo);

        stage.show();
    }

    public void caseInfoBtn(ActionEvent actionEvent) throws IOException {
        if (selectedCitizenInfo != null) {
            Parent root1;
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/GUI/View/Universal/Case/Cases.fxml"));
            root1 = (Parent) fxmlLoader1.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));

            fxmlLoader1.<CasesController>getController().setSelectedCitizen(selectedCitizenInfo);
            stage.show();

        }
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

    private void setStudentTableView() throws IOException {
        tcCitizenId.setCellValueFactory(new PropertyValueFactory<>("citizenId"));

        tcCitizenName.setCellValueFactory(new PropertyValueFactory<>("citizenName"));

        tcCitizenLastName.setCellValueFactory(new PropertyValueFactory<>("citizenLastName"));

        tcCitizenAddress.setCellValueFactory(new PropertyValueFactory<>("citizenAddress"));

        tcCPR.setCellValueFactory(new PropertyValueFactory<>("CPR"));

        tcCitizenInformation.setCellValueFactory(new PropertyValueFactory<>("citizenInformation"));


        tvPatients.setItems(citizenInfoModel.getAllCitizens());
    }
}
