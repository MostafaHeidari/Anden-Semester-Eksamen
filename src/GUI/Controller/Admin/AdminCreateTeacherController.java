package GUI.Controller.Admin;

import BE.Teacher;
import GUI.Controller.Universal.NotFilledTxtFieldController;
import GUI.Controller.Universal.SimpleDialogController;
import GUI.Model.LoginModel;
import GUI.Model.Admin.TeacherModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class AdminCreateTeacherController implements Initializable {


    TeacherModel teacherModel;

    public Teacher selectedTeacher;

    @FXML
    public JFXButton BtnBack;
    @FXML
    public Button createTeacher;
    @FXML
    public JFXButton createAdmin;
    @FXML
    public JFXButton deleteTeacher;

    @FXML
    public TextField teacherNameTxt;
    @FXML
    public TextField teacherLastNameTxt;
    @FXML
    public TextField teacherUserNameTxt;
    @FXML
    public TextField teacherPasswordTxt;

    @FXML
    public TableView tvTeacher;
    @FXML
    public TableColumn tcTeacherName;
    @FXML
    public TableColumn tcTeacherLastName;
    @FXML
    public TableColumn tcTeacherUserName;

    /**
     * Constructor
     * @throws IOException
     */
    public AdminCreateTeacherController() throws IOException {

        teacherModel = TeacherModel.getInstance();
    }

    /**
     * initialize
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            setTeacherTableView();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tvTeacher.setOnMouseClicked((MouseEvent event) -> {
            setSelectedTeacher();
        });
    }

    /**
     * Goes to the Login view
     */
    public void BtnBack(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Universal/Login.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }

    /**
     * Creating a teacher with the createTeacherBtn method
     */
    public void createTeacherBtn(ActionEvent event) throws IOException, SQLException {
        if (teacherNameTxt.getText() == "" || teacherLastNameTxt.getText() == "" || teacherUserNameTxt.getText() == "" || teacherPasswordTxt.getText() == "" ){
            Popup popup = new Popup();
            NotFilledTxtFieldController controller = new NotFilledTxtFieldController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/NotFilledTxtField.fxml"));
            loader.setController(controller);
            popup.getContent().add((Parent)loader.load());
        }
        else {

            String teacherName = teacherNameTxt.getText();
            String teacherLastName = teacherLastNameTxt.getText();
            String teacherUserName = teacherUserNameTxt.getText();

            String userNameTeacher = teacherUserNameTxt.getText();
            String passwordTeacher = teacherPasswordTxt.getText();




            uploadLogin(userNameTeacher,passwordTeacher);
            uploadTeacherInfo(teacherName, teacherLastName,teacherUserName);
        }
    }

    /**
     * remove a Teacher with the deleteTeacherBtn method
     */
    public void deleteTeacherBtn(ActionEvent event) {
        if (SimpleDialogController.delete() && selectedTeacher != null) {
            teacherModel.removeTeacher(selectedTeacher);
        }
    }


    /**
     * selects a Teacher with the setSelectedStudent method
     */
    private void setSelectedTeacher() {
        if (tvTeacher.getSelectionModel().getSelectedItem() != null)
        {
            selectedTeacher = (Teacher) tvTeacher.getSelectionModel().getSelectedItem();
        }
    }

    /**
     * Goes to the Create Admin view
     */
    public void createAdminBtn(ActionEvent event) throws IOException {
        Stage switcher = (Stage) BtnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Admin/AdminCreateAdmin.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("Opret System");
        switcher.setScene(scene);
    }



    /**
     * uploads a teacher login info with the uploadLogin method
     */
    private void uploadLogin(String userNameTeacher, String passwordTeacher) throws IOException, SQLException {
        LoginModel loginModel = LoginModel.getInstance();

        loginModel.uploadLoginTeacher(userNameTeacher,passwordTeacher);
    }

    /**
     * uploads a teacher info with the uploadTeacherInfo method
     */
    private void uploadTeacherInfo(String teacherName, String teacherLastName, String teacherUserName) throws IOException, SQLException {
        TeacherModel teacherModel =  TeacherModel.getInstance();

        teacherModel.uploadTeacherInfo(teacherName, teacherLastName,teacherUserName);

        teacherNameTxt.clear();
        teacherLastNameTxt.clear();
        teacherUserNameTxt.clear();
        teacherPasswordTxt.clear();

        tvTeacher.getItems().clear();

        tvTeacher.setItems(teacherModel.getAllTeachers());
    }


    /**
     * here we set the information in the tableView
     * @throws IOException
     */
    public void setTeacherTableView() throws IOException {
        tcTeacherName.setCellValueFactory(new PropertyValueFactory<>("teacherName"));

        tcTeacherLastName.setCellValueFactory(new PropertyValueFactory<>("teacherLastName"));

        tcTeacherUserName.setCellValueFactory(new PropertyValueFactory<>("teacherUserName"));

        tvTeacher.setItems(teacherModel.getAllTeachers());
    }
}
