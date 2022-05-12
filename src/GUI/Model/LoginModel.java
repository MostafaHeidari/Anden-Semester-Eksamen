package GUI.Model;

import BE.Login;
import BE.Student;
import BLL.LoginManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class LoginModel {
    private LoginManager loginManager;

    private ObservableList<Login> loginList = FXCollections.observableArrayList();

    /**
     * Constructor
     * @throws IOException
     */
    public LoginModel() throws IOException {
        loginManager = new LoginManager();
    }

    /**
     * Gets the login username and the password using login from loginManager
     * @param username
     * @param password
     * @return
     * @throws SQLServerException
     */
    public Login login(String username, String password) throws SQLServerException {
        return loginManager.login(username, password);
    }

    /**
     * Gets the uploadLogin studentUsername, studentPassword using uploadLogin from loginManager
     * @param studentUsername
     * @param hashedPassword
     * @throws SQLServerException
     */
    public void uploadLogin(String studentUsername, String hashedPassword) throws SQLException {
        loginList.add(loginManager.uploadLogin(studentUsername,hashedPassword));
    }
}
