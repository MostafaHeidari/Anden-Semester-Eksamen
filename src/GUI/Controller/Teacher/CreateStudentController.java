package GUI.Controller.Teacher;

import BE.Student;
import GUI.Controller.Universal.SimpleDialogController;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateStudentController implements Initializable {

    public StudentModel studentModel;
    public JFXButton citizenInfomation;
    private EditStudentController editStudentController;

    @FXML
    public JFXButton backClasses;
    @FXML
    public JFXButton BtnBackPatient;
    @FXML
    private JFXButton BtnBack;

    @FXML
    private JFXButton BtnTilbageOpretStudent;
    @FXML
    private JFXButton Logud;

    @FXML
    private TextField txtNameField;
    @FXML
    private TextField txtLastnameField;
    @FXML
    private TextField txtEmailField;
    @FXML
    private TextField txtAgeField;
    @FXML
    private TextField txtUserField;

    @FXML
    public TableView tvStudent;
    @FXML
    public TableColumn tcId;
    @FXML
    public TableColumn tcNameStudent;
    @FXML
    public TableColumn tcLastName;
    @FXML
    public TableColumn tcEmail;
    @FXML
    public TableColumn tcAge;
    @FXML
    public TableColumn tcUserName;

    public Student selectedStudent;


    /**
     * Constructor
     * @throws IOException
     */
    public CreateStudentController() throws IOException {
        this.studentModel = new StudentModel();
        this.editStudentController = new EditStudentController();
    }

    /**
     * initialize
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            setStudentTableView();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tvStudent.setOnMouseClicked((MouseEvent event) -> {
            setSelectedStudent();
        });
    }

    /**
     * Creating a student with the OpretElevActionButton method
     */
    public void CreateStudentActionButton(ActionEvent actionEvent) throws IOException, SQLException {
        if (txtNameField.getText() == "" || txtLastnameField.getText() == "" || txtEmailField.getText() == "" || txtAgeField.getText() == ""){

        }
        else {
            String studentName = txtNameField.getText();
            String studentLastname = txtLastnameField.getText();
            String studentEmail = txtEmailField.getText();
            String studentAge = txtAgeField.getText();
            String StudentAccount = txtUserField.getText();

            uploadStudentInfo(studentName, studentLastname, studentEmail, studentAge,StudentAccount);
        }
    }

    /**
     * uploads a student info with the uploadStudentInfo method
     */
    private void uploadStudentInfo(String studentName, String studentLastname, String studentEmail, String studentAge, String userName) throws IOException, SQLException {
        StudentModel studentModelInfo = new StudentModel();

        studentModelInfo.uploadStudentinfo(studentName, studentLastname, studentEmail, studentAge, userName);

        txtNameField.clear();
        txtLastnameField.clear();
        txtEmailField.clear();
        txtAgeField.clear();

        txtUserField.clear();


        tvStudent.getItems().clear();


        tvStudent.setItems(studentModel.getAllStudents());
    }


    /**
     * Goes to the Teacher view
     */
    public void BtnBack(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Forside");
        switcher.setScene(scene);
    }

    /**
     * Goes to the CreateStudent view
     */
    public void BtnTilbageOpretStudentAction(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnTilbageOpretStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml"));
        Scene scene = new Scene(root);
        switcher.setScene(scene);
    }


    /**
     * Log out and goes to the Login view
     */
    public void LogOutAction(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Logud.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setScene(scene);
    }


    /**
     * edit a student with the EditStudentAction method
     */
    public void EditStudentAction(ActionEvent actionEvent) throws IOException {
        if (selectedStudent != null) {
            Student selectedStudent = (Student) tvStudent.getSelectionModel().getSelectedItem();
            Parent root1;
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/GUI/View/Teacher/EditStudent.fxml"));
            root1 = (Parent) fxmlLoader1.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));

            fxmlLoader1.<EditStudentController>getController().setSelectedStudent(selectedStudent);
            fxmlLoader1.<EditStudentController>getController().setSelectedTable(tvStudent);
            stage.show();

        }
    }


    /**
     * this button must to save the selected students information
     */
    public void GamOplysingerActionButton(ActionEvent actionEvent) {
    }

    public void setStudentTableView() throws IOException {
        tcId.setCellValueFactory(new PropertyValueFactory<>("studentId"));

        tcNameStudent.setCellValueFactory(new PropertyValueFactory<>("studentName"));

        tcLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tcAge.setCellValueFactory(new PropertyValueFactory<>("age"));

        tcUserName.setCellValueFactory(new PropertyValueFactory<>("UserName"));

        tvStudent.setItems(studentModel.getAllStudents());
    }



    /**
     * Goes to the TeacherKlasseAndStudents view
     */
    public void btnBackClasses(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backClasses.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherKlasseAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Classe Manger");
        switcher.setScene(scene);
    }

    /**
     * Goes to the CreateCitizen view
     */
    public void btnBackPatient(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnBackPatient.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateCitizen.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Borger");
        switcher.setScene(scene);
    }


    /**
     * remove a student with the SletElevAction method
     */
    public void SletElevAction(ActionEvent actionEvent) {
        if (SimpleDialogController.delete() && selectedStudent != null) {
            studentModel.removeStudent(selectedStudent);
        }
    }

    /**
     * selects a student with the setSelectedStudent method
     */
    private void setSelectedStudent() {
        if (tvStudent.getSelectionModel().getSelectedItem() != null)
        {
            selectedStudent = (Student) tvStudent.getSelectionModel().getSelectedItem();
        }
    }

    /**
     * Goes to the CitizenInfo view
     */
    public void citizenInfomationBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnBackPatient.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/CitizenInfo.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Borger Informationer");
        switcher.setScene(scene);
    }
}
