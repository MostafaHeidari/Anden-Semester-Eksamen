package GUI.Controller.Universal;

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
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class FunctionalAbilityController implements Initializable {

    public FunctionalAbilityModel functionalAbilityModel;

    private final FunctionalAbilityDAO functionalAbilityDAO;

    private int caseID;

    @FXML
    private AnchorPane Pane;
    @FXML
    private Button Button;

    @FXML
    private TextArea tb1;
    @FXML
    private TextArea tb2;

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
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/FunctionalAbilityCategory.fxml"));
        Scene scene = new Scene(root);
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

        //uploads the selected checkbox to database with their respectable names, which you get from the stringResult array
        functionalAbilityDAO.uploadCaseID(caseID, stringResult[row1int], stringResult[row2int]);
    }

    public void rememberChoice() throws IOException {
        FXMLLoader switcher = new FXMLLoader(getClass().getResource("/GUI/View/Universal/FunctionalAbility.fxml"));
        Parent root = (Parent)switcher.load();
        FunctionalAbilityController controller = (FunctionalAbilityController)switcher.getController();
        caseID = Integer.parseInt(switcher.getController().toString());
        System.out.println(caseID = Integer.parseInt(switcher.getController().toString()));

        try{
            List<FunctionalAbility> allFuncionalAbilities = functionalAbilityDAO.getAllFuncionalAbilities();
            for (int i = 0; i < allFuncionalAbilities.size(); i++){
                if (allFuncionalAbilities.get(i).getCaseID() == caseID){
                    System.out.println(allFuncionalAbilities.get(i).getcondition());
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
        //array of checkboxes in row 1 and 2
        row1 = new CheckBox[]{cb1, cb2, cb3, cb4, cb5, cb6};
        row2 = new CheckBox[]{cb21, cb22, cb23, cb24, cb25, cb26};
        row3 = new CheckBox[]{cb31, cb32, cb33, cb34};
        row4 = new CheckBox[]{cb41, cb42};

        //array of names for the checkboxes
        stringResult = new String[]{"Ingen/ubetydelige begrænsninger", "Lette begrænsninger", "Moderate begrænsninger", "Svære begrænsninger", "Totale begrænsninger", "Ikke relevant"};

    }

    public void buttonBack(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/FunctionalAbilityCategory.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("FunktionsevneTilstand Kategori");
        switcher.setScene(scene);


    }
}
