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
import javafx.scene.input.MouseEvent;
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
    private Button Button;
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
    @FXML
    private CheckBox cb35;
    @FXML
    private CheckBox cb36;

    private CheckBox[] row3;


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
     * nuværende tilstands knapper
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
     * Kommene tilstands knapper
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
     * Borgerens mening om tilstand knapper
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

    public void checked35(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row3);
    }

    public void checked36(ActionEvent actionEvent) {
        deselectOthers(actionEvent, row3);
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
        System.out.println(caseID);
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
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

        //uploads the selected checkbox to database with their respectable names, which you get from the stringResult array
        functionalAbilityDAO.uploadCaseID(caseID, stringResult[row1int], stringResult[row2int], stringResult[row3int]);
    }

    /**
     * initialize
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       //Stage switcher = (Stage) Button.getScene().getWindow();
        //caseID = Integer.parseInt(switcher.getUserData().toString());
        //array of checkboxes in row 1 and 2
        row1 = new CheckBox[]{cb1, cb2, cb3, cb4, cb5, cb6};
        row2 = new CheckBox[]{cb21, cb22, cb23, cb24, cb25, cb26};
        row3 = new CheckBox[]{cb31, cb32, cb33, cb34, cb35, cb36};
        //array of names for the checkboxes
        stringResult = new String[]{"Ingen/ubetydelige begrænsninger", "Lette begrænsninger", "Moderate begrænsninger", "Svære begrænsninger", "Totale begrænsninger", "Ikke relevant"};

        /*
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
        */
    }

}
