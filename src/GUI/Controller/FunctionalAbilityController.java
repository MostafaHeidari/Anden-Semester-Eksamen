package GUI.Controller;

import GUI.Model.FunctionalAbilityModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class FunctionalAbilityController {

    public FunctionalAbilityModel functionalAbilityModel;

    @FXML
    private Button Button;

    @FXML
    private boolean cb1;
    @FXML
    private Checkbox cb2;
    @FXML
    private Checkbox cb3;
    @FXML
    private Checkbox cb4;
    @FXML
    private Checkbox cb5;
    @FXML
    private Checkbox cb6;

    @FXML
    private Checkbox cb21;
    @FXML
    private Checkbox cb22;
    @FXML
    private Checkbox cb23;
    @FXML
    private Checkbox cb24;
    @FXML
    private Checkbox cb25;
    @FXML
    private Checkbox cb26;




public FunctionalAbilityController() throws IOException {
    this.functionalAbilityModel = new FunctionalAbilityModel();
}

    //Nuværende tilstands knapper
    public void Checked1(ActionEvent actionEvent) {
    }

    public void Checked2(ActionEvent actionEvent) {
    }

    public void Checked3(ActionEvent actionEvent) {
    }

    public void Checked4(ActionEvent actionEvent) {
    }

    public void Checked5(ActionEvent actionEvent) {
    }

    public void Checked6(ActionEvent actionEvent) {
    }


    //Kommene tilstands knapper
    public void checked21(ActionEvent actionEvent) {
    }

    public void checked22(ActionEvent actionEvent) {
    }

    public void checked23(ActionEvent actionEvent) {
    }

    public void checked24(ActionEvent actionEvent) {
    }

    public void checked25(ActionEvent actionEvent) {
    }

    public void checked26(ActionEvent actionEvent) {
    }

    public void buttonSave(ActionEvent actionEvent) throws IOException {

    if(boolean )

        Stage switcher = (Stage) Button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSU System");
        switcher.setScene(scene);

        //TODO
        //save choice to database
    }
}
