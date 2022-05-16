package GUI.Controller.Universal;

import BE.Login;
import DAL.crypto.BCrypt;
import GUI.Controller.Teacher.CreateStudentController;
import GUI.Model.LoginModel;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private CreateStudentController createStudentController = new CreateStudentController();

    public FontAwesomeIconView LockIkon;
    public FontAwesomeIconView userIkon;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtFieldUsername;
    @FXML
    private TextField txtPasswordField;


    private LoginModel loginModel = LoginModel.getInstance();

    /**
     * Constructor
     * @throws IOException
     */
    public LoginController() throws IOException {
    }

    /**
     * Testing for teacher or Student login
     * @throws IOException
     * @throws SQLServerException
     */
    public void Login() throws IOException, SQLServerException {

        Login login =  loginModel.login(txtFieldUsername.getText(), txtPasswordField.getText());

        /**
         * Testing in terminal to see right data from user
         */
        //System.out.println(txtFieldUsername.getText());
        //System.out.println(txtPasswordField.getText());

        if(login != null) {

            /**
             * If Student then login
             */
            if (login.getUserType().equals("Student")) {
                Stage switcher = (Stage) btnLogin.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Patient.fxml"));
                switcher.setTitle("Patient");
                Scene scene = new Scene(root);
                switcher.setScene(scene);
            }

            /**
             * If Teacher then login
             */
            if (login.getUserType().equals("Teacher")) {
                Stage switcher = (Stage) btnLogin.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
                switcher.setTitle("Teacher");
                Scene scene = new Scene(root);
                switcher.setScene(scene);
            }

            /**
             * If Admin then login
             */
            if (login.getUserType().equals("Admin")) {
                Stage switcher = (Stage) btnLogin.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Admin/AdminCreateTeacher.fxml"));
                switcher.setTitle("Teacher");
                Scene scene = new Scene(root);
                switcher.setScene(scene);
            }
        }

    }

    /**
     * See what key is pressed and presse login Btn on The enter key
     * @param keyEvent
     * @throws IOException
     * @throws SQLServerException
     */
    public void handleOnKeyPressed(KeyEvent keyEvent) throws IOException, SQLServerException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            Login();
        }
    }
}
