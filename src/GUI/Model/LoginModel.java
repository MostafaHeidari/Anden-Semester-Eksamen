package GUI.Model;

import BE.Login;
import BLL.LoginManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;

public class LoginModel {
    private LoginManager loginManager;

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
}
