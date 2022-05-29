package GUI.Controller.Teacher;

import BE.SchoolGroups;
import BE.Student;

import GUI.Controller.Universal.SimpleDialogController;
import GUI.Model.GroupModel;
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
import java.util.Objects;
import java.util.ResourceBundle;

public class TeacherGroupAndStudentsController implements Initializable {

    public StudentModel studentModel;

    public GroupModel groupModel;


    public Student selectedStudent;

    public Student selectedStudentInGroup;

    public SchoolGroups selectedGroup;


    @FXML
    private JFXButton backStudent;
    @FXML
    private JFXButton backPatientBtn;

    @FXML
    private TableView tvClassInformation;
    @FXML
    private TableColumn tcClassId;
    @FXML
    private TableColumn tcClassName;

    @FXML
    private TableView tvStudent;
    @FXML
    private TableColumn tcNameStudent;
    @FXML
    private TableColumn tcStudentId;
    @FXML
    private TableColumn tcLastname;


    @FXML
    private TableView tvStudentsInGroups;
    @FXML
    private TableColumn tcStudentNameInGroup;
    @FXML
    private TableColumn tcLastNameInGroup;


    /**
     * initialize
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setKlasseTableView();
            setStudentTableView();
            setStudentsInGroups();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tvStudentsInGroups.setOnMouseClicked((MouseEvent event) -> {
            setSelectedItems();

            tvClassInformation.getItems().clear();


            tvClassInformation.setItems(groupModel.getAllGroups());
        });
        tvClassInformation.setOnMouseClicked((MouseEvent event) -> {
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
    public TeacherGroupAndStudentsController() throws IOException {
        groupModel = new GroupModel();
        studentModel = new StudentModel();
    }

    /**
     * Goes to the Teacher view
     */
    public void BackFrontpageBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) backStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/View/Teacher/Teacher.fxml")));
        Scene scene = new Scene(root);
        switcher.setTitle("Teacher");
        switcher.setScene(scene);
    }

    /**
     * Goes to the CreateKlasse view
     */
    public void newGroupBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) backStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/View/Teacher/CreateGroups.fxml")));
        Scene scene = new Scene(root);
        switcher.setTitle("Classe Manger");
        switcher.setScene(scene);
    }

    /**
     * Goes to the CreateStudent view
     */
    public void newStudentBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) backStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml")));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Student");
        switcher.setScene(scene);
    }

    /**
     * Sets the setKlasseTableView
     */
    private void setKlasseTableView() throws IOException {

        tcClassId.setCellValueFactory(new PropertyValueFactory<>("groupId"));

        tcClassName.setCellValueFactory(new PropertyValueFactory<>("groupName"));


        tvClassInformation.setItems(groupModel.getAllGroups());
        if(tvClassInformation.getItems().size() > 0){ //Set den valgte til den første i listen, hvis der er nogen
            selectedGroup = (SchoolGroups) tvClassInformation.getItems().get(0);
        }
    }

    /**
     * Sets the setStudentTableView
     */
    public void setStudentTableView() throws IOException {

        tcStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));

        tcNameStudent.setCellValueFactory(new PropertyValueFactory<>("studentName"));

        tcLastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));



            try {
                tvStudent.setItems(studentModel.getAllStudents());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    /**
     * Sets the setStudentsInGroups
     */
    public void setStudentsInGroups(){

        tcStudentNameInGroup.setCellValueFactory(new PropertyValueFactory<Student, String>("studentName"));

        tcLastNameInGroup.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));


        tvStudentsInGroups.setItems(studentModel.setStudentsInGroup(selectedGroup.getGroupId()));

    }

    /**
     * Sets the setSelectedItems
     */
    private void setSelectedItems() {
        if (tvStudentsInGroups.getSelectionModel().getSelectedItem() != null)
        {
            selectedStudentInGroup = (Student) tvStudentsInGroups.getSelectionModel().getSelectedItem();
        }
        if (tvStudent.getSelectionModel().getSelectedItem() != null)
        {
            selectedStudent = (Student) tvStudent.getSelectionModel().getSelectedItem();
        }
        if (tvClassInformation.getSelectionModel().getSelectedItem() != null)
        {
            selectedGroup = (SchoolGroups) tvClassInformation.getSelectionModel().getSelectedItem();
            setStudentsInGroups();
        }
    }

    /**
     * add the student to a class
     */
    public void addStudentToGroupBtn(ActionEvent event) {
        try {
            studentModel.addStudentToGroup(
                    selectedGroup,
                    selectedStudent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tvStudentsInGroups.setItems(studentModel.setStudentsInGroup(selectedGroup.getGroupId()));
        tvStudentsInGroups.refresh();
    }

    /**
     * delete the student to a class
     */
    public void deleteStudentInGroupsBtn(ActionEvent event) throws SQLException {
        if(SimpleDialogController.delete()){
            studentModel.deleteStudentInGroups(selectedGroup,
             selectedStudentInGroup
            );
            tvStudentsInGroups.getItems().remove(selectedStudentInGroup);
            tvStudentsInGroups.refresh();
        }
    }

    /**
     * Goes to the CreateCitizen view
     */
    public void btnBackPatient(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backPatientBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/View/Teacher/CreateCitizen.fxml")));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Borger");
        switcher.setScene(scene);
    }

    /**
     * Goes to the CitizenInfo view
     */
    public void citizenInformationBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/View/Universal/CitizenInfo.fxml")));
        Scene scene = new Scene(root);
        switcher.setTitle("Borger Informationer");
        switcher.setScene(scene);
    }

    /**
     * Goes to the CreateStudent view
     */
    public void btnBackStudent(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml")));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Student");
        switcher.setScene(scene);
    }

    /**
     * delete a class
     */
    public void deleteAGroupBtn(ActionEvent event) {
        if (SimpleDialogController.delete())
            groupModel.deleteAGroup(selectedGroup);
        tvClassInformation.refresh();
    }

    public void LogOutOfClass(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) backStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/View/Universal/Login.fxml")));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }
}
