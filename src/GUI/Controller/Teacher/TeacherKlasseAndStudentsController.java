package GUI.Controller.Teacher;

import BE.SchoolClass;
import BE.Student;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TeacherKlasseAndStudentsController implements Initializable {

    public StudentModel studentModel;


    private ClassModel klasseModel;

    public Student selectedStudent;

    public Student selectedStudentInClass;

    public SchoolClass selectedClass;

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

    @FXML
    public TableView tvStudentsInClasses;
    @FXML
    public TableColumn tcClaseNameForStudentClasses;
    @FXML
    public TableColumn tcStudentNameInClass;
    @FXML
    public TableColumn tcLastNameInClass;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setKlasseTableView();
            setStudentTableView();
            setStudentsInClasses(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        tvKlasseInfomationer.setOnMouseClicked((MouseEvent event) -> {
            setSelectedItems();
        });
        tvStudent.setOnMouseClicked((MouseEvent event) -> {
            setSelectedItems();
        });
        tvStudentsInClasses.setOnMouseClicked((MouseEvent event) -> {
            setSelectedItems();
        });
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

        tcKlasseId.setCellValueFactory(new PropertyValueFactory<>("classId"));

        tcKlasseNavn.setCellValueFactory(new PropertyValueFactory<>("className"));


        tvKlasseInfomationer.setItems(klasseModel.getAllClasses());
        if(tvKlasseInfomationer.getItems().size() > 0){ //Set den valgte til den første i listen, hvis der er nogen
            selectedClass = (SchoolClass) tvKlasseInfomationer.getItems().get(0);
        }
    }

    public void setStudentTableView() throws IOException {

        tcStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));

        tcNameStudent.setCellValueFactory(new PropertyValueFactory<>("studentName"));

        tcEfterName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tcAlder.setCellValueFactory(new PropertyValueFactory<>("age"));


            try {
                tvStudent.setItems(studentModel.getAllStudents());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    public void setStudentsInClasses(){

        tcStudentNameInClass.setCellValueFactory(new PropertyValueFactory<Student, String>("studentName"));

        tcLastNameInClass.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));


        tvStudentsInClasses.setItems(studentModel.setStudentsInClass(selectedClass.classId));

    }

    private void setSelectedItems() {
        if (tvStudent.getSelectionModel().getSelectedItem() != null)
        {
            selectedStudent = (Student) tvStudent.getSelectionModel().getSelectedItem();
        }
        if (tvKlasseInfomationer.getSelectionModel().getSelectedItem() != null)
        {
            selectedClass = (SchoolClass) tvKlasseInfomationer.getSelectionModel().getSelectedItem();
            setStudentsInClasses();
        }
        if (tvStudentsInClasses.getSelectionModel().getSelectedItem() != null)
        {
            selectedStudentInClass = (Student) tvStudentsInClasses.getSelectionModel().getSelectedItem();
        }
    }

    public void addStudentToClassBtn(ActionEvent event) {
        try {
            studentModel.addStudentToClass(
                    selectedClass,
                    selectedStudent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tvStudentsInClasses.setItems(studentModel.setStudentsInClass(selectedClass.classId));
        tvStudentsInClasses.refresh();
    }
}
