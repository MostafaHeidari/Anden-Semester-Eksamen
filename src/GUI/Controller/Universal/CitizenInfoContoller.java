package GUI.Controller.Universal;

import BE.Citizen;
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

    public Citizen selectedCitizen;


    @FXML
    public JFXButton caseInfo;
    @FXML
    public JFXButton backClass;
    @FXML
    public JFXButton backStudent;
    @FXML
    public JFXButton backCitizen;
    @FXML
    public JFXButton createCase;

    @FXML
    public TableView<Citizen>  tvCitizenInfo;
    @FXML
    public TableColumn<Citizen, Integer> tcCitizenId;
    @FXML
    public TableColumn<Citizen, String>  tcNameCitizen;
    @FXML
    public TableColumn<Citizen, String>  tcCitizenLastname;
    @FXML
    public TableColumn<Citizen, String>  tcCitizenAge;

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

        tcCitizenAge.setCellValueFactory(new PropertyValueFactory<>("citizenAge"));


        tvCitizenInfo.setItems(citizenInfoModel.getAllCitizens());

    }

    /**
     * Goes to Teacher view
     */
    public void backToLastPageBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backClass.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Forside");
        switcher.setScene(scene);
    }

    /**
     * Goes to TeacherKlasseAndStudents view
     */
    public void backClassBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherKlasseAndStudents.fxml"));
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
        casesController.setCitizenID(selectedCitizen);
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }


    /**
     * Changes selected Name  in the adminEventMangerTableViewName
     */
    private void setSelectedItems() {
        if (tvCitizenInfo.getSelectionModel().getSelectedItem() != null)
        {
            selectedCitizen = tvCitizenInfo.getSelectionModel().getSelectedItem();
        }

    }

    public void createCaseBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) caseInfo.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/CreateCase.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        CreateCaseController casesController = fxmlLoader.<CreateCaseController>getController();
        casesController.setCitizenID(selectedCitizen);
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }
}
