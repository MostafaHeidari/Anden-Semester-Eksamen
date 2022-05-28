package GUI.Controller.Universal;

import BE.CitizenInfo;
import DAL.GeneralInformationDAO;
import GUI.Controller.Universal.Case.CasesController;
import GUI.Model.GeneralInformationModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ResourceBundle;

public class GeneralinformationController implements Initializable {

    public GeneralInformationModel generalInformationModel;

    private final GeneralInformationDAO generalInformationDAO;
    
    @FXML
    public Button BtnMestring;
    @FXML
    public Button BtnMotivation;
    @FXML
    public Button BtnRessourcer;
    @FXML
    public Button BtnRoller;
    @FXML
    public Button BtnVaner;
    @FXML
    public Button BtnUddannelse;
    @FXML
    public Button BtnLivsHistorie;
    @FXML
    public Button BtnHelbred;
    @FXML
    public Button BtnHjælpeMidler;
    @FXML
    public Button BtnBolig;
    @FXML
    public Button BtnNetwork;
    @FXML
    public JFXButton BtnBack;
    @FXML
    public TextArea InfoTextBox;

    private CitizenInfo selectedCitizenId;

    /**
     * Constructor
     * @throws IOException
     */
    public GeneralinformationController() throws IOException {
        this.generalInformationModel = new GeneralInformationModel();
        this.generalInformationDAO = new GeneralInformationDAO();
    }

    public void BtnBack(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnBack.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/Case/Cases.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        CasesController controller = loader.getController();
        controller.setSelectedCitizen(selectedCitizenId);
        switcher.setTitle("Sager");
        switcher.setScene(scene);
    }

    public void btnHandleSaveCitizen(ActionEvent actionEvent) throws SQLException {
        generalInformationDAO.updateMestring(InfoTextBox.getText(), selectedCitizenId.getCitizenId());
    }

    public void mestring(ActionEvent actionEvent) throws SQLException {
        InfoTextBox.setText(String.valueOf(new PropertyValueFactory("Mestring")));
    }

    public void motivation(ActionEvent actionEvent) {
    }

    public void ressourcer(ActionEvent actionEvent) {
    }

    public void roller(ActionEvent actionEvent) {
    }

    public void vaner(ActionEvent actionEvent) {
    }

    public void uddannelse(ActionEvent actionEvent) {
    }

    public void livsHistorie(ActionEvent actionEvent) {
    }

    public void helbred(ActionEvent actionEvent) {
    }

    public void hjælpeMidler(ActionEvent actionEvent) {
    }

    public void bolig(ActionEvent actionEvent) {
    }

    public void network(ActionEvent actionEvent) {
    }

    public void setSelectedCitizen(CitizenInfo selectedCitizen) {
        selectedCitizenId = selectedCitizen;
        try {
            generalInformationDAO.createGeneralInformation(null, null, null,null, null, null,null,
                    null, null, null, null, selectedCitizenId.getCitizenId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}