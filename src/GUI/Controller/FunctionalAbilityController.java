package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

public class FunctionalAbilityController {

    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;

    @FXML
    private Tooltip tt1;
    @FXML
    private Tooltip tt2;
    @FXML
    private Tooltip tt3;
    @FXML
    private Tooltip tt4;
    @FXML
    private Tooltip tt5;
    @FXML
    private Tooltip tt6;


    public void hba1(ActionEvent actionEvent) {
        b1.setTooltip(tt1);
    }
}
