package GUI.Controller.Universal;

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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CitizenInfoContoller implements Initializable {


    private CitizenInfoModel citizenInfoModel;

    public JFXButton caseInfo;
    public JFXButton BtnTilbage;
    public JFXButton tilbageKlasser;
    public JFXButton tilbageBogerBtn;
    @FXML
    public TableView tvCitizenInfo;
    @FXML
    public TableColumn tcCitizenId;
    @FXML
    public TableColumn tcNameCitizen;
    @FXML
    public TableColumn tcCitizenEfterName;
    @FXML
    public TableColumn tcCitizenAlder;

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
    }

    /**
     * Sets the StudentTableView
     */
    public void setStudentTableView() throws IOException {

        tcCitizenId.setCellValueFactory(new PropertyValueFactory<>("citizenId"));

        tcNameCitizen.setCellValueFactory(new PropertyValueFactory<>("citizenName"));

        tcCitizenEfterName.setCellValueFactory(new PropertyValueFactory<>("citizenLastName"));

        tcCitizenAlder.setCellValueFactory(new PropertyValueFactory<>("citizenAge"));


        tvCitizenInfo.setItems(citizenInfoModel.getAllCitizens());
    }

    /**
     * Goes to Teacher view
     */
    public void backToLastPageBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnTilbage.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Forside");
        switcher.setScene(scene);
    }

    /**
     * Goes to TeacherKlasseAndStudents view
     */
    public void backClassBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) tilbageKlasser.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherKlasseAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Classe Manger");
        switcher.setScene(scene);
    }

    /**
     * Goes to CreateCitizen view
     */
    public void backCitizenBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnTilbage.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateCitizen.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Borger");
        switcher.setScene(scene);
    }

    /**
     * Goes to CreateStudent view
     */
    public void backStudentBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) tilbageKlasser.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Student");
        switcher.setScene(scene);
    }


    public void caseInfoBtn(ActionEvent event) {

    }
}
