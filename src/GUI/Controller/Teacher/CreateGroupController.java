package GUI.Controller.Teacher;

import GUI.Model.GroupModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CreateGroupController {

    @FXML
    public JFXButton saveButton;
    @FXML
    public JFXButton backButton;
    @FXML
    public TextField classNameTxt;

    GroupModel classModelInfo = new GroupModel();

    /**
     * Constructor
     * @throws IOException
     */
    public CreateGroupController() throws IOException {
    }


    /**
     * Saves the klasseNavn
     */
    public void saveBtn(ActionEvent actionEvent) throws IOException, SQLException {
        String klasseNavn = classNameTxt.getText();
        uploadClassInfo(klasseNavn);
        cancel(actionEvent);
    }

    /**
     * uploads the classinfo
     */
    private void uploadClassInfo(String className) throws SQLException, IOException {
        classModelInfo.uploadGroupInfo(className);
    }

    /**
     * Goes to the previous view
     */
    public void backBtn(ActionEvent actionEvent) throws IOException {
        cancel(actionEvent);
    }

    /**
     * Cancel and goes to the TeacherKlasseAndStudents view
     */
    private void cancel(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) saveButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherGroupAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Klassen");
        switcher.setScene(scene);
    }
}
