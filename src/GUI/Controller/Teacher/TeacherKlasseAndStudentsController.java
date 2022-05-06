package GUI.Controller.Teacher;

import BE.SchoolClass;
import BE.Student;

import GUI.Controller.Universal.SimpleDialogController;
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

    public ClassModel classModel;


    public Student selectedStudent;

    public Student selectedStudentInClass;

    public SchoolClass selectedClass;


    @FXML
    public JFXButton nyKlasse;
    @FXML
    public JFXButton nyStudent1;
    @FXML
    public JFXButton addStudentToClass;
    @FXML
    public JFXButton deleteStudentInClass;
    @FXML
    public JFXButton tilbageElever;
    @FXML
    public JFXButton tilbageBogerBtn;

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


    /**
     * initialize
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setKlasseTableView();
            setStudentTableView();
            setStudentsInClasses(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        tvStudentsInClasses.setOnMouseClicked((MouseEvent event) -> {
            setSelectedItems();

            tvKlasseInfomationer.getItems().clear();


            tvKlasseInfomationer.setItems(classModel.getAllClasses());
        });
        tvKlasseInfomationer.setOnMouseClicked((MouseEvent event) -> {
            setSelectedItems();
        });
        tvStudent.setOnMouseClicked((MouseEvent event) -> {
            setSelectedItems();
        });
    }

    /**
     * Constructor
     * @throws IOException
     */
    public TeacherKlasseAndStudentsController() throws IOException {
        classModel = new ClassModel();
        studentModel = new StudentModel();
    }

    /**
     * Goes to the Teacher view
     */
    public void TilbageForsideBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) tilbageElever.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Teacher");
        switcher.setScene(scene);
    }

    /**
     * Goes to the CreateKlasse view
     */
    public void nyKlasseBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) tilbageElever.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateKlasse.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Classe Manger");
        switcher.setScene(scene);
    }

    /**
     * Goes to the CreateStudent view
     */
    public void nyStudentBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) tilbageElever.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Student");
        switcher.setScene(scene);
    }

    /**
     * Sets the setKlasseTableView
     */
    private void setKlasseTableView() throws IOException {

        tcKlasseId.setCellValueFactory(new PropertyValueFactory<>("classId"));

        tcKlasseNavn.setCellValueFactory(new PropertyValueFactory<>("className"));


        tvKlasseInfomationer.setItems(classModel.getAllClasses());
        if(tvKlasseInfomationer.getItems().size() > 0){ //Set den valgte til den første i listen, hvis der er nogen
            selectedClass = (SchoolClass) tvKlasseInfomationer.getItems().get(0);
        }
    }

    /**
     * Sets the setStudentTableView
     */
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


    /**
     * Sets the setStudentsInClasses
     */
    public void setStudentsInClasses(){

        tcStudentNameInClass.setCellValueFactory(new PropertyValueFactory<Student, String>("studentName"));

        tcLastNameInClass.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));


        tvStudentsInClasses.setItems(studentModel.setStudentsInClass(selectedClass.classId));

    }

    /**
     * Sets the setSelectedItems
     */
    private void setSelectedItems() {
        if (tvStudentsInClasses.getSelectionModel().getSelectedItem() != null)
        {
            selectedStudentInClass = (Student) tvStudentsInClasses.getSelectionModel().getSelectedItem();
        }
        if (tvStudent.getSelectionModel().getSelectedItem() != null)
        {
            selectedStudent = (Student) tvStudent.getSelectionModel().getSelectedItem();
        }
        if (tvKlasseInfomationer.getSelectionModel().getSelectedItem() != null)
        {
            selectedClass = (SchoolClass) tvKlasseInfomationer.getSelectionModel().getSelectedItem();
            setStudentsInClasses();
        }
    }

    /**
     * add the student to a class
     */
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

    /**
     * delete the student to a class
     */
    public void deleteStudentInClassBtn(ActionEvent event) throws SQLException {
        if(SimpleDialogController.delete()){
            studentModel.deleteStudentInClass(selectedClass,
             selectedStudentInClass
            );
            tvStudentsInClasses.getItems().remove(selectedStudentInClass);
            tvStudentsInClasses.refresh();
        }
    }

    /**
     * Goes to the CreateCitizen view
     */
    public void btnTilbageBoger(ActionEvent event) throws IOException {
        Stage switcher = (Stage) tilbageBogerBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateCitizen.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Borger");
        switcher.setScene(scene);
    }

    /**
     * Goes to the CitizenInfo view
     */
    public void citizenInfomationBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) tilbageElever.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Unvesial/CitizenInfo.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Borger Informationer");
        switcher.setScene(scene);
    }

    /**
     * Goes to the CreateStudent view
     */
    public void btnTilbageElever(ActionEvent event) throws IOException {
        Stage switcher = (Stage) tilbageElever.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Student");
        switcher.setScene(scene);
    }

    /**
     * delete a class
     */
    public void deleteAClassBtn(ActionEvent event) {
        if (SimpleDialogController.delete())
            classModel.deleteAClass(selectedClass);
            tvKlasseInfomationer.refresh();
    }
}
