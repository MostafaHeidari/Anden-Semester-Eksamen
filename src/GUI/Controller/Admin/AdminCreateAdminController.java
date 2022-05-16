package GUI.Controller.Admin;

import GUI.Controller.Universal.NotFilledTxtFieldController;
import GUI.Model.Admin.AdminModel;
import GUI.Model.LoginModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminCreateAdminController implements Initializable {

    AdminModel adminModel;

    @FXML
    public JFXButton BtnBack;
    @FXML
    public JFXButton deleteAdmin;
    @FXML
    public Button createAdmin;

    @FXML
    public TextField adminUserNameTxt;
    @FXML
    public PasswordField adminPasswordTxt;

    @FXML
    public TableView tvAdmin;
    @FXML
    public TableColumn tcAdminUserName;

    /**
     * Constructor
     * @throws IOException
     */
    public AdminCreateAdminController() throws IOException {

        adminModel = AdminModel.getInstance();
    }



    /**
     * initialize
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setAdminTableView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Goes to the Admin create Teacher view
     */
    public void BtnBack(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) BtnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Admin/AdminCreateTeacher.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("SOSUS System");
        switcher.setScene(scene);
    }


    /**
     * Creating a admin with the createAdminBtn method
     */
    public void createAdminBtn(ActionEvent actionEvent) throws SQLException, IOException {
        if (adminUserNameTxt.getText() == "" || adminPasswordTxt.getText() == ""){
            Popup popup = new Popup();
            NotFilledTxtFieldController controller = new NotFilledTxtFieldController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Universal/NotFilledTxtField.fxml"));
            loader.setController(controller);
            popup.getContent().add((Parent)loader.load());
        }
        else {

            String userNameAdmin = adminUserNameTxt.getText();
            String passwordAdmin = adminPasswordTxt.getText();


            uploadLogin(userNameAdmin,passwordAdmin);

        }
    }


    /**
     * uploads a admin login info with the uploadLogin method
     */
    private void uploadLogin(String userNameAdmin, String passwordAdmin) throws IOException, SQLException {
        LoginModel loginModel = LoginModel.getInstance();

        adminUserNameTxt.clear();
        adminPasswordTxt.clear();


        loginModel.uploadLoginAdmin(userNameAdmin,passwordAdmin);
        
        tvAdmin.getItems().clear();


        tvAdmin.setItems(adminModel.getAllAdmins());
    }

    public void deleteAdminBtn(ActionEvent actionEvent) {
    }


    /**
     * here we set the information in the tableView
     * @throws IOException
     */
    public void setAdminTableView() throws IOException {

        tcAdminUserName.setCellValueFactory(new PropertyValueFactory("username"));

        tvAdmin.setItems(adminModel.getAllAdmins());
    }


}
