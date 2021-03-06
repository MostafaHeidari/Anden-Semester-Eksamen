package GUI.Controller.Universal;

import BE.CitizenInfo;
import GUI.Controller.Universal.Case.CasesController;
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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CitizenInfoContoller implements Initializable {


    private final CitizenInfoModel citizenInfoModel;

    public CitizenInfo selectedCitizenInfo;


    @FXML
    private JFXButton caseInfo;
    @FXML
    private JFXButton backGroups;
    @FXML
    private JFXButton backStudent;
    @FXML
    private JFXButton backCitizen;
    @FXML
    private JFXButton createCase;

    @FXML
    private TableView<CitizenInfo> tvCitizenInfo;
    @FXML
    private TableColumn<CitizenInfo, Integer> tcCitizenId;
    @FXML
    private TableColumn<CitizenInfo, String> tcNameCitizen;
    @FXML
    private TableColumn<CitizenInfo, String> tcCitizenLastname;
    @FXML
    private TableColumn<CitizenInfo, String> tcCitizenAge;

    /**
     * Constructor
     *
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
        if (tvCitizenInfo.getItems().size() > 0) { //Set den valgte til den f??rste i listen, hvis der er nogen
            selectedCitizenInfo = (CitizenInfo) tvCitizenInfo.getItems().get(0);
        }

    }

    /**
     * Goes to Login view
     */
    public void backToLastPageBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) caseInfo.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/View/Teacher/EditCitizen.fxml")));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }

    /**
     * Goes to TeacherKlasseAndStudents view
     */
    public void btnBackGroups(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/View/Teacher/TeacherGroupAndStudents.fxml")));
        Scene scene = new Scene(root);
        switcher.setTitle("Klassen");
        switcher.setScene(scene);
    }

    /**
     * Goes to CreateCitizen view
     */
    public void backCitizenBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backCitizen.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/View/Teacher/CreateCitizen.fxml")));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Borger");
        switcher.setScene(scene);
    }

    /**
     * Goes to CreateStudent view
     */
    public void backStudentBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml")));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Student");
        switcher.setScene(scene);
    }


    public void caseInfoBtn(ActionEvent event) throws IOException {

        if (selectedCitizenInfo != null) {
            Parent root1;
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/GUI/View/Universal/Case/Cases.fxml"));
            root1 = (Parent) fxmlLoader1.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            Image icon = new Image(getClass().getResourceAsStream("/GUI/View/img/old lady.png"));
            stage.getIcons().add(icon);

            fxmlLoader1.<CasesController>getController().setSelectedCitizen(selectedCitizenInfo);
            stage.show();

        }
    }


    /**
     * Changes selected Name tvCitizenInfo in the adminEventMangerTableViewName
     */
    private void setSelectedItems() {
        if (tvCitizenInfo.getSelectionModel().getSelectedItem() != null) {
            selectedCitizenInfo = tvCitizenInfo.getSelectionModel().getSelectedItem();
        }

    }


    public void createCaseBtn(ActionEvent event) throws IOException {
        CitizenInfo citizenInfo = (CitizenInfo) tvCitizenInfo.getSelectionModel().getSelectedItem();
        Parent root1;
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/GUI/View/Universal/Case/CreateCase.fxml"));
        root1 = (Parent) fxmlLoader1.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));

        fxmlLoader1.<CreateCaseController>getController().setCitizenID(citizenInfo);

        stage.show();
    }

    public void LogOut(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) caseInfo.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/View/Universal/Login.fxml")));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);
    }
}
