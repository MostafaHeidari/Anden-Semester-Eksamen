package GUI.Controller.Universal;

import BE.CitizenInfo;
import BE.FunctionalAbility;
import DAL.FunctionalAbilityDAO;
import GUI.Model.FunctionalAbilityModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.Node;

import java.util.Arrays;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class FunctionalAbilityController implements Initializable {

    public FunctionalAbilityModel functionalAbilityModel;

    private final FunctionalAbilityDAO functionalAbilityDAO;

    private CitizenInfo selectedCitizenId;

    private int selectedCatId;

    private int selectedCaseId;

    private boolean updateNeeded;

    @FXML
    private AnchorPane Pane;
    @FXML
    private Button Button;
    @FXML
    private Text subCatName;

    private String[] subCatNameArray;

    @FXML
    private TextArea tb1;
    @FXML
    private TextArea tb2;

    private String tb1StringResult;
    private String tb2StringResult;

    @FXML
    private CheckBox cb1;
    @FXML
    private CheckBox cb2;
    @FXML
    private CheckBox cb3;
    @FXML
    private CheckBox cb4;
    @FXML
    private CheckBox cb5;
    @FXML
    private CheckBox cb6;

    private CheckBox[] row1;


    @FXML
    private CheckBox cb21;
    @FXML
    private CheckBox cb22;
    @FXML
    private CheckBox cb23;
    @FXML
    private CheckBox cb24;
    @FXML
    private CheckBox cb25;
    @FXML
    private CheckBox cb26;

    private CheckBox[] row2;


    @FXML
    private CheckBox cb31;
    @FXML
    private CheckBox cb32;
    @FXML
    private CheckBox cb33;
    @FXML
    private CheckBox cb34;

    private CheckBox[] row3;


    @FXML
    private CheckBox cb41;
    @FXML
    private CheckBox cb42;

    private CheckBox[] row4;


    private String[] stringResult;
    private String[] stringResult2;
    private String[] stringResult3;


    /**
     * Constructor
     * @throws IOException
     */
    public FunctionalAbilityController() throws IOException {
        this.functionalAbilityModel = new FunctionalAbilityModel();
        this.functionalAbilityDAO = new FunctionalAbilityDAO();
    }

    /**
     * deselects all other checkboxes, when you select one
     * @param actionEvent
     * @param row
     */
    private void deselectOthers (ActionEvent actionEvent, CheckBox[] row){
        final Node source = (Node) actionEvent.getSource();
        String id = source.getId();
        for (CheckBox cb : row){
            if(cb.isSelected()){
                if(cb.getId() != id){
                    cb.setSelected(false);
                }
            }
        }
    }

    /**
     * nuværende niveau
     * @param actionEvent
     */
    public void Checked1(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row1);
    }

    public void Checked2(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row1);
    }

    public void Checked3(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row1);
    }

    public void Checked4(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row1);
    }

    public void Checked5(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row1);
    }

    public void Checked6(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row1);
    }

    /**
     * Forventet niveau
     * @param actionEvent
     */
    public void checked21(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row2);
    }

    public void checked22(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row2);
    }

    public void checked23(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row2);
    }

    public void checked24(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row2);
    }

    public void checked25(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row2);
    }

    public void checked26(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row2);
    }


    /**
     * Udførelse
     * @param actionEvent
     */
    public void checked31(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row3);
    }

    public void checked32(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row3);
    }

    public void checked33(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row3);
    }

    public void checked34(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row3);
    }


    /**
     * Betydning af udførelse
     * @param actionEvent
     */
    public void checked41(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row4);
    }

    public void checked42(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row4);
    }

    /**
     * saves functional ability
     * @param actionEvent
     * @throws IOException
     * @throws SQLException
     */
    public void buttonSave(ActionEvent actionEvent) throws IOException, SQLException {
//switches scene when you press save
        Stage switcher = (Stage) Button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/FunctionalAbilityCategory.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        FunctionalAbilityCategoryController controller = loader.getController();
        controller.setSelectedCitizen(selectedCitizenId);
        controller.setCaseID(selectedCaseId);
        switcher.setTitle("FunktionsevneTilstand Kategori");
        switcher.setScene(scene);


        //checks which checkbox is selected
        int row1int = 0;
        for(int i = 0; i < row1.length; i++){
            if(row1[i].isSelected()){
                row1int = i;
            }
        }

        int row2int = 0;
        for(int i = 0; i < row2.length; i++){
            if(row2[i].isSelected()){
                row2int = i;
            }
        }

        int row3int = 0;
        for(int i = 0; i < row3.length; i++){
            if(row3[i].isSelected()){
                row3int = i;
            }
        }

        int row4int = 0;
        for(int i = 0; i < row4.length; i++){
            if(row4[i].isSelected()){
                row4int = i;
            }
        }

        tb1StringResult = tb1.getText();
        tb2StringResult = tb2.getText();

        //uploads the selected checkbox to database with their respectable names, which you get from the stringResult array
        if(updateNeeded){
            functionalAbilityDAO.updateFunctionalAbility(selectedCaseId, stringResult[row1int], stringResult[row2int], tb1StringResult, stringResult2[row3int], stringResult3[row4int], tb2StringResult = tb2.getText(), selectedCatId);
        }
        else{
            functionalAbilityDAO.uploadCaseID(selectedCaseId, stringResult[row1int], stringResult[row2int], tb1StringResult, stringResult2[row3int], stringResult3[row4int], tb2StringResult = tb2.getText(), selectedCatId);
        }
    }

    public void rememberChoice() throws IOException {
        try {
            updateNeeded = false;
            List<FunctionalAbility> allFuncionalAbilities = functionalAbilityDAO.getAllFuncionalAbilities();
            for (int i = 0; i < allFuncionalAbilities.size(); i++) {
                if (allFuncionalAbilities.get(i).getCaseID() == selectedCaseId && allFuncionalAbilities.get(i).getCatID() == selectedCatId) {
                    updateNeeded = true;
                    //For checkbox 1
                    for (String str : stringResult) {
                        if(Objects.equals(allFuncionalAbilities.get(i).getcondition(), str)) {
                            int stringResultInt = Arrays.asList(stringResult).indexOf(str);
                            row1[stringResultInt].setSelected(true);
                        }
                    }

                    //For checkbox 2
                    for (String str : stringResult) {
                        if(Objects.equals(allFuncionalAbilities.get(i).getfutureCondition(), str)) {
                            int stringResultInt = Arrays.asList(stringResult).indexOf(str);
                            row2[stringResultInt].setSelected(true);
                        }
                    }

                    //For textbox 1
                    tb1.setText(allFuncionalAbilities.get(i).getProfessionalNote());

                    //For checkbox 3
                    for (String str : stringResult2) {
                        if(Objects.equals(allFuncionalAbilities.get(i).getPerformance(), str)) {
                            int stringResultInt = Arrays.asList(stringResult2).indexOf(str);
                            row3[stringResultInt].setSelected(true);
                        }
                    }

                    //For checkbox 4
                    for (String str : stringResult3) {
                        if(Objects.equals(allFuncionalAbilities.get(i).getPerformanceMeaning(), str)) {
                            int stringResultInt = Arrays.asList(stringResult3).indexOf(str);
                            row4[stringResultInt].setSelected(true);
                        }
                    }

                    //for textbox 2
                    tb2.setText(allFuncionalAbilities.get(i).getCitizenNote());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    /**
     * initialize
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //array of checkboxes in row 1, 2, 3 and 4
        row1 = new CheckBox[]{cb1, cb2, cb3, cb4, cb5, cb6};
        row2 = new CheckBox[]{cb21, cb22, cb23, cb24, cb25, cb26};
        row3 = new CheckBox[]{cb31, cb32, cb33, cb34};
        row4 = new CheckBox[]{cb41, cb42};

        //array of category names
        subCatNameArray = new String[]{"",
                "Vaske sig", "Gå på toilet", "kropspleje", "Af- og påklædning,", "Spise", "Drikke", "Varetage egen sundhed", "Fødeindtagelse",
                "Udføre daglige rutiner", "Skaffe sig varer og Tjenesteydelser", "Lave mad", "Lave husligt arbejde",
                "Ændre kropsstilling", "Forflytte sig", "Løfte og bære", "Gå", "Bevæge sig omkring", "Færden i forskellige omgivelser", "Bruge transportmidler", "Udholdenhed", "Muskelstyrke",
                "Tilegne sig færdigheder", "Problemløsning", "Anvende kommunikationsudstyr og-teknikker", "Orienteringsevne", "Energi og handlekraft", "Hukommelse", "Følelsesfunktioner", "overordnede kognitive funktioner",
                "Vaske sig"
        };

        //array of names for the checkboxes and textfields
        stringResult = new String[]{"Ingen/ubetydelige begrænsninger", "Lette begrænsninger", "Moderate begrænsninger", "Svære begrænsninger", "Totale begrænsninger", "Ikke relevant"};
        stringResult2 = new String[]{"Udfører det selv", "Udfører dele selv", "Udfører ikke selv", "Ikke relevant"};
        stringResult3 = new String[]{"Oplever ikke begrænsninger","Oplever begrænsninger"};


    }

    public void buttonBack(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/FunctionalAbilityCategory.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        FunctionalAbilityCategoryController controller = loader.getController();
        controller.setSelectedCitizen(selectedCitizenId);
        controller.setCaseID(selectedCaseId);
        switcher.setTitle("FunktionsevneTilstand");
        switcher.setScene(scene);
    }

    public void setSelectedCitizen(CitizenInfo citizenId) {
        selectedCitizenId = citizenId;
    }

    public void setCaseID(int caseId) {
        selectedCaseId = caseId;
    }

    public void setCatID(int catID){
        selectedCatId = catID;
        subCatName.setText(subCatNameArray[selectedCatId]);
        try {
            rememberChoice();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
