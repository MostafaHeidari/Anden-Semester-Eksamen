package GUI.Controller.Teacher;

import GUI.Model.KlasseModel;
import com.jfoenix.controls.JFXButton;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CreateKlasseController {

    public JFXButton Gemknap;
    public JFXButton TilbageKnap;
    public TextField klasseNavnTxt;

    public void GemBtn(ActionEvent actionEvent) throws IOException, SQLException {
        String klasseNavn = klasseNavnTxt.getText();

        uploadKlasseInfo(klasseNavn);

        cancel(actionEvent);
    }

    private void uploadKlasseInfo(String klasseNavn) throws SQLException, IOException {
        KlasseModel klasseModelInfo = new KlasseModel();

        klasseModelInfo.uploadKlasseInfo(klasseNavn);
    }

    public void TilbageBtn(ActionEvent actionEvent) throws IOException {
        cancel(actionEvent);
    }

    private void cancel(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Gemknap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherKlasseAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }
}
