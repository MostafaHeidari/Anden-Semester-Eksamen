package GUI.Controller.Teacher;

import GUI.Model.ClassModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherKlasseAndStudentsController implements Initializable {

    @FXML
    private ClassModel klasseModel;

    @FXML
    public JFXButton TilbageForside;
    @FXML
    public JFXButton nyKlasse;
    @FXML
    public JFXButton nyStudent1;

    @FXML
    public TableView tvKlasseInfomationer;
    @FXML
    public TableColumn tcKlasseId;
    @FXML
    public TableColumn tcKlasseNavn;

    @FXML
    public TableView tvStudent;
    @FXML
    public TableColumn tcNameStudent;
    @FXML
    public TableColumn tcEfterName;
    @FXML
    public TableColumn tcEmail;
    @FXML
    public TableColumn tcAlder;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setKlasseTableView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TeacherKlasseAndStudentsController() throws IOException {
        this.klasseModel = new ClassModel();
    }

    public void TilbageForsideBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) TilbageForside.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }

    public void nyKlasseBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) TilbageForside.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateKlasse.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }

    public void nyStudentBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) TilbageForside.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }

    private void setKlasseTableView() throws IOException {

        tcKlasseId.setCellValueFactory(new PropertyValueFactory<>("klasseId"));

        tcKlasseNavn.setCellValueFactory(new PropertyValueFactory<>("klasseNavn"));


        tvKlasseInfomationer.setItems(klasseModel.getAllClasses());
    }

    public void setStudentTableView(){
        tcNameStudent.setCellValueFactory(new PropertyValueFactory<>("studentName"));
    }

}
