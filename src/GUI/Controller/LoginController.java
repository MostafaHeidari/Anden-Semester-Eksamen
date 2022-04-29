package GUI.Controller;

import BE.Login;
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
    public FontAwesomeIconView LockIkon;
    public FontAwesomeIconView userIkon;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtFieldUsername;
    @FXML
    private TextField txtPasswordField;

    private LoginModel loginModel = new LoginModel();

    public LoginController() throws IOException {
    }

    public void Login() throws IOException, SQLServerException {
        System.out.println(txtFieldUsername.getText());
        System.out.println(txtPasswordField.getText());


        Login login =  loginModel.login(txtFieldUsername.getText(), txtPasswordField.getText());
        if(login.getUserType().equals("Student")){
            Stage switcher = (Stage) btnLogin.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Patient.fxml"));
            switcher.setTitle("Patient");
            Scene scene = new Scene(root);
            switcher.setScene(scene);
        }

        if(login.getUserType().equals("Teacher")){
            Stage switcher = (Stage) btnLogin.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/Teacher/Teacher.fxml"));
            switcher.setTitle("Teacher");
            Scene scene = new Scene(root);
            switcher.setScene(scene);
        }
    }
    public void handleOnKeyPressed(KeyEvent keyEvent) throws IOException, SQLServerException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            Login();
        }
    }
}
