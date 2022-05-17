package GUI.Controller.Universal;

import BE.CitizenInfo;
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

public class CitizenInfoContoller implements Initializable {



    private CitizenInfoModel citizenInfoModel;

    public CitizenInfo selectedCitizenInfo;


    @FXML
    public JFXButton caseInfo;
    @FXML
    public JFXButton backGroups;
    @FXML
    public JFXButton backStudent;
    @FXML
    public JFXButton backCitizen;
    @FXML
    public JFXButton createCase;

    @FXML
    public TableView<CitizenInfo>  tvCitizenInfo;
    @FXML
    public TableColumn<CitizenInfo, Integer> tcCitizenId;
    @FXML
    public TableColumn<CitizenInfo, String>  tcNameCitizen;
    @FXML
    public TableColumn<CitizenInfo, String>  tcCitizenLastname;
    @FXML
    public TableColumn<CitizenInfo, String>  tcCitizenAge;

    /**
     * Constructor
     * @throws IOException
     */
    public CitizenInfoContoller() throws IOException {
        citizenInfoModel = new CitizenInfoModel();
    }

    /**
     * initialize
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setStudentTableView();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tvCitizenInfo.setOnMouseClicked((MouseEvent event) -> {
            setSelectedItems();
        });
    }

    /**
     * Sets the StudentTableView
     */
    public void setStudentTableView() throws IOException {

        tcCitizenId.setCellValueFactory(new PropertyValueFactory<>("citizenId"));

        tcNameCitizen.setCellValueFactory(new PropertyValueFactory<>("citizenName"));

        tcCitizenLastname.setCellValueFactory(new PropertyValueFactory<>("citizenLastName"));

        tvCitizenInfo.setItems(citizenInfoModel.getAllCitizens());

    }

    /**
     * Goes to Teacher view
     */
    public void backToLastPageBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backGroups.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Forside");
        switcher.setScene(scene);
    }

    /**
     * Goes to TeacherKlasseAndStudents view
     */
    public void btnBackGroups(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherGroupAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Klassen");
        switcher.setScene(scene);
    }

    /**
     * Goes to CreateCitizen view
     */
    public void backCitizenBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backCitizen.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateCitizen.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Borger");
        switcher.setScene(scene);
    }

    /**
     * Goes to CreateStudent view
     */
    public void backStudentBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Student");
        switcher.setScene(scene);
    }


    public void caseInfoBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) caseInfo.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/Cases.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        CasesController casesController = fxmlLoader.<CasesController>getController();
        casesController.setCitizenID(selectedCitizenInfo);
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }


    /**
     * Changes selected Name tvCitizenInfo in the adminEventMangerTableViewName
     */
    private void setSelectedItems() {
        if (tvCitizenInfo.getSelectionModel().getSelectedItem() != null)
        {
            selectedCitizenInfo = tvCitizenInfo.getSelectionModel().getSelectedItem();
        }

    }


    public void createCaseBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) caseInfo.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/CreateCase.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        CreateCaseController casesController = fxmlLoader.<CreateCaseController>getController();
        casesController.setCitizenID(selectedCitizenInfo);
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }

    public void LogOut(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) caseInfo.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }
}
