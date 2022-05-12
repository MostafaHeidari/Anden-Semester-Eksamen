package GUI.Controller.Universal;

import BE.Case;
import BE.CitizenInfo;
import GUI.Model.CaseModel;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CasesController implements Initializable {


    public JFXButton deleteCase;
    private CitizenInfo selectedCitizenInfo;

    public CaseModel caseModel;

    public Case selectedCase;


    @FXML
    public TableView tvCase;
    @FXML
    public TableColumn tcCaseId;
    @FXML
    public TableColumn tcCaseInfo;
    @FXML
    public TableColumn tcCaseName;

    @FXML
    public JFXButton backToLastPage;
    @FXML
    public JFXButton backClass;
    @FXML
    public JFXButton backCitizen;
    @FXML
    public JFXButton backStudent;

    @FXML
    public Text nameCitizenTxt;
    @FXML
    public Text lastNameCitizenTxt;

    public CasesController() throws IOException {
        caseModel = new CaseModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tvCase.setOnMouseClicked((MouseEvent event) -> {
            setSelectedCase();
        });
    }

    /**
     * Goes to CitizenInfo view
     */
    public void backToLastPageBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backToLastPage.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/CitizenInfo.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Borger Informationer");
        switcher.setScene(scene);
    }

    /**
     * Goes to TeacherKlasseAndStudents view
     */
    public void backClassBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backClass.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherGroupAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Classe Manger");
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

    private void setCaseView(){

        tcCaseId.setCellValueFactory(new PropertyValueFactory<>("caseId"));

        tcCaseName.setCellValueFactory(new PropertyValueFactory<>("caseName"));

        tcCaseInfo.setCellValueFactory(new PropertyValueFactory<>("caseInformation"));

        tvCase.setItems(caseModel.getAllCases(selectedCitizenInfo.getCitizenId()));
    }

    public void setCitizenID(CitizenInfo citizenInfo) {
        selectedCitizenInfo = citizenInfo;
        nameCitizenTxt.setText(citizenInfo.getCitizenName());
        lastNameCitizenTxt.setText(citizenInfo.getCitizenLastName());
        setCaseView();
    }

    public void deleteCaseBtn(ActionEvent actionEvent) {
        if (SimpleDialogController.delete() && selectedCase != null) {
            caseModel.deleteCase(selectedCase);
        }
    }

    /**
     * selects a student with the setSelectedCase method
     */
    private void setSelectedCase() {
        if (tvCase.getSelectionModel().getSelectedItem() != null)
        {
            selectedCase = (Case) tvCase.getSelectionModel().getSelectedItem();
        }
    }


}
