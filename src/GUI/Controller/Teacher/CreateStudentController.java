package GUI.Controller.Teacher;

import BE.Student;
import DAL.crypto.BCrypt;
import GUI.Controller.Universal.NotFilledTxtFieldController;
import GUI.Controller.Universal.SimpleDialogController;
import GUI.Model.LoginModel;
import GUI.Model.StudentModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateStudentController implements Initializable {

    public StudentModel studentModel;


    private EditStudentController editStudentController;

    @FXML
    public JFXButton backClasses;
    @FXML
    public JFXButton BtnBackPatient;
    @FXML
    private JFXButton BtnBack;
    @FXML
    public JFXButton citizenInformation;
    @FXML
    public JFXButton BtnCreateStudent;
    @FXML
    public JFXButton BtnDeleteStudent;


    @FXML
    private TextField txtNameField;
    @FXML
    private TextField txtLastnameField;
    @FXML
    public PasswordField passwordTxt;
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

    public String saltPw(){
        /** Randomly generated salt
         / Statict salt
         */
        String salt = "SuperCoolAppLol";
        return salt;
    }

    /**
     * Creating a student with the OpretElevActionButton method
     */
    public void CreateStudentActionButton(ActionEvent actionEvent) throws IOException, SQLException {
        if (txtNameField.getText() == "" || txtLastnameField.getText() == "" || passwordTxt.getText() == "" || txtUserField.getText() == ""){
            Popup popup = new Popup();
            NotFilledTxtFieldController controller = new NotFilledTxtFieldController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/NotFilledTxtField.fxml"));
            loader.setController(controller);
            popup.getContent().add((Parent)loader.load());
        }
        else {

            String studentName = txtNameField.getText();
            String studentLastname = txtLastnameField.getText();
            String studentAccount = txtUserField.getText();



            /** Hash a password for the first time
            / Store this value in DB. Salt is included, so no need for separate salt column in DB
             */
            String studentUsername = txtUserField.getText();


            uploadLogin(studentUsername,passwordTxt.getText());
            uploadStudentInfo(studentName, studentLastname,studentAccount);
        }
    }


    private void uploadLogin(String studentUsername, String hashedPassword) throws IOException, SQLException {
        LoginModel loginModel = LoginModel.getInstance();

        loginModel.uploadLogin(studentUsername,hashedPassword);
    }

    /**
     * uploads a student info with the uploadStudentInfo method
     */
    private void uploadStudentInfo(String studentName, String studentLastname, String userName) throws IOException, SQLException {
        StudentModel studentModelInfo = new StudentModel();

        studentModelInfo.uploadStudentinfo(studentName, studentLastname, userName);

        txtNameField.clear();
        txtLastnameField.clear();
        passwordTxt.clear();
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
     * Goes to the TeacherGroupAndStudents view
     */
    public void btnBackGroups(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnCreateStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherGroupAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setScene(scene);
    }


    /**
     * Log out and goes to the Login view
     */
    public void LogOut(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnBack.getScene().getWindow();
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

        tcUserName.setCellValueFactory(new PropertyValueFactory<>("UserName"));

        tvStudent.setItems(studentModel.getAllStudents());
    }



    /**
     * Goes to the TeacherKlasseAndStudents view
     */
    public void btnBackClasses(ActionEvent event) throws IOException {
        Stage switcher = (Stage) backClasses.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherGroupAndStudents.fxml"));
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
    public void DeleteStudentAction(ActionEvent actionEvent) {
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
    public void citizenInformationBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnBackPatient.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/CitizenInfo.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Borger Informationer");
        switcher.setScene(scene);
    }
}
