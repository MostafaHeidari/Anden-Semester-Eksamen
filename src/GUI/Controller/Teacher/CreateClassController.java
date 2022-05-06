package GUI.Controller.Teacher;

import GUI.Model.ClassModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CreateClassController {

    public JFXButton saveButton;
    public JFXButton backButton;
    public TextField classNavnTxt;
    ClassModel classModelInfo = new ClassModel();


    public CreateClassController() throws IOException {
    }


    /**
     * Saves the klasseNavn
     */
    public void saveBtn(ActionEvent actionEvent) throws IOException, SQLException {
        String klasseNavn = classNavnTxt.getText();
        uploadClassInfo(klasseNavn);
        cancel(actionEvent);
    }

    /**
     * uploads the classinfo
     */
    private void uploadClassInfo(String className) throws SQLException, IOException {
        classModelInfo.uploadKlasseInfo(className);
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
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherKlasseAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }
}
