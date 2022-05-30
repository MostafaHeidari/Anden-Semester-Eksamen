package GUI.Controller.Universal;

import BE.Case;
import BE.CitizenInfo;
import BE.GeneralInformation;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ResourceBundle;

public class GeneralinformationController implements Initializable {

    public GeneralInformationModel generalInformationModel;

    private final GeneralInformationDAO generalInformationDAO;
    private int CategoryID = 0;
    
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
    @FXML
    public Text selectedCategory;

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

        switch (CategoryID) {
            case 1:  generalInformationDAO.updateMestring(InfoTextBox.getText(), selectedCitizenId.getCitizenId());
                break;
            case 2:  generalInformationDAO.updateMotivation(InfoTextBox.getText(), selectedCitizenId.getCitizenId());
                break;
            case 3:  generalInformationDAO.updateRessourcer(InfoTextBox.getText(), selectedCitizenId.getCitizenId());
                break;
            case 4:  generalInformationDAO.updateRoller(InfoTextBox.getText(), selectedCitizenId.getCitizenId());
                break;
            case 5:  generalInformationDAO.updateVaner(InfoTextBox.getText(), selectedCitizenId.getCitizenId());
                break;
            case 6:  generalInformationDAO.updateUddanelseJob(InfoTextBox.getText(), selectedCitizenId.getCitizenId());
                break;
            case 7:  generalInformationDAO.updateLivhistorie(InfoTextBox.getText(), selectedCitizenId.getCitizenId());
                break;
            case 8:  generalInformationDAO.updateHelbredsOplysninger(InfoTextBox.getText(), selectedCitizenId.getCitizenId());
                break;
            case 9:  generalInformationDAO.updateHjælpemidler(InfoTextBox.getText(), selectedCitizenId.getCitizenId());
                break;
            case 10: generalInformationDAO.updateBoligensIndretning(InfoTextBox.getText(), selectedCitizenId.getCitizenId());
                break;
            case 11: generalInformationDAO.updateNetværk(InfoTextBox.getText(), selectedCitizenId.getCitizenId());
                break;
            default:
                break;
        }
    }

    public void mestring(ActionEvent actionEvent) throws SQLException {
        CategoryID = 1;
        InfoTextBox.clear();
        InfoTextBox.setText(generalInformationDAO.getMestring(selectedCitizenId.getCitizenId()));
        selectedCategory.setText("Mestring");
    }

    public void motivation(ActionEvent actionEvent) throws SQLException {
        CategoryID = 2;
        InfoTextBox.clear();
        InfoTextBox.setText(generalInformationDAO.getMotivation(selectedCitizenId.getCitizenId()));
        selectedCategory.setText("Motivation");
    }

    public void ressourcer(ActionEvent actionEvent) throws SQLException {
        CategoryID = 3;
        InfoTextBox.clear();
        InfoTextBox.setText(generalInformationDAO.getRessourcer(selectedCitizenId.getCitizenId()));
        selectedCategory.setText("Ressourcer");
    }

    public void roller(ActionEvent actionEvent) throws SQLException {
        CategoryID = 4;
        InfoTextBox.clear();
        InfoTextBox.setText(generalInformationDAO.getRoller(selectedCitizenId.getCitizenId()));
        selectedCategory.setText("Roller");
    }

    public void vaner(ActionEvent actionEvent) throws SQLException {
        CategoryID = 5;
        InfoTextBox.clear();
        InfoTextBox.setText(generalInformationDAO.getVaner(selectedCitizenId.getCitizenId()));
        selectedCategory.setText("Vaner");
    }

    public void uddannelse(ActionEvent actionEvent) throws SQLException {
        CategoryID = 6;
        InfoTextBox.clear();
        InfoTextBox.setText(generalInformationDAO.getUddanelseJob(selectedCitizenId.getCitizenId()));
        selectedCategory.setText("Uddanelse");
    }

    public void livsHistorie(ActionEvent actionEvent) throws SQLException {
        CategoryID = 7;
        InfoTextBox.clear();
        InfoTextBox.setText(generalInformationDAO.getLivshistorie(selectedCitizenId.getCitizenId()));
        selectedCategory.setText("Livshistorie");
    }

    public void helbred(ActionEvent actionEvent) throws SQLException {
        CategoryID = 8;
        InfoTextBox.clear();
        InfoTextBox.setText(generalInformationDAO.getHelbredsOplysninger(selectedCitizenId.getCitizenId()));
        selectedCategory.setText("Helbred");
    }

    public void hjælpeMidler(ActionEvent actionEvent) throws SQLException {
        CategoryID = 9;
        InfoTextBox.clear();
        InfoTextBox.setText(generalInformationDAO.getHjælpemidler(selectedCitizenId.getCitizenId()));
        selectedCategory.setText("Hjælpemidler");
    }

    public void bolig(ActionEvent actionEvent) throws SQLException {
        CategoryID = 10;
        InfoTextBox.clear();
        InfoTextBox.setText(generalInformationDAO.getBoligIndretning(selectedCitizenId.getCitizenId()));
        selectedCategory.setText("Bolig");
    }

    public void network(ActionEvent actionEvent) throws SQLException {
        CategoryID = 11;
        InfoTextBox.clear();
        InfoTextBox.setText(generalInformationDAO.getNetværk(selectedCitizenId.getCitizenId()));
        selectedCategory.setText("Netværk");
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