package BLL;

import BE.Login;
import DAL.LoginDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;

public class LoginManager {
    private LoginDAO loginDao;

    /**
     * Constructor
     * @throws IOException
     */
    public LoginManager() throws IOException {
        loginDao = new LoginDAO();
    }

    /**
     * Gets the login username and the password using login from adminDAO
     * @param username
     * @param password
     * @return
     * @throws SQLServerException
     */
    public Login login(String username, String password) throws SQLServerException {
        return loginDao.login(username, password);
    }
}
