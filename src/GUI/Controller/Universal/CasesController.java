package GUI.Controller.Universal;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CasesController {


    @FXML
    public TableView tvCase;
    @FXML
    public TableColumn tcCaseId;
    @FXML
    public TableColumn tcCaseInfo;

    @FXML
    public JFXButton backToLastPage;
    @FXML
    public JFXButton backClass;
    @FXML
    public JFXButton backCitizen;
    @FXML
    public JFXButton backStudent;

    @FXML
    public Text nameCitizen;
    @FXML
    public Text LastNameCitizen;

    /**
     * Goes to CitizenInfo view
     */
    public void backToLastPageBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backToLastPage.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Unvesial/CitizenInfo.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Borger Informationer");
        switcher.setScene(scene);
    }

    /**
     * Goes to TeacherKlasseAndStudents view
     */
    public void backClassBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backClass.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherKlasseAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Classe Manger");
        switcher.setScene(scene);
    }

    /**
     * Goes to CreateCitizen view
     */
    public void backCitizenBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backCitizen.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateCitizen.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Borger");
        switcher.setScene(scene);
    }

    /**
     * Goes to CreateStudent view
     */
    public void backStudentBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Student");
        switcher.setScene(scene);
    }
}
