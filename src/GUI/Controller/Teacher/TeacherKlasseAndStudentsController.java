package GUI.Controller.Teacher;

import GUI.Model.ClassModel;
import GUI.Model.StudentModel;
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

    public StudentModel studentModel;


    private ClassModel klasseModel;

    @FXML
    public JFXButton TilbageForside;
    @FXML
    public JFXButton nyKlasse;
    @FXML
    public JFXButton nyStudent1;
    @FXML
    public JFXButton addStudentToClass;

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
    public TableColumn tcStudentId;
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
            setStudentTableView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TeacherKlasseAndStudentsController() throws IOException {
        klasseModel = new ClassModel();
        studentModel = new StudentModel();
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

    public void setStudentTableView() throws IOException {
        tcStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));

        tcNameStudent.setCellValueFactory(new PropertyValueFactory<>("studentName"));

        tcEfterName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tcAlder.setCellValueFactory(new PropertyValueFactory<>("age"));


        tvStudent.setItems(studentModel.getAllStudents());
    }

    public void addStudentToClassBtn(ActionEvent event) {
        
    }
}
