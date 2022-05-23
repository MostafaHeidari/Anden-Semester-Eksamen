package GUI.Controller.Universal.Case;

import BE.Case;
import BE.CitizenInfo;
import GUI.Controller.Universal.CategoryController;
import GUI.Controller.Universal.SimpleDialogController;
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

    @FXML
    public JFXButton deleteCase;
    public JFXButton editCase;
    @FXML
    private CitizenInfo selectedCitizenInfo;
    @FXML
    public CaseModel caseModel;
    @FXML
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
    @FXML
    public Text CprCitizenTxt;
    @FXML
    public Text GenInfoTxt1;
    @FXML
    public JFXButton Category;

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
        /*turn back to Create student window*/
        Stage switcher = (Stage) deleteCase.getScene().getWindow();
        switcher.setTitle("Case System");
        switcher.close();
    }


    private void setCaseView(){

        tcCaseId.setCellValueFactory(new PropertyValueFactory<>("caseId"));

        tcCaseName.setCellValueFactory(new PropertyValueFactory<>("caseName"));

        tcCaseInfo.setCellValueFactory(new PropertyValueFactory<>("caseInformation"));

        tvCase.setItems(caseModel.getAllCases(selectedCitizenInfo.getCitizenId()));
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


    public void btnBackGroups(ActionEvent actionEvent) {
    }

    public void funktionsevneBtn(ActionEvent event) throws IOException {
        if (tvCase.getSelectionModel().getSelectedItem() != null) {
            selectedCase = (Case) tvCase.getSelectionModel().getSelectedItem();
            int tempCaseID = selectedCase.getCaseId();
            Stage switcher = (Stage) Category.getScene().getWindow();
            switcher.setUserData(tempCaseID);
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/FunctionalAbility.fxml"));
            Scene scene = new Scene(root);
            switcher.setTitle("FunktionsEvne");
            switcher.setScene(scene);
        }
    }

    public void BtnCategory(ActionEvent actionEvent) throws IOException {
        if (tvCase.getSelectionModel().getSelectedItem() != null)
        {
            selectedCase = (Case) tvCase.getSelectionModel().getSelectedItem();

            Stage switcher = (Stage) Category.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/Category.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            CategoryController controller = loader.getController();
            controller.setCaseID(selectedCase.getCaseId());
            loader.<CategoryController>getController().setSelectedCitizen(selectedCitizenInfo);
            switcher.setTitle("Helbredstilstande");
            switcher.setScene(scene);
        }
    }


    public void editCaseBtn(ActionEvent event) throws IOException {
        if (selectedCase != null) {
            Case selectedCase = (Case) tvCase.getSelectionModel().getSelectedItem();
            Parent root1;
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/GUI/View/Universal/Case/CasesEdit.fxml"));
            root1 = (Parent) fxmlLoader1.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));

            fxmlLoader1.<CasesEditController>getController().setSelectedCase(selectedCase);
            fxmlLoader1.<CasesEditController>getController().setController(this);
            stage.show();

        }
    }

    public void setSelectedCitizen(CitizenInfo selectedCitizen) {
        selectedCitizenInfo = selectedCitizen;
        nameCitizenTxt.setText(selectedCitizen.getCitizenName());
        lastNameCitizenTxt.setText(selectedCitizen.getCitizenLastName());
        CprCitizenTxt.setText(selectedCitizen.getCPR());
        GenInfoTxt1.setText(selectedCitizen.getCitizenInformation());
        setCaseView();

    }
}
