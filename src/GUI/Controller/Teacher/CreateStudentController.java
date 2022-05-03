package GUI.Controller.Teacher;

import BE.Student;
import GUI.Controller.SimpleDialogController;
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
import java.util.Objects;
import java.util.ResourceBundle;

public class CreateStudentController implements Initializable {

    public StudentModel studentModel;
    private EditStudentController editStudentController;

    @FXML
    public JFXButton tilbageKlasser;
    @FXML
    public JFXButton tilbageBogerBtn;
    @FXML
    private JFXButton BtnTilbage;
    @FXML
    private JFXButton BtnOpretElev;
    @FXML
    private JFXButton BtnRedigerElev;
    @FXML
    private JFXButton BtnSletElev;

    @FXML
    private JFXButton BtnTilbageOpretStudent;
    @FXML
    private JFXButton Logud;

    @FXML
    private TextField txtnavnField;
    @FXML
    private TextField txtefterNavnField;
    @FXML
    private TextField txtEmailField;
    @FXML
    private TextField txtAlderFiled;

    @FXML
    private JFXButton BtnGamOplysinger;

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

    public Student selectedStudent;



    public CreateStudentController() throws IOException {
        this.studentModel = new StudentModel();
        this.editStudentController = new EditStudentController();
    }

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


    public void OpretElevActionButton(ActionEvent actionEvent) throws IOException, SQLException {
        if (txtnavnField.getText() == "" || txtefterNavnField.getText() == "" || txtEmailField.getText() == "" || txtAlderFiled.getText() == ""){

        }
        else {
            String studentNavn = txtnavnField.getText();
            String studentEfternavn = txtefterNavnField.getText();
            String studentEmail = (txtEmailField.getText());
            String studentAlder = txtAlderFiled.getText();
            uploadStudentInfo(studentNavn, studentEfternavn, studentEmail, studentAlder);
        }
    }

    private void uploadStudentInfo(String studentNavn, String studentEfternavn, String studentEmail, String studentAlder) throws IOException, SQLException {
        StudentModel studentModelInfo = new StudentModel();

        studentModelInfo.uploadStudentinfo(studentNavn, studentEfternavn, studentEmail, studentAlder);

        txtnavnField.clear();
        txtefterNavnField.clear();
        txtEmailField.clear();
        txtAlderFiled.clear();


    }



    /* this button turn back to teacher window*/
    public void BtnTilbage(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnTilbage.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Forside");
        switcher.setScene(scene);
    }

    /* this button turn back to createStudent window*/
    public void BtnTilbageOpretStudentAction(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnTilbageOpretStudent.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/CreateStudent.fxml"));
        Scene scene = new Scene(root);
        switcher.setScene(scene);
    }


    /*this button must to log out*/
    public void LogOutAction(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) Logud.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setScene(scene);
    }

    /* this button edit the Student 4*/
    public void RedigerElevAction(ActionEvent actionEvent) throws IOException {
        if (selectedStudent != null) {
            Student selectedStudent = (Student) tvStudent.getSelectionModel().getSelectedItem();
            Parent root1;
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/GUI/View/Teacher/EditStudent.fxml"));
            root1 = (Parent) fxmlLoader1.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));

            fxmlLoader1.<EditStudentController>getController().setSelectedStudent(selectedStudent);

            stage.show();

        }
    }




    /*this button must to save the selected students information*/
    public void GamOplysingerActionButton(ActionEvent actionEvent) {
    }

    public void setStudentTableView() throws IOException {
        tcId.setCellValueFactory(new PropertyValueFactory<>("studentId"));

        tcNameStudent.setCellValueFactory(new PropertyValueFactory<>("studentName"));

        tcLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tcAge.setCellValueFactory(new PropertyValueFactory<>("age"));


        tvStudent.setItems(studentModel.getAllStudents());
    }


    public void btnTilbageKlasser(ActionEvent event) throws IOException {
        Stage switcher = (Stage) tilbageKlasser.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/TeacherKlasseAndStudents.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Classe Manger");
        switcher.setScene(scene);
    }

    public void btnTilbageBoger(ActionEvent event) throws IOException {
        Stage switcher = (Stage) tilbageBogerBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/OpretBorger.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret Borger");
        switcher.setScene(scene);
    }



    //remove student method //
    public void SletElevAction(ActionEvent actionEvent) {
        if (SimpleDialogController.delete() && selectedStudent != null) {
            studentModel.removeStudent(selectedStudent);
        }
    }

    private void setSelectedStudent() {
        if (tvStudent.getSelectionModel().getSelectedItem() != null)
        {
            selectedStudent = (Student) tvStudent.getSelectionModel().getSelectedItem();
        }
    }
}
